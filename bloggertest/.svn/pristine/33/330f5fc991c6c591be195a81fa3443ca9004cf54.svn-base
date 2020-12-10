$(function(){

$('#upload-userPhoto').mouseover(function(){

	$('.photo-mask').css("opacity","0.5");
	
});
$('#upload-userPhoto').mouseout(function(){

	$('.photo-mask').css('opacity','0');
	
});

var username=$('.editor-name-a').siblings().eq(1).text();
var qianming=$('.editor-qianming-a').siblings().eq(1).text();
$('.editor-name-a').click(function(){

	var charaQM=$(this).siblings().eq(1).html();
	$(this).siblings().eq(1).html("");
	$(this).hide();
	$("div[id='name_box']").show();
	

})
$("button[id='save-user']").click(function(){
	username=$('input[id="input-31"]').val();
	$('.editor-name-a').show();
	$('.editor-name-a').siblings().eq(1).text(username);
	$("div[id='name_box']").hide();
	$('input[id="input-31"]').val("");
})
$("button[id='quxiao-user']").click(function(){
    $('.editor-name-a').show();
	$('.editor-name-a').siblings().eq(1).text(username);
	$("div[id='name_box']").hide();
	$('input[id="input-31"]').val("");
	
	
	
})

$('.editor-qianming-a').click(function(){
	var charaQM=$(this).siblings().eq(1).html();
	$(this).siblings().eq(1).html("");
	$(this).hide();
	$("div[id='qianming_box']").show();
	

})
$("button[id='save-qianming']").click(function(){
	qianming=$('input[id="qianmingText"]').val();
	$('.editor-qianming-a').show();
	$('.editor-qianming-a').siblings().eq(1).text(qianming);
	$("div[id='qianming_box']").hide();
	$('textarea[id="qianmingText"]').val("");
})
$("button[id='quxiao-qianming']").click(function(){
    $('.editor-qianming-a').show();
	$('.editor-qianming-a').siblings().eq(1).text(qianming);
	$("div[id='qianming_box']").hide();
	$('textarea[id="qianmingText"]').val("");
	
	
	
})
})