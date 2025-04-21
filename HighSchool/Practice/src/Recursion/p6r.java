package Recursion;

import java.util.Scanner;

public class p6r {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int num1;
		
		System.out.println("Enter 2 numbers");
		num1 = input.nextInt();

		
		System.out.println(sum(num1));
		
	}
	
	
	private static int sum(int num) {
		
		
		if(num == 0) {
			return 0;
			
		}else {
			return num + sum(num -1);
		}
		
	}

}
