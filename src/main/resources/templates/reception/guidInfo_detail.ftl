 <!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>详情页面</title>
    <#include "header.ftl">
    <script type="text/javascript" src="/EmpGuid/js/index.js"></script>
    <style type="text/css">
    	body{
    		background-color:#dedede;
    	}
    	.detail_con{
    		padding:10px;
    		margin:-22px auto;
    		width:1140px;
    		border:1px solid #F8F8F8;
    		background-color:#fff;
    	}
    	.detail_header{
    		width:100%;
    		height:40px;
    	}
    	.rec_text{
    		padding:30px;
    		margin:0 auto;
    		width:1140px;
    		border:1px solid #F8F8F8;
    		background-color:#fff;
    	}
    	pre {
			white-space: pre-wrap;
			word-wrap: break-word;
		}
    </style>
</head>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<#include "nav.ftl">
				
			</div>
		</div>
		<ul class="breadcrumb">
			<li><a href="/EmpGuid/recruit/index">主页</a></li>
			<li><a href="/EmpGuid/guidInfo/guidInfo?typeId=${guidInfo.typeId}&guidName=${guidName}">${guidName}</a></li>
			<li class="active">${guidName}详情</li>
		</ul>
	</div>
	<div class="detail_con">		
		<div class="detail_header">
			<table class="table table-striped">
				<tbody>
					<tr>
						<td colspan="3" style="text-align:center;font-size:18px;line-height:30px;">${guidInfo.title}</td>
						<td style="text-align:right;font-size:12px;line-height:30px;">作者：${guidInfo.author}</td>
						<td style="text-align:right;font-size:12px;line-height:30px;">日期：${guidInfo.date?string('yyyy-MM-dd')}</td>
					</tr>
				</tbody>
			</table>
		</div>		
	</div>
	<pre class="rec_text">${guidInfo.content}</pre>
	<#include "footer.ftl">
	<#include "login_form.ftl">
</body>
</html>