<?php
$transaction_id = $value['transaction_id'];
$product_id = $value['product_id'];
$qty = $value['qty'];
$amount = $value['amount'];
$status = $value['status'];
$con = new mysqli("localhost", "root", "", "webbackend");
$st  = $con->prepare("INSERT INTO order (id,transaction_id, product_id, qty, amount, status)VALUES (null,'$transaction_id','$product_id','$qty','$amount','$status')");
$st->execute();
$rs = $st->get_result();
$emp = array();
while ($row = $rs->fetch_assoc()) {
    array_push($emp, $row);
}
echo json_encode($emp);
