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

<title>Danh sách sinh viên</title>

<!-- Custom fonts for this template -->
<link href="template/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="template/css/sb-admin-2.min.css" rel="stylesheet">

<!-- Custom styles for this page -->
<link href="template/vendor/datatables/dataTables.bootstrap4.min.css"
	rel="stylesheet">

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
					<div class="card shadow mb-4">
						<div class="card-header py-3">
							<h2 class="m-0 font-weight-bold text-primary">Bảng Sinh Viên</h2>
							<div align="right" style="margin-bottom: -48px;">
								<a href="admin-student-add" class="btn btn-primary"
									style="margin-right: 15px; margin-bottom: 38px"> Thêm Sinh
									Viên</a>
							</div>

						</div>
						<div class="card-body">
							<div class="table-responsive">

								<!-- <table class="table table-hover table-bordered "> -->


								<table class="table table-bordered" id="dataTable" width="100%"
									cellspacing="0">
									<thead>
										<tr>
											<th class="th-sm">Mã sinh viên</th>
											<th class="th-sm">Tên sinh viên</th>
											<th class="th-sm">Giới tính</th>
											<th class="th-sm">Email</th>
											<th class="th-sm">Ngày sinh</th>
											<th class="th-sm">Nơi sinh</th>
											<th class="th-sm">Lớp</th>
											<th class="th-sm">Actions</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="student" items="${list}">
											<tr>
												<td><c:out value="${student.id}"></c:out></td>
												<td><c:out value="${student.name}"></c:out></td>
												<td><c:out value="${student.gender}"></c:out></td>
												<td><c:out value="${student.email}"></c:out></td>
												<td><c:out value="${student.birthDate}"></c:out></td>
												<td><c:out value="${student.birthPlace}"></c:out></td>
												<td><c:out value="${student.classroom.id}"></c:out></td>
												<td><div class="d-inline-flex">
														<a class="btn btn btn-primary"
															href="admin-student-update?studentId=${student.id}">
															<!-- <i class="fas fas fa-edit fa-fw mr-2 text-gray-400"></i> -->
															Sửa
														</a> <a class="btn btn btn-danger ml-2"
															href="admin-student-delete?studentId=${student.id}">
															<!-- <i class="fas fas fa-minus fa-fw mr-2 text-gray-400"></i> -->
															Xóa
														</a>

													</div></td>
											</tr>
										</c:forEach>

									</tbody>
								</table>
							</div>
						</div>
					</div>
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
	<script src="template/vendor/datatables/jquery.dataTables.min.js"></script>
	<script src="template/vendor/datatables/dataTables.bootstrap4.min.js"></script>

	<!-- Page level custom scripts -->
	<script src="template/js/demo/datatables-demo.js"></script>
</body>
</html>