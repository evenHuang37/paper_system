<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title> 毕业生毕业设计</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="favicon.ico"> <link href="admin/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="admin/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="admin/css/animate.css" rel="stylesheet">
    <link href="admin/css/style.css?v=4.1.0" rel="stylesheet">

</head>
<%@page import="java.util.*" %>
<%@page import="control.tutor.MArticleBean" %>
<%
  request.setCharacterEncoding("UTF-8");
  List<MArticleBean> list=(ArrayList<MArticleBean>)request.getAttribute("list");
%>
<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
       
        <div class="row">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>毕业生毕业论文</h5>
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
                      
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th>序号</th>
                                    <th>已提交文件</th>
                                    <th>提交时间</th>                                
                                    <th>下载</th> 
                                </tr>
                            </thead>
                            <tbody> 
                                <tr>
                                  <td>1</td>
                                   <td><%=list.get(0).getHandedType()%></td>
                                   <td><%=list.get(0).getHandinTime()%></td>
                                   <td><a href='/MyPaper/StartPaperDownloadSevlet?filename=<%=list.get(0).getDownloadHref()%>'><%=list.get(0).getDownloadHref()%></a></td>
                                  </tr>                                                                 
                                
                               <tr>
                                 <%for(int i=1;i<list.size();i++)
                                 { %>
                                   <tr>
                                   <td><%=(i+1)%></td>
                                   <td><%=list.get(i).getHandedType()%></td>
                                   <td><%=list.get(i).getHandinTime()%></td>
                                   <td><a href='/MyPaper/DownLoadServlet?filename=<%=list.get(i).getDownloadHref()%>'><%=list.get(i).getDownloadHref()%></a></td>
                                   </tr>
                                <% } %>                                                                   
                               </tr>
                            </tbody>
                        </table>
                         
                    </div>
                </div>
            </div>
    </div>


    <!-- 全局js -->
    <script src="js/jquery.min.js?v=2.1.4"></script>
    <script src="js/bootstrap.min.js?v=3.3.6"></script>

    <!-- 自定义js -->
    <script src="js/content.js?v=1.0.0"></script>

    <!-- jQuery Validation plugin javascript-->
    <script src="js/plugins/validate/jquery.validate.min.js"></script>
    <script src="js/plugins/validate/messages_zh.min.js"></script>

    <script src="js/demo/form-validate-demo.js"></script>

    
    

</body>

</html>