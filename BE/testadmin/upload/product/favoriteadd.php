<!-- <?php
include 'connect.php';
$tensanpham = $_POST['name'];
$giasanpham = $_POST['price'];
$hinhanhsanpham = $_POST['img'];
$id_sp = $_POST['id_sp'];
$sql = "INSERT INTO favorite VALUES (null,'$id_sp','$tensanpham','$giasanpham','$hinhanhsanpham')";
if (!$conn->query($sql)) {
    echo "failure";
} else {
    echo "success";
}
?> -->
<?php
include 'connect.php';

$json = $_POST['json']; //'[{"transaction_id":"56","product_id":29,"qty":1,"amount":180000,"status":0}]';
$data = json_decode($json, true);
foreach ($data as $value) {
    $tensanpham = $_POST['name'];
    $giasanpham = $_POST['price'];
    $hinhanhsanpham = $_POST['img'];
    $id_sp = $_POST['id_sp'];
    $sql = "INSERT INTO favorite(id,id_sp, name, price, img)  VALUES ('$id_sp','$tensanpham','$giasanpham','$hinhanhsanpham')";
    if ($conn->query($sql) === true) {
        echo "Records inserted successfully.";
    } else {
        echo "ERROR: Could not able to execute $sql. "
            . $mysqli->error;
    }
}
// Close connection 
$conn->close();
?>

