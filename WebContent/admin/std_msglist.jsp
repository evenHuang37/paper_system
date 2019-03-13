<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> - 通知 &amp; 提示</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="admin/favicon.ico"> <link href="admin/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="admin/css/font-awesome.css?v=4.4.0" rel="stylesheet">

    <link href="admin/css/animate.css" rel="stylesheet">
    <link href="admin/css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeIn">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>我的留言板</h5>
                    </div>
                    <div class="ibox-content">
                        
                      <%  
                          request.setCharacterEncoding("UTF-8");
                          response.setCharacterEncoding("UTF-8");
                          int listnum=(Integer)request.getAttribute("listnum");
                          for(int i=0;i<listnum;i++){
                            out.println("<div class='alert alert-success'>");                      	 
                            System.out.println("message"+i);
                        	out.println(request.getAttribute("message"+i));
                        	out.println("</div>");
                          }
                      %> 
                       
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- 全局js -->
    <script src="admin/js/jquery.min.js?v=2.1.4"></script>
    <script src="admin/js/bootstrap.min.js?v=3.3.6"></script>



    <!-- 自定义js -->
    <script src="admin/js/content.js?v=1.0.0"></script>   

</body>

</html>
