import java.util.Scanner;

public class Even {
	public static void main (String[] args) {
		Scanner input = new Scanner (System.in);
		
		System.out.print("Enter a number");
		int number = input.nextInt();
		
		if (isEven(number))
			System.out.println("The number is even");
		else System.out.println("The Number isnt even");
		
	}
	
	
	private static boolean isEven(int number) {
		
		if (number % 2 == 0)
			return true;
		else
			return false;
		
		
		
	}

}
