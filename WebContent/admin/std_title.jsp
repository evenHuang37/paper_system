<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>ç³è¯·éé¢</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="favicon.ico"> <link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>申请选题</h5>
                    </div>
                    <div class="ibox-content">
                        <div class="row">
                            <div class="col-sm-12">
                                <form role="form" action="/MyPaper/applyTitle">
                                <small>注意：</small>
                                <p></p>
                                <small>1)您需要根据院系教务管理人员发布的选题信息来选题，不可超出选题信息范围之外。</small>
                                <p></p>
                                <small>2)如果您申请的选题指导老师没有同意，您可以修改内容，再次提交。</small>
                                <p></p>
                                    <div class="form-group">
                                    
                                        <label>选题根据</label>
                                        <input type="text" name="lie" placeholder="请输入您选题所依据的选题信息" class="form-control">
                                    </div>
                                    <div class="form-group">
                                        <label>论文题目</label>
                                        <input type="text" name="title" placeholder="请输入您的选题" class="form-control">
                                    </div>
                                    <div class="form-group">
                                        <label>论文简介</label>
                                        <input type="text" name="dec" placeholder="请输入您的选题简介" class="form-control">
                                    </div>
                                    <div>
                                        <button class="btn btn-sm btn-primary" type="submit"><strong>提交</strong>
                                        </button>
                                        <button class="btn btn-sm btn-white" type="reset"><strong>重置</strong>
                                        </button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </body>

    <!-- å¨å±js -->
    <script src="js/jquery.min.js?v=2.1.4"></script>
    <script src="js/bootstrap.min.js?v=3.3.6"></script>

    <!-- èªå®ä¹js -->
    <script src="js/content.js?v=1.0.0"></script>

    <!-- iCheck -->
    <script src="js/plugins/iCheck/icheck.min.js"></script>
    <script>
        $(document).ready(function () {
            $('.i-checks').iCheck({
                checkboxClass: 'icheckbox_square-green',
                radioClass: 'iradio_square-green',
            });
        });
    </script>

    
    

</body>

</html>
