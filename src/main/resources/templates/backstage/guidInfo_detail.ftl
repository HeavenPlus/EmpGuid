<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<br>
			<div role="form">
				<input id="mId" type="hidden" value="${guidInfo.id}"/>
				<div class="form-group">
					 <label>标题</label><input id="title" name="title" type="text" class="form-control" value="${guidInfo.title}"/>
				</div>
				<div class="form-group">
					 <label>作者</label><input id="author" name="author" type="text" class="form-control" value="${guidInfo.author}"/>
				</div>
				<div class="form-group">
					 <label>内容</label><pre id="content" name="content" contenteditable="true" class="form-control" style="height:300px;resize:none;">${guidInfo.content}</pre>
				</div>
				<div class="form-group">
					 <input type="hidden" id="t_id" value="${guidInfo.typeId}">
					 <label>类别</label>
					 <select id="typeId" name="typeId" class="form-control">
						<option value="1">简历指导</option>
						<option value="2">面试指导</option>
					 </select>
					
				</div>
				<button type="submit" class="btn btn-default" id="edit">修改</button>
				<div type="submit" class="btn btn-default" onclick="openURL('信息列表', '/EmpGuid/manager/guidInfoList?page=${currentPage}')">返回</div><br><br>
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
							$.messager.alert('错误信息','作者不能为空','error');
							return;
						}else if($.trim(vContent.innerHTML)==""){
							$.messager.alert('错误信息','内容不能为空','error');
							return;
						}
						var url = "/EmpGuid/manager/editGuidInfo";
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