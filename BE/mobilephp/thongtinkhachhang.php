<?php
    include "connect.php";
    // $user_id = $_POST['user_id'];
    $user_name = $_POST['user_name'];
    $user_email =$_POST['user_email'];
    $user_phone = $_POST['user_phone'];
    $user_address = $_POST['user_address'];
    $message = $_POST['message'];
    $amount = $_POST['amount'];
    if(
            strlen($user_name)>0
            && strlen($user_email)>0
            && strlen($user_phone)>0 
            && strlen($user_address)>0 
            && strlen($message)>0 
            // && strlen($payment)>0 
            ) {
        $query = "INSERT INTO transaction (id,user_name,user_email,user_phone,user_address,message,amount) 
         VALUES (null,'$user_name','$user_email','$user_phone','$user_address','$message','$amount')";
         if(mysqli_query($conn,$query)){
            $iddonhang = $conn -> insert_id;
            echo $iddonhang;
        }else {
            echo "that bai";
        }
    }else{
        echo "Faill";
    }
?>
