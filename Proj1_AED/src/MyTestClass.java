import java.math.BigInteger;


public class MyTestClass {
	public static void main(String[] args) {
		BigNatural myNum = new BigNatural(24531);
		System.out.println("Numero: " + myNum);

		// testes arimetricos
		int num = 23;
		System.out.println("\n-- Testes Aritmetricos --");
		System.out.println("Soma: " + num + " + " + myNum + " = " 
				+ myNum.sum(new BigNatural(num)));
		
		num = 152;
		System.out.println("Soma: " + num + " + " + myNum + " = " 
				+ myNum.sum(new BigNatural(num)));
		
		System.out.println("Sucessor de " + myNum + ": " + myNum.suc());
		
		num = 15;
		System.out.println("Multiplicacao: " + myNum + " * " 
				+ num + " = " + myNum.mult(new BigNatural(num)));
		
		// testes geq
		num = 24530;
		System.out.println("\n-- Testes GEQ --");
		System.out.println("GEQ: " + myNum + " >= " 
				+ num + " -> " + myNum.geq(new BigNatural(num)));
		
		num = 24531;
		System.out.println("GEQ: " + myNum + " >= " 
				+ num + " -> " + myNum.geq(new BigNatural(num)));
		
		num = 2453;
		System.out.println("GEQ: " + myNum + " >= " 
				+ num + " -> " + myNum.geq(new BigNatural(num)));
		
		num = 24532;
		System.out.println("GEQ: " + myNum + " >= " 
				+ num + " -> " + myNum.geq(new BigNatural(num)));
		
		num = 2453243;
		System.out.println("GEQ: " + myNum + " >= " 
				+ num + " -> " + myNum.geq(new BigNatural(num)));
		
		num = 2453243;
		System.out.println("GEQ: " + myNum + " >= " 
				+ num + " -> " + myNum.geq(new BigNatural(num)));
		
		// testes de duracao
		long start = System.currentTimeMillis();
		long end = System.currentTimeMillis();

		System.out.println("\n-- Testes Tempo --");
		System.out.println(Factorial.factorial(100, 1));
		System.out.printf("%.3f ms%n", (end-start) / 1000d);  
		System.out.println(Factorial.bigFactorial(new BigInteger("100"),
				new BigInteger("1")));

		start = System.currentTimeMillis();
		end = System.currentTimeMillis();
		System.out.printf("%.3f ms%n", (end-start) / 1000d);
		
		// testes equals
		BigNatural b1 = new BigNatural(123);
		BigNatural b2 = new BigNatural(123);
		BigNatural b3 = new BigNatural(20);
		BigNatural b4 = new BigNatural(234);
		
		System.out.println("\n-- Testes equals --");
		System.out.println("O b1 = " + b1  + " e o b2 = " + b2 + " " + 
				b1.equals(b2));
		System.out.println(b1 + " = " + b1 + " -> " + b1.equals(b1));
		System.out.println(b1 + " = " + b2 + " -> " + b1.equals(b2));
		System.out.println(b1 + " = " + b3 + " -> " + b1.equals(b3));
		System.out.println(b1 + " = " + b4 + " -> " + b1.equals(b4));
		System.out.println(b1.suc().mult(b2));
		System.out.println(b2.sum(b1.mult(b2)));
	}
}
