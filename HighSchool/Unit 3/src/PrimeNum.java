
public class PrimeNum {
	
	public static void main(String[] args) {
		
		for (int num = 2; num <= 100;num++) {
			
			if (prime(num))
				System.out.printf("%d is prime\n ", num);
		}
	}

	private static boolean prime(int num) { // to accept num
		
	
		for (int factor = 2; factor <= Math.sqrt(num); factor++)
			if (num % factor ==0)
				return false;
		return true;
		
	
	}

}
