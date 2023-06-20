package com.ipartek.formacion.bibliotecas;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;
import java.time.format.DateTimeParseException;

public class Consola {
	private static final Scanner SC = new Scanner(System.in);

	public static void mostrarLineaError(Object texto) {
		System.err.println("ERROR: " + texto);
	}

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

	public static long leerLong(String mensaje) {
		boolean equivocado = true;

		long l = 0;

		do {
			String texto = leerLinea(mensaje);
			try {
				l = Long.parseLong(texto);
				equivocado = false;
			} catch (NumberFormatException e) {
				mostrarLineaError("No es un número válido");
			}
		} while (equivocado);

		return l;
	}

	public static BigDecimal leerBigDecimal(String mensaje) {
		boolean equivocado = true;

		BigDecimal bd = null;

		do {
			String texto = leerLinea(mensaje);
			try {
				bd = new BigDecimal(texto);
				equivocado = false;
			} catch (NumberFormatException e) {
				mostrarLineaError("No es un número válido");
			}
		} while (equivocado);

		return bd;
	}

	public static boolean leerBooleano(String mensaje) {
		String texto = leerLinea(mensaje + "(s/N)");
		boolean booleano = Utilidades.convertirABoolean(texto);

		return booleano;
	}

	public static LocalDate leerLocalDate(String mensaje) {
		boolean equivocado = true;

		LocalDate ld = null;

		do {
			String texto = leerLinea(mensaje + " (AAAA-MM-DD)");
			try {
				ld = LocalDate.parse(texto);
				equivocado = false;
			} catch (DateTimeParseException e) {
				mostrarLineaError("No es una fecha válida. Debe ser el año en cuatro dígitos, mes en dos dígitos y día en dos dígitos separados por guión. Por ejemplo: 2000-01-02");
			}
		} while (equivocado);

		return ld;
	}
}
