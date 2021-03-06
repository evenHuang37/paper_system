<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%
    request.setCharacterEncoding("UTF-8");
    String download=request.getParameter("download"); 
    System.out.println(download);
    %>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title> -</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="favicon.ico"> <link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/plugins/markdown/bootstrap-markdown.min.css" />
    <link href="css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content">

                <div class="row">
                    <div class="col-lg-12">
                    <form id="my-awesome-dropzone" class="dropzone" action="/MyPaper/ReleaseNotice?download=<%=download%>" method="post">
                        <div class="ibox float-e-margins">
                            <div class="ibox-title">
                                <h5>发布公告信息</h5>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">主题：</label>
                                <div class="col-sm-8">
                                    <input type="text-align:left" placeholder="主题" class="form-control" name="title"> 
                                    <span class="help-block m-b-none"></span>
                                </div>
                             </div>
                            <div class="ibox-content">
                             <label class="form-group control-label">内容：</label>
                                <textarea name="content" data-provide="markdown" rows="10"></textarea>
                            </div>
                            <div class="ibox-content">
                        
                   <center>
                   <div class="form-group control-label">
                      <button class="btn btn-primary" type="submit" >发布</button>
                   </div>
                  </center>   
         </form>   
       <form id="form1" name="form1" method="post" action="/MyPaper/NoticeUploadServlet" enctype="multipart/form-data">    
          <table border="0" align="center"> 
                           <tr height="50px">
                            <td>添加附件：</td>
                            <td><input name="file" type="file" size="20" ></td>
                           </tr>    
                         <tr>   
                         <td></td>
                          <td>
                          &nbsp;&nbsp;&nbsp;&nbsp;
                          <input type="submit" name="submit" value="提交" >
                          &nbsp;&nbsp;&nbsp;&nbsp;
                           <input type="reset" name="reset" value="重置" >
                          </td>
                         </tr>
                        </table>
                     </form>

                </div>
            </div>
            

            </div>
            </div>
    </div>

    <!-- 全局js -->
    <script src="js/jquery.min.js?v=2.1.4"></script>
    <script src="js/bootstrap.min.js?v=3.3.6"></script>

    <!-- 自定义js -->
    <script src="js/content.js?v=1.0.0"></script>

    <!-- simditor -->
    <script type="text/javascript" src="js/plugins/markdown/markdown.js"></script>
    <script type="text/javascript" src="js/plugins/markdown/to-markdown.js"></script>
    <script type="text/javascript" src="js/plugins/markdown/bootstrap-markdown.js"></script>
    <script type="text/javascript" src="js/plugins/markdown/bootstrap-markdown.zh.js"></script>


    
    
</body>

</html>
