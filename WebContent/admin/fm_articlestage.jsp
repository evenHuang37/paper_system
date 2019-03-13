<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<script language="javascript">
function addrows(){
var len = optionlist.rows.length; //得到table的行数
var obj = optionlist.insertRow(len);//在最后一行插入
/**插入第一列**/
obj.insertCell(0);
obj.cells(0).innerHTML="<input type='text' name='stage' class='form-control'>";
obj.insertCell(1);
obj.cells(1).innerHTML="<input type='text' name='abstracts' class='form-control'>";
obj.insertCell(2);
obj.cells(2).innerHTML="<input type='text' name='beginDate' class='form-control'>"
	obj.insertCell(3);
obj.cells(3).innerHTML="<input type='text' name='endDate' class='form-control'>";
}
function deleterow(){
	var len = optionlist.rows.length;
	if(len <= 1) {
	alert("至少要有一个选项");
	}
	else {
	optionlist.deleteRow(len-1);//删除最后一项
	}
	}
	function getOptionCount(){
	return optionlist.rows.length;
	}
	</script> 
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>发布阶段信息</title>
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
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>论文阶段信息</h5>
                    </div>
                    <form action="/MyPaper/subStageInfo" method="post">
                    <div class="ibox-content">

                        <table class="table table-bordered" id="optionlist">
                            <thead>
                                <tr>
                                    <th>阶段名称</th>
                                    <th>主要任务说明</th>
                                    <th>开始日期</th>
                                    <th>结束日期</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td><input type="text" name="stage" class="form-control"></td>
                                    <td><input type="text" name="abstracts" class="form-control"></td>
                                     <td><input type="text" name="beginDate" class="form-control"></td>
                                    <td><input type="text" name="endDate" class="form-control"></td>
                                </tr>
                                 <input type="button" id="bt1" value="添加选项" onClick="addrows();">
<input type="button" id="bt2" value="删除选项" onClick="deleterow();"> 
                             
                            </tbody>
                           
                        </table>
                        <div >
                        
                        <center>
                                    <button class="btn btn-primary" type="reset">重置</button>
                                    <button class="btn btn-primary" type="submit">发布</button>             </center>
                                </div>
                             <div >
                          </form>          
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
