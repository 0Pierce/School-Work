package Recursion;

import java.util.Scanner;

public class practice {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		int factorial1;

		System.out.println("Enter a number");
		int number = input.nextInt();

		int fact = factorial(number);

		
		
		
		System.out.println("Your answer " + fact);

	}

	public static int factorial(int number) {

		if (number == 0) {
			return 1;
		} else {
			return number*factorial(number-1);
			
		}

	}
}
