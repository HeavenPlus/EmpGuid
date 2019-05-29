
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<br>
			<div role="form">
				<input id="mId" type="hidden" value="${notes.id}"/>
				<div class="form-group">
					 <label>标题</label><input id="title" name="title" type="text" class="form-control" value="${notes.title}"/>
				</div>
				<div class="form-group">
					 <label>来源</label><input id="author" name="author" type="text" class="form-control" value="${notes.author}"/>
				</div>
				<div class="form-group">
					 <label>内容</label><pre id="content" name="content" contenteditable="true" class="form-control" style="height:300px;resize:none;">${notes.content}</pre>
				</div>
				<button type="submit" class="btn btn-default btn-success" id="edit">修改</button>
				<div type="submit" class="btn btn-default btn-success" onclick="openURL('招聘简章', '/EmpGuid/manager/notesList?page=${currentPage}')">返回</div><br><br>
			</div>
			<script type="text/javascript">
				$(function(){
					$("#edit").click(function(){
						var vTitle = document.getElementById("title");
						var vAuthor = document.getElementById("author");
						var vContent = document.getElementById("content");
						var mID = document.getElementById("mId");
						if($.trim(vTitle.value)==""){
							$.messager.alert('错误信息','标题不能为空','error');
							return;
						}else if($.trim(vAuthor.value)==""){
							$.messager.alert('错误信息','来源不能为空','error');
							return;
						}else if($.trim(vContent.innerHTML)==""){
							$.messager.alert('错误信息','内容不能为空','error');
							return;
						}
						var url = "/EmpGuid/manager/editNotes";
						var args = {
							"id":mId.value,
							"title":vTitle.value,
							"author":vAuthor.value,
							"content":vContent.innerHTML,
							"time":new Date()
						};
						$.post(url,args,function(data){
				   			$.messager.alert('提示信息','更新成功','info');
						});
					});
				})
			</script>
		</div>
	</div>
</div>