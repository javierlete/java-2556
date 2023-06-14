import java.util.Scanner;

public class HolaMundo {
	public static void main(String[] args) {
		System.out.println("Hola");

		int a = -2000000000;
		int b = 6;

		System.out.println(a);
		System.out.println(b);

		double d = 12, e = 56.3;

		float f = 12.5f;

		System.out.println(d);
		System.out.println(e);

		long l = 8123123123123123123l;

		boolean bool = true;

		char c = 'e';

		String nombre = "Javier Lete";

		System.out.println(nombre);

		Scanner sc = new Scanner(System.in);

		System.out.println("DIME TU NOMBRE:");

		nombre = sc.nextLine();

		System.out.println("Hola " + nombre);

		System.out.print("Dame a: ");

		a = sc.nextInt();

		System.out.print("Dame b: ");

		b = sc.nextInt();

		int suma = a + b;

		System.out.println("a + b = " + suma);
	}
}
