import java.math.BigInteger;

public class Recursividad {
	public static void main(String[] args) {
		BigInteger diezmil = new BigInteger("10000");
		BigInteger resultado = factorial(diezmil);
		String textoResultado = resultado.toString();
		int numeroDigitos = textoResultado.length();

		System.out.println(numeroDigitos);

		BigInteger cienmil = new BigInteger("100000");
		resultado = factorialIterativo(cienmil);
		textoResultado = resultado.toString();
		numeroDigitos = textoResultado.length();
		
		System.out.println(numeroDigitos);
	}

	// 5! = 5*4*3*2*1
	// 5! = 5*4!
	// 4! = 4*3!
	// 3! = 3*2!
	// 2! = 2*1!
	// 1! = 1

	private static BigInteger factorial(BigInteger numero) {
		if (numero.compareTo(BigInteger.ONE) == 0) {
			return BigInteger.ONE;
		}

		return numero.multiply(factorial(numero.subtract(BigInteger.ONE)));
	}

	private static BigInteger factorialIterativo(BigInteger numero) {
		BigInteger total = BigInteger.ONE;

		for (BigInteger c = BigInteger.ONE; c.compareTo(numero) <= 0; c.add(BigInteger.ONE)) {
			total = total.multiply(c);
		}

		return total;
	}
}
