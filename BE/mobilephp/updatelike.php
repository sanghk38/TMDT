<?php
include "connect.php";
$luotthich = $_POST['view'];
$idsanphamyeuthich = $_POST['id'];

$query = "SELECT view FROM product WHERE id = '$idsanphamyeuthich'";
$dataluotthich = mysqli_query($conn,$query);
$row = mysqli_fetch_assoc($dataluotthich);
$tongluotthich = $row['view'];

if(isset($luotthich)){
    $tongluotthich = $tongluotthich + $luotthich;
    $querysum = "UPDATE product SET view = '$tongluotthich' WHERE id = '$idsanphamyeuthich'";
    $dataupdate = mysqli_query($conn,$querysum);
    if($dataupdate){
        echo "Success";
    }
    else{
        echo "Failed";
    }
}
