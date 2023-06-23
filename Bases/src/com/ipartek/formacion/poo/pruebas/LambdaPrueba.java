package com.ipartek.formacion.poo.pruebas;

import java.util.function.DoubleBinaryOperator;
import java.util.ArrayList;

public class LambdaPrueba {
	public static void main(String[] args) {
		DoubleBinaryOperator operacion;

		operacion = (a, b) -> a + b;

		System.out.println(operacion.applyAsDouble(5, 6));

		operacion = (a, b) -> { return a - b; };

		System.out.println(operacion.applyAsDouble(5, 6));

		ArrayList<Integer> enteros = new ArrayList<>();
		
		enteros.add(5);
		enteros.add(7);
		enteros.add(6);
		
		enteros.forEach(entero -> System.out.println(entero));
		
		enteros.forEach(entero -> {
			if(entero > 5) {
				System.out.println(entero);
			}
		});
	}
}
