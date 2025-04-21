import java.util.Arrays;
import java.util.Scanner;

public class PrintArrayBackwards {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int[] array = new int[5];
		
		System.out.println("Enter 5 numbers");
		for(int i = 0; i < array.length; i++) {
			array[i] = input.nextInt();
		}
		
		
		int count = array.length -1;
		
		System.out.println(Arrays.toString(array));
		
		
		
		pArray(array,count);
		
		
		
	}
	
	public static int pArray(int[] array, int count) {
		
		
		
		if(count != -1) {
			
			System.out.print(array[count] + "  ");
			count--;
			pArray(array, count);
			
		}
		
		return 1;
		
		
		
		
		
		
	}

}
