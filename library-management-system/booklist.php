<?php
session_start();

require_once "database/db.php";

$conn = getConnection();

// if(!isset($_SESSION['user_id'])){
//     header("Location: index.php");
//     exit();

// }

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
                        <a href="booklist.php"></a>
                        <i class="fa-solid fa-book"></i>
                    </li>

                    

                </ul>

            </aside>

            <main class="main-content">

            </main>

        </div>
    </body>

</html>