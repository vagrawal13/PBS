var id;

function onWindowSubmit(fieldNm) {
	window.opener.$('input[name="' + fieldNm + '"]').val(id);
	window.close();
}

$(document).ready(function() {
	
	$('.list li').click(function() {
		$(this).siblings().css({background:""});
		$(this).css({background:"#e0e0e0"});
		id = $(this).attr("id");
	});
	
	$('input[name="cancel"]').click(function(){
		window.close();
	});
});
