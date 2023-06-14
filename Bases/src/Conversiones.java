import java.util.Date;
import java.util.Scanner;

public class Conversiones {
	public static void main(String[] args) {
		String numeroTexto = "123";

		System.out.println(numeroTexto + 4);

		int numero = Integer.parseInt(numeroTexto);

		System.out.println(numero + 4);

		Scanner sc = new Scanner(System.in);

		System.out.print("¿Te gusta? ");

		String boolTexto = sc.nextLine();
		
		System.out.println(boolTexto);
		
		String boolTextoSinEspacios = boolTexto.trim();
		
		System.out.println(boolTextoSinEspacios);
		
		String boolTextoMinusculas = boolTextoSinEspacios.toLowerCase();
		
		System.out.println(boolTextoMinusculas);
		
		char boolPrimeraLetra = boolTextoMinusculas.charAt(0);

		System.out.println(boolPrimeraLetra);
		
		boolean bool = boolPrimeraLetra == 's'; // "s".equalsIgnoreCase(boolPrimeraLetra);

		System.out.println(bool);

		sc.close();
		
		String boolOtroTexto = String.valueOf(bool);
		
		System.out.println(boolOtroTexto);
		
		Date fecha = new Date();
		String fechaTexto = fecha.toString();
		
		System.out.println(fechaTexto);
		
		fechaTexto = String.valueOf(fecha);
		
		System.out.println(fechaTexto);
	}
}
