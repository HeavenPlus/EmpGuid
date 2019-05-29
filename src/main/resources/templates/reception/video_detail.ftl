 <!DOCTYPE html>
<html lang="en">
<#include "header.ftl">
<script type="text/javascript" src="/EmpGuid/js/index.js"></script>
<!--封装好的视频布局样式-->
<link rel="stylesheet" href="/EmpGuid/css/jsmodern.min.css">
<!--mp4视频插件-->
<script src="/EmpGuid/js/jsmodern.min.js"></script>

<style type="text/css">
	.video_box{
		width:1140px;
		height:452px;
		margin: 0 auto;
	}
	#video {
		width: 750px;
		height: 450px;
		position: relative;
		
	}
	#video video {
		width: 100%;
		height: 100%;
		object-fit: fill;
	}
	.VideoBtn {
		position: absolute;
		left: 50%;
		top: 50%;
		display: block;
		width: 70px;
		height: 70px;
		margin-left: -35px;
		margin-top: -35px;
		cursor: pointer;
		z-index: 10;
	}
	.video_datil{
		width:350px;
		height:450px;
		margin-left:40px;
		padding:0 0 0 10px;
	}
	.video_box div{
		float:left;
	}
	.gu{
		width:1170px;
		margin:0 auto;
	}
</style>
<!--视频插件调用方法-->
<script type="text/javascript">
	$(function () {
		//视频
		jsModern.video("#video");
		//播放视频
		$(".VideoBtn").click(function () {
			var video = document.getElementById("videoShow");
			video.play();
			$('.VideoBtn').hide();
		})
		//监听视频的播放状态
		var video = document.getElementById("videoShow");
		video.oncanplay = function () {
			$(".VideoBtn").show();
			//$("#video").attr("poster","");
		}
		//视频播放事件
		video.onplay = function () {
			$("#videoShow").attr("poster", "");
			$(".VideoBtn").hide();
		};
		video.onplaying = function () {
			$(".VideoBtn").hide();
		};
	
		//视频暂停事件
		video.onpause = function () {
			$(".VideoBtn").show();
		};
		//点击视频周围暂停播放图片出现
		video.onclick = function () {
			if (video.paused) {
				$(".VideoBtn").hide();
				video.play();
			} else {
				$(".VideoBtn").show();
				video.pause();
			}
		};
	})
</script>
<body>
	<div class="container" style="margin:0 auto;">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<#include "videoNav.ftl">
			</div>
		</div>
	</div>
	<div class="row clearfix gu">
		<div class="col-md-12 column" >
			<ul class="breadcrumb">
				<li><a href="/EmpGuid/loginInterceptor/videos">热门视频</a></li>
				<li><a href="/EmpGuid/study/showVideosByType">视频分类</a></li>
				<li class="active">视频详情</li>
			</ul>
		</div>
	</div>
	<div class="video_box">
		<div id="video">
			<video style="border:1px solid #dfdfdf;" poster="/EmpGuid/upload/${videoVO.image}" src="/EmpGuid/videos/demo.mp4" controls="controls" id="videoShow"></video>
		</div>
		<div class="video_datil">
			<h4 style="line-height:30px;"><strong>${videoVO.title}</strong></h4>
			<h5><strong>时长：</strong>${videoVO.time}</h5>
			<h5 style="line-height:25px;"><strong>简介：</strong>${videoVO.description}</h5>
		</div>
	</div><br><br>
	<h3 style="width:1140px;margin:20px auto;color:#67AEF4;">评论</h3>
	<div style="width:1140px;border:1px solid #dfdfdf;margin:0 auto;"></div><br>
	<#if videoVO.videoCommentVOs?? &&(videoVO.videoCommentVOs?size > 0)>
		<#list videoVO.videoCommentVOs as videoCommentList>
			<div style="border-bottom:1px solid #dfdfdf;width:1140px;margin:0 auto;padding:0 0 10px 20px;">
				<h5 style="line-height:30px;"><strong>用户：${videoCommentList.username}</strong></h5>
				<h5 style="line-height:30px;">${videoCommentList.content}</h5>
				<h5 style="line-height:30px;">时间：${videoCommentList.date?string('yyyy-MM-dd HH:mm:ss')}</h5>
			</div>
		</#list>
	<#else>
		<div style="border-bottom:1px solid #dfdfdf;width:1140px;margin:0 auto;padding:0 0 10px 20px;">
			<h5 style="line-height:30px;"></h5>
			<h5 style="line-height:30px;">此视频还没有评论~</h5>
			<h5 style="line-height:30px;"></h5>
		</div>
	</#if>
	<br>
	<form action="/EmpGuid/study/commitComment" method="post">
		<div style="width:1140px;height:200px;margin:0 auto;">
			<h5>发布评论：长度小于200</h5>
			<input type="hidden" name="id" value="${videoVO.id}"/>
			<input type="hidden" name="username" value="${username}"/>
			<textarea name="comment" id="comment" style="resize:none;width:100%;height:120px;padding:5px 0 0 10px;"></textarea>
			<div class="col-md-12 column" style="padding:0;margin-top:10px;">
				 <button type="submit" class="btn btn-default btn-primary">发布</button>
			</div>
		</div>
	</form>
	<#include "footer.ftl">
	<#include "login_form.ftl">
</body>
</html>