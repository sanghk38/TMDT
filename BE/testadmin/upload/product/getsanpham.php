<?php
include "connect.php";
$page = $_GET['page'];
$idsp = 1;
$space = 5;
$limit = ($page - 1) * $space;
$mangsanpham = array();
$query = "SELECT * FROM product where catalog_id = $idsp LIMIT  $limit,$space";
$data = mysqli_query($conn, $query);
while ($row = mysqli_fetch_assoc($data)) {
    array_push($mangsanpham, new Sanpham(
        $row['id'],
        $row['catalog_id'],
        $row['name'],
        $row['content'],
        $row['price'],
        //$row['discount'],
        $row['image_link'],
        // $row['image_list'],
         $row['view'],
        // $row['buyed'],
        // $row['rate_total'],
        // $row['rate_count'],
        // $row['created']
    ));
}
echo json_encode($mangsanpham);
class SanPham{
    function SanPham($id,$idsanpham,$tensanpham,$motasanpham,$giasanpham,$hinhanhsanpham,$yeuthich){
        $this->id=$id;
        $this->idsanpham=$idsanpham;
        $this->tensanpham=$tensanpham;
        $this->motasanpham=$motasanpham;
        $this->giasanpham=$giasanpham;
        $this->hinhanhsanpham=$hinhanhsanpham;
        $this->yeuthich=$yeuthich;
     } 
}
