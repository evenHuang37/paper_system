<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

    <title> - 登录</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <link href="admin/css/bootstrap.min.css" rel="stylesheet">
    <link href="admin/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="admin/css/animate.css" rel="stylesheet">
    <link href="admin/css/style.css" rel="stylesheet">
    <link href="admin/css/login.css" rel="stylesheet">

    <link rel="shortcut icon" href="favicon.ico"> <link href="admin/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="admin/css/plugins/iCheck/custom.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
    <script>
        if (window.top !== window.self) {
            window.top.location = window.location;
        }
    </script>

</head>

<body class="signin gray-bg">
<div id="wallpaper">
  <div class="header">
    <div class="logo"><img src="admin/img/logo1.png" hspace="160" vspace="20" /></div>
  </div>

    <div class="middle-box text-center  loginscreen animated fadeInDown">

                    <div class="ibox-content">
                         <form class="form-horizontal" role="form" action="/MyPaper/login">
                            <div class="form-group">

                                <div class="col-sm-12">
                                    <input type="text" placeholder="用户名" class="form-control" name="userID"> 
                                    
                                </div>
                            </div>
                            <div class="form-group">
                                
                                <div class="col-sm-12">
                                    <input type="password" placeholder="密码" class="form-control" name="userPwd">
                                </div>
                            </div>
                            <div class="form-group">
                            
<div class="col-sm-12">
    <select class="form-control" name="role">
        <option>毕业生</option>
        <option>导师</option>
        <option>院系教务管理人员</option>
        <option>管理员</option>
    </select>
</div>
</div>
                            <div class="form-group">
                                <div class="col-sm-12">
                                    <button class="btn btn-sm btn-info block full-width m-b" type="submit">登 录</button>
                                   
                                </div>
                            </div>
                        </form>
                    </div>
    </div>
</body>

<!-- 全局js -->
    <script src="admin/js/jquery.min.js?v=2.1.4"></script>
    <script src="admin/js/bootstrap.min.js?v=3.3.6"></script>

    <!-- 自定义js -->
    <script src="admin/js/content.js?v=1.0.0"></script>

    <!-- iCheck -->
    <script src="admin/js/plugins/iCheck/icheck.min.js"></script>
    <script>
        $(document).ready(function () {
            $('.i-checks').iCheck({
                checkboxClass: 'icheckbox_square-green',
                radioClass: 'iradio_square-green',
            });
        });
    </script>

</html>
