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

<title>Thêm sinh viên</title>

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

					<form class="user" action="admin-student-add" method="post">
						<div class="form-group">
							<div class="row">
								<div class="col-md-3">
									<label>Mã sinh viên</label>
								</div>
								<div class="col-md-6">
									<input type="text" class="form-control" name="id" required>
								</div>
								<div class="col-md-3"></div>
							</div>
						</div>

						<div class="form-group">
							<div class="row">
								<div class="col-md-3">
									<label>Tên sinh viên</label>
								</div>
								<div class="col-md-6">
									<input type="text" class="form-control" name="name" required>
								</div>
								<div class="col-md-3"></div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-md-3">
									<label>Giới tính</label>
								</div>
								<div class="col-md-6">
									<input type="text" class="form-control" name="gender" required>
								</div>
								<div class="col-md-3"></div>
							</div>

						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-md-3">
									<label>Email</label>
								</div>
								<div class="col-md-6">
									<input type="email" class="form-control" name="email" required>
								</div>
								<div class="col-md-3"></div>
							</div>

						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-md-3">
									<label>Ngày sinh</label>
								</div>
								<div class="col-md-6">
									<input type="date" class="form-control" name="birth_date"
										required>
								</div>
								<div class="col-md-3"></div>
							</div>

						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-md-3">
									<label>Nơi sinh</label>
								</div>
								<div class="col-md-6">
									<select name="birth_place" class="custom-select form-control">
										<option disabled selected>Nơi sinh...</option>
										<option value="An Giang">An Giang
										<option value="Bà Rịa - Vũng Tàu">Bà Rịa - Vũng Tàu
										<option value="Bắc Giang">Bắc Giang
										<option value="Bắc Kạn">Bắc Kạn
										<option value="Bạc Liêu">Bạc Liêu
										<option value="Bắc Ninh">Bắc Ninh
										<option value="Bến Tre">Bến Tre
										<option value="Bình Định">Bình Định
										<option value="Bình Dương">Bình Dương
										<option value="Bình Phước">Bình Phước
										<option value="Bình Thuận">Bình Thuận
										<option value="Bình Thuận">Bình Thuận
										<option value="Cà Mau">Cà Mau
										<option value="Cao Bằng">Cao Bằng
										<option value="Đắk Lắk">Đắk Lắk
										<option value="Đắk Nông">Đắk Nông
										<option value="Điện Biên">Điện Biên
										<option value="Đồng Nai">Đồng Nai
										<option value="Đồng Tháp">Đồng Tháp
										<option value="Đồng Tháp">Đồng Tháp
										<option value="Gia Lai">Gia Lai
										<option value="Hà Giang">Hà Giang
										<option value="Hà Nam">Hà Nam
										<option value="Hà Tĩnh">Hà Tĩnh
										<option value="Hải Dương">Hải Dương
										<option value="Hậu Giang">Hậu Giang
										<option value="Hòa Bình">Hòa Bình
										<option value="Hưng Yên">Hưng Yên
										<option value="Khánh Hòa">Khánh Hòa
										<option value="Kiên Giang">Kiên Giang
										<option value="Kon Tum">Kon Tum
										<option value="Lai Châu">Lai Châu
										<option value="Lâm Đồng">Lâm Đồng
										<option value="Lạng Sơn">Lạng Sơn
										<option value="Lào Cai">Lào Cai
										<option value="Long An">Long An
										<option value="Nam Định">Nam Định
										<option value="Nghệ An">Nghệ An
										<option value="Ninh Bình">Ninh Bình
										<option value="Ninh Thuận">Ninh Thuận
										<option value="Phú Thọ">Phú Thọ
										<option value="Quảng Bình">Quảng Bình
										<option value="Quảng Bình">Quảng Bình
										<option value="Quảng Ngãi">Quảng Ngãi
										<option value="Quảng Ninh">Quảng Ninh
										<option value="Quảng Trị">Quảng Trị
										<option value="Sóc Trăng">Sóc Trăng
										<option value="Sơn La">Sơn La
										<option value="Tây Ninh">Tây Ninh
										<option value="Thái Bình">Thái Bình
										<option value="Thái Nguyên">Thái Nguyên
										<option value="Thanh Hóa">Thanh Hóa
										<option value="Thừa Thiên Huế">Thừa Thiên Huế
										<option value="Tiền Giang">Tiền Giang
										<option value="Trà Vinh">Trà Vinh
										<option value="Tuyên Quang">Tuyên Quang
										<option value="Vĩnh Long">Vĩnh Long
										<option value="Vĩnh Phúc">Vĩnh Phúc
										<option value="Yên Bái">Yên Bái
										<option value="Phú Yên">Phú Yên
										<option value="Tp.Cần Thơ">Tp.Cần Thơ
										<option value="Tp.Đà Nẵng">Tp.Đà Nẵng
										<option value="Tp.Hải Phòng">Tp.Hải Phòng
										<option value="Tp.Hà Nội">Tp.Hà Nội
										<option value="TP  HCM">TP HCM
									</select>
								</div>
								<div class="col-md-3"></div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-md-3">
									<label>Lớp</label>
								</div>
								<div class="col-md-6">
									<input type="text" class="form-control" name="class_id"
										required>
								</div>
								<div class="col-md-3"></div>
							</div>

						</div>
						<div class="form-group d-flex justify-content-center">
							<div class="row">
								<div class="col-md-3"></div>
								<div class="col-md-6">
									<button type="submit" name="action" value="add"
										class="btn btn btn-primary ">Thêm</button>
								</div>
								<div class="col-md-3"></div>
							</div>
						</div>
					</form>
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