<style>
    .fileinput-button1 {
        position: absolute;
        top:235px;
        left:220px;
        display: inline-block;
        overflow: hidden;
    }

    .fileinput-button1 input{
        position:absolute;
        right:0px;
        top:0px;
        opacity: 0;
        -ms-filter: 'alpha(opacity=0)';
        font-size: 200px;
    }
    .fileinput-button2 {
        position: absolute;
        top:309px;
        left:220px;
        display: inline-block;
        overflow: hidden;
    }

    .fileinput-button2 input{
        position:absolute;
        right:0px;
        top:0px;
        opacity: 0;
        -ms-filter: 'alpha(opacity=0)';
        font-size: 200px;
    }
</style>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<br>
			<form id="formdata" role="form">
				<input id="mId" name="id" type="hidden" value="${videoTypeVO.id}"/>
				<div class="form-group">
					 <label>类别</label><input id="typeName" name="typeName" type="text" class="form-control" value="${videoTypeVO.typeName}"/>
				</div>
				<div class="form-group">
					 <input type="hidden" id="tec_id" value="${videoTypeVO.tecTypeVO.id}">
					 <label>所属分类</label>
					 <select id="videoTypeId" name="tecTypeId" class="form-control">
					 	<#list tecTypeVOs as tecList>
							<option value="${tecList.id}">${tecList.typeName}</option>
						</#list>
					 </select>
				</div>
			</form>
			<button type="submit" class="btn btn-default btn-success" id="edit">修改</button>
			<div type="submit" class="btn btn-default btn-success" onclick="openURL('分类管理', '/EmpGuid/manager/showCategory?page=${currentPage}')">返回</div><br><br>
		</div>
	</div>
</div>
<script>
$(function(){
	var tec_id = document.getElementById("tec_id");
	var options = document.getElementsByTagName("option");
	for(i=0;i<options.length;i++){
		if(options[i].value==tec_id.value){
			options[i].selected = true;
		}
	}
	$("#edit").click(function(){
		var oName = document.getElementById("typeName");
		oName_val = $.trim(typeName.value);
		if(oName_val==""){
			$.messager.alert('提示信息','类别不能为空','info');
			return false;
		}
		var formData = new FormData($('#formdata')[0]);
		$.ajax({
			type: 'post',
			url: "/EmpGuid/manager/editVideoType",
			data: formData,
			cache: false,
			processData: false,
			contentType: false,
		}).success(function (data) {
			$.messager.alert('提示信息','修改成功','info');
		}).error(function () {
			$.messager.alert('错误信息','修改失败，请稍后重试','error');
		});
	});
})
</script>