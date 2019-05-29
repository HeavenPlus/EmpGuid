<nav class="navbar navbar-default" role="navigation" id="banner">
	<div class="navbar-header">
		 <span class="navbar-brand" style="font-size:25px">网站导航</span>
	</div>
	
	<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		<ul class="nav navbar-nav" style="font-size:20px">
			<li class="first_page">
				 <a href="/EmpGuid/recruit/index">平台首页</a>
			</li>
			<li class="first_page">
				 <a href="/EmpGuid/loginInterceptor/showGuidInfo"`>就业指导</a>
			</li>
			<li class="dropdown">
				 <a href="#" class="dropdown-toggle" data-toggle="dropdown">学习平台<strong class="caret"></strong></a>
				<ul class="dropdown-menu" style="min-width:100%;">
					<li>
						 <a href="/EmpGuid/loginInterceptor/showNotes">技术文章</a>
					</li>
					<li class="divider">
					</li>
					<li>
						 <a href="/EmpGuid/loginInterceptor/videos">热门视频</a>
					</li>
				</ul>
			</li>
		</ul>
		<form class="navbar-form navbar-left" role="search" action="/EmpGuid/study/videoSearch">
			<div class="form-group">
				<input type="text" name="keyWord" class="form-control" placeholder="请输入关键字查询" autofocus/>
			</div> <button type="submit" class="btn btn-default">搜索</button>
		</form>
		<ul class="nav navbar-nav navbar-right">
			<#if username??>
				<li class="dropdown">
				 	<a href="#" class="dropdown-toggle" data-toggle="dropdown">用户：${username}<strong class="caret"></strong></a>
					<ul class="dropdown-menu" style="min-width:100%;">
						<li><a href="/EmpGuid/logout">修改个人信息</a></li>
						<li class="divider"></li>
						<li><a href="/EmpGuid/logout">退出登录</a></li>
					</ul>
				</li>
			<#else>
				<li><a href="#" class="log">登录/注册</a></li>
			</#if>
		</ul>
	</div>
</nav>