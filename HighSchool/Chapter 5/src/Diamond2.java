import java.util.Scanner;

public class Diamond2 {

	public static void main(String[] args) {

		// height = 9

		Scanner input = new Scanner (System.in);
		
		int numRows;
		int numSpaces;
		int numStars;

		
		do {
			System.out.println("Enter a odd number of rows from 1-19: ");
			numRows = input.nextInt();
			
			
			
		}while (numRows < 1 || numRows > 19 || numRows % 2 ==0);
		
		numSpaces = numRows / 2;
		numStars = 1;
		
		
		
		
		for (int row = 1; row <= 9; row++) {

			for (int spaces = 1; spaces <= numSpaces; spaces++)
				System.out.print(" ");

			for (int stars = 1; stars <= numStars; stars++)
				System.out.print("*");

			System.out.println();

			if (row < 5) {

				numStars += 2;
				numSpaces--;
			} else {

				numStars -= 2;
				numSpaces++;
			}

		}

	}

}
