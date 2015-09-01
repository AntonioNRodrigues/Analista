import java.math.BigInteger;


public class Factorial {
	public Factorial() {
		
	} 
	
	public static int factorial(int n, int aux) {
		if (n == 0) 
			return aux;
		else 
			return factorial(n - 1, aux * n);
	}
	
	public static BigInteger bigFactorial(BigInteger n, BigInteger aux) {
		if (n.compareTo(new BigInteger("0")) == 0) 
			return aux;
		else 
			return bigFactorial(n.subtract(
					new BigInteger("1")), aux.multiply(n));
	}
}
