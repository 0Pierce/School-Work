package Recursion;

import java.util.Scanner;

public class p2 {
	
	/*
	 * (Power) Write a recursive method power( base, exponent ) that, when called, returns 
	 */
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		
		
		
		
		System.out.println("Enter a base");
		int base = input.nextInt();
		System.out.println("Enter exponent");
		int exponent = input.nextInt();
		
		
		
		int answer = power(base,exponent);
		
		System.out.println(answer);
		
		
	}
	
	
	public static int power(int base, int exponent) {
		int count = 0;
		
		if(exponent != 0) {
			count++;
			return base * power(base,exponent -1);
			
		}
		else {
			return 1;
		}
		
		
		
	}
	

}
