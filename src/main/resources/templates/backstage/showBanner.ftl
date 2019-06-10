
<div class="container" >
	<div class="row clearfix">
		<div class="col-md-12 column">
			<br>
			<nav class="navbar navbar-default" role="navigation" id="banner" style="width:600px;margin:0 auto;">
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1" style="float:right;">
					<button class="btn btn-default btn-success" style="margin-top:8px;" onclick="openURL('上传图片', '/EmpGuid/manager/addBanner')">添加</button>
				</div>
			</nav><br>
			<table class="table table-bordered table-hover" style="text-align:center;width:600px;margin:0 auto;">
				<thead>
					<tr>
						<th style="text-align:center;width:350px;">图片</th>
						<th style="text-align:center;width:150px;">分类</th>
						<th style="text-align:center;width:100px;">操作</th>
					</tr>
				</thead>
				<tbody>
					<#list bannerList as banner>
						<tr style="cursor:pointer;">
							<td><img width="150" height="100" src="/EmpGuid/upload/${banner.image}"/></td>
							<td style="line-height:100px;">${banner.imgPage}</td>
							<td style="line-height:100px;">
								<button type="button" class="btn btn-default btn-danger" id="${banner.id}" name="${currentPage}" onclick="confirm.call(this);">删除</button>
							</td>
						</tr>
					</#list>	
				</tbody>
			</table>
		</div>
	</div>
</div>
<div class="col-md-12 column" style="text-align:center;">
	<ul class="pagination" style="text-align:center;">
		<#if currentPage lte 1>
			<li class=disabled><a>上一页</a></li>
		<#else>
			<li onclick="openURL('图片管理', '/EmpGuid/manager/showBanner?page=${currentPage-1}')"><a>上一页</a></li>
		</#if>
		<#list 1..totalPage as index>
			<#if currentPage==index>
				<li class=disabled><a>${index}</a></li>
			<#else>
				<li onclick="openURL('图片管理', '/EmpGuid/manager/showBanner?page=${index}')"><a>${index}</a></li>
			</#if>
		</#list>
		<#if currentPage gte totalPage>
			<li class="disabled"><a>下一页</a></li>
		<#else>
			<li onclick="openURL('图片管理', '/EmpGuid/manager/showBanner?page=${currentPage+1}')"><a>下一页</a></li>
		</#if>
	</ul>
</div>
<script>
	function confirm(){
		var oid = $(this).attr("id");
		var ocp = $(this).attr("name");
		var url = '/EmpGuid/manager/delBanner?id='+oid+'&page='+ocp;
		$.messager.confirm('提示信息', '确定要删除吗？', function(r){
			if (r){
				openURL('信息列表', url)
				$.messager.alert('提示信息','删除成功！','info');
			}
		});
	}
</script>