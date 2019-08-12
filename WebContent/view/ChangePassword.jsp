<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Đổi mật khẩu</title>

  <!-- Custom fonts for this template-->
  <link href="template/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="template/css/sb-admin-2.min.css" rel="stylesheet">
</head>
<body class="bg-gradient-primary">

  <div class="container">

    <!-- Outer Row -->
    <div class="row justify-content-center">

      <div class="col-xl-10 col-lg-12 col-md-9">

        <div class="card o-hidden border-0 shadow-lg my-5">
          <div class="card-body p-0">
            <!-- Nested Row within Card Body -->
            <div class="row">
              <div class="col-lg-6 d-none d-lg-block bg-password-image"></div>
              <div class="col-lg-6">
                <div class="p-5">
                  <div class="text-center">
                    <h1 class="h4 text-gray-900 mb-2">Đổi Mật Khẩu</h1>
                    <p class="mb-4">Nhập mật khẩu hiện tại và mật khẩu mới!</p>
                  </div>
                  <form class="user" action="ChangePassword" method="POST">
                    <div class="form-group">
                      <input name="currentpassword" type="password" class="form-control form-control-user" id="exampleInputEmail" aria-describedby="emailHelp" placeholder="Current Password...">
                    </div>
                    
                <div class="form-group row">
                  <div class="col-sm-6 mb-3 mb-sm-0">
                    <input name="newpassword1" type="password" class="form-control form-control-user" id="exampleInputPassword" placeholder=" New Password">
                  </div>
                  <div class="col-sm-6">
                    <input name="newpassword2" type="password" class="form-control form-control-user" id="exampleRepeatPassword" placeholder="Repeat New Password">
                  </div>
                </div>
                    
                    <input type="submit" class="btn btn-primary btn-user btn-block" value="Lưu thay đổi">
                  </form>
                  <p style="text-align: center; margin-top: 20px; color: red;">${tb8}</p>
                  <div class="text-center">
                    <a class="small" href="Login">${tb9}</a>
                  </div>
                  <hr>
                  <div class="text-center">
                    <a class="small" href="Login">Quay lại trang chủ</a> <!-- Quay về login nếu đã tồn tại session account sẽ tự chuyển hướng đến home -->
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>

      </div>

    </div>

  </div>

  <!-- Bootstrap core JavaScript-->
  <script src="template/vendor/jquery/jquery.min.js"></script>
  <script src="template/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="template/vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="template/js/sb-admin-2.min.js"></script>

</body>
</html>