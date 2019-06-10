	$(function(){
		$(".first_page").mouseover(function(){
			$(this).addClass("active");
		});
		$(".first_page").mouseleave(function(){
			$(this).removeClass("active");
		});
		$("#anno_banner div:first-child").attr("class","item active");
		$("#gen_banner div:first-child").attr("class","item active");
	})
	$(function () {
		$(".dropdown").mouseover(function () {
			$(this).addClass("open");
		});
		$(".dropdown").mouseleave(function(){
			$(this).removeClass("open");
		})
	})	
	function bodyScroll(event){  
		event.preventDefault();  
	} 
	$(function(){
		$(".log").click(function(){
			$(".bg").fadeIn(500);
			$(".content").css("display","block");
			document.body.addEventListener('touchmove',bodyScroll,false);  
			$('body').css({'position':'fixed',"width":"100%"});
			$(".login_switch").click(function(){
				$(".content").css("display","none");
				$(".content_gl").css("display","block");		
				document.getElementById("user1").value="";
				document.getElementById("pass1").value="";
				document.getElementById("gl_user").value="";
				document.getElementById("gl_pass").value="";
				$("#user1_val").html("");
				$("#pass1_val").html("");
				$("#guser_val").html("");
			})
			$(".gl_switch").click(function(){
				$(".content_gl").css("display","none");
				$(".content").css("display","block");		
			})
		})
		$(".bg").click(function(){
			$(".bg").fadeOut(500);
			$(".content").css("display","none");
			$(".content_gl").css("display","none");
			document.body.removeEventListener('touchmove',bodyScroll,false);   
			$("body").css({"position":"initial","height":"auto"});
			$("#user1_val").html("");
			$("#pass1_val").html("");
			$("#guser_val").html("");
			document.getElementById("user1").value="";
			document.getElementById("pass1").value="";
			document.getElementById("gl_user").value="";
			document.getElementById("gl_pass").value="";
		})
	})
	$(function(){
		$(".login_btn").click(function(){
			var user1 = document.getElementById("user1");
			var pass1 = document.getElementById("pass1");
			user1_val = $.trim(user1.value);
			pass1_val = $.trim(pass1.value);
			
			var url = "/EmpGuid/login";
			var args = {"username":user1_val,"password":pass1_val,"time":new Date()};
			$.post(url,args,function(data){
			   var str = data.substr(1,5);
				if($.trim(str)=="font"){
					$("#user1_val").html(data);
				}else{
					window.location.href = '/EmpGuid/doLogin';
				}
			});
		});
		$(".gl_btn").click(function(){
			var gUser = document.getElementById("gl_user");
			var gPass = document.getElementById("gl_pass");
			gUser_val = $.trim(gUser.value);
			gPass_val = $.trim(gPass.value);
			if(gUser_val==""){
				$("#guser_val").html("<font color='red'>用户名不能为空</font>");
				return;
			}else if(gPass_val==""){
				$("#guser_val").html("<font color='red'>密码不能为空</font>");
				return;
			}
			var url = "/EmpGuid/manager/login";
			var args = {"username":gUser_val,"password":gPass_val,"time":new Date()};
			$.post(url,args,function(data){
			   var str = data.substr(1,5);
				if($.trim(str)=="font"){
					$("#guser_val").html(data);
					return;
				}else{
					window.location.href = '/EmpGuid/manager/doLogin';
				}
			});
		});
	})
	$(function(){
		$(".reg_btn").click(function(){
			window.location.href = '/EmpGuid/regist';
		});
	})
	