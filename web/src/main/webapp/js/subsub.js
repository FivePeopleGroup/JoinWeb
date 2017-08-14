$(function(){
	$(".bigpic").hover(function(){
		$(".header").animate({right:"20%"},1000,function(){
			$(".header").css("color","#66CCFF");
		})
	})

	var win=$(window);
	var sc=$(document);
	win.scroll(function(){
		if(sc.scrollTop()<=200){
			$("#pp").hide();
		}
		else{
			$("#pp").show(2000);
		}
	})

	$(".centerone").hover(function(){
		$("#bb").show(1000,function(){
			$(".smapic").slideDown();
		})
	})

	$(".centertwo").hover(function(){
		$(".pi1").fadeIn(1000,function(){
			$(".blueone").slideDown(1000);
		});
		$(".pi2").fadeIn(1000,function(){
			$(".bluetwo").slideDown(1000);
		});
	})

	$(".centerthree").hover(function(){
		$("#cc").show(2000);
	})

	$(".circle").click(function(){
		$(this).fadeOut(1000,function(){
			$(this).siblings().show(1500);
		})
	})
})