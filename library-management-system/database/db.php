<?php
function getConnection(){
$host = "localhost";
$user = "root";
$password = "4312";
$database = "library_management_system";

$conn = mysqli_connect($host,$user,$password,$database);

if(!$conn){
    die("Connection Failed : ".mysqli_connect_error());
}

return $conn;
}

?>