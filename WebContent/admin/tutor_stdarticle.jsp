<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title> - 表单验证 jQuery Validation</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="favicon.ico"> <link href="admin/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="admin/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="admin/css/animate.css" rel="stylesheet">
    <link href="admin/css/style.css?v=4.1.0" rel="stylesheet">

</head>
<%@page import="java.util.*" %>
<%@page import="control.tutor.StdArticleBean" %>
<body class="gray-bg">
<%
request.setCharacterEncoding("UTF-8");
List<StdArticleBean> list=(ArrayList<StdArticleBean>)request.getAttribute("list");
%>
    <div class="wrapper wrapper-content animated fadeInRight">
       
        <div class="row">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>毕业生毕业设计</h5>
                        <div class="ibox-tools">
                            <a class="collapse-link">
                                <i class="fa fa-chevron-up"></i>
                            </a>
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                                <i class="fa fa-wrench"></i>
                            </a>
                            <a class="close-link">
                                <i class="fa fa-times"></i>
                            </a>
                        </div>
                    </div>
                    <div class="ibox-content">
                      
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th>序号</th>
                                    <th>姓名</th>
                                    <th>学号</th>
                                    <th>论文题目</th>
                                    <th>状态</tr>
                                </tr>
                            </thead>
                            <tbody>
                            <%for(int i=0;i<list.size();i++)
                            { %>
                                <tr>
                                <td><%=(i+1)%></td>
                                <td><a href='/MyPaper/FindStuArticle?stuID=<%=list.get(i).getGraID()%>'><%=list.get(i).getGraName()%></a></td>
                                <td><%=list.get(i).getGraID()%></td>
                                <td><%=list.get(i).getArticleTitle()%></td>
                                <td><%=list.get(i).getState()%></td>
                                </tr>
                            <%}%>
                            </tbody>
                        </table>
                         
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