import java.util.Random;
import java.util.Scanner;




public class DiceTable {
	static int[] diceTallyArray = new int[13];
	
	
	
	public static void main(String[] args) {
		
		// 3.Grabs input values and send to processing section  
		roll(numOfRolls());
		
		
		
	    //Output
		display();

		
	}

	private static int numOfRolls() {
		
		Scanner input = new Scanner(System.in);
		// 1.Gets num of dice rolls
		System.out.println("Enter the amount of dice rolls: ");
		//2.Sends to main
		return input.nextInt();
		
		
	
		
		
		
	}
    //4.Processing
	private static void roll(int numTimes) {
		
		//5.Enables random argument
		Random random = new Random();
		int diceTotal;
		
		
		
		for(int x= 1; x<= numTimes; x++) {
			
			
			
			diceTotal = (random.nextInt(6) + 1) + (random.nextInt(6) + 1);
			
			//6.Stores processed value into the Array
			++diceTallyArray[diceTotal];
		}
		
		
	}

	private static void display() {
		
		System.out.printf("Dice results\n");
		System.out.println("Total\tNumber\n");
		
		for (int x = 2; x<diceTallyArray.length; x++)
			System.out.printf("%d\t%d\n", x,diceTallyArray[x]);
		
		
		
	}

}
