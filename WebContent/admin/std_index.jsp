<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">

    <title> 毕业生 主页</title>

    <meta name="keywords" content="">
    <meta name="description" content="">

    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->

    <link rel="shortcut icon" href="admin/favicon.ico"> <link href="admin/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="admin/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
    <link href="admin/css/animate.css" rel="stylesheet">
    <link href="admin/css/style.css?v=4.1.0" rel="stylesheet">
</head>

<body class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden">
    <div id="wrapper">
        <!--左侧导航开始-->
        <nav class="navbar-default navbar-static-side" role="navigation">
            <div class="nav-close"><i class="fa fa-times-circle"></i>
            </div>
            <div class="sidebar-collapse">
                <ul class="nav" id="side-menu">
                    <li class="nav-header">
                        <div class="dropdown profile-element">
                            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                                <span class="clear">
                                    <span class="block m-t-xs" style="font-size:20px;">
                                        <i class="fa fa-area-chart"></i>
                                        <strong class="font-bold">毕业生</strong>
                                    </span>
                                </span>
                            </a>
                        </div>
                        
                        <div class="logo-element">毕业生
                        </div>
                    </li>
                    <li class="line dk"></li>
                    <li>
                        <a class="J_menuItem" href="/MyPaper/getInfo">
                            <i class="fa fa-home"></i>
                            <span class="nav-label">个人主页</span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <i class="fa fa fa-bar-chart-o"></i>
                            <span class="nav-label">毕业论文套表</span>
                            <span class="fa arrow"></span>
                        </a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a class="J_menuItem" href="/MyPaper/GetLoad">论文套表下载</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#">
                        <i class="fa fa-envelope"></i> 
                        <span class="nav-label">系统留言版 </span>
                        <span class="fa arrow"></span>
                        </a>
                        <ul class="nav nav-second-level">
                            <li><a class="J_menuItem" href="admin/std_msg.jsp">给指导老师留言</a>
                            </li>
                            <li><a class="J_menuItem" href="/MyPaper/getMessage">我的留言列表</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-edit"></i> <span class="nav-label">毕业论文</span><span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li><a class="J_menuItem" href="/MyPaper/getStage">论文阶段信息</a>
                            </li>
                            <li><a class="J_menuItem" href="/MyPaper/getTitle">选题信息</a>
                            </li>
                            <li><a class="J_menuItem" href="admin/std_title.jsp">申请选题</a>
                            </li>
                            <li><a class="J_menuItem" href="admin/std_startpaper.jsp">提交开题报告</a>
                            </li>
                            <li><a class="J_menuItem" href="admin/std_article.jsp">上传毕业论文</a>
                            </li>
                            </li>
                            </li>
                            <li><a class="J_menuItem" href="/MyPaper/getScore">查看成绩</a>
                            </li>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-desktop"></i> <span class="nav-label">公告信息</span><span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li><a class="J_menuItem" href="/MyPaper/ShowNotice">公告信息预览</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a class="J_menuItem" href="./login.jsp">
                            <i class="fa fa-home"></i>
                            <span class="nav-label">安全退出系统</span>
                        </a>
                    </li>
                </ul>
            </div>
        </nav>
        <!--左侧导航结束-->
        <!--右侧部分开始-->
        <div id="page-wrapper" class="gray-bg dashbard-1">
            <div class="row border-bottom">
                <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
                    <div class="navbar-header">
                     
                        <form class="navbar-form-custom" >
                            <div class="form-group">
                           
                        <img alt="image" src="admin/img/logo1.png"/>
                            </div>
                        </form>
                    </div>
                </nav>
            </div>
            <div class="row J_mainContent" id="content-main">
                <iframe id="J_iframe" width="100%" height="100%" src="admin/index.jsp?v=4.0" frameborder="0" data-id="admin/index.jsp" seamless></iframe>
            </div>
        </div>
        <!--右侧部分结束-->
    </div>

    <!-- 全局js -->
    <script src="admin/js/jquery.min.js?v=2.1.4"></script>
    <script src="admin/js/bootstrap.min.js?v=3.3.6"></script>
    <script src="admin/js/plugins/metisMenu/jquery.metisMenu.js"></script>
    <script src="admin/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
    <script src="admin/js/plugins/layer/layer.min.js"></script>

    <!-- 自定义js -->
    <script src="admin/js/hAdmin.js?v=4.1.0"></script>
    <script type="text/javascript" src="admin/js/index.js"></script>

    <!-- 第三方插件 -->
    <script src="admin/js/plugins/pace/pace.min.js"></script>
</body>

</html>
