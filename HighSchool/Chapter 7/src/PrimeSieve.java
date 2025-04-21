import java.util.Scanner;

public class PrimeSieve {

	static boolean[] primeArray = new boolean[1000];

	public static void main(String[] args) {

		// set the prime array
		setPrimeArray();
		// filter the primes
		filterPrime();
		// display the results
		displayResults();

	}

	private static void setPrimeArray() {

		for (int index = 2; index < primeArray.length; index++)
			primeArray[index] = true; //Arrays.fill for shortcut
			
			
		

	}

	private static void filterPrime() {
		for (int index = 2; index < primeArray.length; index++) {
			if (primeArray[index] == true) {
				for (int num = index+1;num < primeArray.length; num++) {
					
					if(primeArray[num] == true && num % index == 0)
						primeArray[num] = false;
					
				}
				
				
			}
		}
		
		
		

	}

	private static void displayResults() {
		for (int index = 2; index < primeArray.length;index++) {
			
			if (primeArray[index] == true)
				System.out.println(index);
			
		}

	}

}
