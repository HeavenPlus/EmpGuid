<!DOCTYPE HTML>
<html>
	<#include "header.ftl">
<body>

<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<#include "nav.ftl">
			<div class="carousel slide" id="carousel-845940">
				<ol class="carousel-indicators">
					<li class="active" data-slide-to="0" data-target="#carousel-845940">
					</li>
					<li data-slide-to="1" data-target="#carousel-845940">
					</li>
					<li data-slide-to="2" data-target="#carousel-845940">
					</li>
				</ol>
				<div class="carousel-inner">
					<div class="item active">
						<img width="100%" alt="" src="/EmpGuid/images/banner1.jpg" />
					</div>
					<div class="item">
						<img width="100%" alt="" src="/EmpGuid/images/banner2.jpg" />
					</div>
					<div class="item">
						<img width="100%" alt="" src="/EmpGuid/images/banner3.jpg" />
					</div>
				</div> <a class="left carousel-control" href="#carousel-845940" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a> <a class="right carousel-control" href="#carousel-845940" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
			</div>
			<div class="row clearfix pad" style="border:1px solid #dfdfdf;">
				<div class="col-md-8 column" style="padding:0px">
					<div class="tabbable" id="tabs-447149">
						<ul class="nav nav-tabs"  style="font-size:26px;">
							<li class="active">
								 <a href="#panel-913032" data-toggle="tab">招聘公告</a>
							</li>
							<li>
								 <a href="#panel-799133" data-toggle="tab">实习岗位</a>
							</li>
							<li>
								 <a href="#panel-799133" data-toggle="tab">企业招聘</a>
							</li>
							<li>
								 <a href="#panel-799133" data-toggle="tab">校园招聘</a>
							</li>
							<li>
								 <a href="#panel-799133" data-toggle="tab">校园宣讲会</a>
							</li>
						</ul>
						<div class="tab-content" >
							<div class="tab-pane active" id="panel-913032">
								<div class="panel panel-default">
									<div class="panel-body" style="padding:20px;">
										<table class="table table-hover table-striped">
											<tbody style="font-size:14px;">
												<#list announcementList as announcement>
													<#if announcement.recruidId==1>
														<tr>
															<td>${announcement.name}</td>
															<td style="text-align:right;">${announcement.date?string('yyyy-MM-dd HH:mm:ss')}</td>
														</tr>
													</#if>
												</#list>
											</tbody>
										</table>
									</div>
									<div class="panel-footer" style="height:55px;">
										<ul class="pagination" style="margin-top:0px;">
											<#if currentPage lte 1>
												<li class=disabled><a>上一页</a></li>
											<#else>
												<li><a href="/EmpGuid/index?page=${currentPage-1}">上一页</a></li>
											</#if>
											<#list 1..totalPage as index>
												<#if currentPage==index>
													<li class=disabled><a>${index}</a></li>
												<#else>
													<li><a href="/EmpGuid/index?page=${index}">${index}</a></li>
												</#if>
											</#list>
											<#if currentPage gte totalPage>
												<li class="disabled"><a>下一页</a></li>
											<#else>
												<li><a href="/EmpGuid/index?page=${currentPage+1}">下一页</a></li>
											</#if>
										</ul>
									</div>
								</div>
							</div>
							<div class="tab-pane" id="panel-799133">
								<p>
									Howdy, I'm in Section 2.
								</p>
							</div>
							<div class="tab-pane" id="panel-799133">
								<p>
									Howdy, I'm in Section 3.
								</p>
							</div>
							<div class="tab-pane" id="panel-799133">
								<p>
									Howdy, I'm in Section 4.
								</p>
							</div>
							<div class="tab-pane" id="panel-799133">
								<p>
									Howdy, I'm in Section 5.
								</p>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-4 column" style="padding:0px">
					<div class="list-group" style="width:391px;">
						<a href="#" class="list-group-item active" style="font-size:24px"><img style="margin-top:-4px" width="20px" height="20px" alt="140x140" src="https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1553582202&di=66e657704a4877cd1ab38b6613c01893&src=http://pic.51yuansu.com/pic3/cover/02/80/87/5a4df52111c0c_610.jpg" />&nbsp日历</a>
						<div class="list-group-item" style="padding:0px">
							<div id="cc" class="easyui-calendar" style="width:390px;height:413px;"></div> 
						</div>
					</div> 
				</div>
			</div>
		</div>
		<div class="col-md-12 column" style="margin-top:20px;border:1px solid #dfdfdf;height:500px;padding:0px">
			<nav class="navbar navbar-default" role="navigation" >
				<div class="navbar-header">
					 <span class="navbar-brand" style="font-size:30px">招聘简章</span>
				</div>
			</nav>
			<div class="col-md-4 column" style="font-size:20px">
				<ul class="list-unstyled">
					<li>
						Lorem ipsum dolor sit amet
					</li>
					<li>
						Consectetur adipiscing elit
					</li>
					<li>
						Integer molestie lorem at massa
					</li>
					<li>
						Facilisis in pretium nisl aliquet
					</li>
					<li>
						Nulla volutpat aliquam velit
					</li>
					<li>
						Faucibus porta lacus fringilla vel
					</li>
					<li>
						Aenean sit amet erat nunc
					</li>
					<li>
						Eget porttitor lorem
					</li>
				</ul>
			</div>
			<div class="col-md-4 column" style="font-size:20px">
				<ul class="list-unstyled">
					<li>
						Lorem ipsum dolor sit amet
					</li>
					<li>
						Consectetur adipiscing elit
					</li>
					<li>
						Integer molestie lorem at massa
					</li>
					<li>
						Facilisis in pretium nisl aliquet
					</li>
					<li>
						Nulla volutpat aliquam velit
					</li>
					<li>
						Faucibus porta lacus fringilla vel
					</li>
					<li>
						Aenean sit amet erat nunc
					</li>
					<li>
						Eget porttitor lorem
					</li>
				</ul>
			</div>
			<div class="col-md-4 column" style="font-size:20px">
				<ul class="list-unstyled">
					<li>
						Lorem ipsum dolor sit amet
					</li>
					<li>
						Consectetur adipiscing elit
					</li>
					<li>
						Integer molestie lorem at massa
					</li>
					<li>
						Facilisis in pretium nisl aliquet
					</li>
					<li>
						Nulla volutpat aliquam velit
					</li>
					<li>
						Faucibus porta lacus fringilla vel
					</li>
					<li>
						Aenean sit amet erat nunc
					</li>
					<li>
						Eget porttitor lorem
					</li>
				</ul>
			</div>
			<ul class="pagination" style="margin-top:140px;margin-left:50px;">
				<li>
					 <a href="#">Prev</a>
				</li>
				<li>
					 <a href="#">1</a>
				</li>
				<li>
					 <a href="#">2</a>
				</li>
				<li>
					 <a href="#">3</a>
				</li>
				<li>
					 <a href="#">4</a>
				</li>
				<li>
					 <a href="#">5</a>
				</li>
				<li>
					 <a href="#">Next</a>
				</li>
			</ul>
		</div>
	</div>
</div>
<#include "login_form.ftl">
<script type="text/javascript">
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
		})
	})
</script>
</body>
</html>