	$(function(){
		$(".first_page").mouseover(function(){
			$(this).addClass("active");
		})
		$(".first_page").mouseleave(function(){
			$(this).removeClass("active");
		})
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
			document.getElementById("user1").value="";
			document.getElementById("pass1").value="";
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
	})
	$(function(){
		$(".reg_btn").click(function(){
			window.location.href = '/EmpGuid/regist';
		});
	})
	