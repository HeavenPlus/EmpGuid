<!DOCTYPE HTML>
<html>
	<#include "header.ftl">
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
							<form class="form-horizontal" role="form">
								<div class="form-group">
									 <label class="col-sm-2 control-label">用户名</label>
									<div class="col-sm-10">
										<input type="email" class="form-control"/>
									</div>
								</div>
								<div class="form-group">
									 <label class="col-sm-2 control-label">密码</label>
									<div class="col-sm-10">
										<input type="password" class="form-control"/>
									</div>
								</div>
								<div class="form-group">
									 <label class="col-sm-2 control-label">性别</label>
									 <div class="col-sm-10" style="margin-top:5px;">
										<input name="gender" type="radio" value="男"/>男&nbsp;&nbsp;&nbsp;
										<input name="gender" type="radio" value="女"/>女
									 </div>
								</div>
								<div class="form-group">
									 <label class="col-sm-2 control-label">邮箱</label>
									<div class="col-sm-10">
										<input type="password" class="form-control"/>
									</div>
								</div>
								<div class="form-group">
									<div class="col-sm-offset-2 col-sm-10">
										 <button type="submit" class="btn btn-default btn-success" style="width:100px;font-size:14px;">保&nbsp;&nbsp;存</button>
									</div>
								</div>
							</form>
						</div>
					</div>
					<div class="tab-pane" id="panel-216252">
						<p>
							Howdy, I'm in Section 2.
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<#include "footer.ftl">
<#include "login_form.ftl">
<script type="text/javascript" src="/EmpGuid/js/index.js"></script>
</body>
</html>