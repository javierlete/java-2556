'use strict';

window.addEventListener('DOMContentLoaded', function () {
    const h1 = document.querySelector('h1');

    console.log(h1);

    h1.innerHTML = 'Modificado por JavaScript';

    const input = document.querySelector('input');
    const boton = document.querySelector('button');
    const span = document.querySelector('span');

    boton.addEventListener('click', function () {
        span.innerHTML = 'Hola ' + input.value;
    });

    const coleccion = ['Uno', 'Dos', 'Tres'];

    const ul = document.querySelector('ul');

    for(const dato of coleccion) {
        const li = document.createElement('li');
        li.innerHTML = dato;

        ul.appendChild(li);
    }
});