$(document).ready(function(){
	$('.basket_button').click(function(){
		var id = $(this).attr('id');
		$.get('/GAMER/shop?action=add-to-basket&id=' + id, function(respJson) {
        	$('img#add-basket-' + id).attr({'src':'/GAMER/res/img/misc/AddedToBasket.png', 'style':'display: none;'});
        	setTotalNumProductsInBasket(respJson);
        	$('img#add-basket-' + id).fadeIn(300);
		});
	});
});

$(document).ready(function(){
	$('.quan-plus').click(function(){
		var id = $(this).attr('name');
        $.get('/GAMER/shop?action=add-to-basket&id=' + id, function(respJson) {
        	setTotalNumProductsInBasket(respJson);
        	setQuantity(id, respJson);
        	setLineCost(id, respJson);
        	setTotalCostOfBasket(respJson);
        });
	});
});

$(document).ready(function(){
	$('.quan-min').click(function(){
		var id = $(this).attr('name');
        $.get('/GAMER/shop?action=rem-from-basket&id=' + id, function(respJson) {
        	setTotalNumProductsInBasket(respJson);
        	setQuantity(id, respJson);
        	setLineCost(id, respJson);
        	setTotalCostOfBasket(respJson);
        });
	});
});

// TODO fix bug where all items are removed if all set to 0 quantity
$(document).ready(function(){
	$('.rem-item').click(function(){
		var id = $(this).attr('name');
		$.get('/GAMER/shop?action=del-from-basket&id=' + id, function(respJson) {
        	
        	if (respJson.totalNumProductsInBasket > 0) { // remove row
        		$('#row-' + id).fadeOut(500, function(){
        			setTotalCostOfBasket(respJson);
        			$('#row-' + id).remove();
        			setTotalNumProductsInBasket(respJson);
                });
        	} else { // remove basket
        		$('#bask-tab').fadeOut(500);
        		$('#pur-button').fadeOut(500, function(){
        			$('#bask-tab').remove();
	        		$('#pur-button').remove();
	        		$('#basket-content').html('<p id="no-items">There are currently no items in your basket</p>');
	        		setTotalNumProductsInBasket(respJson);
        		});
        	}
		});
	});
});

function setTotalNumProductsInBasket(respJson) {
	$('span#basket-num').text('( ' + respJson.totalNumProductsInBasket + ' )');
}

function setQuantity(id, respJson) {
	$('#quan-' + id).val(respJson.quantity);
}

function setLineCost(id, respJson) {
	$('#line-price-' + id).text(respJson.lineCost);
}

function setTotalCostOfBasket(respJson) {
	$('#bask-total-fig').text(respJson.totalCostOfBasket);
}