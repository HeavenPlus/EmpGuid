<br><br>
<div style="width:700px;height:350px;margin:0 auto;border:1px solid #919191;padding:20px;">
	<table style="font-size:16px;margin:0 auto;" >
		<tr>
			<td style="width:100px;text-align:right;">用户名：</td>
			<td style="width:200px;"><input id="username" style="width:200px;height:35px;border-left-width:0px;border-top-width:0px;border-right-width:0px;border-bottom-color:black;" type="text" value="${userVO.username}"/></td>
		</tr>
		<tr><td style="height:25px;" colspan="2"></td></tr>
		<tr>
			<td style="width:100px;text-align:right;">密码：</td>
			<td style="width:200px;"><input id="password" style="border-left-width:0px;border-top-width:0px;border-right-width:0px;border-bottom-color:black;width:200px;height:35px;" type="text" value="${userVO.password}"/></td>
		</tr>
		<tr><td style="height:25px;" colspan="2"></td></tr>
		<tr>
			<td style="width:100px;text-align:right;">性别：</td>
			<td style="width:200px;">
				<input id="gen" type="hidden" value="${userVO.gender}">
				<input name="gender" type="radio" value="男"/>男&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  
				<input name="gender" type="radio" value="女"/>女 
			</td>
		</tr>
		<tr><td style="height:25px;" colspan="2"></td></tr>
		<tr>
			<td style="width:100px;text-align:right;">邮箱：</td>
			<td style="width:200px;"><input id="email" style="border-left-width:0px;border-top-width:0px;border-right-width:0px;border-bottom-color:black;width:200px;height:35px;" type="text" value="${userVO.email}"/></td>
		</tr>
		<tr><td colspan="2"><input id="id" type="hidden" value="${userVO.id}"></td></tr>
		<tr><td colspan="2"><input id="typeId" type="hidden" value="2"></td></tr>
	</table>
	<br><br>
	<button type="submit" class="btn btn-default btn-success" id="edit" style="margin:0 290px;width:100px;">修&nbsp;&nbsp;&nbsp;改</button>
</div>
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
			var url = "/EmpGuid/manager/editInfo";
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
		   		window.location.reload();
			});
		});
	})
</script>