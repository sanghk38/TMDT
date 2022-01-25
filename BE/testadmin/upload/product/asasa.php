<?php
include 'connect.php';
class SanphamYeuThich
{
    function SanphamYeuThich($id, $tensanpham, $giasanpham, $hinhanhsanpham, $motasanpham, $idsanpham, $yeuthich)
    {
        $this->id = $id;
        $this->tensanpham = $tensanpham;
        $this->giasanpham = $giasanpham;
        $this->hinhanhsanpham = $hinhanhsanpham;
        $this->motasanpham = $motasanpham;
        $this->idsanpham = $idsanpham;
        $this->yeuthich = $yeuthich;
    }
}
$arraysanpham = array();
$query = "SELECT * FROM product ORDER BY view DESC LIMIT 30";
$data = mysqli_query($conn, $query);
while ($row = mysqli_fetch_assoc($data)) {
    array_push($arraysanpham, new SanphamYeuThich(
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
echo json_encode($arraysanpham);
