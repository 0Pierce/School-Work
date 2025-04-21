import java.util.Scanner;
public class CharacterSquare {
	public static void main(String[] args) {
		
		Scanner input = new Scanner (System.in);
		String answer;
		
		int sidelenght;
		do {
			
			
			System.out.println("What is the side lenght?");
			sidelenght = input.nextInt();
			
			
			squarecharacters(sidelenght, "#");
			
			
			System.out.println("Do you want to continue Y/N");
			answer = input.next();
		}while (answer.equalsIgnoreCase("Y"));
		
	}

	private static void squarecharacters(int sidelenght, String shape) {
		
		for (int row = 1; row < sidelenght; row++) {
			for (int column = 1; column < sidelenght; column++)
				System.out.printf("%s ", shape);
		
			System.out.println(); // Skipping to next row
		}
	}

}
