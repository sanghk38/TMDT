<?php
    include "connect.php";
    // $page = $_GET['page'];
    // $idsp = $_POST['catalog_id'];
    // $space = 5;
    // $limit = ($page - 1) * $space;

    // $mangsanpham = array();
    // $query = "SELECT * FROM product WHERE catalog_id = $idsp LIMIT $limit,$space";
   $page = $_GET['page'];
    $idsp = 21; //$_POST['catalog_id'];
   // $space = 5;
    //$limit = ($page - 1) * $space;
    $mangsanpham = array();
    $query = "SELECT * FROM product WHERE catalog_id = $idsp";
    $data = mysqli_query($conn,$query);
    while($row = mysqli_fetch_assoc($data)){
        array_push($mangsanpham, new product(
            $row['id'],
            $row['catalog_id'],
            $row['name'],
            $row['content'],
            $row['price'],
            $row['discount'],
            $row['image_link'],
            $row['image_list'],
            $row['view'],
            $row['buyed'],
            $row['rate_total'],
            $row['rate_count'],
            $row['created']
            
        ));
    }
        echo json_encode($mangsanpham);
    class product {
        function product($id,$catalog_id,$name,$content,$price,
        $image_link,$image_list,$view,$rate_total,$buyed,$rate_count,$created){
            $this -> id=$id;
            $this -> catalog_id=$catalog_id;
            $this -> name=$name;
            $this -> content=$content;
            $this -> price=$price;
            $this -> image_link=$image_link;
            $this -> image_list=$image_list;
            $this -> view=$view;
            $this -> buyed=$buyed;
            $this -> rate_total=$rate_total;
            $this -> rate_count=$rate_count;
            $this -> created=$created;
        }
    }
?>