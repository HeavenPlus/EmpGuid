<!DOCTYPE html>
<html>
	<#include "header.ftl">
	<script type="text/javascript" src="/EmpGuid/js/index.js"></script>
<style type="text/css">
	.note_body{
		width:1140px;
		height:500px;
		margin:0 auto;
		padding:10px;
	}
	.note_body div{
		float:left;
	}
	.img_body img{
		margin-top:5px;
		border:1px solid #dfdfdf;
	}
	.more{
		color:#000;
		cursor:pointer;
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
	<div class="note_body">
		<div class="img_body" style="width:300px;height:480px;">
			<#list bannerList as banner>
				<img width="298" height="230" src="/EmpGuid/upload/${banner.image}" />
			</#list>
		</div>
		<div style="border:1px solid #dfdfdf;width:800px;height:480px;margin-left:10px;">
			<div class="col-md-12 column">
			<table class="table table-hover" style="cursor:pointer;">
				<thead>
					<tr>
						<th style="text-align:center;">标题</th>
						<th style="text-align:right;">上传发布日期</th>
					</tr>
				</thead>
				<tbody>
					<#list selectByRandom as random>
						<tr onclick="location.href='/EmpGuid/study/notesDetails?id='+${random.id};">
							<td>${random.title}</td>
							<td style="text-align:right;">${random.date?string('yyyy-MM-dd')}</td>
						</tr>
					</#list>
				</tbody>
			</table>
			<a class="more" href="/EmpGuid/study/selectAllNotes">更多文章...</a>
		</div>
		</div>
	</div>
	<#include "footer.ftl">
	<#include "login_form.ftl">
</body>
</html>