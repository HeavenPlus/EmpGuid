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
			<form id="formdata" role="form" enctype="multipart/form-data">
				<input id="mId" name="id" type="hidden" value="${videoVO.id}"/>
				<div class="form-group">
					 <label>标题</label><input id="title" name="title" type="text" class="form-control" value="${videoVO.title}"/>
				</div>
				<div class="form-group">
					 <label>封面</label>
					 <input type="hidden" name="image" value="${videoVO.image}" />
					 <img id="preview" class="form-control" style="border:1px solid #dfdfdf;width:200px;height:150px;" src="/EmpGuid/upload/${videoVO.image}"/>
					 <div align="center">
				        <span class="btn btn-success fileinput-button1">
				            <span>上传</span>
				            <input id="image" name="ifile" type="file">
				        </span>
				    </div>
				</div>
				<div class="form-group">
					 <label>视频</label>
					 <input type="hidden" name="path" value="${videoVO.path}" />
					 <input id="path_view" readonly="readonly" type="text" class="form-control" style="width:200px;" value="${videoVO.path}"/>
					 <div align="center">
				        <span class="btn btn-success fileinput-button2">
				            <span>上传</span>
				            <input id="path" name="vfile" type="file">
				        </span>
				    </div>
				</div>
				<input name="time" type="hidden" value="${videoVO.time}"/>
				<div class="form-group">
					 <label>简介</label><input id="description" name="description" type="text" class="form-control" value="${videoVO.description}"/>
				</div>
				<div class="form-group">
					 <input type="hidden" id="v_t_id" value="${videoVO.videoTypeVO.id}">
					 <label>类别</label>
					 <select id="videoTypeId" name="videoTypeId" class="form-control">
					 	<#list videoTypes as typeList>
							<option value="${typeList.id}">${typeList.typeName}</option>
						</#list>
					 </select>
				</div>
			</form>
			<button type="submit" class="btn btn-default btn-success" id="edit">修改</button>
			<div type="submit" class="btn btn-default btn-success" onclick="openURL('视频列表', '/EmpGuid/manager/showVideoList?page=${currentPage}')">返回</div><br><br>
		</div>
	</div>
</div>
<script>
$(function(){
	var t_id = document.getElementById("v_t_id");
	var options = document.getElementsByTagName("option");
	for(i=0;i<options.length;i++){
		if(options[i].value==t_id.value){
			options[i].selected = true;
		}
	}
	$("#image").change(function () {
		var path = $("#image").val();
		var extStart = path.lastIndexOf('.'),
		ext = path.substring(extStart, path.length).toUpperCase();
		if (ext !== '.PNG' && ext !== '.JPG' && ext !== '.JPEG') {
			$.messager.alert('提示信息','请上传.png .jpg .jpeg 格式的文件','info');
			return false;
		}else{
			var $file = $(this);
            var fileObj = $file[0];
            var windowURL = window.URL || window.webkitURL;
            var dataURL;
            var $img = $("#preview");
            if (fileObj && fileObj.files && fileObj.files[0]) {
                dataURL = windowURL.createObjectURL(fileObj.files[0]);
                $img.attr('src', dataURL);
            } else {
                dataURL = $file.val();
                var imgObj = document.getElementById("preview");
                imgObj.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
                imgObj.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = dataURL;
            }
		}
	});
	$("#path").change(function () {
		var path = $("#path").val();
		var extStart = path.lastIndexOf('.'),
		ext = path.substring(extStart, path.length).toUpperCase();
		if (ext !== '.MP4' && ext !== '.OGG') {
			$.messager.alert('提示信息','请上传.mp4 .ogg 格式的文件','info');
			return false;
		}else{
			var oPath = document.getElementById("path").files;
			$("#path_view").val(oPath[0].name);
		}
	});
	$("#edit").click(function(){
		var oTitle = document.getElementById("title");
		var oDescription = document.getElementById("description");
		oTitle_val = $.trim(oTitle.value);
		oDescription_val = $.trim(oDescription.value);
		if(oTitle_val==""){
			$.messager.alert('提示信息','标题不能为空','info');
			return false;
		}else if(oDescription_val==""){
			$.messager.alert('提示信息','简介不能为空','info');
			return false;
		}else if(oTitle_val.length>30){
			$.messager.alert('提示信息','标题不能超过30个字符','info');
			return false;
		}else if(oDescription_val.length>180){
			$.messager.alert('提示信息','简介不能超过180个字符','info');
			return false;
		}
		var formData = new FormData($('#formdata')[0]);
		$.ajax({
			type: 'post',
			url: "/EmpGuid/manager/editVideoDetail",
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