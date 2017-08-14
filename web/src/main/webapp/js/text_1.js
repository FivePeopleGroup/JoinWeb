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





$(function(){
	var win=$(window);
	var sc=$(document);
	win.scroll(function(){
		if(sc.scrollTop()>=300&&(sc.scrollTop()<=500)){
			$(".block_1 p").fadeIn(1000);
		} 
		else{
			$(".block_1 p").fadeOut(1000);
			$(".block_1 img").animate({width: "50%"},1000).addClass("text");
		}
	}); 
});

$(function(){
	var win=$(window);
	var sc=$(document);
	win.scroll(function(){
		if(sc.scrollTop()>=700&&(sc.scrollTop()<=1200)){
			$(".block_2 p").fadeIn(1000);
			$(".block_2 img").animate({width: "35%",left:"200px",top:"200px"},1000).addClass("textn");
		} 
		else{
			$(".block_2 p").fadeOut(1000);
		}
	});
});

$(function(){
    $('.block_3 ul li').hover(function(){
        $(this).find('.text').css('display','none');
        $(this).stop().animate({width : '400px'}).siblings().stop().animate({width : '160px'});
    }, function(){
        $(this).children('.text').css('display','block');
        $('.block_3 ul li').stop().animate({width : '200px'})
    })
})