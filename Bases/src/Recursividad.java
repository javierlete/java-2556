
public class Recursividad {
	public static void main(String[] args) {
		System.out.println(factorial(5));
	}
	
	// 5! = 5*4*3*2*1
	// 5! = 5*4!
	// 4! = 4*3!
	// 3! = 3*2!
	// 2! = 2*1!
	// 1! = 1
	
	private static int factorial(int numero) {
		if(numero == 1) {
			return 1;
		}
		
		return numero * factorial(numero - 1);
	}
}
