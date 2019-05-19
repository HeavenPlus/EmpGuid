<nav class="navbar navbar-default" role="navigation">
	<div class="navbar-header">
		 <span class="navbar-brand" style="font-size:25px">网站导航</span>
	</div>
	
	<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		<ul class="nav navbar-nav" style="font-size:20px">
			<li class="first_page">
				 <a href="/EmpGuid/recruit/index">平台首页</a>
			</li>
			<li class="dropdown">
				 <a href="#" class="dropdown-toggle" data-toggle="dropdown">就业指导<strong class="caret"></strong></a>
				<ul class="dropdown-menu" style="min-width:100%;">
					<li>
						 <a href="/EmpGuid/guidInfo/guidInfo?typeId=1&guidName=简历指导">简历指导</a>
					</li>
					<li class="divider">
					</li>
					<li>
						 <a href="/EmpGuid/guidInfo/guidInfo?typeId=2&guidName=面试指导">面试指导</a>
					</li>
				</ul>
			</li>
			<li class="dropdown">
				 <a href="#" class="dropdown-toggle" data-toggle="dropdown">学习平台<strong class="caret"></strong></a>
				<ul class="dropdown-menu" style="min-width:100%;">
					<li>
						 <a href="/EmpGuid/study/selectAllNotes">技术文章</a>
					</li>
					<li class="divider">
					</li>
					<li>
						 <a href="/EmpGuid/study/videos">热门视频</a>
					</li>
				</ul>
			</li>
		</ul>
		<form class="navbar-form navbar-left" role="search">
			<div class="form-group">
				<input type="text" class="form-control" placeholder="请输入企业名称" autofocus/>
			</div> <button type="submit" class="btn btn-default">搜索</button>
		</form>
		<ul class="nav navbar-nav navbar-right">
			<#if username??>
				<li class="dropdown">
				 	<a href="#" class="dropdown-toggle" data-toggle="dropdown">用户：${username}<strong class="caret"></strong></a>
					<ul class="dropdown-menu" style="min-width:100%;">
						<li>
							 <a href="/EmpGuid/recruit/index">注销</a>
						</li>
					</ul>
				</li>
			<#else>
				<li><a href="#" class="log">登陆/注册</a></li>
			</#if>
		</ul>
	</div>
</nav>