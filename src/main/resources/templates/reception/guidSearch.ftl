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
				<#include "guidInfoNav.ftl">
			</div>
		</div>
	</div>
	<#if guidInfoVOList??&& (guidInfoVOList?size > 0)>
		<#if guidInfoVOList?size < 4>
			<div style="width:1140px;height:500px;margin:0 auto;">
				<#list guidInfoVOList as guidInfoVO>
					<div class="searchContent">
						<a style="color:#000;cursor:pointer;"><h4 onclick="location.href='/EmpGuid/guidInfo/guidInfoDetails?id='+${guidInfoVO.id}+'&guidName=${guidInfoVO.guidType.type}';">${guidInfoVO.title}</h4></a>
						<h5>${guidInfoVO.content}</h5>
					</div>
					<br>
				</#list>
			</div>
		<#else>
			<#list guidInfoVOList as guidInfoVO>
				<div class="searchContent">
					<a style="color:#000;cursor:pointer;"><h4 onclick="location.href='/EmpGuid/guidInfo/guidInfoDetails?id='+${guidInfoVO.id}+'&guidName=${guidInfoVO.guidType.type}';">${guidInfoVO.title}</h4></a>
					<h5>${guidInfoVO.content}</h5>
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