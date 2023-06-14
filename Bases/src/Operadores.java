public class Operadores {
	public static void main(String[] args) {
		System.out.println(5 + 2 + 1);
		System.out.println(Math.pow(5, 2));

		int x = -5;

		System.out.println(x == 5);
		System.out.println(x != 5);

		System.out.println(1 <= x && x <= 10);

		int a, b, c;

		a = b = c = 1;

		a = -6;

		c = a > b ? a : b;
		
		System.out.println(c);
		
		boolean arrancado = false;
		
		System.out.println(arrancado ? "ARRANCADO" : "PARADO");
		
		System.out.println((int)(Math.random() * 6.0) + 1);
	}
}
