<?php

session_start();
require_once "database/db.php";
$conn = getConnection();
$error = "";
$messageType = "";

if (isset($_POST['login'])){
    $username = trim($_POST['username']);
    $password = trim($_POST['password']);

    if (empty($username) && empty($password)){

    $error = "Please enter username and password.";
    $messageType = "warning";

    }elseif (empty($username)){
        $error = "please enter your username.";
        $messageType = "warning";
    }elseif (empty($password)){
        $error = "please enter your password.";
        $messageType = "warning";
    }else {
        $sql = "SELECT * FROM users WHERE username = ? AND role = 'librarian' LIMIT 1";

        $stmt = mysqli_prepare($conn, $sql);

        mysqli_stmt_bind_param($stmt, "s", $username);

        mysqli_stmt_execute($stmt);

        $result = mysqli_stmt_get_result($stmt);

        if (mysqli_num_rows($result) == 1){
            $user = mysqli_fetch_assoc($result);

            if (password_verify($password, $user['password'])){
                $_SESSION['user_id'] = $user['user_id'];
                $_SESSION['username'] = $user['username'];
                $_SESSION['full_name'] = $user['full_name'];
                $_SESSION['role'] = $user['role'];

                header("Location: Dashboard.php");
                exit();

            }else{
                $error = "Invalid username or password";
                $messageType = "error";
            }
        }else {
            $error = "Invalid username or password";
            $messageType = "error";
        }
    }

    }

?>

<!DOCTYPE html>
<html lang = "en">
<head>

<meta charset = "UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Librarian Login</title>

<link rel="stylesheet"
href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css">
<link rel="stylesheet" href="assets/css/login.css">

</head> 
  
<body>
   
<header>
    <h1>Librarian Login</h1>

</header>

<div class="container">
    <div class="left">
       <img src="assets/images/logo.png" alt="Library Logo"> 

    </div>

    <div class="right">
        <div class="login-form">
        <h2>Welcome back</h2>
        <p>please login to continue.</p>

        <?php if (!empty($error)) : ?>
            <div class="message <?php echo $messageType; ?>">
                <?php if ($messageType == "warning") : ?>
                    <i class="fa-solid fa-triangle-exclamation"></i>
                    <?php endif; ?>

                    <?php if ($messageType == "error") : ?>
                        <i class="fa-solid fa-circle-xmark"></i>
                        <?php endif; ?>

                        <span><?php echo htmlspecialchars($error); ?></span>
            </div>
            <?php endif; ?>
        

        <form action="" method="POST">
            <label for="">Username</label>

            <div class="input-box">
                <i class="fa-regular fa-user"></i>

                <input type="text" name="username" placeholder="Enter Libraian ID">

            </div>

            <label for="">Password</label>
            <div class="input-box">
                <i class="fa-solid fa-lock"></i>

                <input type="password" id="password" name="password" placeholder="Enter Password">

                <i class="fa-regular fa-eye" id="togglePassword"></i>
            </div>

          
            <a href="#" class="forgot">forgot password?</a>

            <button type="submit" name="login">
                <i class="fa-solid fa-right-to-bracket"></i>
                Login
            </button>
        </form>
    </div>
</div>
</div>

<script src="assets/js/login.js"></script> 
</body>

</html>