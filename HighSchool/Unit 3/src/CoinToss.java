import java.util.Scanner;

public class CoinToss {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int choice;
		int countHead = 0;
		int countTail = 0;
		
		do {
			System.out.println("Enter 1) toss coin 2) Exit");
			choice = input.nextInt();
			if (choice == 1) {
				
				if (toss()){
					countHead++;
					System.out.println("Heads");
				} else {
					countTail++;
					System.out.println("Tails");
				}
				
				System.out.printf("The current number of heads is %d and tails %d",countHead, countTail);
			}
		} while (choice !=2);
		
	}

	private static boolean toss() {
		//pick a random number - either 0 or 1
		
		int randomNum;
		
		randomNum = (int)(Math.random() * 2); //Creates a number 0<= x < 1
		                                      // If we multiply by 2 then half will be less then 1.0 and half are graTER THEN 1.0
		if (randomNum == 0)                   // Int for less then 1 will become 0
			                                  //Int for greater or equal to 1 they will become 1
			return true;
		else if (randomNum == 1)
			return false;
		return false;
		
		
	}

}
