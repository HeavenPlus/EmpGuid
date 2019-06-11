<!DOCTYPE HTML>
<html>
	<#include "header.ftl">
<style>
	.header{
		width:900px;
		height:50px;
		padding:10px 0 0 0;
	}
	.header div{
		float:left;
		width:285px;
		height:25px;
		line-height:25px;
		margin-left:10px;
		overflow:hidden;
	}
</style>
<body>

<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<#include "nav.ftl">
		</div>
		<div class="col-md-12 column">
			<div class="tabbable" id="tabs-309259" style="border:1px solid #dfdfdf;height:320px;">
				<ul class="nav nav-tabs">
					<li class="active">
						 <a href="#panel-247384" data-toggle="tab">个人信息</a>
					</li>
					<li>
						 <a href="#panel-216252" data-toggle="tab">我的评论</a>
					</li>
				</ul>
				<div class="tab-content" style="height:276px;">
					<div class="tab-pane active" id="panel-247384">
						<div style="margin:28px auto;width:450px;">
							<div class="form-horizontal" role="form">
								<div class="form-group">
									 <label class="col-sm-2 control-label">用户名</label>
									<div class="col-sm-10">
										<input id="id" type="hidden" value="${userVO.id}">
										<input id="typeId" type="hidden" value="1">
										<input type="text" id="username" class="form-control" value="${userVO.username}"/>
									</div>
								</div>
								<div class="form-group">
									 <label class="col-sm-2 control-label">密码</label>
									<div class="col-sm-10">
										<input type="text" id="password" class="form-control" value="${userVO.password}"/>
									</div>
								</div>
								<div class="form-group">
									 <label class="col-sm-2 control-label">性别</label>
									 <div class="col-sm-10" style="margin-top:5px;">
									 	<input id="gen" type="hidden" value="${userVO.gender}">
										<input name="gender" type="radio" value="男"/>男&nbsp;&nbsp;&nbsp;
										<input name="gender" type="radio" value="女"/>女
									 </div>
								</div>
								<div class="form-group">
									 <label class="col-sm-2 control-label">邮箱</label>
									<div class="col-sm-10">
										<input type="text" id="email" class="form-control" value="${userVO.email}"/>
									</div>
								</div>
								<div class="form-group">
									<div class="col-sm-offset-2 col-sm-10">
										 <button type="button" id="edit" class="btn btn-default btn-success" style="width:100px;font-size:14px;">保&nbsp;&nbsp;存</button>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="tab-pane" id="panel-216252" style="height:276px;overflow-y:scroll;margin-top:10px;">
						<#list VideoCommentVOList as videoComment>
							<form id="commentForm_${videoComment.id}">
								<div style="border:1px solid #dfdfdf;width:901px;margin:0 auto;padding:0;">
									<div class="header">
										<input name="id" type="hidden" value="${videoComment.id}"/>
										<input name="userId" type="hidden" value="${videoComment.userVO.id}"/>
										<input name="videoId" type="hidden" value="${videoComment.videoVO.id}"/>
										<div>视频标题：<input name="title" style="border:none;background-color:#fff;" readonly="readonly" value="${videoComment.videoVO.title}"/></div>
										<div>用户名：<input name="username" style="border:none;background-color:#fff;" readonly="readonly" value="${videoComment.username}"/></div>
										<div>评论发布日期：<input style="border:none;background-color:#fff;" readonly="readonly" value="${videoComment.date?string('yyyy-MM-dd HH:mm:ss')}"/></div>
									</div>
									&nbsp;&nbsp;评论内容：
									<textarea name="content" style="resize:none;width:100%;padding:5px;border:none;">${videoComment.content}</textarea><br><br>
									<button style="margin:-16px 0 0 710px" type="button" class="btn btn-default btn-success" onclick="editCom.call(this)" id="${videoComment.id}">修改</button>
									<button style="margin:-56px 0 0 790px;" type="button" class="btn btn-default btn-danger"  id="${videoComment.id}" onclick="confirm.call(this);">删除</button>
								</div><br>
							</form>
						</#list>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<#include "footer.ftl">
<#include "login_form.ftl">
<script>
	$(function(){
		var oGen = document.getElementById("gen");
		var genders = document.getElementsByName("gender");
		for(i=0;i<genders.length;i++){
			if(genders[i].value==oGen.value){
				genders[i].checked = "checked";
			}
		}
		$("#edit").click(function(){
			var oId = document.getElementById("id");
			var oUser = document.getElementById("username");
			var oPass = document.getElementById("password");
			var oGenders = document.getElementsByName("gender");
			var oEmail = document.getElementById("email");
			var oTypeId = document.getElementById("typeId");
			var oUser_val = $.trim(oUser.value);
			var oPass_val = $.trim(oPass.value);
			for(var i=0;i<oGenders.length;i++){
				if(oGenders[i].checked){
					var oGenderT_val = oGenders[i].value;
				}
			}
			var oEmailT_val = $.trim(oEmail.value);
			var oTypeIdT_val = oTypeId.value;
			if(oUser_val==""){
				$.messager.alert('提示信息','用户名不能为空','info');
				return false;
			}else if(oUser_val.length<4 || oUser_val.length>12){
				$.messager.alert('提示信息','请输入4-12个字符','info');
				return false;
			}
			if(oPass_val==""){
				$.messager.alert('提示信息','密码不能为空','info');
				return false;
			}else if(oPass_val.length<4 || oPass_val.length>12){
				$.messager.alert('提示信息','请输入4-12个字符','info');
				return false;
			}
			var reg = /^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/;
			if(oEmailT_val==""){
				$.messager.alert('提示信息','邮箱不能为空','info');
				return false;
			}else if(reg.test(oEmailT_val)==false){
				$.messager.alert('提示信息','邮箱格式不正确','info');
				return false;
			}
			var url = "/EmpGuid/recruit/editInfo";
			var args = {
				"id":oId.value,
				"username":oUser_val,
				"password":oPass_val,
				"gender":oGenderT_val,
				"email":oEmailT_val,
				"typeId":oTypeIdT_val,
				"time":new Date()
			};
			$.post(url,args,function(data){
		   		$.messager.alert('提示信息',data,'info');
		   		window.location.href = '/EmpGuid/recruit/showInfo?username='+ oUser_val;
			});
		});
	})
	function editCom(){
		var oid = $(this).attr("id");
		var formId = "#commentForm_"+oid;
		var formData = new FormData($(formId)[0]);
		$.ajax({
			type: 'post',
			url: "/EmpGuid/recruit/editComment",
			data: formData,
			cache: false,
			processData: false,
			contentType: false,
		}).success(function (data) {
			$.messager.alert('提示信息',data,'info');
		}).error(function () {
			$.messager.alert('错误信息','修改失败，请稍后重试','error');
		});
	}
	function confirm(){
		var oid = $(this).attr("id");
		var url = '/EmpGuid/recruit/delComment?id='+oid;
		$.messager.confirm('提示信息', '确定要删除吗？', function(r){
			if (r){
				window.location.href = url;
				$.messager.alert('提示信息','删除成功！','info');
				window.location.reload();
			}
		});
	}
</script>
<script type="text/javascript" src="/EmpGuid/js/index.js"></script>
</body>
</html>