<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<br>
			<div role="form">
				<input id="mId" type="hidden" value="${announcement.id}"/>
				<div class="form-group">
					 <label>标题</label><input id="title" name="title" type="text" class="form-control" value="${announcement.name}"/>
				</div>
				<div class="form-group">
					 <label>来源</label><input id="author" name="author" type="text" class="form-control" value="${announcement.author}"/>
				</div>
				<div class="form-group">
					 <label>内容</label><pre id="content" name="content" contenteditable="true" class="form-control" style="height:300px;resize:none;">${announcement.content}</pre>
				</div>
				<div class="form-group">
					 <input type="hidden" id="t_id" value="${announcement.recruidId}">
					 <label>类别</label>
					 <select id="typeId" name="typeId" class="form-control">
						<option value="1">招聘公告</option>
						<option value="2">实习岗位</option>
						<option value="3">企业招聘</option>
						<option value="4">校园招聘</option>
						<option value="5">校园宣讲会</option>
					 </select>
					
				</div>
				<button type="submit" class="btn btn-default btn-success" id="edit">修改</button>
				<div type="submit" class="btn btn-default btn-success" onclick="openURL('信息列表', '/EmpGuid/manager/annoList?page=${currentPage}')">返回</div><br><br>
			</div>
			<script type="text/javascript">
				$(function(){
					var t_id = document.getElementById("t_id");
					var options = document.getElementsByTagName("option");
					for(i=0;i<options.length;i++){
						if(options[i].value==t_id.value){
							options[i].selected = true;
						}
					}
					$("#edit").click(function(){
						var vTitle = document.getElementById("title");
						var vAuthor = document.getElementById("author");
						var vContent = document.getElementById("content");
						var vTypeId = document.getElementById("typeId");
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
						var url = "/EmpGuid/manager/editAnno";
						var args = {
							"id":mId.value,
							"title":vTitle.value,
							"author":vAuthor.value,
							"content":vContent.innerHTML,
							"typeId":vTypeId.value,
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