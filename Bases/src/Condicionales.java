import java.util.Scanner;

public class Condicionales {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Dime tu nombre: ");

		String nombre = sc.nextLine();

//		if ("Javier Lete".equals(nombre)) {
//			System.out.println("Hola profe");
//		} else if ("Yerai".equals(nombre)) {
//			System.out.println("Hola antiguo alumno");
//		} else {
//			System.out.println("Hola alumno");
//			System.out.println("¿Qué pasa alumno?");
//		}

		// Java7 (switch con String)
		switch (nombre) {
		case "Javier Lete":
			System.out.println("Hola profe");
			break;
		case "Yerai":
			System.out.println("Hola antiguo alumno");
			break;
		default:
			System.out.println("Hola alumno");
			System.out.println("¿Qué pasa alumno?");
		}

		System.out.println("Hasta la próxima");
		
		sc.close();
	}
}
