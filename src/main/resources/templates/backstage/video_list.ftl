<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<br>
			<table class="table table-bordered table-hover" style="text-align:center;width:900px;margin:0 auto;">
				<thead>
					<tr>
						<th style="text-align:center;width:200px;">视频</th>
						<th style="text-align:center;width:400px;">标题</th>
						<th style="text-align:center;width:100px;">类别</th>
						<th colspan="2" style="text-align:center;width:200px;">操作</th>
					</tr>
				</thead>
				<tbody>
					<#list videoVOList as videoList>
						<tr style="cursor:pointer;">
							<td><img width="150" height="100" src="/EmpGuid/upload/${videoList.image}"/></td>
							<td style="line-height:100px;">${videoList.title}</td>
							<td style="line-height:100px;">${videoList.videoTypeVO.typeName}</td>
							<td style="line-height:100px;" onclick="openURL('修改信息', '/EmpGuid/manager/videoDetail?id=${videoList.id}&page=${currentPage}')">
								<button type="button" class="btn btn-default btn-success">修改</button>
							</td>
							<td style="line-height:100px;">
								<button type="button" class="btn btn-default btn-danger" id="${videoList.id}" name="${currentPage}" onclick="confirm.call(this);">删除</button>
							</td>
						</tr>
					</#list>
				</tbody>
			</table>
		</div>
		<div class="col-md-12 column" style="text-align:center;">
			<ul class="pagination" style="text-align:center;">
				<#if currentPage lte 1>
					<li class=disabled><a>上一页</a></li>
				<#else>
					<li onclick="openURL('视频列表', '/EmpGuid/manager/showVideoList?page=${currentPage-1}')"><a>上一页</a></li>
				</#if>
				<#list 1..totalPage as index>
					<#if currentPage==index>
						<li class=disabled><a>${index}</a></li>
					<#else>
						<li onclick="openURL('视频列表', '/EmpGuid/manager/showVideoList?page=${index}')"><a>${index}</a></li>
					</#if>
				</#list>
				<#if currentPage gte totalPage>
					<li class="disabled"><a>下一页</a></li>
				<#else>
					<li onclick="openURL('视频列表', '/EmpGuid/manager/showVideoList?page=${currentPage+1}')"><a>下一页</a></li>
				</#if>
			</ul>
		</div>
	</div>
</div>
<script>
	function confirm(){
		var oid = $(this).attr("id");
		var ocp = $(this).attr("name");
		var url = '/EmpGuid/manager/deleteVideo?id='+oid+'&page='+ocp;
		$.messager.confirm('提示信息', '确定要删除吗？', function(r){
			if (r){
				openURL('信息列表', url)
				$.messager.alert('提示信息','删除成功！','info');
			}
		});
	}
</script>