<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title> 查询成绩 jQuery Validation</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="favicon.ico"> <link href="admin/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="admin/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="admin/css/animate.css" rel="stylesheet">
    <link href="admin/css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
<%
String name=(String)request.getAttribute("name");
String stuID=(String)request.getAttribute("stuID");
String tutorScore=(String)request.getAttribute("tutorScore");
String replyScore=(String)request.getAttribute("replyScore");
String finalScore=(String)request.getAttribute("finalScore");


%>
    <div class="wrapper wrapper-content animated fadeInRight">
       
        <div class="row">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>我的成绩</h5>
                    </div>
                    <div class="ibox-content">

                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th>毕业生姓名</th>
                                    <th>毕业生学号</th>
                                    <th>论文分数</th>
                                    <th>答辩分数</th>
                                    <th>总成绩</th>
                                
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td><%=name %></td>
                                    <td><%=stuID %></td>
                                     <td><%=tutorScore %></td>
                                    <td><%=replyScore %></td>
                                    <td><%=finalScore %></td>
                                </tr>
                               
                              
                            </tbody>
                            
                        </table>
                     <div >                 
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
