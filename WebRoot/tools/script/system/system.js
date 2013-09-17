$(function(){
	
	
	$('#west li').click(function(){
		var href=$(this).attr('href');
	    $('#center').panel('refresh',href);
	});
	
	
});