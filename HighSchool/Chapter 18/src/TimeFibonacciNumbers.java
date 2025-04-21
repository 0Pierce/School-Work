import java.math.BigInteger;

public class TimeFibonacciNumbers {

	private static BigInteger TWO = BigInteger.valueOf(2);
	static int count = 0;

	public static void main(String[] args) {
		// System.out.print("time in nanoseconds = ");
		System.out.println(System.nanoTime());
		double first = System.nanoTime();
		double answer = 0;
		

		for (int counter = 0; counter <= 100; counter++) {
			
			System.out.printf("Fibonacci of %d is %d\n", count, fibonacci(BigInteger.valueOf(counter)));
			double last = System.nanoTime();
			
			answer = last - first;
			System.out.println(answer + " Nanoseconds");
			System.out.println("Method was entered "+ count + " times");
		}
		
		// System.out.println(System.nanoTime());

	}

	public static BigInteger fibonacci(BigInteger number) {
		count++;
		
		
		if(number.equals(BigInteger.ZERO) || number.equals(BigInteger.ONE)) {
			
			return number;
			
		}else {
			
			return fibonacci(number.subtract(BigInteger.ONE)).add(fibonacci(number.subtract(TWO)));
			
		}
		
		 
		
	

	}

}
