<?php
$con = new mysqli("localhost", "root", "", "webbacken");
$st  = $con->prepare("SELECT * FROM product");
$st->execute();
$rs = $st->get_result();
$emp = array();
while ($row = $rs->fetch_assoc()) {
    array_push($emp, $row);
}
echo json_encode($emp);
