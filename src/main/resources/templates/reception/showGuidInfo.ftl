<!DOCTYPE html>
<html>
	<#include "header.ftl">
	<script type="text/javascript" src="/EmpGuid/js/index.js"></script>
<style type="text/css">
	.res_int{
		padding:0 0 0 15px;
	}
	.res_int li{
		height:40px;
		line-height:40px;
		cursor:pointer;
	}
	.img_body{
		width:1140px;
		height:202px;
		margin:0 auto;
	}
	.img_body div{
		float:left;
		margin-left:15px;
	}
	.guid_body{
		width:1140px;
		height:900px;
		margin:30px auto;
		padding:15px;
	}
	.guid_body div{
		float:left;
	}
	.guid{
		position: relative;
	}
	.res_more{
		position: relative;
		top:100px;
		left:1175px;
		cursor:pointer;
		color:#000;
		font-size:14px;
	}
	.int_more{
		position: relative;
		top:540px;
		left:1130px;
		cursor:pointer;
		color:#000;
		font-size:14px;
	}
	.info div{
		float:left;
	}
	.res_kno{
		padding:0 0 0 12px;
	}
	.res_kno li{
		height:30px;
		line-height:30px;
		cursor:pointer;
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
	<div class="img_body">
		<div><img width="360" height="200" src="/EmpGuid/images/resume1.jpg" style="border:1px solid #dfdfdf;"/></div>
		<div><img width="360" height="200" src="/EmpGuid/images/resume2.jpg" style="border:1px solid #dfdfdf;"/></div>
		<div><img width="360" height="200" src="/EmpGuid/images/resume3.jpg" style="border:1px solid #dfdfdf;"/></div>
	</div>
	<a href="/EmpGuid/guidInfo/guidInfo?typeId=1&guidName=简历指导" class="res_more">更多...</a>
	<a href="/EmpGuid/guidInfo/guidInfo?typeId=2&guidName=面试指导" class="int_more">更多...</a>
	<div class="guid_body">
		<div style="width:360px;height:870px;border:1px solid #dfdfdf;padding:10px;">
			<h3 style="font-size:20px;width:100px;" class="guid"><strong>就业指导</strong></h3>
			<hr>
			<ul class="res_int">
				<#list selectByRandom as random>
					<li onclick="location.href='/EmpGuid/guidInfo/guidInfoDetails?id='+${random.id}+'&guidName=${random.guidType.type}';">${random.title}</li>
				</#list>
			</ul>
		</div>
		<div style="height:870px;border:1px solid #dfdfdf;margin-left:10px;"></div>
		<div class="info" style="width:725px;height:430px;border:1px solid #dfdfdf;margin-left:10px;padding:10px;">
			<h3 style="width:200px;"><strong>简历&nbsp;&nbsp;&nbsp;RESUME</strong></h3><hr>
			<div style="margin-top:30px;"><img src="/EmpGuid/images/resume4.jpg" width="350" height="250"/></div>
			<div style="margin-top:30px;width:340px;height:250px;margin-left:5px;padding:10px;">
				<h4>简历指导</h4>
				<ul class="res_kno">
					<#list selectSixByType as resume>
						<#if resume.guidType.id==1>
							<li onclick="location.href='/EmpGuid/guidInfo/guidInfoDetails?id='+${resume.id}+'&guidName=${resume.guidType.type}';">${resume.title}</li>
						</#if>
					</#list>
				</ul>
			</div>
		</div>
		<div class="info" style="width:725px;height:430px;border:1px solid #dfdfdf;margin-left:10px;margin-top:10px;padding:10px;">
			<h3 style="width:300px;"><strong>面试&nbsp;&nbsp;&nbsp;INTERVIEW</strong></h3><hr>
			<div style="margin-top:30px;"><img src="/EmpGuid/images/interview.jpg" width="350" height="250"/></div>
			<div style="margin-top:30px;width:340px;height:250px;margin-left:5px;padding:10px;">
				<h4>面试指导</h4>
				<ul class="res_kno">
					<#list selectSixByType as interview>
						<#if interview.guidType.id==2>				
							<li onclick="location.href='/EmpGuid/guidInfo/guidInfoDetails?id='+${interview.id}+'&guidName=${interview.guidType.type}';">${interview.title}</li>
						</#if>
					</#list>
				</ul>
			</div>
		</div>
	</div>
	<#include "footer.ftl">
	<#include "login_form.ftl">
</body>
</html>