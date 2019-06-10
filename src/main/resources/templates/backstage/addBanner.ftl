<style>
    .fileinput-button1 {
        position: absolute;
        top:161px;
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
</style>
<div style="margin:0 auto;width:500px;">
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-4 column">
				<br>
				<form id="formdata" role="form" enctype="multipart/form-data">
					<div class="form-group">
						 <label>图片</label>
						 <img id="preview" class="form-control" alt="请选择一张图片" style="border:1px solid #dfdfdf;width:200px;height:150px;" src="/EmpGuid/images/upload.png"/>
						 <div align="center">
					        <span class="btn btn-success fileinput-button1">
					            <span>上传</span>
					            <input id="image" name="file" type="file">
					        </span>
					    </div>
					</div>	
					<div class="form-group">
						<label>类别</label>
						 <select id="imgPage" name="imgPage" class="form-control">
							<option value="招聘宣传">招聘宣传</option>
							<option value="招聘简章">招聘简章</option>
							<option value="面试指导">面试指导</option>
							<option value="简历指导">简历指导</option>
							<option value="技术文章">技术文章</option>
						 </select>
					</div>	
					<button type="button" class="btn btn-default btn-success" id="add">添加</button>
				</form>
			</div>
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
	$("#add").click(function(){
		
		var formData = new FormData($('#formdata')[0]);
		$.ajax({
			type: 'post',
			url: "/EmpGuid/manager/doAddBanner",
			data: formData,
			cache: false,
			processData: false,
			contentType: false,
		}).success(function (data) {
			$.messager.alert('提示信息',data,'info');
			openURL('添加信息', '/EmpGuid/manager/addBanner');
		}).error(function () {
			$.messager.alert('错误信息',data,'error');
		});
	});
})
</script>