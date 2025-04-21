import java.util.Scanner;

public class MaximumMinEverything {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.println("1)Max area for a 4 side rectangle enter (1) ");
		System.out.println("2)Max area for a 3 side rectangle enter (2)");
		System.out.println("3)Min area for a cylinder  enter (3)");
		int answer = input.nextInt();

		if (answer == 1) {

			foursides();

		}

		if (answer == 2) {
			threesides();
		}

		if (answer == 3) {
			cylinder();
		}

	}

	public static void foursides() {

		Scanner input = new Scanner(System.in);

		System.out.println("---You have chosen 4 sides---");
		System.out.println("");

		System.out.println("For table of values enter (1)");
		System.out.println("For single calculations enter (In case the length increase is random) (2)");
		int swap = input.nextInt();

		double area = 0, biggest = 0, lBiggest = 0, wBiggest = 0;
		int answer = 0;

		if (swap == 2) {
			System.out.println("--You have chosen single calculations--");
			System.out.println("");
		}

		while (swap == 2) {
			System.out.println("Enter perimeter:");
			int perimeter = input.nextInt();

			System.out.println("Enter value of length:");
			double length = input.nextInt();

			System.out.println("Enter starting value of width:");
			double width = input.nextInt();

			width = (perimeter - length * 2) / 2;

			// Calcs the area
			area = width * length;

			System.out.printf(" %.2fL * %.2fW = %.2f A   |   Your area is %.2f %n", length, width, area, area);

			System.out.println("Wanna go again? (2 = yes) (1 = tables) (3 = exit)");
			swap = input.nextInt();

		}

		while (swap == 1) {

			System.out.println("Enter perimeter:");
			int perimeter = input.nextInt();

			System.out.println("Enter starting value of length:");
			double length = input.nextInt();

			System.out.println("Enter starting value of width:");
			double width = input.nextInt();

			System.out.println("By how much does the length increase?:");
			int increase = input.nextInt();

			System.out.println("How many rows do you want:");
			int rows = input.nextInt();

			// Creates the rows
			for (int i = 0; i < rows; i++) {

				// Gets the width
				width = (perimeter - length * 2) / 2;

				// Calcs the area
				area = width * length;

				System.out.printf(" %.2fL * %.2fW = %.2f A   |   Your area is %.2f %n", length, width, area, area);

				if (area > biggest) {
					biggest = area;
					// Used for debugging
					// System.out.printf("Biggest area %d %n", biggest);
					lBiggest = length;
					// Used for debugging
					// System.out.printf("Biggest length %d %n", lBiggest);
					wBiggest = width;
					// Used for debugging
					// System.out.printf("Biggest width %d %n", wBiggest);

				}

				if (area < 0)
					break;

				length += increase;

			}

			System.out.println("");
			System.out.printf("%.2fL * %.2fW = %.2f is the biggest area %n", lBiggest, wBiggest, biggest);

			System.out.println("");
			System.out.println("Wanna go again? (2 = yes) | (1 = no)");
			swap = input.nextInt();

		}

	}

	public static void threesides() {

		Scanner input = new Scanner(System.in);

		double biggest = 0, lBiggest = 0, wBiggest = 0;
		int answer = 0;
		System.out.println("---You have chosen 3 sides---");
		System.out.println("");

		System.out.println("For table of values enter (1)");
		System.out.println("For single calculations enter (In case the length increase is random) (2)");
		int swap = input.nextInt();

		if (swap == 2) {
			System.out.println("--You have chosen single calculations--");
			System.out.println("");
		}

		while (swap == 2) {

			System.out.println("Enter the perimeter:");
			double perimeter = input.nextInt();

			System.out.println("Enter the length:");
			double length = input.nextInt();

			System.out.println("Enter the width:");
			double width = input.nextInt();

			width = perimeter - length * 2;

			double area = width * length;

			System.out.printf("%.2fL * %.2fW = %.2f A | Your area is %.2f %n", length, width, area, area);

			System.out.println("Wanna go again? (2 = yes) (1 = tables) (3 = exit)");
			swap = input.nextInt();

		}

		while (swap == 1) {

			System.out.println("Enter the perimeter:");
			double perimeter = input.nextInt();

			System.out.println("Enter the starting length:");
			double length = input.nextInt();

			System.out.println("Enter the starting width:");
			double width = input.nextInt();

			System.out.println("By how much does the length increase?:");
			int increase = input.nextInt();

			System.out.println("How many rows do you want?:");
			int rows = input.nextInt();

			for (int i = 0; i < rows; i++) {

				width = perimeter - length * 2;

				double area = width * length;

				System.out.printf("%.2fL * %.2fW = %.2f A | Your area is %.2f %n", length, width, area, area);

				if (area > biggest) {
					biggest = area;
					// Used for debugging
					// System.out.printf("Biggest area %d %n", biggest);
					lBiggest = length;
					// Used for debugging
					// System.out.printf("Biggest length %d %n", lBiggest);
					wBiggest = width;
					// Used for debugging
					// System.out.printf("Biggest width %d %n", wBiggest);

				}

				if (area < 0)
					break;

				length += increase;

			}

			System.out.println("");
			System.out.printf("%.2fL * %.2fW = %.2f is the biggest area %n", lBiggest, wBiggest, biggest);

			System.out.println("");

			System.out.println("Wanna go again? (1 = yes) | (2 = no)");
			answer = input.nextInt();

		}

	}

	public static void cylinder() {

		Scanner input = new Scanner(System.in);

		System.out.println("---You have chosen cylinder---");
		System.out.println("");

		double radius, height, volume, area, increase, pi = 3.1415926535;
		int rows;

		System.out.println("For table of values enter (1)");
		System.out.println("For single calculations enter (In case the radius increase is random) (2)");
		int swap = input.nextInt();

		if (swap == 2) {
			System.out.println("--You have chosen single calculations--");
			System.out.println("");
		}

		while (swap == 2) {

			System.out.println("--You have chosen single calc--");

			System.out.println("Enter the radius:");
			radius = input.nextDouble();

			System.out.println("Enter the volume:");
			volume = input.nextDouble();

			height = volume / (pi * Math.pow(radius, 2));

			area = (2 * pi * radius * height) + (2 * pi * Math.pow(radius, 2));

			System.out.printf(" %.2f         %.2f          %.2f%n ", radius, height, area);

			System.out.println("");
			System.out.println("Wanna go again? (1 = switch to tables) (2 = yes) (3 = exit)");
			swap = input.nextInt();

		}

		double smallest = 1000000, rSmallest = 0, hSmallest = 0;

		System.out.println("--You have chosen tables--");
		System.out.println("");
		while (swap == 1) {

			System.out.println("Enter the radius:");
			radius = input.nextDouble();

			System.out.println("Enter the volume:");
			volume = input.nextDouble();

			System.out.println("By how much does the radius increase?:");
			increase = input.nextDouble();

			System.out.println("How many rows do you want?:");
			rows = input.nextInt();

			System.out.println("Radius   |   Height   |   Surface Area");

			for (int i = 0; i < rows; i++) {

				height = volume / (pi * Math.pow(radius, 2));

				area = (2 * pi * radius * height) + (2 * pi * Math.pow(radius, 2));

				System.out.printf(" %.2f         %.2f          %.2f%n ", radius, height, area);

				if (area < smallest) {
					smallest = area;
					rSmallest = radius;
					hSmallest = height;
				}

				radius += increase;

				if (height < 0) {
					break;
				}

			}
			
			System.out.println("");
			System.out.printf(" %.2f         %.2f          %.2f%n is the smallest", rSmallest, hSmallest, smallest);

			System.out.println("Wanna go again? (1 = yes) | (2 = no)");
			swap = input.nextInt();

		}

	}

}
