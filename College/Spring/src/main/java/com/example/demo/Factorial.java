package com.example.demo;

import java.util.Scanner;

public class Factorial {
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Emter a number");
		
		int num = scan.nextInt();
		
		System.out.println("Factorial of: "+ num + " is " + calcFactorial(num));
		

	}
	
	
	public static long calcFactorial(int num) {
		
		if(num >= 1) 
			return num * calcFactorial(num-1);
		else
			return 1;
		
	}

}