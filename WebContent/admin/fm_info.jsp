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

    <link rel="shortcut icon" href="favicon.ico"> <link href="admin/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="admin/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="admin/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="admin/css/animate.css" rel="stylesheet">
    <link href="admin/css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
<%
String name=(String)request.getAttribute("name");
String managerID=(String)request.getAttribute("managerID");
String facultyName=(String)request.getAttribute("facultyName");
String email=(String)request.getAttribute("email");
String telephone=(String)request.getAttribute("telephone");
%>
    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>个人信息</h5>
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
                                <label class="col-sm-2">工号：</label>
                                <label class="col-sm-8">
                                <%=managerID %>    
                                </label>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2">院系：</label>
                                <label class="col-sm-8">
                                <%=facultyName %> 
                                </label>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2">邮箱：</label>
                                <label class="col-sm-8">
                                <%=email %>  
                                </label>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2">电话：</label>
                                <label class="col-sm-8">
                                <%=telephone %>   
                                </label>
                            </div> 
                        </form>
                    </div>
                </div>
        </div>
       
    
    

</body>

</html>
