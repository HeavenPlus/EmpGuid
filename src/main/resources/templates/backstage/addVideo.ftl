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
				<div class="form-group">
					 <label>标题</label><input id="title" name="title" type="text" class="form-control" value=""/>
				</div>
				<div class="form-group">
					 <label>封面</label>
					 <img id="preview" class="form-control" alt="请选择一张图片" style="border:1px solid #dfdfdf;width:200px;height:150px;" src="/EmpGuid/upload/"/>
					 <div align="center">
				        <span class="btn btn-success fileinput-button1">
				            <span>上传</span>
				            <input id="image" name="ifile" type="file">
				        </span>
				    </div>
				</div>
				<div class="form-group">
					 <label>视频</label>
					 <input id="path_view" readonly="readonly" type="text" class="form-control" style="width:200px;" value="请选择要上传的视频"/>
					 <div align="center">
				        <span class="btn btn-success fileinput-button2">
				            <span>上传</span>
				            <input id="path" name="vfile" type="file">
				        </span>
				    </div>
				</div>
				<div class="form-group">
					 <label>简介</label><input id="description" name="description" type="text" class="form-control" value=""/>
				</div>
				<div class="form-group">
					 <label>类别</label>
					 <select id="videoTypeId" name="videoTypeId" class="form-control">
					 	<#list videoTypeList as videoType>
							<option value="${videoType.id}">${videoType.typeName}</option>
						</#list>
					 </select>
				</div>
			</form>
			<button type="submit" class="btn btn-default btn-success" id="add">添加</button>
		</div>
	</div>
</div>
<br>
<script>
$(function(){
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
	$("#add").click(function(){
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
			url: "/EmpGuid/manager/doAddVideo",
			data: formData,
			cache: false,
			processData: false,
			contentType: false,
		}).success(function (data) {
			$.messager.alert('提示信息',data,'info');
			openURL('添加信息', '/EmpGuid/manager/addVideo');
		}).error(function () {
			$.messager.alert('错误信息','上传失败，请稍后重试','error');
		});
	});
})
</script>