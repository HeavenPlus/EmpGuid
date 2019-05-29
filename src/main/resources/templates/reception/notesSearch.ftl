<!DOCTYPE HTML>
<html>
	<#include "header.ftl">
	<style type="text/css">
		.searchContent{
			width:1140px;
			height:150px;
			margin:0 auto;
			border:1px solid #dfdfdf;
			overflow: hidden;
			padding:20px;
		}
		.searchContent h5{
			line-height:28px;
			color:gray;
		}
	</style>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<#include "notesNav.ftl">
			</div>
		</div>
	</div>
	<#if notesList??&& (notesList?size > 0)>
		<#if notesList?size < 4>
			<div style="width:1140px;height:500px;margin:0 auto;">
				<#list notesList as notes>
					<div class="searchContent">
						<a style="color:#000;cursor:pointer;"><h4 onclick="location.href='/EmpGuid/study/notesDetails?id='+${notes.id};">${notes.title}</h4></a>
						<h5>${notes.content}</h5>
					</div>
					<br>
				</#list>
			</div>
		<#else>
			<#list notesList as notes>
				<div class="searchContent">
					<a style="color:#000;cursor:pointer;"><h4 onclick="location.href='/EmpGuid/study/notesDetails?id='+${notes.id};">${notes.title}</h4></a>
					<h5>${notes.content}</h5>
				</div>
				<br>
			</#list>
		</#if>
	<#else>
		<div style="width:1140px;height:320px;margin:0 auto;text-align:center;color:gray;font-size:18px;">共找到0条相关内容</div>
	</#if>
<#include "footer.ftl">
<#include "login_form.ftl">
<script type="text/javascript" src="/EmpGuid/js/index.js"></script>
</body>
</html>