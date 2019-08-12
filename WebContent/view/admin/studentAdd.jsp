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
									<input type="text" class="form-control"
										name="id" required>
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
									<input type="text" class="form-control"
										name="name" required>
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
									<input type="text" class="form-control"
										name="gender" required>
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
									<input type="email" class="form-control"
										name="email" required>
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
									<input type="date" class="form-control"
										name="birth_date" required>
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
									<select name="birth_place"
										class="custom-select form-control">
										<option disabled selected>Nơi sinh...</option>
										<option value="HA NOI">Hà Nội</option>
										<option value="TP HCM">TP Hồ Chí Minh</option>
										<option value="DBSCL">ĐBSCL</option>
										<option value="AN GIANG">An Giang</option>
										<option value="BA RIA">Bà Rịa</option>
										<option value="BAC CAN">Bắc cạn</option>
										<option value="BAC GIANG">Bắc Giang</option>
										<option value="BAC LIEU">Bạc Liêu</option>
										<option value="BAC NINH">Bắc Ninh</option>
										<option value="BEN TRE">Bến Tre</option>
										<option value="BIEN HOA">Biên Hòa</option>
										<option value="BINH DINH">Bình Định</option>
										<option value="BINH DUONG">Bình Dương</option>
										<option value="BINH PHUOC">Bình Phước</option>
										<option value="BINH THUAN">Bình Thuận</option>
										<option value="CA MAU">Cà Mau</option>
										<option value="CAN THO">Cần Thơ</option>
										<option value="CAO BANG">Cao Bằng</option>
										<option value="DA NANG">Đà Nẵng</option>
										<option value="DAC LAC">Đắc Lắc</option>
										<option value="DIEN BIEN">Điện Biên</option>
										<option value="DONG NAI">Đồng Nai</option>
										<option value="DONG THAP">Đồng Tháp</option>
										<option value="GIA LAI">Gia Lai</option>
										<option value="HA GIANG">Hà Giang</option>
										<option value="HA NAM">Hà Nam</option>
										<option value="HA TAY">Hà Tây</option>
										<option value="HA TINH">Hà Tĩnh</option>
										<option value="HAI DUONG">Hải Dương</option>
										<option value="HAI PHONG">Hải Phòng</option>
										<option value="HOA BINH">Hòa Bình</option>
										<option value="HUNG YEN">Hưng Yên</option>
										<option value="KHANH HOA">Khánh Hòa</option>
										<option value="KON TUM">Kon Tum</option>
										<option value="LAI CHAU">Lai Châu</option>
										<option value="LAM DONG">Lâm Đồng</option>
										<option value="LANG SON">Lạng Sơn</option>
										<option value="LAO CAI">Lào Cai</option>
										<option value="LONG AN">Long An</option>
										<option value="NAM DINH">Nam Định</option>
										<option value="NGHE AN">Nghệ An</option>
										<option value="NINH BINH">Ninh Bình</option>
										<option value="NINH THUAN">Ninh Thuận</option>
										<option value="PHU THO">Phú Thọ</option>
										<option value="PHU YEN">Phú Yên</option>
										<option value="QUANG BINH">Quảng Bình</option>
										<option value="QUANG NAM">Quảng Nam</option>
										<option value="QUANG NGAI">Quảng Ngãi</option>
										<option value="QUANG NINH">Quảng Ninh</option>
										<option value="QUANG TRI">Quảng Trị</option>
										<option value="SOC TRANG">Sóc Trăng</option>
										<option value="SON LA">Sơn La</option>
										<option value="TAY NINH">Tây Ninh</option>
										<option value="THAI BINH">Thái Bình</option>
										<option value="THAI NGUYEN">Thái Nguyên</option>
										<option value="THANH HOA">Thanh Hóa</option>
										<option value="THUA THIEN HUE">Thừa Thiên-Huế</option>
										<option value="TIEN GIANG">Tiền Giang</option>
										<option value="TRA VINH">Trà Vinh</option>
										<option value="TUYEN QUANG">Tuyên Quang</option>
										<option value="KIEN GIANG">Kiên Giang</option>
										<option value="VINH LONG">Vĩnh Long</option>
										<option value="VINH PHUC">Vĩnh Phúc</option>
										<option value="VUNG TAU">Vũng Tàu</option>
										<option value="YEN BAI">Yên Bái</option>
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
									<input type="text" class="form-control"
										name="class_id" required>
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