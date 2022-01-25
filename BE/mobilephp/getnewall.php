<?php
    include "connect.php";
    $page = $_GET['page'];
    $idsp = $_POST['id'];
    $space = 500;
    $limit = ($page - 1) * $space;
    $mangsanpham = array();
    $query = "SELECT * FROM product WHERE id = $idsp LIMIT $limit,$space";
    $data = mysqli_query($conn,$query);
    while($row = mysqli_fetch_assoc($data)){
        array_push($mangsanpham, new Sanpham(
            $row['id'],
            $row['name'],
            $row['price'],
            $row['image_link'],
            $row['content'],
            $row['catatlog_id']
        ));
    }
        echo json_encode($mangsanpham);
    class Sanpham {
        function Sanpham($id,$tensanpham,$giasanpham,$hinhanhsanpham,$motasanpham,$idsanpham){
            $this -> id=$id;
            $this -> tensanpham=$tensanpham;
            $this -> giasanpham=$giasanpham;
            $this -> hinhanhsanpham=$hinhanhsanpham;
            $this -> motasanpham=$motasanpham;
            $this -> idsanpham=$idsanpham;
        }
    }
