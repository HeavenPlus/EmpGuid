<!DOCTYPE HTML>
<html>
	<#include "header.ftl">
	<link rel="stylesheet" href="/EmpGuid/css/videos.css">
	<style type="text/css">
		.tec_type{
			padding:15px 0 0 0;
		}
		.tec_type li{
			float:left;
			margin-left:15px;
			list-style:none;
			cursor:pointer;
		}
		.video_type{
			padding:15px 0 0 0;
		}
		.video_type li{
			float:left;
			margin-left:15px;
			list-style:none;
			cursor:pointer;
		}
		.video_list{
			width:1140px;
			margin:0 auto;
			padding:10px 0 30px 50px;
		}
	</style>
<body>
	<div class="container" style="margin:0 auto;">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<#include "videoNav.ftl">
			</div>
		</div>
	</div>
	<div style="width:1140px; height:50px;margin:0 auto;border-top:1px solid #dfdfdf;">
		<ul class="tec_type">
			<li><strong>方向：</strong></li>
			<li onclick="location.href='/EmpGuid/study/showVideos'">全部</li>
			<#list allTecTypeList as allTecType>
				<li onclick="location.href='/EmpGuid/study/showVideos?typeId=${allTecType.id}'">${allTecType.typeName}</li>
			</#list>
		</ul>
	</div>
	<div style="width:1140px;height:100px;margin:0 auto;border-top:1px solid #dfdfdf;">
		<ul class="video_type" id="videoType">
			<li><strong>分类：</strong></li>
			<li onclick="location.href='/EmpGuid/study/showVideosByType'">全部</li>
			<#list tecTypeVOs as tecTypeList>
				<#list tecTypeList.videoTypeVOs as videoTypeList>
					<li name="category" id="li_${videoTypeList.id}" onclick="location.href='/EmpGuid/study/showVideosByType?typeId=${videoTypeList.id}'">${videoTypeList.typeName}</li>
				</#list>
			</#list>
		</ul>
	</div>
	<div style="margin:0 auto;width:300px;text-align:center;color:red;font-size:16px;">
		<strong><#if tecType??>${tecType}</#if>&nbsp;&nbsp;<#if videoType??>${videoType}</#if></strong>
	</div>
	<hr>
	<div class="video_list">
		<div class="row clearfix">
			<#list tecTypeVOs as tecTypeList>
				<#list tecTypeList.videoTypeVOs as videoTypeList>
					<#list videoTypeList.videoVOs as videoList>
						<div class="col-md-4">
							<div class="thumbnail" style="height:360px;width:300px;">
								<img style="cursor:pointer;" onclick="location.href='/EmpGuid/study/showVideoDetails?id=${videoList.id}'" width="300" src="/EmpGuid/upload/${videoList.image}" />
								<div class="caption">
									<h5><strong>${videoList.title}</strong></h5>
									<h6 style="text-indent:2em;line-height:18px;">${videoList.description}</h6>
								</div>
							</div>
						</div>	
					</#list>
				</#list>
			</#list>
		</div>
	</div>
	<#include "footer.ftl">
	<#include "login_form.ftl">
	<script type="text/javascript" src="/EmpGuid/js/index.js"></script>
	<script type="text/javascript" src="/EmpGuid/js/videos.js"></script>
</body>
</html>