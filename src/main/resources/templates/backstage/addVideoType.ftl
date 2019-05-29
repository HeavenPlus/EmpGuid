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
				<div class="form-group">
					 <label>类别</label><input id="typeName" name="typeName" type="text" class="form-control"/>
				</div>
				<div class="form-group">
					 <label>所属分类</label>
					 <select id="videoTypeId" name="tecTypeId" class="form-control">
					 	<#list tecTypeVOs as tecList>
							<option value="${tecList.id}">${tecList.typeName}</option>
						</#list>
					 </select>
				</div>
			</form>
			<button type="submit" class="btn btn-default btn-success" id="add">提交</button>
		</div>
	</div>
</div>
<script>
$(function(){
	$("#add").click(function(){
		var oName = document.getElementById("typeName");
		oName_val = $.trim(typeName.value);
		if(oName_val==""){
			$.messager.alert('提示信息','类别不能为空','info');
			return false;
		}else if(oName_val.length>10){
			$.messager.alert('提示信息','类别名称长度不能大于10个字符','info');
			return;
		}
		var formData = new FormData($('#formdata')[0]);
		$.ajax({
			type: 'post',
			url: "/EmpGuid/manager/doAddVideoType",
			data: formData,
			cache: false,
			processData: false,
			contentType: false,
		}).success(function (data) {
			if(data=="success"){
				$.messager.alert('提示信息','添加成功','info');
				openURL('添加分类', '/EmpGuid/manager/addVideoType');
			}else{
				$.messager.alert('提示信息',data,'info');
			}		
		}).error(function () {
			$.messager.alert('错误信息','修改失败，请稍后重试','error');
		});
	});
})
</script>