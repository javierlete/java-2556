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
		// Actualización de la cantidad de un id 
		const respuestaPatch = await fetch(`${URL}${id}?cantidad=${cantidad}`, { method: 'PATCH' });

		// Si va mal interrumpimos el proceso y notificamos al usuario
		if (!respuestaPatch.ok) {
			alert('Error');
			return;
		}
		
		// Pedimos los datos necesarios para pantalla
		// Totales de cantidad y precio
		const respuestaCantidad = await fetch(`${URL}cantidad`);
		const cantidadTotal = await respuestaCantidad.json(); 
		
		const respuestaTotal = await fetch(`${URL}total`);
		const total = await respuestaTotal.json();
		
		// Buscamos los elementos donde queremos hacer modificaciones en pantalla
		// Los span de cantidad y total		
		const cantidades = document.querySelectorAll('.cantidad-total');
		const totales = document.querySelectorAll('.precio-total');
		
		// Modificamos los elementos con los datos recibidos
		cantidades.forEach(c => c.innerText = cantidadTotal);
		totales.forEach(t => t.innerText = EURO.format(total));
		
		const option = select.children[0];
		
		option.innerText = 'Cant: ' + cantidad;
		option.value = cantidad;
		option.selected = true;
	}));
});
