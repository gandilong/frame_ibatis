$(function(){
	
	//点击左面菜单，中心面板跳转到相应页面。
	$('#west li').click(function(){
		var href=$(this).attr('href');
	    $('#center').panel('refresh',href);
	});
	
	
});

//关于 模块里的 连接方法
function goPage(href){
	$('#center').panel('refresh',href);
}

