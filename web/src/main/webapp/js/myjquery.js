$(function(){
	// header导航
	$(".level11>a").click(function(){
		$(this).addClass("current").next().slideToggle()
		.parent().siblings().children("a").removeClass("current").next().hide();
	})

	// 内容
	$(".person > span").eq(0).hover(function(){
		$(this).addClass("change");
		$("#one").slideDown();
	},function(){
		$(this).removeClass("change");
		$("#one").slideUp();
	})

	$(".person > span").eq(1).hover(function(){
		$(this).addClass("change");
		$("#two").slideDown();
	},function(){
		$(this).removeClass("change");
		$("#two").slideUp();
	})

	$(".person > span").eq(2).hover(function(){
		$(this).addClass("change");
		$("#three").slideDown();
	},function(){
		$(this).removeClass("change");
		$("#three").slideUp();
	})

	$(".person > span").eq(3).hover(function(){
		$(this).addClass("change");
		$("#four").slideDown();
	},function(){
		$(this).removeClass("change");
		$("#four").slideUp();
	})

	$(".person > span").eq(4).hover(function(){
		$(this).addClass("change");
		$("#five").slideDown();
	},function(){
		$(this).removeClass("change");
		$("#five").slideUp();
	})
	// 轮播
	var i=0;
	var timer=null;
	for (var j = 0; j < $('.img li').length; j++) { 
		$('.num').append('<li></li>');
	}
	$('.num li').first().css("background-color","white"); 
	var first=$('.img li').first().clone(); 
	$('.img').append(first).width($('.img li').length*($('.img img').width())); 
	$('.num li').mouseover(function(){
		var index=$(this).index();
		i = index; 
		$('.img').stop().animate({left:-index*1200},150);
		$('.num li').eq(index).css("background-color","white")
		.siblings().css("background-color","#888");
	})

	timer = setInterval(function(){
		i++;
		if (i==$('.img li').length) {
			i=1;
			$('.img').css({left:0});
		};
		$('.img').stop().animate({left:-i*1200},300);
		if (i==$('.img li').length-1) { 
			$('.num li').eq(0).css("background-color","white")
			.siblings().css("background-color","#888");
		}
		else{
			$('.num li').eq(i).css("background-color","white")
			.siblings().css("background-color","#888");
		}
	},2000)
	
	$('.banner').hover(function(){ 
		clearInterval(timer);
	},function(){
		timer = setInterval(function(){
			i++;
			if (i==$('.img li').length) {
				i=1;
				$('.img').css({left:0});
			};
			$('.img').stop().animate({left:-i*1200},300);
			if (i==$('.img li').length-1) { 
				$('.num li').eq(0).css("background-color","white")
				.siblings().css("background-color","#888");
			}
			else{
				$('.num li').eq(i).css("background-color","white")
				.siblings().css("background-color","#888");
			}
		},2000)
	})

	// 滑页效果
	var win=$(window);
	var sc=$(document);
	win.scroll(function(){
		if(sc.scrollTop()<=650){
			$(".left").hide();
			$(".right").hide();
			$(".left1").hide();
			$(".right1").hide();
			$(".left2").hide();
			$(".right2").hide();
			$(".blueone").hide();
			$(".bluetwo").hide();
			$(".pan").hide();
		}
		else{
			$(".blueone").slideDown(1500);
			$(".left").show(1500);
			$(".left1").show(1500);
			$(".left2").show(1500);
			$(".pan").show(1500);
			$(".bluetwo").slideDown(1500);
			$(".right").show(1500);
			$(".right1").show(1500);
			$(".right2").show(1500);
		}
	})
	win.scroll(function(){
		if(sc.scrollTop()<=1200){
			$(".rig").hide();
			$(".lef").hide();
		}
		else{
			$(".lef").show(2000);
			$(".rig").slideDown(2000);
		}
	})
	win.scroll(function(){
		if(sc.scrollTop()<=2200){
			$("#font").hide();
			$(".topleft").hide();
		}
		else{
			$(".topleft").show(1000,function(){
				$("#font").show(1000);
			});
		}
	})

	$("#next").click(function(){
		$(".smapanone").hide();
		$(".smapantwo").slideDown(2000);
	})
	$("#prev").click(function(){
		$(".smapantwo").hide();
		$(".smapanone").slideDown(2000);
	})
})
