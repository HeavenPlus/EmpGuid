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
    		padding:20px 0 10px 80px;
    		margin:-23px auto;
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
			<li><a href="/EmpGuid/recruit/generalMore">校园宣讲会</a></li>
			<li class="active">校园宣讲会详情</li>
		</ul>
	</div>
	<div class="detail_con">		
		<div class="detail_header">
			<table class="table table-striped">
				<tbody>
					<tr>
						<td colspan="3" style="text-align:center;font-size:18px;line-height:30px;">${general.title}</td>
						<td style="text-align:right;font-size:12px;line-height:30px;">来源：${general.author}</td>
						<td style="text-align:right;font-size:12px;line-height:30px;">发布日期：${general.date?string('yyyy-MM-dd')}</td>
					</tr>
				</tbody>
			</table>
		</div>		
	</div>
	<div style="width:1140px;height:300px;margin:23px auto;background-color:#fff;">
		<div style="width:500px;height:300px;margin-left:50px;padding:30px;float:left;">
			<p><font color="gray">单位性质：</font>${general.chara}</p>
			<p><font color="gray">单位行业：</font>${general.vocation}</p>
			<p><font color="gray">单位规模：</font>${general.peopleNum}</p>
			<p><font color="gray">宣讲时间：</font>${general.startDate?string('yyyy-MM-dd hh:mm')} - ${general.endDate?string('hh:mm')}</p>
			<p><font color="gray">宣讲学校：</font>${general.school}</p>
			<p><font color="gray">宣讲地址：</font>${general.address}</p>
			<p><font color="gray">公司邮箱：</font>${general.email}</p>
			<p><font color="gray">联系电话：</font>${general.telNum}</p>
		</div>
		<div style="height:300px;width:300px;float:left;margin-left:50px;text-align:center;">
			
		</div>
	</div>
	<pre class="rec_text">${general.content}</pre><br><br>
	<#include "footer.ftl">
	<#include "login_form.ftl">
</body>
</html>