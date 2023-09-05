'use strict';

const URL = 'http://localhost:8080/todo/api/v2/tareas/';

let ul = document.querySelector('ul.list-unstyled');
window.addEventListener('DOMContentLoaded', async function() {
	rellenar();

	const btnAnadir = document.getElementById('btn-anadir');

	btnAnadir.addEventListener('click', async function() {
		const tarea = { texto: btnAnadir.form.texto.value, terminada: false };

		const respuesta = await fetch(URL, {
			method: 'POST',
			body: JSON.stringify(tarea),
			headers: {
				'Accept': 'application/json',
				'Content-Type': 'application/json'
			},
		});

		if(respuesta.ok) {
			rellenar();
		}
	});
});

async function rellenar() {
	const respuesta = await fetch(URL);
	const tareas = await respuesta.json();
	
	ul.innerHTML = '';
	
	tareas.forEach(t => {
		console.log(t);

		const li = document.createElement('li');
		li.innerHTML = `
					<form class="input-group mb-3">
						<input type="hidden" name="id" value="${t.id}">

						<div class="input-group-text">
							<input name="terminada" class="fs-3 form-check-input mt-0" type="checkbox" ${t.terminada
				? 'checked' : ''}>
						</div>
						<input type="text" name="texto"
							class="form-control ${t.terminada ? 'text-decoration-line-through' : ''}" value="${t.texto}">
						<button type="button" id="btn-modificar" class="btn btn-outline-secondary">
							<i class="fs-3 bi bi-pencil"></i>
						</button>
						<button type="button" id="btn-terminada" class="btn btn-outline-danger">
							<i class="fs-3 bi bi-trash"></i>
						</button>
					</form>
				`;
		ul.appendChild(li);
	});
}
