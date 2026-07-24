<?php
// ini_set('display_errors', 1);
// error_reporting(E_ALL);

session_start();

require_once "database/db.php";

$conn = getConnection();

// if(!isset($_SESSION['user_id'])){
//     header("Location: index.php");
//     exit();

// }E

$categoryResult = mysqli_query($conn, "
SELECT category_id, category_name FROM categories ORDER BY category_name ASC");

$bookResult = mysqli_query($conn, "
SELECT
books.book_id,
books.isbn,
books.title,
authors.author_name,
publisher.publisher_name,
categories.category_name,
books.publication_year,
books.available_copies,
books.book_status
FROM books
LEFT JOIN authors
ON books.author_id = authors.author_id

LEFT JOIN publisher
ON books.publisher_id = publisher.publisher_id

LEFT JOIN categories
ON books.category_id = categories.category_id

ORDER BY books.book_id DESC");

if (!$bookResult) {
    die(mysqli_error($conn));
}

if(isset($_POST['add_book'])){
    $isbn = trim($_POST['isbn']);
    $authorName = trim($_POST['author_name']);
    $puslisherName = trim($_POST['publisher_name']);
    $categoryName = trim($_POST['category_name']);
    $publicationYear = trim($_POST['publication_year']);
    $availableCopies = trim($_POST['available_copies']);

    $sql = "SELECT auther_id FROM authors WHERE author_name = ?";

    $stmt = mysqli_prepare($conn, $sql);

    mysqli_stmt_bind_param($stmt, "s", $authorName);

    mysqli_stmt_execute($stmt);

    $result = mysqli_stmt_get_result($stmt);

    if(mysqli_num_rows($result) > 0){
        $author = mysqli_fetch_assoc($result);
        $authorID = $author['author_id'];

    }else{
        $sql = "INSERT INTO authors(author_name) VALUES(?)";

        $stmt = mysqli_prepare($conn, $sql);
        mysqli_stmt_bind_param($stmt, "s", $authorName);

        mysqli_stmt_execute($stmt);
        $authorID = mysqli_insert_id($conn);
    }

}

?>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>Book Management</title>

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css">

        <link rel="stylesheet" href="assets/css/booklist.css">

    </head>
    <body>
        <div class="dashboard">
            <aside class="sidebar">
                <div class="logo">
                    <img src="assets/images/logo.png" alt="logo">

                    <h2>Library MS</h2>

                </div>

                <ul class="menu">
                    <li>
                        <a href="dashboard.php">
                            <i class="fa-solid fa-house"></i>
                            <span>Dashboard</span>
                        </a>
                    </li>

                    <li>
                        <a href="booklist.php">
                        <i class="fa-solid fa-book"></i>
                        <span>Books</span>
                        </a>
                    </li> 

                    <li>
                        <a href="members.php">
                            <i class="fa-solid fa-users"></i>
                            <span>Members</span>
                        </a>
                    </li>

                    <li>
                        <a href="borrow.php">
                        <i class="fa-solid fa-book-open-reader"></i>
                        <span>Borrow</span>
                        </a>
                    </li>

                    <li>
                        <a href="return.php">
                        <i class="fa-solid fa-rotate-left"></i>
                        <span>Return</span>
                        </a>
                    </li>

                    <li>
                        <a href="fine.php">
                        <i class="fa-solid fa-money-bill"></i>
                        <span>Fine Management</span>
                        </a>
                    </li>

                    <li>
                        <a href="reports.php">
                        <i class="fa-solid fa-chart-column"></i>
                        <span>Reports</span>
                        </a>
                    </li>

                    <li>
                        <a href="settings.php">
                            <i class="fa-solid fa-gear"></i>
                            <span>Settings</span>
                        </a>
                    </li>

                    <li>
                        <a href="logout.php">
                            <i class="fa-solid fa-right-from-bracket"></i>
                            <span>logout</span>
                        </a>
                    </li>
                    
                </ul>

            </aside>

            <main class="main-content">
                <header class="topbar">
                    <h2>Book Management</h2>
                    <div class="profile">
                        <i class="fa-reguler fa-bell"></i>
                        <span><?php echo htmlspecialchars($_SESSION['full_name']); ?></span>

                    </div>

                </header>

                <section class="book-management">
                    <div class="toolbar">
                        <button class="add-book-btn">
                            <i class="fa-solid fa-square-plus"></i>
                            Add Book 
                        </button>

                        <div class="search-box">
                            <i class="fa-solid fa-magnifying-glass"></i>
                            <input type="text" name="search" placeholder="Search by title, ISBN, or author.....">

                        </div>

                        <select name="category" class="category-filter" id="">
                            <option value="">All Categories</option>
                            <?php while($category = mysqli_fetch_assoc($categoryResult)){ ?>
                            <option value="" <?php echo $category['category_id']; ?>></option>

                            <?php echo htmlspecialchars($category['category_name']); ?>

                           <?php }?>
                        </select>

                    </div>

                </section>

                <section class="books-table">
                    <table>
                        <thead>
                            <tr>
                                <th>ISBN</th>
                                <th>Book</th>
                                <th>Author</th>
                                <th>Publisher</th>
                                <th>Category</th>
                                <th>Yeat</th>
                                <th>Copies</th>
                                <th>Status</th>
                                <th>Action</th>
                            </tr>
                        </thead>

                        <tbody>
                            <?php while($book = mysqli_fetch_assoc($bookResult)){?>
                            <tr>
                                <td><?php echo htmlspecialchars($book['isbn']); ?></td>
                                <td><?php echo htmlspecialchars($book['title']); ?></td>
                                <td><?php echo htmlspecialchars($book['author_name']); ?></td>
                                <td><?php echo htmlspecialchars ($book['publisher_name']); ?></td>
                                <td><?php echo htmlspecialchars ($book['category_name']); ?></td>
                                <td><?php echo htmlspecialchars ($book['publication_year']); ?></td>
                                <td><?php echo htmlspecialchars($book['available_copies']); ?></td>
                                <td><?php ucfirst($book['book_status']); ?></td>
                                <td>
                                    <button class="edit-btn" data-id="<?php echo $book['book_id']; ?>">
                                        <i class="fa-solid fa-pe-to-square"></i>

                                    </button>

                                    <button class="delete-btn" data-id="<?php echo $book['book_id']; ?>">
                                        <i class="fa-solid fa-trash"></i>

                                    </button>
                                </td>
                            </tr>
                           <?php }?>
                        </tbody>
                    </table>

                </section>

                <div class="model" id="addBookModel">
                    <div class="model-content">
                        <div class="model-header">
                            <h2>Add New Book</h2>
                            <button class="close-btn" type="button">
                                <i class="fa-solid fa-xmark"></i>

                            </button>
                             </div>

                            <form action="" method="POST">
                                <div class="form-group">
                                    <label for=""> ISBN</label>
                                <input type="text" name="isbn" placeholder="Enter ISBN">

                                </div>

                                <div class="form-group">
                                    <label for=""> Book Title</label>
                                    <input type="text" name="title" placeholder="Enter Book Title">

                                </div>

                                <div class="form-group">
                                    <label for="">Author</label>
                                    <input type="text" name="author_name" placeholder="Enter Author Name">

                                </div>

                                <div class="form-group">
                                    <label for="">Publisher</label>
                                    <input type="text" name="Publisher_name" placeholder="Enter Publisher Name">

                                </div>

                                <div class="form-group">
                                    <label for="">Category</label>
                                    <input type="text" name="category_name" placeholder="Enter Category Name">


                                </div>
                                
                                <div class="form-group">
                                    <label for="">Publication Year</label>
                                    <input type="number" name="publication_year" placeholder="2026">

                                </div>

                                <div class="form-group">
                                    <label for="">Available Copies</label>
                                    <input type="number" name="available_copies" placeholder="23">

                                </div>
                                

                            </form>

                       

                    </div>

                </div>


            </main>

        </div>
    </body>

</html>