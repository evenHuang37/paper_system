<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>论文阶段信息jQuery Validation</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="admin/favicon.ico"> <link href="admin/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="admin/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="admin/css/animate.css" rel="stylesheet">
    <link href="admin/css/style.css?v=4.1.0" rel="stylesheet">

</head>
<%@page import="java.util.*" %>
<%@page import="model.vo.ArticleStage" %>
<body class="gray-bg">
<%
request.setCharacterEncoding("UTF-8");
List<ArticleStage> stage=((ArrayList<ArticleStage>)request.getAttribute("stage"));
%>
    <div class="wrapper wrapper-content animated fadeInRight">
       
        <div class="row">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>论文阶段信息</h5>
                    </div>
                    <div class="ibox-content">

                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th>阶段名称</th>
                                    <th>主要任务说明</th>
                                    <th>开始日期</th>
                                    <th>结束日期</th>
                                </tr>
                            </thead>
                            <tbody>
                               <%
                               for(int i=0;i<stage.size();i++)
                               {
                            	   out.println("<tr>");
                            	   out.println("<td>"+stage.get(i).getStageName()+"</td>");
                            	   out.println("<td>"+stage.get(i).getMissionExplain()+"</td>");
                            	   out.println("<td>"+stage.get(i).getBeginDate()+"</td>");
                            	   out.println("<td>"+stage.get(i).getEndDate()+"</td>");
                            	   out.println("</tr>");
                               }
                               %>
                            </tbody>
                            
                        </table>
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
