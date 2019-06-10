<style>
	.header{
		width:900px;
		height:50px;
		padding:10px 0 0 0;
	}
	.header div{
		float:left;
		width:285px;
		height:25px;
		line-height:25px;
		margin-left:10px;
		overflow:hidden;
	}
</style>
<br>
<#list VideoCommentVOList as videoComment>
	<div style="border:1px solid #dfdfdf;width:901px;margin:0 auto;padding:0">
		<div class="header">
			<div>视频标题：<font color="#3D3D3D">${videoComment.videoVO.title}</font></div>
			<div>用户名：<font color="#3D3D3D">${videoComment.username}</font></div>
			<div>评论发布日期：<font color="#3D3D3D">${videoComment.date?string('yyyy-MM-dd HH:mm:ss')}</font></div>
		</div>
		<div style="width:900px;padding:10px;">
			评论内容：<font color="#3D3D3D">${videoComment.content}</font>
		</div><br><br>
		<button style="float:right;margin:-40px 10px 0 0;" type="button" class="btn btn-default btn-danger"  id="${videoComment.id}" name="${currentPage}" onclick="confirm.call(this);">删除</button>
	</div><br>
</#list>
<div class="col-md-12 column" style="text-align:center;">
	<ul class="pagination" style="text-align:center;">
		<#if currentPage lte 1>
			<li class=disabled><a>上一页</a></li>
		<#else>
			<li onclick="openURL('信息列表', '/EmpGuid/manager/showComment?page=${currentPage-1}')"><a>上一页</a></li>
		</#if>
		<#list 1..totalPage as index>
			<#if currentPage==index>
				<li class=disabled><a>${index}</a></li>
			<#else>
				<li onclick="openURL('信息列表', '/EmpGuid/manager/showComment?page=${index}')"><a>${index}</a></li>
			</#if>
		</#list>
		<#if currentPage gte totalPage>
			<li class="disabled"><a>下一页</a></li>
		<#else>
			<li onclick="openURL('信息列表', '/EmpGuid/manager/showComment?page=${currentPage+1}')"><a>下一页</a></li>
		</#if>
	</ul>
</div>
<script>
	function confirm(){
		var oid = $(this).attr("id");
		var ocp = $(this).attr("name");
		var url = '/EmpGuid/manager/delComment?id='+oid+'&page='+ocp;
		$.messager.confirm('提示信息', '确定要删除吗？', function(r){
			if (r){
				openURL('信息列表', url)
				$.messager.alert('提示信息','删除成功！','info');
			}
		});
	}
</script>