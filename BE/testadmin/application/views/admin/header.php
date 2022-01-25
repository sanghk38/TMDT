<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#sidebar-collapse">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="<?php echo admin_url('home'); ?>">LiLac Store<span> Admin</span></a>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Xin chào: <?php echo $login->name; ?> <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="<?php echo admin_url('admin/edit/' . $login->id); ?>">Tài khoản</a></li>
						<li role="separator" class="divider"></li>
						<li><a id="logout" href="<?php echo admin_url('admin/logout'); ?>">Đăng xuất</a></li>
					</ul>
				</li>
			</ul>
		</div>

		<!-- <a class="navbar-brand navbar-right" href="<?php echo admin_url('admin/edit/' . $login->id); ?>">Xin chào: <?php echo $login->name; ?></a>
		<a class="navbar-brand pull-right" id="logout" href="<?php echo admin_url('admin/logout'); ?>">Đăng xuất</a> -->
	</div><!-- /.container-fluid -->
</nav>
