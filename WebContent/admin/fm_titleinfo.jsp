<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>提交分数 jQuery Validation</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="favicon.ico"> <link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
       
        <div class="row">
                <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>上传选题信息</h5>
                    </div>
                    <div class="ibox-content">
                        <form id="form1" name="form1" method="post" action="/MyPaper/subTitles">
                           <table border="0" align="center"> 
                           <tr height="50px">
                            <td>上传选题excel表：</td>
                            <td><input name="fileToUpload" type="file" size="20" ></td>
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
