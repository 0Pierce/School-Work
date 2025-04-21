import java.util.Scanner;

public class Power {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int  exponent,base ;
		
		System.out.println("Enter the base and then the exponent");
		exponent = input.nextInt();
		base = input.nextInt();
		
		
		
		System.out.printf("The base value is %d", integerpower(base,exponent));

	}

	private static int integerpower(int exponent, int base) {
		int output2 = 0, output = 1;
		


		

		for (int loop = 1; loop <= exponent; loop++) {
			output *= base;

		}

		return output;

	}

}
