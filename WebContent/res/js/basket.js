$(document).ready(function(){
	$('.basket_button').click(function(){
		var id = $(this).attr('id');
		$.get('/GAMER/shop?action=add_to_basket&id=' + id, function(respTxt) {
        	$('img#add-basket-' + id).attr({'src':'/GAMER/res/img/misc/AddedToBasket.png', 'style':'display: none;'});
        	$('img#add-basket-' + id).fadeIn(300, function(){
        		$('span#basket-num').fadeToggle(200, function(){
        			$('span#basket-num').text('( ' + respTxt + ' )');
        			$('span#basket-num').fadeToggle(200);
        		});
        	});
		});
	});
});

$(document).ready(function(){
	$('.quan-plus').click(function(){
		var id = $(this).attr('name');
        $.get('/GAMER/shop?action=add_to_basket&id=' + id, function(respTxt) {
        	// update basket val
        	$('span#basket-num').text('( ' + respTxt + ' )');
        	// update quantity val
        	var numProd = $('#' + id).val();
        	$('#' + id).val(parseInt(numProd, 10) + 1);
        	// update line price
        	var itemPrice = parseInt($('#price-' + id).val(), 10);
        	var curPrice = parseInt($('#bask-price-' + id).text(), 10);
        	$('#bask-price-' + id).text(curPrice + itemPrice);
        	// update total price
        	var curTotal = parseInt($('#bask-total-fig').text(), 10);
        	$('#bask-total-fig').text(curTotal + itemPrice);
        });
	});
});

$(document).ready(function(){
	$('.quan-min').click(function(){
		var id = $(this).attr('name');
        $.get('/GAMER/shop?action=rem_from_basket&id=' + id, function(respTxt) {
        	// update basket val
        	$('span#basket-num').text('( ' + respTxt + ' )');
        	// update quantity val
        	var numProd = $('#' + id).val();
        	if (numProd != 0) {
        		$('#' + id).val(parseInt(numProd, 10) - 1);
	        	// update line price
	        	var itemPrice = parseInt($('#price-' + id).val(), 10);
	        	var curPrice = parseInt($('#bask-price-' + id).text(), 10);
	        	$('#bask-price-' + id).text(curPrice - itemPrice);
	        	// update total price
	        	var curTotal = parseInt($('#bask-total-fig').text(), 10);
	        	$('#bask-total-fig').text(curTotal - itemPrice);
        	}
        });
	});
});

$(document).ready(function(){
	$('.rem-item').click(function(){
		var id = $(this).attr('name');
		$.get('/GAMER/shop?action=del_from_basket&id=' + id, function(respTxt) {
        	// update basket val
        	$('span#basket-num').text('( ' + respTxt + ' )');
        	// remove row
        	if (respTxt > 0) {
        		$('#row-' + id).fadeOut(400, function(){
        			$('#row-' + id).remove();
                });
	        	//update total price
	        	var curPrice = parseInt($('#bask-price-' + id).text(), 10);
        		var curTotal = parseInt($('#bask-total-fig').text(), 10);
        		$('#bask-total-fig').text(curTotal - curPrice);
        	} else {
        		$('#bask-tab').fadeOut(400);
        		$('#pur-button').fadeOut(400, function(){
        			$('#bask-tab').remove();
	        		$('#pur-button').remove();
	        		$('#basket-content').html('<p id="no-items">There are currently no items in your basket</p>');
        		});
        	}
		});
	});
});