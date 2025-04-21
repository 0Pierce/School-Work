package Recursion;

import java.util.Scanner;

public class p3 {
	
	/* The greatest common divisor (gcd) of integers x and y is the largest integer that evenly divides into both x and y. 
	 * Write a recursive method gcd that returns the greatest common divisor of x and y. 
	 * The gcd of x and y is defined recursively as follows:
	 *  If y is equal to 0, then gcd(x, y) is x; otherwise, gcd(x, y) is gcd(y, x % y), where % is the remainder operator (mod).
	 *   Incorporate this method into an application that reads the values from the user and displays the result.
	 */

	
	
	public static void main(String[] args) {
		
		
		Scanner input = new Scanner(System.in);
		
		
		System.out.println("Enter x");
		int x = input.nextInt();
		System.out.println("Enter y");
		int y = input.nextInt();
		
		
		int answer =gcd(x,y);
		
		System.out.println(answer);
		
	}
	
	
	public static int gcd(int x, int y) {
		
		if(y == 0) {
			return x;
		}else {
			return gcd(y, x % y);
		}
		
		
	}

}
