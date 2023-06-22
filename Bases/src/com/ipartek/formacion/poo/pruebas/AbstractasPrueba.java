package com.ipartek.formacion.poo.pruebas;

import java.util.*;
import java.math.BigDecimal;

public class AbstractasPrueba {

	public static void main(String[] args) {
		ArrayList<Number> numeros = new ArrayList<>();
		
		numeros.add(5); //new Integer(5);
		numeros.add(2.3); //new Double(2.3));
		numeros.add(new BigDecimal("45.2"));
		
		for(Number numero: numeros) {
			System.out.println(numero.doubleValue());
		}
	}
}
