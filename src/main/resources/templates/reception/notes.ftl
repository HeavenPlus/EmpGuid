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
    	.rec_con{
    		padding:10px;
    		margin:-22px auto;
    		width:1140px;
    		height:450px;
    		border:1px solid #F8F8F8;
    		background-color:#fff;
    	}
    </style>
</head>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<#include "notesNav.ftl">
				
			</div>
		</div>
		<ul class="breadcrumb">
			<li><a href="/EmpGuid/loginInterceptor/showNotes">学习平台</a></li>
			<li class="active">技术文章</li>
		</ul>
	</div>
	<div class="rec_con">		
		<table class="table table-hover table-striped">
			<tbody>
				<#list notesList as notes>
					<tr style="cursor: pointer;" onclick="location.href='/EmpGuid/study/notesDetails?id='+${notes.id};">
						<td>${notes.title}</td>
						<td style="text-align:right;">${notes.date?string('yyyy-MM-dd')}</td>
					</tr>
				</#list>
			</tbody>
		</table>
		<ul class="pagination" style="margin-top:0px;">
			<#if currentPage lte 1>
				<li class=disabled><a>上一页</a></li>
			<#else>
				<li><a href="/EmpGuid/study/selectAllNotes?page=${currentPage-1}">上一页</a></li>
			</#if>
			<#list 1..totalPage as index>
				<#if currentPage==index>
					<li class=disabled><a>${index}</a></li>
				<#else>
					<li><a href="/EmpGuid/study/selectAllNotes?page=${index}">${index}</a></li>
				</#if>
			</#list>
			<#if currentPage gte totalPage>
				<li class="disabled"><a>下一页</a></li>
			<#else>
				<li><a href="/EmpGuid/study/selectAllNotes?page=${currentPage+1}">下一页</a></li>
			</#if>
		</ul>
	</div>
	<br>
	<#include "footer.ftl">
	<#include "login_form.ftl">
</body>
</html>