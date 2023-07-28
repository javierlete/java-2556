'use strict';

const URL = 'http://localhost:8080/amazonia/api/cesta/';

const EURO = new Intl.NumberFormat('es-ES', {
    style: 'currency',
    currency: 'EUR',
});

window.addEventListener('DOMContentLoaded', function() {
	// Identificamos los elementos con los que necesitamos interactuar
	// Buscamos los desplegables con name cantidad
	const selects = document.querySelectorAll('select[name=cantidad]');

	// Reaccionamos a los eventos que nos interesan
	// En este caso, al cambiar el valor de un desplegable
	selects.forEach(select => select.addEventListener('change', async function() {
		// Recogemos la información
		const cantidad = +select.value;
		const id = +select.dataset.id;

		// Llamamos a un servidor REST
		// Actualización de la cantidad de un id y recepción de la cesta resultante
		const respuesta = await fetch(`${URL}${id}?cantidad=${cantidad}`, { method: 'PATCH' });

		// Si va mal interrumpimos el proceso y notificamos al usuario
		if (!respuesta.ok) {
			alert('Error');
			return;
		}

		const cesta = await respuesta.json();
		
		// Buscamos los elementos donde queremos hacer modificaciones en pantalla
		// Los span de cantidad y total		
		const cantidades = document.querySelectorAll('.cantidad-total');
		const totales = document.querySelectorAll('.precio-total');
		
		// Modificamos los elementos con los datos recibidos
		cantidades.forEach(c => c.innerText = cesta.cantidadArticulos);
		totales.forEach(t => t.innerText = EURO.format(cesta.total));
		
		const option = select.children[0];
		
		option.innerText = 'Cant: ' + cantidad;
		option.value = cantidad;
		option.selected = true;
	}));
});
