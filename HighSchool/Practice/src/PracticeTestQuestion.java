import java.lang.reflect.Array;
import java.util.Arrays;

/* 1) Create a loop to go through the data
 * 2) If the number of the left is bigger then on the right SWAP
 * 3) After pass 1 second stage begins
 * 		a) Create a loop to go through the data from right to left
 * 		b) If right number is smaller then left number SWAP
 * 		c) Go through entire array like this
 * 4) If nothing gets sorted after one pass break out of the loop
 * 		a) use an If statement to break
 * 5) Output the sorted array
 * 
 */

public class PracticeTestQuestion {

	public static void main(String[] args) {
		
		boolean swapped = true;

		// int numbers[] = new int[10];

		int[] numbers = { 5, 3, 5, 6, 27, 29, 26, 9, 5, 13, 5, 17 };

		int start = 0, end;

		int length = numbers.length;

		System.out.println(length);
		while(swapped) {
			
			for (int spot = start; spot < length - 1; ++spot) {

				if (numbers[spot] > numbers[spot + 1]) {

					System.out.println("Entered first loop");

					int temp = numbers[spot];
					System.out.printf("Temp number is %d %n", temp);
					numbers[spot] = numbers[spot + 1];

					numbers[spot + 1] = temp;
					swapped = true;

				}
				System.out.println(spot);
				
				if(swapped == false) {
					break;
				}
				else {
					swapped = false;
					length = length -1;
				}
				
			}
			
			

		

		System.out.println(Arrays.toString(numbers));

	for(int i = 1; i < length; i++) {
		for (int spot1 = length; spot1 > start; spot1--) {

			if (numbers[spot1 - 1] > numbers[spot1]) {

				System.out.println("Entered second loop");

				int temp = numbers[spot1];
				numbers[spot1] = numbers[spot1 - 1];
				numbers[spot1 - 1] = temp;
				swapped = true;

			}

			System.out.println("Loop Running");

		}
		
	}
			start = start +1;
		}

			
		

		System.out.println(Arrays.toString(numbers));

	}

}
