<%@ page language="java"  contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,model.vo.Titles" %>  
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>è®ºæéé¢ä¿¡æ¯jQuery Validation</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="admin/favicon.ico"> <link href="admin/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="admin/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="admin/css/animate.css" rel="stylesheet">
    <link href="admin/css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
<%
 List list=(List)request.getAttribute("list");

%>
    <div class="wrapper wrapper-content animated fadeInRight">
       
        <div class="row">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>论文选题信息</h5>
                    </div>
                    <div class="ibox-content">

                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th>序号</th>
                                    <th>可用选项</th>
                                    <th>选题简介</th>
                                </tr>
                            </thead>
                           <tbody> 
<%

for (int i=0;i<list.size();i++){ 
Titles t=(Titles)list.get(i);%>
<tr><td> 
<%=t.getTitleID()%></td><td>
<%=t.getTitleName()%></td><td>
<%=t.getTitleAbstract()%></td></tr>

<%
}
%>

</tbody>
                            
                        </table>
                    </div>
                </div>
    </div>


    <!-- å¨å±js -->
    <script src="admin/js/jquery.min.js?v=2.1.4"></script>
    <script src="admin/js/bootstrap.min.js?v=3.3.6"></script>

    <!-- èªå®ä¹js -->
    <script src="admin/js/content.js?v=1.0.0"></script>

    <!-- jQuery Validation plugin javascript-->
    <script src="admin/js/plugins/validate/jquery.validate.min.js"></script>
    <script src="admin/js/plugins/validate/messages_zh.min.js"></script>

    <script src="admin/js/demo/form-validate-demo.js"></script>

    
    

</body>

</html>
