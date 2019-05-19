<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<br>
			<div role="form">
				<div class="form-group">
					 <label>标题</label><input id="title" name="title" type="text" class="form-control"/>
				</div>
				<div class="form-group">
					 <label>作者</label><input id="author" name="author" type="text" class="form-control"/>
				</div>
				<div class="form-group">
					 <label>内容</label><textarea id="content" name="content" class="form-control" style="height:300px;resize:none;"></textarea>
				</div>
				<div class="form-group">
					 <label>类别</label>
					 <select id="typeId" name="typeId" class="form-control">
						<option value="0">请选择类别</option>
						<option value="1">简历指导</option>
						<option value="2">面试指导</option>
					 </select>
				</div>
				<div type="submit" id="save" class="btn btn-default">提交</div><br><br>
				<script type="text/javascript">
					$(function(){
						$("#save").click(function(){
							var vTitle = document.getElementById("title");
							var vAuthor = document.getElementById("author");
							var vContent = document.getElementById("content");
							var vTypeId = document.getElementById("typeId");
							if($.trim(vTitle.value)==""){
								$.messager.alert('错误信息','标题不能为空','error');
								return;
							}else if($.trim(vAuthor.value)==""){
								$.messager.alert('错误信息','作者不能为空','error');
								return;
							}else if($.trim(vContent.value)==""){
								$.messager.alert('错误信息','内容不能为空','error');
								return;
							}else if(vTypeId.value==0){
								$.messager.alert('错误信息','请选择类别','error');
								return;
							}
							var url = "/EmpGuid/manager/doAddGuidInfo";
							var args = {
								"title":vTitle.value,
								"author":vAuthor.value,
								"content":vContent.value,
								"typeId":vTypeId.value,
								"time":new Date()
							};
							$.post(url,args,function(data){
					   			$.messager.alert('提示信息','保存成功','info');
					   			openURL('添加信息', '/EmpGuid/manager/addGuidInfo');
							});
						});
					})
				</script>
				
			</div>
		</div>
	</div>
</div>
