import java.lang.reflect.Array;
import java.util.Scanner;

/*
 * Youtube link explaining this - https://www.youtube.com/watch?v=hKI93hOfeIk&ab_channel=BillBarnum
 * 
 * 
 * 
 */

public class BinarySearch {

	public static void main(String[] args) {

		int[] array = new int[6];

		int begin = 0;
		int last = array.length - 1;
		int mid = 0;

		Scanner input = new Scanner(System.in);

		System.out.println("Enter 5 numbers");

		
		//loop to get all of the inputs
		for (int i = 0; i < 5; i++) {
			array[i] = input.nextInt();
		}

		int check = 1;

		
		//For testing purposes
		System.out.println("Enter what you are looking for");
		int key = input.nextInt();

		// Makes sure that the left side is on the left rather then on the right
		while (begin <= last) {

			// Gets the middle
			mid = (begin + last) / 2;

			// Checks if num in the middle of the array is smaller then the key
			if (array[mid] < key) {

				// Moves pointer to the right
				begin = mid + 1;

				// System.out.println("1st if");
			} else if (array[mid] > key) {

				// moves pointer to the left
				last = mid - 1;

				// System.out.println("2nd if");
			} else {

				// once pointers are on top of each other (See video for explanation)
				System.out.println("Found");
				return;
			}

			// Prints the amount of times loop ran
			// System.out.printf("loop ran %d %n", check);

			//check++;

		}
		
		//If program leaves the loop then the number was not found
		System.out.println("Not found");

	}

}
