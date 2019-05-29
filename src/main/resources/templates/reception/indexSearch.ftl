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
				<#include "nav.ftl">
			</div>
		</div>
	</div>
	<#if list??&& (list?size > 0)>
		<#if list?size < 4>
			<div style="width:1140px;height:500px;margin:0 auto;">
				<#list list as searchList>
					<div class="searchContent">
						<#if searchList.name??>
							<a style="color:#000;cursor:pointer;"><h4 onclick="location.href='/EmpGuid/recruit/recruitDetails?id='+${searchList.id}+'&recruitName=${searchList.recruit.recruitName}';">${searchList.name}</h4></a>
						<#else>
							<a style="color:#000;cursor:pointer;"><h4 onclick="location.href='/EmpGuid/recruit/generalDetails?id='+${searchList.id};">${searchList.title}</h4></a>
						</#if>
						<h5>${searchList.content}</h5>
					</div>
					<br>
				</#list>
			</div>
		<#else>
			<#list list as searchList>
				<div class="searchContent">
					<#if searchList.name??>
						<a style="color:#000;cursor:pointer;"><h4 onclick="location.href='/EmpGuid/recruit/recruitDetails?id='+${searchList.id}+'&recruitName=${searchList.recruit.recruitName}';">${searchList.name}</h4></a>
					<#else>
						<a style="color:#000;cursor:pointer;"><h4 onclick="location.href='/EmpGuid/recruit/generalDetails?id='+${searchList.id};">${searchList.title}</h4></a>
					</#if>
					<h5>${searchList.content}</h5>
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