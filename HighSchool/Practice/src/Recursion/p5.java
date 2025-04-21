package Recursion;

import java.util.Scanner;



public class p5 {
	
	public static void main(String[] args) {

		
		
	
		int[] array = new int[] {6,7,8,4,10};
		int count = 0;
	
		
		
		printArray(array, count);
		
		
		
	}
	
	
	public static int printArray(int array[], int count) {
		
		if(count < array.length) {
			System.out.print("     " + array[count]);
			count++;
			return printArray(array, count);
		}
		else {
			return 1;
		}
		
		
		
		
		
		
		
		
	}

}
