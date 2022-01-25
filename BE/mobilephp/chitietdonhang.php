<?php
    include 'connect.php';
    $json =$_POST['json']; //'[{"transaction_id":"56","product_id":29,"qty":1,"amount":180000,"status":0}]';
    $data = json_decode($json,true);
    foreach ($data as $value){
        $transaction_id =$value['transaction_id'];
        $product_id = $value['product_id'];
        $qty = $value['qty'];
    $sizes = $value['sizes'];
        $amount = $value['amount'];
        $status = $value['status'];
       $sql = "INSERT INTO oderr (id,transaction_id, product_id, qty,sizes, amount, status) 
              VALUES (null,'$transaction_id','$product_id','$qty','$sizes','$amount','$status')";
    if ($conn->query($sql) === true) 
{ 
    echo "Records inserted successfully."; 
} 
else
{ 
    echo "ERROR: Could not able to execute $sql. "
           .$mysqli->error; 
} 
} 

// Close connection 
$conn->close(); 
?>