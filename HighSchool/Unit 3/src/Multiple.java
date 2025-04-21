import java.util.Scanner;

public class Multiple {
	public static void main (String[] args) {
		Scanner input = new Scanner (System.in);
		
		int number1,number2;
		
		
		System.out.print("Enter the first number: ");
		number1 = input.nextInt();
		

		System.out.print("Enter the second number: ");
		number2 = input.nextInt();
		
		
		if (isMultiple(number1,number2))
			System.out.printf("%d is a multiple of %d", number2,number1);
		else
			System.out.printf("%d is not a multiple of %d", number2, number1);
			
		
	}
	
	private static boolean isMultiple(int num1, int num2) {
		
		if (num1 % num2 == 0) {
			return true;
		} else
			return false;
		
	}

}
