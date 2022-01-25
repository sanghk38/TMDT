


<?php
include "connect.php";
mysqli_set_charset($conn, 'utf8');
/** Array for JSON response*/
$response = array();
$email = $_POST['email'];
$password = md5($_POST['password']);
$sqlCheck = "SELECT * FROM user WHERE email = '$email' AND password = '$password' ";
$result = mysqli_query($conn, $sqlCheck);
if (mysqli_num_rows($result) != 0) {
	$row = mysqli_fetch_assoc($result);
	$response["success"] = 1;
	$response["message"] = "Đăng nhập thành công!";
	$response["email"] = $row['email'];
	$response["user_name"] = $row['name'];
	$response["password"] = $row['password'];
} else {
	$response["success"] = 0;
	$response["message"] = "Tài khoản không tồn tại. Thử lại!";
}
/**Return json*/
echo json_encode($response);
?>

