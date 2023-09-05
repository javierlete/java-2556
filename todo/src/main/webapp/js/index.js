'use strict';

window.addEventListener('DOMContentLoaded', function() {
	const checkboxes = document.querySelectorAll('input[type=checkbox]');
	
	checkboxes.forEach(checkbox => checkbox.addEventListener('click', function() {
		checkbox.form.submit();
	})); 
});