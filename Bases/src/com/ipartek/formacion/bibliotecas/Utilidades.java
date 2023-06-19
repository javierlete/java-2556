package com.ipartek.formacion.bibliotecas;

public class Utilidades {
	public static boolean convertirABoolean(String boolTexto) {
		//System.out.println(boolTexto);
		
		String boolTextoSinEspacios = boolTexto.trim();
		
		int longitud = boolTextoSinEspacios.length();
		
		if(longitud == 0) {
			return false;
		}
		
		String boolTextoMinusculas = boolTextoSinEspacios.toLowerCase();
		
		char boolPrimeraLetra = boolTextoMinusculas.charAt(0);

		boolean bool = boolPrimeraLetra == 's'; // "s".equalsIgnoreCase(boolPrimeraLetra);
		
		return bool;
	}
}
