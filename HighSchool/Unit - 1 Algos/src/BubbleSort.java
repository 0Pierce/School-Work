import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {
	
	
	public static void main(String[] args) {
		
		
		
		
		int[] array = new int[5];
		
		
		int x = array.length;
		
		Scanner input = new Scanner(System.in);
		
		//Loop to get all 5 numbers into the array
		System.out.println("Enter 5 numbers");
		for(int j = 0; j < 5; j++ )
			array[j] = input.nextInt();
		
		
		System.out.println("These are your numbers");
		System.out.println(Arrays.toString(array));
		
		//Runs the code only through the length of the array.
		//Every time it runs it will ignore the last spot (-1)
		for(int i = 0; i < array.length - 1; i++)
			for(int spot = 0; spot < x-1; spot++) {
				
				//If you swap the <> you can change if it sorts from smallest or biggest
				if(array[spot] > array[spot+1]) {
					
					//Used to store the temporary number 
					int temp = array[spot];
					
					//System.out.println(temp);
					
					//Once array slot 1 is empty array slot 2 value is moved to slot 1
					array[spot] = array[spot+1];
					//empty slot 2 is now filled with temp number
					//The values have now been swapped in the array
					array[spot+1] = temp;
					
					
				}
			}
		
		//Output
		System.out.println("These are your numbers sorted");
		System.out.println(Arrays.toString(array));
		
		
		
	}

}
