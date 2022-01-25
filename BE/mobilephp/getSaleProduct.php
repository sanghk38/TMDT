<?php
    include "connect.php";
    $mangsanphammoinhat = array();
$query = "SELECT * FROM product ORDER BY ID DESC LIMIT 50";
    
    $data = mysqli_query($conn,$query);
    while ($row = mysqli_fetch_assoc($data)){
        array_push($mangsanphammoinhat,new Sanphammoinhat(
        $row['id'],
        $row['name'],
        $row['discount'],
        $row['image_link'],
        $row['content'],
        $row['catalog_id']
    ));
    }
    echo json_encode($mangsanphammoinhat);
    class Sanphammoinhat {
        function Sanphammoinhat($id,$tensanpham,$giasanpham,$hinhanhsanpham,$motasanpham,$idsanpham){
            $this -> id=$id;
            $this -> tensanpham=$tensanpham;
            $this -> giasanpham=$giasanpham;
            $this -> hinhanhsanpham=$hinhanhsanpham;
            $this -> motasanpham=$motasanpham;
            $this -> idsanpham=$idsanpham;
        }
    }
