<div class="container"> 
	<div class="row clearfix">
		<div class="col-md-12 column">
			<br>
			<form id="formdata" role="form">
				<div class="form-group">
					 <label>标题</label><input id="title" name="title" type="text" class="form-control"/>
				</div>
				<div class="form-group">
					 <label>来源</label><input id="author" name="author" type="text" class="form-control"/>
				</div>
				<div class="form-group">
					 <label>单位性质</label><input id="character" name="chara" type="text" class="form-control"/>
				</div>
				<div class="form-group">
					 <label>单位行业</label><input id="vocation" name="vocation" type="text" class="form-control"/>
				</div>
				<div class="form-group">
					 <label>单位规模</label>
					 <select id="peopleNum" name="peopleNum" class="form-control">
						<option value="少于50人">少于50人</option>
						<option value="50-150人">50-150人</option>
						<option value="150-500人">150-500人</option>
						<option value="500-1000人">500-1000人</option>
						<option value="1000-2000人">1000-2000人</option>
						<option value="2000人以上">2000人以上</option>
					 </select>
				</div>
				<div class="form-group">
					 <label>开始时间</label>
					 <input class="easyui-datetimebox" id="startDate" name="startDate" style="width:100%;">
				</div>
				<div class="form-group">
					 <label>结束时间</label>
					 <input class="easyui-datetimebox" id="endDate" name="endDate" style="width:100%;">
				</div>
				<div class="form-group">
					 <label>宣讲学校</label><input id="school" name="school" type="text" class="form-control"/>
				</div>
				<div class="form-group">
					 <label>宣讲地址</label><input id="address" name="address" type="text" class="form-control"/>
				</div>
				<div class="form-group">
					 <label>公司邮箱</label><input id="email" name="email" type="text" class="form-control"/>
				</div>
				<div class="form-group">
					 <label>联系电话</label><input id="telNum" name="telNum" type="text" class="form-control"/>
				</div>
				<div class="form-group">
					 <label>内容</label>
					 <textarea id="content" name="content" class="form-control" style="resize:none;height:300px;resize:none;"></textarea>
				</div>
				<button type="button" class="btn btn-default btn-success" id="add">提交</button>
			</form><br>
		</div>
	</div>
</div>
<script>
	$(function(){
		$("#add").click(function(){
			var vTitle = document.getElementById("title");
			var vAuthor = document.getElementById("author");
			var vChar = document.getElementById("character");
			var vCat = document.getElementById("vocation");
			var vPeo = document.getElementById("peopleNum");
			var vSch = document.getElementById("school");
			var vAdd = document.getElementById("address");
			var vEma = document.getElementById("email");
			var vTel = document.getElementById("telNum");
			var vContent = document.getElementById("content");
			var mID = document.getElementById("mId");
			var vStart = document.getElementById("startDate");
			var vEnd = document.getElementById("endDate");
			var reg = /^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/;
			var isMobilePhone = /^1[34578]\d{9}$/;
			var isFixMob= /^0\d{2,3}-?\d{7,8}$/;
			if($.trim(vTitle.value)==""){
				$.messager.alert('提示信息','标题不能为空','info');
				return false;
			}else if($.trim(vTitle.value).length>30){
				$.messager.alert('提示信息','标题长度不能大于30','info');
				return false;
			}else if($.trim(vAuthor.value)==""){
				$.messager.alert('提示信息','来源不能为空','info');
				return false;
			}else if($.trim(vAuthor.value).length>20){
				$.messager.alert('提示信息','来源长度不能大于20','info');
				return false;
			}else if($.trim(vContent.value)==""){
				$.messager.alert('提示信息','内容不能为空','info');
				return false;
			}else if($.trim(vChar.value)==""){
				$.messager.alert('提示信息','请填写单位性质','info');
				return false;
			}else if($.trim(vChar.value).length>10){
				$.messager.alert('提示信息','单位性质长度不能大于10','info');
				return false;
			}else if($.trim(vCat.value)==""){
				$.messager.alert('提示信息','请填写单位行业','info');
				return false;
			}else if($.trim(vCat.value).length>30){
				$.messager.alert('提示信息','单位行业长度不能大于30','info');
				return false;
			}else if($.trim(vSch.value)==""){
				$.messager.alert('提示信息','请填写宣讲学校','info');
				return false;
			}else if($.trim(vSch.value).length>20){
				$.messager.alert('提示信息','宣讲学校名称长度不能大于20','info');
				return false;
			}else if($.trim(vAdd.value)==""){
				$.messager.alert('提示信息','请填写宣讲地址','info');
				return false;
			}else if($.trim(vAdd.value).length>30){
				$.messager.alert('提示信息','宣讲地址长度不能大于30','info');
				return false;
			}else if($.trim(vEma.value)==""){
				$.messager.alert('提示信息','请填写公司邮箱','info');
				return false;
			}else if(reg.test(vEma.value)==false){
				$.messager.alert('提示信息','邮箱格式不正确','info');
				return false;
			}else if($.trim(vTel.value)==""){
				$.messager.alert('提示信息','请填写公司电话','info');
				return false;
			}else if(isMobilePhone.test(vTel.value)==false&&isFixMob.test(vTel.value)==false){
				$.messager.alert('提示信息','联系电话格式不正确','info');
				return false;
			}
			var curTime = new Date();
			//2把字符串格式转换为日期类
			var startTime = new Date(Date.parse(vStart.value));
			var endTime = new Date(Date.parse(vEnd.value));
			//3进行比较
			if(startTime<curTime){
				$.messager.alert('提示信息','开始时间不能小于当前时间','info');
				return false;
			}else if(endTime<curTime){
				$.messager.alert('提示信息','结束时间不能小于当前时间','info');
				return false;
			}else if(endTime<startTime){
				$.messager.alert('提示信息','结束时间不能小于开始时间','info');
				return false;
			}
			var formData = new FormData($('#formdata')[0]);
			$.ajax({
				type: 'post',
				url: "/EmpGuid/manager/doAddGeneral",
				data: formData,
				cache: false,
				processData: false,
				contentType: false,
			}).success(function (data) {
				$.messager.alert('提示信息',data,'info');
				openURL('添加信息', '/EmpGuid/manager/addGeneral');
			}).error(function () {
				$.messager.alert('错误信息',data,'error');
				return false;
			});
		});
	})
</script>