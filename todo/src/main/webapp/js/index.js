'use strict';

const TACHADO = 'text-decoration-line-through';
const URL_TERMINADA = 'api/terminada';

window.addEventListener('DOMContentLoaded', function() {
	const checkboxes = document.querySelectorAll('input[type=checkbox]');

	checkboxes.forEach(checkbox => checkbox.addEventListener('click', async function() {
		// checkbox.form.submit();

		const id = checkbox.form.id.value;
		const terminada = checkbox.checked;
		
		const respuesta = await fetch(`${URL_TERMINADA}?id=${id}&terminada=${terminada}`);

		if (respuesta.ok) {
			const clases = checkbox.form.texto.classList;
			
			if (terminada) {
				clases.add(TACHADO);
			} else {
				clases.remove(TACHADO);
			}
		} else {
			alert('No se ha podido modificar la tarea');
			
			checkbox.checked = !terminada;
		}
	}));
});