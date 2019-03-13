<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,model.vo.Graduates"%>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>提交分数 jQuery Validation</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="favicon.ico"> <link href="admin/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="admin/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="admin/css/animate.css" rel="stylesheet">
    <link href="admin/css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
<%
 List list=(List)request.getAttribute("list");
%>
    <div class="wrapper wrapper-content animated fadeInRight">
       <form role="form" action="/MyPaper/submitScore" method="post">
        <div class="row">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>毕业生论文成绩</h5>
                        
                    </div>
                    <div class="ibox-content">

                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th>毕业生姓名</th>
                                    <th>毕业生学号</th>
                                    <th>论文分数</th>
                                
                                </tr>
                            </thead>
                            <tbody>
                            <%

for (int i=0;i<list.size();i++){ 
Graduates t=(Graduates)list.get(i);%>
<tr><td> 
<%=t.getStuID()%></td><td>
<%=t.getStuName()%></td><td><input type="text" name="score<%=i%>" placeholder="请输入分数" class="form-control">
</td></tr>
<%
}
%>
                                  
                            </tbody>
                            
                        </table>
                        <div >
                        <center>
                                    <button class="btn btn-primary" type="submit">发布</button>&nbsp;&nbsp;
                                                 </center>
                                </div>
                                  <div >
                                    
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

    <!-- jQuery Validation plugin javascript-->
    <script src="admin/js/plugins/validate/jquery.validate.min.js"></script>
    <script src="admin/js/plugins/validate/messages_zh.min.js"></script>

    <script src="admin/js/demo/form-validate-demo.js"></script>

    
    

</body>

</html>
