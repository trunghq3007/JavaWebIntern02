<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Trang Admin</title>

<!-- Custom fonts for this template-->
<link href="template/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="template/css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Sidebar -->
		<jsp:include page="/view/admin/_sidebar.jsp"></jsp:include>
		<!-- End of Sidebar -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<!-- Topbar -->
				<jsp:include page="/view/admin/_topbar.jsp"></jsp:include>
				<!-- End of Topbar -->

				<!-- Begin Page Content -->
				<div class="container-fluid">
					<form class="user" action="admin-account-add" method="post">
					
							<div class="form-group" >
								<div class="row">
									<div class="col-md-3"> <label>Username</label> </div>
									<div class="col-md-6">
										<input type="text" class="form-control form-control-user" name="username" value="" required>
									</div>
									<div class="col-md-3"></div>
								</div>
							</div> <br>
							
							<div class="form-group" >
								<div class="row">
									<div class="col-md-3"> <label>Password</label> </div>
									<div class="col-md-6">
										<input type="password" class="form-control form-control-user" name="password1" value="" required>
									</div>
									<div class="col-md-3"></div>
								</div>
							</div> <br>
							
							<div class="form-group" >
								<div class="row">
									<div class="col-md-3"> <label>Repeat Password</label> </div>
									<div class="col-md-6">
										<input type="password" class="form-control form-control-user" name="password2" value="" required>
									</div>
									<div class="col-md-3"></div>
								</div>
							</div> <br>
							
							<div class="form-group">
							<div class="row">
								<div class="col-md-3">
									<label>Role</label>
								</div>
								<div class="col-md-6">
									<select name="role" class="custom-select form-control">
										<option value="admin">admin</option>		
									</select>
								</div>
								<div class="col-md-3"></div>
							</div>
						</div> <br>
							
							<div class="form-group d-flex justify-content-center">
								<div class="row">
									<div class="col-md-3"></div>
									<div class="col-md-6">
										<button type="submit" name="action" value="add"
											class="btn btn btn-primary" style="width: 100px;">
											<i class="fas fas fa-plus fa-fw mr-2 text-white"></i> 
											Thêm
										</button>
									</div>
									<div class="col-md-3"></div>
								</div>
							</div>
						
					</form>
					<p style="text-align: center; margin-top: 20px; color: red;">${tb16}</p>



					<!--THÊM NỘI DUNG VÀO ĐÂY-->
					<!--THÊM NỘI DUNG VÀO ĐÂY-->
					<!--THÊM NỘI DUNG VÀO ĐÂY-->
					<!--THÊM NỘI DUNG VÀO ĐÂY-->
					<!--THÊM NỘI DUNG VÀO ĐÂY-->





				</div>
				<!-- /.container-fluid -->

			</div>
			<!-- End of Main Content -->

			<!-- Footer -->
			<jsp:include page="/view/admin/_footer.jsp"></jsp:include>
			<!-- End of Footer -->

		</div>
		<!-- End of Content Wrapper -->

	</div>
	<!-- End of Page Wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<!-- Bootstrap core JavaScript-->
	<script src="template/vendor/jquery/jquery.min.js"></script>
	<script src="template/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="template/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="template/js/sb-admin-2.min.js"></script>

	<!-- Page level plugins -->
	<script src="template/vendor/chart.js/Chart.min.js"></script>

	<!-- Page level custom scripts -->
	<script src="template/js/demo/chart-area-demo.js"></script>
	<script src="template/js/demo/chart-pie-demo.js"></script>

</body>
</html>