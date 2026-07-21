<?php 
session_start();
require_once "database/db.php";

$conn = getConnection();

// if (!isset($SESSION['user_id'])){
//     header("Location: index.php");

//     exit();
// }

$bookQuery = mysqli_query($conn, "SELECT COUNT(*) AS total FROM books");
$totalBooks = mysqli_fetch_assoc($bookQuery)['total'];

$memberQuery = mysqli_query($conn, "SELECT COUNT(*) AS total FROM members");
$totalMembers = mysqli_fetch_assoc($memberQuery)['total'];

$borrowQuery = mysqli_query($conn, "SELECT COUNT(*) AS total FROM borrowings 
WHERE status='borrowed'");
$totalBorrowed = mysqli_fetch_assoc($borrowQuery)['total'];

$returnedQuery = mysqli_query($conn, "SELECT COUNT(*) AS total FROM borrowings 
WHERE status='returned'");
$totalReturned = mysqli_fetch_assoc($returnedQuery)['total'];

?>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css">
    <link rel="stylesheet" href="assets/css/dashboard.css">
</head>

<body>
    <!-- <h1>Dashboard</h1>
    <h2>welcome, 
        <?php echo htmlspecialchars($_SESSION['full_name']); ?>
    </h2> -->

    <div class="dashboard">

    <aside class="sidebar">
        <div class="logo">
            <img src="assets/images/smalllogo.png" alt="logo">
            <h2>Library MS</h2>

        </div>

        <ul class="menu">
            <li class="active">
                <i class="fa-solid fa-users"></i>
                <span>Dashboard</span>
            </li>

            <li>
                <i class="fa-solid fa-book"></i>
                <span>Books</span>
            </li>

            <li>
                <i class="fa-solid fa-users"></i>
                <span>Members</span>
            </li>

            <li>
                <i class="fa-solid fa-rotate-left"></i>
                <span>Return</span>
            </li>

            <li>
                <i class="fa-solid fa-money-bill"></i>
                <span>Fine Management</span>
            </li>

            <li>
                <i class="fa-solid fa-chart-column"></i>
                <span>Reports</span>
            </li>

            <li>
                <i class="fa-solid fa-gear"></i>
                <span>Settings</span>
            </li>

            <li>
                <i class="fa-solid fa-right-from-bracket"></i>
                <span>Logout</span>
            </li>

        </ul>

    </aside>

    <main class="main-content">
        <header class="topbar">
            <h2>Dashboard</h2>

            <div class="profile">
                <i class="fa-regular fa-bell"></i>
                    <span>
                        <?php echo htmlspecialchars($_SESSION['full_name']); ?>
                    </span>
            </div>
        </header>

        <section class="content">
            <h1>Welcome,
                <?php echo htmlspecialchars($_SESSION['full_name']); ?>

            </h1>

            <p>
                Library Management System
            </p>

        </section>

        <section class="statistics">

    <div class="card">
        <div class="card-icon">
            <i class="fa-solid fa-book"></i>
        </div>

        <div class="card-info">
            <h3>Total Books</h3>
            <h2><?php echo $totalBooks; ?></h2>
        </div>
    </div>

    <div class="card">
        <div class="card-icon">
            <i class="fa-solid fa-users"></i>
        </div>

        <div class="card-info">
            <h3>Total Members</h3>
            <h2><?php echo $totalMembers; ?></h2>
        </div>
    </div>

    <div class="card">
        <div class="card-icon">
            <i class="fa-solid fa-book-open-reader"></i>
        </div>

        <div class="card-info">
            <h3>Borrowed Books</h3>
            <h2><?php echo $totalBorrowed; ?></h2>
        </div>
    </div>

    <div class="card">
        <div class="card-icon">
            <i class="fa-solid fa-rotate-left"></i>
        </div>

        <div class="card-info">
            <h3>Returned Books</h3>
            <h2><?php echo $totalReturned; ?></h2>
        </div>
    </div>

</section>

<section class="charts">
    <div class="bar-chart-card">
        <h2>Monthly Borrowings</h2>

        <div class="bar-chart-container" >
            <canvas id="borrowChart"></canvas>
        </div>
        

    </div>

    <div class="pie-chart-card">
        <h2>Borrowings Categories</h2>

        <div class="pie-chart-container">
              <canvas id="categoryChart"></canvas>
        </div>
      

    </div>

</section>

    </main>
    </div>

        <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
        <script src="assets/js/dashboard.js"></script>

</body>

</html>