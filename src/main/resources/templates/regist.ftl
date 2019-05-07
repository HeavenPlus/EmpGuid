 <!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>注册页面</title>
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.6.1.min.js"></script>
    <style type="text/css">
    	body{
    		background-color:#dfdfdf;
    	}
    	.box{
    		position: relative;
    		margin:0 auto;
    		width:1100px;
    		height:590px;
    		background-image: url("/EmpGuid/images/regist.jpg");
    		filter:alpha(opacity=70);-moz-opacity:0.7;opacity:0.70;
    	}
    	.content{
    		position: relative;
    		top:70px;
    		left:20px;
    		width:300px;
    		height:450px;
    		border:1px solid #fff;
    		background-color:#fff;
    		filter:alpha(opacity=90);-moz-opacity:0.9;opacity:0.90;
    	}
    	.sub_btn{
    		width:120px;
    		height:30px;
    		line-height:20px;
    	}
    	.back_btn{
    		width:120px;
    		height:30px;
    		line-height:20px;
    	}
    </style>
</head>
<body>
    <div class="box">
    	<div class="content">
    		<table style="margin:10px auto;">
    			<tr>
    				<td colspan="2" style="text-align:center;font-size:20px;"><strong>用&nbsp;&nbsp;户&nbsp;&nbsp;注&nbsp;&nbsp;册</strong></td>
    			</tr>
    			<tr style="height:20px;">
					<td></td>
					<td style="font-size:12px;" id="user_val"></td>
				</tr>
    			<tr>
    				<td style="text-align:right;">用户名：</td>
    				<td><input id="user" type="text" placeholder="请输入用户名" name="username"></td>
    			</tr>
    			<tr style="height:20px;">
					<td></td>
					<td style="font-size:12px;" id="pass_val"></td>
				</tr>
    			<tr>
    				<td style="text-align:right;">密码：</td>
    				<td><input id="pass" placeholder="请输入密码" type="password" name="password"></td>
    			</tr>
    			<tr style="height:20px;">
					<td></td>
					<td style="font-size:12px;" id="pass1_val"></td>
				</tr>
    			<tr>
    				<td style="text-align:right;">确认密码：</td>
    				<td><input id="pass1" placeholder="请再次输入密码" type="password" name="password1"></td>
    			</tr>
    			<tr style="height:20px;">
					<td></td>
					<td style="text-align:center;"></td>
				</tr>
    			<tr>
    				<td style="text-align:right;">性别：</td>
    				<td>
    					<label><input name="gender" checked type="radio" value="男"/>男 </label> 
						<label><input name="gender" type="radio" value="女"/>女 </label> 
					</td>
    			</tr>
    			<tr style="height:20px;">
					<td></td>
					<td style="font-size:12px;" id="email_val"></td>
				</tr>
    			<tr>
    				<td style="text-align:right;">邮箱：</td>
    				<td><input id="email" placeholder="请输入邮箱地址" type="text" name="email"></td>
    			</tr>
    			<tr style="height:40px;">
					<td></td>
					<td style="text-align:center;" id="pass1_val"></td>
				</tr>
				<tr><td colspan="2"><input id="typeId" type="hidden" value="1" name="typeId"></td></tr>
    			<tr>
    				<td colspan="2" style="text-align:center;">
    					<button class="sub_btn">免费注册</button>
    					<button class="back_btn">返&nbsp;&nbsp;&nbsp;&nbsp;回</button>
    				</td>
    			</tr>
    		</table>
    	</div>
    </div>
    <script type="text/javascript">
    	$(function(){
			$(".back_btn").click(function(){
				window.location.href = '/EmpGuid/recruit/index';
			});
			$(".sub_btn").click(function(){
				var oUser = document.getElementById("user");
				var oPass = document.getElementById("pass");
				var oPass1 = document.getElementById("pass1");
				var oGenders = document.getElementsByName("gender");
				var oEmail = document.getElementById("email");
				var oTypeId = document.getElementById("typeId");
				var oUser_val = $.trim(oUser.value);
				var oPass_val = $.trim(oPass.value);
				var oPass1_val = $.trim(oPass1.value);
				for(var i=0;i<oGenders.length;i++){
					if(oGenders[i].checked){
						var oGenderT_val = oGenders[i].value;
					}
				}
				var oEmailT_val = $.trim(oEmail.value);
				var oTypeIdT_val = oTypeId.value;
				if(oUser_val==""){
					$("#user_val").html("<font color='red'>用户名不能为空</font>");
					return false;
				}else if(oUser_val.length<4 || oUser_val.length>12){
					$("#user_val").html("<font color='red'>请输入4-12个字符</font>");
					return false;
				}else{
					$("#user_val").html("");
				}
				if(oPass_val==""){
					$("#pass_val").html("<font color='red'>密码不能为空</font>");
					return false;
				}else if(oPass_val.length<4 || oPass_val.length>12){
					$("#pass_val").html("<font color='red'>请输入4-12个字符</font>");
					return false;
				}else{
					$("#pass_val").html("");
				}
				if(oPass1_val==""){
					$("#pass1_val").html("<font color='red'>确认密码不能为空</font>");
					return false;
				}else if(oPass1_val!=oPass_val){
					$("#pass1_val").html("<font color='red'>两次输入密码不一致</font>");
					return false;
				}else{
					$("#pass1_val").html("");
				}
				var reg = /^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/;
				if(oEmailT_val==""){
					$("#email_val").html("<font color='red'>邮箱不能为空</font>");
					return false;
				}else if(reg.test(oEmailT_val)==false){
					$("#email_val").html("<font color='red'>邮箱格式不正确</font>");
					return false;
				}else{
					$("#email_val").html("");
				}
				var url = "/EmpGuid/checkRegist";
				var args = {
							"username":oUser_val,
							"password":oPass_val,
							"gender":oGenderT_val,
							"email":oEmailT_val,
							"typeId":oTypeIdT_val,
							"time":new Date()
							};
				$.post(url,args,function(data){
			   		var str = data.substr(1,5);
					if($.trim(str)=="font"){
						$("#user_val").html(data);
					}else{
						window.location.href = '/EmpGuid/doRegist';
					}
				});
			});
		})
    </script>
</body>
</html>