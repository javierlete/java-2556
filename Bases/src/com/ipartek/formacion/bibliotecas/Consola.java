package com.ipartek.formacion.bibliotecas;

import java.util.Scanner;

public class Consola {
	private static final Scanner SC = new Scanner(System.in);
	
	public static void mostrarLinea(Object texto) {
		System.out.println(texto);
	}
	
	public static void mostrar(Object texto) {
		System.out.print(texto);
	}
	
	public static String leerLinea(String mensaje) {
		mostrar(mensaje + ": ");
		return SC.nextLine();
	}
	
	public static int leerEntero(String mensaje) {
		String texto = leerLinea(mensaje);
		int entero = Integer.parseInt(texto);
		
		return entero;
	}
	
	public static boolean leerBooleano(String mensaje) {
		String texto = leerLinea(mensaje);
		boolean booleano = Utilidades.convertirABoolean(texto);
		
		return booleano;
	}
}
