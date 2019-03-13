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

    <link rel="shortcut icon" href="favicon.ico"> <link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/plugins/markdown/bootstrap-markdown.min.css" />
    <link href="css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content">

                <div class="row">
                <form action="/MyPaper/gramsg" method="post">
                        <div class="ibox float-e-margins">
                            <div class="ibox-title">
                                <h5>给老师留言</h5>
                            </div>
                            <div class="ibox-content">
                                <textarea name="content" data-provide="markdown" rows="10"></textarea>
                            </div>
                            <div class="ibox-content">
                                    <button class="btn btn-primary" type="submit">提交</button>
                                </div>
                        </div>
                 </form>
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
