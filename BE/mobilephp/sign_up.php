<?php
include "connect.php";
$name = $_POST['name'];
$email = $_POST['email'];
$password = md5($_POST['password']);
$phone = $_POST['phone'];
$address = $_POST['address'];
    if(
            strlen($name)>0
            && strlen($email)>0
            && strlen($phone)>0 
            && strlen($address)>0 
            && strlen($password)>0 
            // && strlen($payment)>0 
            ) {
        $query = "INSERT INTO user (id,name,email,password,phone,address) 
         VALUES (null,'$name','$email','$password','$phone','$address')";
         if(mysqli_query($conn,$query)){
		echo "Đăng ký thành công!";
        }else {
            echo "that bai";
        }
    }else{
        echo "Faill";
    }
?>

