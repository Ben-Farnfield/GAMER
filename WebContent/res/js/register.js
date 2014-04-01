$(document).ready(function(){
	testField('forename', 1, 32, /^[A-Z]+$/i);
});

$(document).ready(function(){
	testField('surname', 1, 32, /^[A-Z][A-Z ,'.-]+$/i);
});

$(document).ready(function(){
	testField('email', 1, 100, /^[A-Z0-9._-]+@[A-Z0-9.-]+\.[A-Z]{2,4}$/i);
});

$(document).ready(function(){
	testField('password', 6, 16, /.*/);
});

$(document).ready(function(){
	$("input[name='conf-password']").blur(function(){
		var password = $("input[name='password']").val();
		var confPassword = $("input[name='conf-password']").val();
		if (password === confPassword) {
			$('tr#conf-password-error').css('display', 'none');
		}
		else {
			$('tr#conf-password-error').css('display', 'table-row');
		}
	});
});

$(document).ready(function(){
	testField('card-num', 1, 16, /\d{16}/);
});

$(document).ready(function(){
	testField('house-num', 1, 4, /^\d+$/);
});

$(document).ready(function(){
	testField('street', 1, 32, /^[A-Z ]+$/i);
});

$(document).ready(function(){
	testField('postcode', 1, 10, /^[A-Z]{2}\d{1,2}\s*\d{1,2}[A-Z]{2}$/);
});

function testField(field, minLength, maxLength, regex) {
	$("input[name='"+ field +"']").blur(function(){
		var fieldVal = $("input[name='"+ field +"']").val();
		if (regex.test(fieldVal)
				&& fieldVal.length >= minLength
				&& fieldVal.length <= maxLength) {
			$('tr#'+ field +'-error').css('display', 'none');
		}
		else {
			$('tr#'+ field +'-error').css('display', 'table-row');
		}
	});
}