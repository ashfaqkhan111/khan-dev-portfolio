<?php
session_start();

require_once "database/db.php";

$conn = getConnection();

// if(!isset($_SESSION['user_id'])){
//     header("Location: index.php");
//     exit();

// }

$categoryRsult = mysqli_query($conn, "
SELECT category_id, category_name FROM categories ORDER BY category_name ASC");

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
                            <?php while($category = mysqli_fetch_assoc($categoryRsult)){ ?>
                            <option value="" <?php echo $category['category_id']; ?>></option>

                            <?php echo htmlspecialchars($category['category_name']); ?>

                           <?php }?>
                        </select>

                    </div>

                </section>

            </main>

        </div>
    </body>

</html>