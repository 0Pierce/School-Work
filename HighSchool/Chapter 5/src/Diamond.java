
public class Diamond {

	public static void main(String[] args) {

		// height = 9

		int numSpaces = 4;
		int numStars = 1;

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
