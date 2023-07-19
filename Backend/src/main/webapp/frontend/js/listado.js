'use strict';

const URL = 'http://localhost:8080/backend/api/productos/';

let table, tbody, form, inputId, inputNombre, inputPrecio, inputCaducidad;

window.addEventListener('DOMContentLoaded', function () {
    table = document.querySelector('table');
    tbody = document.querySelector('tbody');
    
    form = document.querySelector('form');
    
    inputId = document.querySelector('#id');
    inputNombre = document.querySelector('#nombre');
    inputPrecio = document.querySelector('#precio');
    inputCaducidad = document.querySelector('#caducidad');

    rellenarTabla();
});

async function rellenarTabla() {
    form.style.display = 'none';
    table.style.display = 'block';

    const respuesta = await fetch(URL);
    const productos = await respuesta.json();

    tbody.innerHTML = '';

    for (const producto of productos) {
        const tr = document.createElement('tr');
        tr.innerHTML = `
            <th>${producto.id}</th>
            <td>${producto.nombre}</td>
            <td>${producto.precio}</td>
            <td>${producto.caducidad}</td>
            <td>
                <a href="javascript:editar(${producto.id})">Editar</a>
                <a href="javascript:borrar(${producto.id})">Borrar</a>
            </td>
        `;

        tbody.appendChild(tr);
    }
}

async function editar(id) {
    console.log('EDITAR', id);

    const respuesta = await fetch(URL + id);
    const producto = await respuesta.json();

    inputId.value = producto.id;
    inputNombre.value = producto.nombre;
    inputPrecio.value = producto.precio;
    inputCaducidad.value = producto.caducidad;

    mostrarFormulario();
}
function mostrarFormulario() {
    form.style.display = 'block';
}

async function borrar(id) {
    console.log('BORRAR', id);

    const respuesta = await fetch(URL + id, {
        method: 'DELETE'
    });
    
    rellenarTabla();
}
function anadir() {
    console.log('AÑADIR');

    form.reset();

    mostrarFormulario();
}

async function guardar() {
    console.log('GUARDAR');

    const producto = { nombre: inputNombre.value, precio: +inputPrecio.value, caducidad: inputCaducidad.value };

    if (id.value) {
        producto.id = +id.value;

        const respuesta = await fetch(URL + producto.id, {
            method: 'PUT',
            body: JSON.stringify(producto),
            headers: {
                'Content-Type': 'application/json'
            }
        });
    } else {
        const respuesta = await fetch(URL, {
            method: 'POST',
            body: JSON.stringify(producto),
            headers: {
                'Content-Type': 'application/json'
            }
        });
    }

    rellenarTabla();
}