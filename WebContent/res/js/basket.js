$(document).ready(function(){
	$('.basket_button').click(function(){
		var id = $(this).attr('id');
		$.get('/GAMER/shop?action=add_to_basket&id=' + id, function(respTxt) {
        	$('img#add-basket-' + id).attr({'src':'/GAMER/res/img/misc/AddedToBasket.png', 'style':'display: none;'});
        	$('img#add-basket-' + id).fadeIn(300, function(){
        		updateNumProdInBasket(respTxt);
        	});
		});
	});
});

$(document).ready(function(){
	$('.quan-plus').click(function(){
		var id = $(this).attr('name');
        $.get('/GAMER/shop?action=add_to_basket&id=' + id, function(respTxt) {
        	
        	updateNumProdInBasket(respTxt);
        	incQuantity(id);
        	incLinePrice(id);
        	incTotal(id);
        });
	});
});

$(document).ready(function(){
	$('.quan-min').click(function(){
		var id = $(this).attr('name');
        $.get('/GAMER/shop?action=rem_from_basket&id=' + id, function(respTxt) {
        	
        	if (getQuantity(id) != 0) {
        		
        		updateNumProdInBasket(respTxt);
        		decQuantity(id);
        		decLinePrice(id);
        		decTotal(id);
        	}
        });
	});
});

$(document).ready(function(){
	$('.rem-item').click(function(){
		var id = $(this).attr('name');
		$.get('/GAMER/shop?action=del_from_basket&id=' + id, function(respTxt) {
        	
        	if (respTxt > 0) { // remove row
        		$('#row-' + id).fadeOut(500, function(){
        			decTotalAfterDel(id);
        			$('#row-' + id).remove();
        			updateNumProdInBasket(respTxt);
                });
        	} else { // remove basket
        		$('#bask-tab').fadeOut(500);
        		$('#pur-button').fadeOut(500, function(){
        			$('#bask-tab').remove();
	        		$('#pur-button').remove();
	        		$('#basket-content').html('<p id="no-items">There are currently no items in your basket</p>');
	        		updateNumProdInBasket(respTxt);
        		});
        	}
		});
	});
});

/* NUM ITEMS IN BASKET ------------------------------------------------------*/
function updateNumProdInBasket(respTxt) {
	$('span#basket-num').text('( ' + respTxt + ' )');
}

/* QUANTITY -----------------------------------------------------------------*/
function incQuantity(id) {
	$('#' + id).val(getQuantity(id) + 1);
}

function decQuantity(id) {
	$('#' + id).val(getQuantity(id) - 1);
}

function getQuantity(id) {
	return parseInt($('#' + id).val(), 10);
}

/* LINE PRICE ---------------------------------------------------------------*/
function incLinePrice(id) {
	var price = getPrices(id);
	$('#bask-price-' + id).text(price['curPrice'] + price['itemPrice']);
}

function decLinePrice(id) {
	var price = getPrices(id);
	$('#bask-price-' + id).text(price['curPrice'] - price['itemPrice']);
}

/* TOTAL PRICE --------------------------------------------------------------*/

function incTotal(id) {
	var price = getPrices(id);
	$('#bask-total-fig').text(price['curTotal'] + price['itemPrice']);
}

function decTotal(id) {
	var price = getPrices(id);
	$('#bask-total-fig').text(price['curTotal'] - price['itemPrice']);
}

function decTotalAfterDel(id) {
	var price = getPrices(id);
	$('#bask-total-fig').text(price['curTotal'] - price['curPrice']);
}

/* PRICES -------------------------------------------------------------------*/
function getPrices(id) {
	return {
		'itemPrice' : parseInt($('#price-' + id).val(), 10),
		'curPrice' : parseInt($('#bask-price-' + id).text(), 10),
		'curTotal' : parseInt($('#bask-total-fig').text(), 10)
	};
}