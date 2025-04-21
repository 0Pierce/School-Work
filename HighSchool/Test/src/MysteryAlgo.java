import java.util.Arrays;

public class MysteryAlgo {

	public static void main(String[] args) {

		/*
		 * 1) Create a for loop to run everything throughout the array 2) Create another
		 * for loop inside of the first to check the slots a) Create the swap mechanism
		 * but instead of checking +1 make that a variable b) every time the loop runs
		 * divide that variable by some factor (e.g 2) (Or just shrink by 1) 3)If the
		 * gap variable will = 1 then the program will run one last time and check for
		 * swaps(Becomes bubble sort pretty much) a) do an if statement to 4) If no
		 * swaps are found(Flag variable) Then the array is printed and sorted
		 */

		int[] data = { 6, 34, 20, 56, 23, 4, 47 };

		mysterysort(data, 1.7);
		
	}

	private static void mysterysort(int data[], double factor) {

		boolean swap = true;

		int begin = 0;
		int last = data.length;
		int gap = 5;

		while (swap == true) {
			
			

			for (int spot = 0; spot < last; spot++) {

				if (data[spot] > data[spot + gap]) {

					int temp = data[spot];
					
					data[spot] = data[spot + gap];

					data[spot + gap] = temp;
					swap = true;
					gap = (int) (gap / factor);

					if (gap == 1) {
						break;
					}
				}

				
			}

			

		}
		
		System.out.println(Arrays.toString(data));

	}

}
