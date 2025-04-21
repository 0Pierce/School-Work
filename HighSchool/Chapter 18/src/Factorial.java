import java.util.Scanner;

public class Factorial {
	
	public static void main(String[] args) {
		
		System.out.println("Main");
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter number");
		int number = input.nextInt();
		
		factorial(number);
		
		int fact = factorial(number);
		System.out.printf("Your factorial is %d", fact);
		
		
		
		
		
	}
	
	
	public static int factorial(int number) {
		
		if(number == 0) {
			System.out.println("Entered if");
			return 1;
			
		}
			
		else {
			System.out.println("Entered else");
			return(number*factorial(number-1));
		}
		
		
		
	}

}
