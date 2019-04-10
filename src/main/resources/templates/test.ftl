<!DOCTYPE HTML>
<html>
	<#include "header.ftl">
<body>
	<div id="content" class="container"></div>
	<div class="container">
	    <div class="panel col-sm-10 panel-default">
	        <div class="panel-body reply-top media">
	            <div id="page"></div>
	        </div>
	    </div>
	</div>
	<script type="text/javascript">
		function pagehtml(pageNum) {
		    var articleid = $("#articleNum").val();
		    if (pageNum == 0){
		        pageNum=1;
		    } else {
		        pageNum=pageNum;
		    }
		    $.ajax({
		        url:"/TsengBlog/article/replyPage",
		        type:"get",
		        dataType:"json",
		        data: {pageNum : pageNum, pageSize : 5, articleid : articleid },
		        success:function (data) {
		            var options = {
		                alignment:"center",//居中显示
		　　　　　　　　　　currentPage: data.pageNum,//当前页数
		　　　　　　　　　　totalPages: data.pages,//总页数 注意不是总条数
		　　　　　　　　　　pageUrl: function(type, page, current){
		                    if (page==current) {
		                        return "javascript:void(0)";
		                    } else {
		                        return "javascript:pagehtml("+page+")";
		                    }
		                }
		            };
		            var html="";
		            $.each(data.list, function (i, obj) {
		                html += '<div class="panel col-sm-10 panel-default">'+
		                        '<div class="panel-body reply-top media">'+
		                        '<div class="col-sm-3 col-md-2 media-left">'+
		                        '<img src="image/Tseng.png" class="img-circle img-thumbnail" />'+
		                        '<p class="p-css">'+obj.name+'</p>'+
		                        '</div>'+
		                        '<div class="col-sm-10">'+
		                        '<div class="text-right">#'+i+'</div>'+
		                        '<hr/>'+
		                        '<div class="reply-content">'+
		                        '<span>'+obj.content+'</span>'+
		                        '</div>'+
		                        '</div>'+
		                        '</div>'+
		                        '</div>';
		            });
		            $("#content").empty();
		            $("#content").append(html);
		            $("#page").bootstrapPaginator(options);
		        },
		        error:function (error) {
		            alert("error");
		        }
		    });
		}
	</script>
</body>
</html>