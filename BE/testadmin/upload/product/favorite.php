<?php
$con = new mysqli("localhost", "root", "", "webbackend");
$st  = $con->prepare("SELECT * FROM favorite");
$st->execute();
$rs = $st->get_result();
$emp = array();
while ($row = $rs->fetch_assoc()) {
    array_push($emp, $row);
}
echo json_encode($emp);

