package com.ipartek.formacion.bibliotecas;

public class Utilidades {
	public static boolean convertirABoolean(String boolTexto) {
		System.out.println(boolTexto);
		
		String boolTextoSinEspacios = boolTexto.trim();
		
		String boolTextoMinusculas = boolTextoSinEspacios.toLowerCase();
		
		char boolPrimeraLetra = boolTextoMinusculas.charAt(0);

		boolean bool = boolPrimeraLetra == 's'; // "s".equalsIgnoreCase(boolPrimeraLetra);
		
		return bool;
	}
}
