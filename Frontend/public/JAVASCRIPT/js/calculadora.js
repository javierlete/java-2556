'use strict';

const etiquetas = [
    '%', 'CE', 'C', '/', 7, 8, 9, 'x', 4, 5, 6, '-', 1, 2, 3, '+', '+/-', 0, ',', '='
];

let op1, op, op2, res;

window.addEventListener('DOMContentLoaded', function () {
    const botonera = document.querySelector('#botonera');

    etiquetas.forEach(etiqueta => {
        const boton = document.createElement('button');
        boton.innerHTML = etiqueta;

        boton.addEventListener('click', botonPulsado);

        botonera.appendChild(boton);
    });

    const display = document.querySelector('input');

    function botonPulsado(e) {
        const boton = e.target;
        const etiqueta = boton.innerText;

        if (etiqueta >= '0' && etiqueta <= '9' || etiqueta == ',') {
            display.value += etiqueta;

            return;
        }

        switch (etiqueta) {
            case '+/-':
                display.value *= -1;
                break;
            case '%':
                display.value *= 0.01;
                break;
            case 'CE':
            case 'C':
                display.value = '';
                break;
            case '/':
            case 'x':
            case '-':
            case '+':
                op1 = parseFloat(display.value.replace(',', '.'));
                op = etiqueta;

                display.value = '';

                break;
            case '=':
                op2 = +display.value.replace(',', '.');

                switch (op) {
                    case '+':
                        res = op1 + op2;
                        break;
                    case '-':
                        res = op1 - op2;
                        break;
                    case 'x':
                        res = op1 * op2;
                        break;
                    case '/':
                        res = op1 / op2;
                        break;
                }

                display.value = res.toFixed(2).replace('.', ',');

                break;
        }
    }
});

