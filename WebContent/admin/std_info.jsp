<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>个人信息</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="admin/favicon.ico"> <link href="admin/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="admin/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="admin/css/animate.css" rel="stylesheet">
    <link href="admin/css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
<%
String name=(String)request.getAttribute("name");
String stuID=(String)request.getAttribute("stuID");
String facultyName=(String)request.getAttribute("facultyName");
String className=(String)request.getAttribute("className");
String year=(String)request.getAttribute("year");
String tutorName=(String)request.getAttribute("tutorName");
%>
    <div class="wrapper wrapper-content animated fadeInRight">
       
        <div class="row">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>我的个人信息</h5>
                        <div class="ibox-tools">
                            <a class="collapse-link">
                                <i class="fa fa-chevron-up"></i>
                            </a>
                            <a class="dropdown-toggle" data-toggle="dropdown" href="form_basic.html#">
                                <i class="fa fa-wrench"></i>
                            </a>
                            <a class="close-link">
                                <i class="fa fa-times"></i>
                            </a>
                        </div>
                    </div>
                    <div class="ibox-content">
                        <form class="form-horizontal m-t" id="commentForm">
                            <div class="form-group">
                                <label class="col-sm-2">姓名：</label>
                                <label class="col-sm-8">
                               <%=name %>
                                </label>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2">学号：</label>
                                <label class="col-sm-8">
                                <%=stuID %>
                                </label>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2">学院：</label>
                                <label class="col-sm-8">
                                  <%=facultyName %>
                                </label>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2">专业班级：</label>
                                <label class="col-sm-8">
                                   <%=className %>
                                </label>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2">毕业届数：</label>
                                <label class="col-sm-8">
                                <%=year %>               </label>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2">指导老师：</label>
                                <label class="col-sm-8">
                                 <%=tutorName %>
                                </label>
                            </div>
                            
                        </form>
                    </div>
                </div>
            </div>
    </div>


    <!-- 全局js -->
    <script src="admin/js/jquery.min.js?v=2.1.4"></script>
    <script src="admin/js/bootstrap.min.js?v=3.3.6"></script>

    <!-- 自定义js -->
    <script src="admin/js/content.js?v=1.0.0"></script>

    <!-- jQuery Validation plugin javascript-->
    <script src="admin/js/plugins/validate/jquery.validate.min.js"></script>
    <script src="admin/js/plugins/validate/messages_zh.min.js"></script>

    <script src="admin/js/demo/form-validate-demo.js"></script>

    
    

</body>

</html>
