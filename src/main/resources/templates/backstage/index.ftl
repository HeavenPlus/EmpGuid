<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>后台管理</title>
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/EmpGuid/css/easyui.css">
	<link rel="stylesheet" type="text/css" href="/EmpGuid/css/icon.css">
	<script type="text/javascript" src="/EmpGuid/js/jquery.min.js"></script>
	<script type="text/javascript" src="/EmpGuid/js/jquery.easyui.min.js"></script>
	<style type="text/css">
		html,body{
			padding:0;
			margin:0;
			height:100%;
		}
		ul{
			list-style:none;
			padding:0;
			margin:0;
		}
		ul li{
			height:30px;
			width:143px;
			border-bottom:1px solid #dedede;
			text-align:center;
			line-height:30px;
			cursor:pointer;
		}
		.guid_title .panel-title{
			font-size:20px;
			height:40px;
			line-height:40px;
			text-align:center;
        }
		.panel-title{
			font-size: 14px;
			font-weight: bold;
			color: #0E2D5F;
			height: 16px;
			line-height: 16px;
			text-align: center;
		}
	</style>
</head>
<body>
    <div class="easyui-layout" style="width:100%;height:100%;">
        <div data-options="region:'north'" style="height:70px;text-align:center;" >
			<span style="font-size:30px;line-height:68px;">大&nbsp;&nbsp; 学&nbsp;&nbsp; 生 &nbsp;&nbsp; 就 &nbsp;&nbsp; 业 &nbsp;&nbsp; 指&nbsp; &nbsp; 导 &nbsp; &nbsp; 及 &nbsp; &nbsp; 教 &nbsp; &nbsp; 育&nbsp; &nbsp;  平 &nbsp; &nbsp; 台</span>
		</div>
        <div data-options="region:'south',split:true" style="height:50px;background-color:rgb(51,51,51);text-align:center;color:#fff;line-height:40px;">@郑州轻工业大学 软件学院 软件工程（软件开发15-01）</div>
        <div data-options="region:'west',split:true,headerCls:'guid_title'" title="导航菜单" style="width:150px;">
            <div class="easyui-accordion" data-options="fit:true,border:false">
                <div title="招聘信息" data-options="selected:true" style="padding:0;">
                    <ul style="font-size:12px;">
						<li onclick="openURL('信息列表', '/EmpGuid/manager/annoList')">信息列表</li>
						<li onclick="openURL('信息列表', '/EmpGuid/manager/generList')">招聘简章</li>
						<li onclick="openURL('添加信息', '/EmpGuid/manager/addAnno')">添加信息</li>
					</ul>
                </div>
                <div title="就业指导" style="padding:0">
                    <ul style="font-size:12px;">
						<li onclick="openURL('信息列表', '/EmpGuid/manager/guidInfoList')">信息列表</li>
						<li onclick="openURL('添加信息', '/EmpGuid/manager/addGuidInfo')">添加信息</li>
					</ul>
                </div>
				<div title="技术文章" style="padding:0">
                    <ul style="font-size:12px;">
						<li onclick="openURL('信息列表', '/EmpGuid/manager/notesList')">信息列表</li>
						<li onclick="openURL('添加信息', '/EmpGuid/manager/addNotes')">添加信息</li>
					</ul>
                </div>
				<div title="技术视频" style="padding:0">
                    <ul style="font-size:12px;">
						<li>增</li>
						<li>删</li>
						<li>改</li>
						<li>查</li>
					</ul>
                </div>
            </div>
        </div>
        <div id="pageContent" data-options="region:'center',title:'欢迎'">
            
        </div>
    </div>
	<script type="text/javascript">
		$(function(){
			$("#pageContent").panel('refresh','/EmpGuid/manager/welcome');
		})
		function openURL(title, url) {
			$("#pageContent").panel({
				title: title,
				href: url
			});
		}
	</script>
</body>
</html>