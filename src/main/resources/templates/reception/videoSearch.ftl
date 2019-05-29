<!DOCTYPE HTML>
<html>
	<#include "header.ftl">
	<style type="text/css">
		.searchContent{
			width:1140px;
			height:150px;
			margin:0 auto;
			border:1px solid #dfdfdf;
			padding:10px 10px 10px 20px;
		}
		.searchContent div{
			float:left;
			margin-left:10px;
		}
		.videoContent h5{
			line-height:40px;
		}
	</style>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<#include "videoNav.ftl">
			</div>
		</div>
	</div>
	<#if videoVOList??&& (videoVOList?size > 0)>
		<#if videoVOList?size < 4>
			<div style="width:1140px;height:500px;margin:0 auto;">
			<#list videoVOList as video>
				<div class="searchContent">
					<div style="width:200px;height:100%;"><img src="/EmpGuid/upload/${video.image}" width="100%" height="100%"></div>
					<div class="videoContent" style="width:850px;height:100%;padding:10px;overflow: hidden;">
						<a style="color:#000;" href="/EmpGuid/study/showVideoDetails?id=${video.id}"><h4>${video.title}</h4></a>
						<p style="color:gray;">${video.time}</p>
						<h5 style="color:gray;">${video.description}</h5>
					</div>
				</div><br>
			</#list>
			</div>
		<#else>
			<#list videoVOList as video>
			<div class="searchContent">
				<div style="width:200px;height:100%;"><img src="/EmpGuid/upload/${video.image}" width="100%" height="100%"></div>
				<div class="videoContent" style="width:850px;height:100%;padding:10px;overflow: hidden;">
					<a style="color:#000;" href="/EmpGuid/study/showVideoDetails?id=${video.id}"><h4>${video.title}</h4></a>
					<p style="color:gray;">${video.time}</p>
					<h5 style="color:gray;">${video.description}</h5>
				</div>
			</div><br>
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