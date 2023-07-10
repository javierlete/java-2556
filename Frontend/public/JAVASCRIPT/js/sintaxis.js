'use strict';

// variables();
// ejemploArrays();
// funciones();
// objetos();
// prototipos();
// clases();
cambioPrototipos();

function variables() {
    //alert('hola');
    console.log('Hola a todos');

    const nombre = prompt('Dime tu nombre');

    console.log(typeof nombre);
    console.log('Hola ' + nombre);

    const numero = +prompt('Dime un numero');

    console.log(typeof numero);

    if (!isNaN(numero)) {
        console.log(numero + 2);

        if (numero === 5) {
            console.log('OK');
        } else {
            console.log('Pues no es 5');
        }
    } else {
        console.log('No es un número');
    }

    let variable = null;

    console.log(variable);
}

function ejemploArrays() {
    let arr = Array(3);

    arr[0] = 10;
    arr[1] = 20;
    arr[2] = 30;
    arr[3] = 7;
    arr[4] = 'alskdfjlkasdjf';
    arr[7] = new Date();
    arr['hola'] = 'Qué tal';
    arr.prueba = 'Lalaralalaaa';
    arr.push('NUEVO');

    console.log(arr.hola);
    console.log(arr['prueba']);

    console.log(arr, typeof arr);

    for (let i = 0; i < arr.length; i++) {
        console.log(arr[i]);
    }

    for (let clave in arr) {
        console.log(clave, arr[clave]);
    }

    for (let dato of arr) {
        console.log(dato);
    }
}

function funciones() {
    console.log(sumar(5, 6));

    console.log(typeof sumar);

    let op = sumar;

    console.log(sumar);

    console.log(op);
    console.log(op(10, 11));

    function sumar(a, b) {
        return a + b;
    }

    const restar = function (a, b) { return a - b; };

    console.log(restar(5, 2));

    const multiplicar = (a, b) => a * b;

    console.log(multiplicar(2, 3));
}

function objetos() {
    const objeto = Object();

    objeto.nombre = 'El nombre';
    objeto.precio = 45.32;

    objeto.nombree = 'Cambiado';
    
    console.log(objeto);

    objeto.mostrarNombre = function() { console.log(this.nombre); };

    objeto.mostrarNombre();

    objeto['mostrarNombre']();

    objeto.bienes = [];

    objeto.bienes.push('Uno');
    objeto.bienes.push('Dos');

    console.log(objeto);
}

function prototipos() {
    function Persona(id, nombre, apellidos) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    Persona.prototype.getNombreCompleto = function() { return this.nombre + ' ' + this.apellidos; };

    const p1 = new Persona(1, 'Javier', 'Lete');

    console.log(p1.id);

    console.log(p1, typeof p1, p1.constructor.name);
    
    console.log(p1.getNombreCompleto());
}

function clases() {
    class Persona {
        constructor(id, nombre, apellidos) {
            this.id = id;
            this.nombre = nombre;
            this.apellidos = apellidos;
        }
        getNombreCompleto() { return this.nombre + ' ' + this.apellidos; }
    }

    const p = new Persona(1, 'Javier', 'Lete');

    console.log(p);
    console.log(p.getNombreCompleto().toUpperCase());
}

function cambioPrototipos() {
    console.log('Hola'.toUpperCase());
    
    String.prototype.prefijo = function() { return 'PREFIJO: ' + this; };
    
    console.log('Hola'.prefijo());
    
    String.prototype.toUpperCase = function() { return 'NA NANA NAAAAA NAAAAAA'; };
    
    console.log('Hola'.toUpperCase());
}