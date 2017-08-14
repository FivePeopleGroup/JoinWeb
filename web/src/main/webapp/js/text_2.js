$(function(){
	$(".level1").mouseenter(function(){
		$(".nav").addClass("lm");
		$(".level2").fadeIn(300); 
	});
	$(".level2").hover(function(){
		$(this).show();
	},function(){
		$(".nav").removeClass("lm");
		$(this).hide();
	});

});
$(function(){
	var win=$(window);
	var sc=$(document);
	win.scroll(function(){
		if((sc.scrollTop()>=60)){
			$(".nav").addClass("fixednav");
		} 
		else{
			$(".nav").removeClass("fixednav");	
		}
	}); 
});