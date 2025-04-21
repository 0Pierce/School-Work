import java.util.Arrays;
import java.util.Scanner;

public class BucketSort {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		// array where the unsorted numbers are stored
		int[] nums = new int[10];

		// gets numbers into array
		System.out.println("Enter 10 numbers (Up to 100)");
		for (int g = 0; g < 10; g++) {
			nums[g] = input.nextInt();
		}

		// 2d array left number is amount of buckets right number is amount of slots per
		// bucket(array)
		int[][] buckets = new int[6][11];

		// Runs 10 times to place all 10 numbers into buckets
		for (int i = 0; i < 10; i++) {
			if (nums[i] < 20) {
				buckets[1][i] = nums[i];

				// Assigns current array value to key to empty array slot
				int key = buckets[1][i];
				int j = i - 1;

				// Keep counts of the count and goes through array[1] to swap numbers
				while (j >= 0 && buckets[1][j] > key) {
					// moves the current array value of j up by one
					buckets[1][j + 1] = buckets[1][j];
					j--;

				}

				// Swaps the right number with the left number
				buckets[1][j + 1] = key;

				// Exactly the same for all other arrays going down
			}
			if ((nums[i] > 21) && (nums[i] < 40)) {
				buckets[2][i] = nums[i];

				int key = buckets[2][i];
				int j = i - 1;

				while (j >= 0 && buckets[2][j] > key) {
					buckets[2][j + 1] = buckets[2][j];
					j--;

				}

				buckets[2][j + 1] = key;

			}
			if ((nums[i] > 41) && (nums[i] < 60)) {
				buckets[3][i] = nums[i];

				int key = buckets[3][i];
				int j = i - 1;

				while (j >= 0 && buckets[3][j] > key) {
					buckets[3][j + 1] = buckets[3][j];
					j--;

				}

				buckets[3][j + 1] = key;

			}
			if ((nums[i] > 61) && (nums[i] < 80)) {
				buckets[4][i] = nums[i];

				int key = buckets[4][i];
				int j = i - 1;

				while (j >= 0 && buckets[4][j] > key) {
					buckets[4][j + 1] = buckets[4][j];
					j--;

				}

				buckets[4][j + 1] = key;

			}
			if ((nums[i] > 81) && (nums[i] < 100)) {
				buckets[5][i] = nums[i];

				int key = buckets[5][i];
				int j = i - 1;

				while (j >= 0 && buckets[5][j] > key) {
					buckets[5][j + 1] = buckets[5][j];
					j--;

				}

				buckets[5][j + 1] = key;

			}

		}
		
		//Prints the 2d array
		System.out.println(Arrays.deepToString(buckets));

	}

}
