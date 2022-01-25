<!DOCTYPE html>
<html lang="en">

<head>
	<?php $this->load->view('admin/head', $this->data); ?>
</head>

<body>
	<div class="container">
		<?php $this->load->view('admin/header', $this->data); ?>
		<?php $this->load->view('admin/slider', $this->data); ?>
		<?php $this->load->view($temp, $this->data); ?>
		<?php $this->load->view('admin/footer', $this->data); ?>
	</div>
	<script src="<?php echo public_url('admin/'); ?>bootstrap/js/bootstrap.min.js"></script>
</body>

</html>
