<!DOCTYPE HTML>
<html>
	<#include "header.ftl">
	<link rel="stylesheet" href="/EmpGuid/css/videos.css">
<body>
	<div class="container" style="margin:0 auto;">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<#include "videoNav.ftl">
			</div>
		</div>
	</div>
	<div style="width:1140px;height:400px;margin:0 auto;overflow:hidden;">
		<#include "video_banner.ftl">
	</div>
	<#list tecTypeVORandom3List as tecTypeList>
		<div style="width:1140px;margin:50px auto;text-align:center;">
			<h4>${tecTypeList.typeName}</h4><hr>
			<div class="row clearfix">
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
			</div>
		</div>
	</#list>
	<#include "footer.ftl">
	<#include "login_form.ftl">
	<script type="text/javascript" src="/EmpGuid/js/index.js"></script>
	<script type="text/javascript" src="/EmpGuid/js/videos.js"></script>
</body>
</html>