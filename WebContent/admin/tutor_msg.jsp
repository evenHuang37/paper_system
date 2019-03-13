<%@page import="model.vo.Graduates"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title> 留言板</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="admin/favicon.ico"> <link href="admin/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="admin/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="admin/css/animate.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="admin/css/plugins/markdown/bootstrap-markdown.min.css" />
    <link href="admin/css/style.css?v=4.1.0" rel="stylesheet">

</head>
<body class="gray-bg">
<%
request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("UTF-8");
List<Graduates> graduates=(ArrayList<Graduates>)request.getAttribute("graduates");
%>
    <div class="wrapper wrapper-content">
         <form action="/MyPaper/msgToStd">
                <div class="row">
                <div class="ibox-content">
    <select class="form-control" name="graduateID">
        <option>---选择毕业生---</option>
        <%
        for(int i=0;i<graduates.size();i++)
        {
        	out.println("<option>"+graduates.get(i).getStuID()+"</option>");
        }
        %>
    </select>
</div>
                </div>
                <div class="row">
                    <div class="col-lg-12">
                        <div class="ibox float-e-margins">
                            <div class="ibox-title">
                                <h5>给毕业生留言</h5>
                            </div>
                            <div class="ibox-content">
                                <textarea name="content" data-provide="markdown" rows="10"></textarea>
                            </div>
                            <div class="ibox-content">
                                    <button class="btn btn-primary" type="submit">提交</button>
                                </div>
                        </div>
                    </div>
                </div>
            </form>
            </div>

    <!-- 全局js -->
    <script src="admin/js/jquery.min.js?v=2.1.4"></script>
    <script src="admin/js/bootstrap.min.js?v=3.3.6"></script>

    <!-- 自定义js -->
    <script src="admin/js/content.js?v=1.0.0"></script>

    <!-- simditor -->
    <script type="text/javascript" src="admin/js/plugins/markdown/markdown.js"></script>
    <script type="text/javascript" src="admin/js/plugins/markdown/to-markdown.js"></script>
    <script type="text/javascript" src="admin/js/plugins/markdown/bootstrap-markdown.js"></script>
    <script type="text/javascript" src="admin/js/plugins/markdown/bootstrap-markdown.zh.js"></script>


    
    
</body>

</html>
