$(function(){
	$(".firstli").mouseover(function(){
		$(this).children("ul").show(); 	 
	});
	 
    $(".firstli").mouseout(function(){
		$(this).children("ul").hide();
	});
	$("#add").click(function(){
	 	var news = "<tr><td><input type='checkbox' name='choic' class='choic'></td><td>1</td><td>1</td><td>1</td><td>1</td></tr>";
	 	$(".box").append(news);
	});
	$("#delate").click(function(){
	 	if($(".box tr").length!=1){
	 		$(".box input:checked").parents("tr").detach();
	 	}
	});
	$("#change").click(function(){
	 	if($(".box tr").length!=1){
	 		$(".box input:checked").siblings().empty();
	 	}
	});
})