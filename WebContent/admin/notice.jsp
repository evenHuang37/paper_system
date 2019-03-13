<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title> - 文章列表</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="favicon.ico"> <link href="admin/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="admin/css/font-awesome.css?v=4.4.0" rel="stylesheet">

    <link href="admin/css/animate.css" rel="stylesheet">
    <link href="admin/css/style.css?v=4.1.0" rel="stylesheet">

</head>
<%@page import="java.util.*" %>
<%@page import="control.fam.NoticeInfo" %>
<%
  request.setCharacterEncoding("UTF-8");
  List<NoticeInfo> noticeList=(ArrayList<NoticeInfo>)request.getAttribute("noticeList");
%>
<body class="gray-bg">
    <div class="wrapper wrapper-content  animated fadeInRight blog">
        <div class="row">
            <div class="col-lg-4">
                <div class="ibox">
                <%
                  for(int i=0;i<noticeList.size();i++)
                  {
                	  out.println("<div class='ibox-content'>");
                	  out.println("<p class='btn-link'>"+noticeList.get(i).getNoticeTitle()+"</p>");
                	  out.println("<div class='small m-b-xs'>");
                	  out.println("<span class='text-muted'>"+noticeList.get(i).getNoticeDate()+"</span>");
                	  out.println("</div>");
                	  out.println("<p>"+noticeList.get(i).getNoticeContent()+"</p>");
                	  out.println("</div>");
                  }                  
                %>
                   
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
