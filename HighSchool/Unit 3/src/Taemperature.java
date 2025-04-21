import java.util.Scanner;

public class Taemperature {
	public static void main(String[] args) {
		
		double temp = 0;
		int choice;
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Which one would you like. 1) C to F or 2) F to C:" );
		choice = input.nextInt();
		System.out.println("Enter the tempature pls: ");
		temp = input.nextDouble();
		
		if (choice == 1)
			System.out.println(fahrenheit(temp));
		else if (choice == 2)
			System.out.println(celcius(temp));
	}

	private static double fahrenheit(double fahrenheit) {
		// TODO Auto-generated method stub
		return 5.0 / 9.0 * (fahrenheit - 32);
	}

	private static double celcius(double celcius) {
		// TODO Auto-generated method stub
		
		return 9.0 / 5.0 * celcius + 32;
		
	}

}
