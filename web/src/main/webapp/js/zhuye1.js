// 加载
document.onreadystatechange=function(){
	if(document.readyState=="complete"){
		$(".load").fadeOut(500);
	}
};
// 导航
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
// 页面下滚时导航效果
$(function(){
	var win=$(window);
	var sc=$(document);
	win.scroll(function(){
		if(sc.scrollTop()>=60){
			$(".nav").addClass("fixednav");
		} 
		else{
			$(".nav").removeClass("fixednav");	
		}
	}); 
});
$(function(){
	$("#next").click(function(){// 向右点击事件
		var nIndex=$("#buttons span").filter(".on").next().index();
		var cIndex=$("#buttons span").filter(".on").index();
		$("#carousel img").eq(cIndex).fadeOut(500);
		$("#carousel img").eq(nIndex).fadeIn(500);
		$("#buttons span").eq(nIndex).addClass("on")
		.siblings().removeClass("on");
		if (cIndex==3) {
			$("#carousel img").eq(0).fadeIn(500).siblings().fadeOut();
			$("#buttons span").removeClass("on").eq(0).addClass("on");
		}
	});// 向左点击事件
	$("#prev").click(function(){
		var pIndex=$("#buttons span").filter(".on").prev().index();
		var cIndex=$("#buttons span").filter(".on").index();
		$("#carousel img").eq(cIndex).fadeOut(500);
		$("#carousel img").eq(pIndex).fadeIn(500);
		$("#buttons span").eq(pIndex).addClass("on")
		.siblings().removeClass("on");
		if (cIndex==0) {
			$("#carousel img").eq(3).fadeIn(500).siblings().fadeOut();
			$("#buttons span").removeClass("on").eq(3).addClass("on");
		}
	});
	var time;// 自动执行点击事件
	function play(){
		time=setInterval(function(){
			$("#next").click();
		},3000);
	};//停止动画
	function stop(){
		clearInterval(time);
	};
	// 鼠标覆盖按钮移开时动画停止和开始
	$("#buttons span").hover(function(){
		stop();
		$(this).addClass("on").siblings().removeClass("on");
		var num=$(this).index();
		$("#carousel img").eq(num).fadeIn(500).siblings().hide();
	},function(){
		play();
	});
	//给a标签一个hover事件，以免点击事件和动画冲突
	$(".arrow").hover(function(){
		stop();
	},function(){
		play();
	});
	play();
});
// 副轮播
$(function(){
	$("#sub-next").click(function(){// 向右点击事件
		$("#sub-carousel img").eq(1).show().siblings().hide();
		$(".branch").show().siblings().hide();
	});
	$("#sub-prev").click(function(){
		$("#sub-carousel img").eq(0).show().siblings().hide();
		$(".cadre").show().siblings().hide();
	});	
});
$(function(){
$(".part1").hover(function(){
	$(".color1").css("backgroundColor","#47bef7");
},function(){
	$(".color1").css("backgroundColor","white");
});
$(".part2").hover(function(){
	$(".color2").css("backgroundColor","#47bef7");
},function(){
	$(".color2").css("backgroundColor","white");
});
$(".part3").hover(function(){
	$(".color3").css("backgroundColor","#47bef7");
},function(){
	$(".color3").css("backgroundColor","white");
});
$(".part4").hover(function(){
	$(".color4").css("backgroundColor","#47bef7");
},function(){
	$(".color4").css("backgroundColor","white");
});
});
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
		if(sc.scrollTop()>=60){
			$(".nav").hide();
			$(".box").addClass("bot");
		}
		else{
			$(".nav").removeClass("fixednav");
			$(".nav").show();
			$(".box").removeClass("bot");
			$(".box").addClass(".box");
		}
	});
});
