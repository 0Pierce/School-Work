import java.util.Scanner;

public class AirplaneSeats {
	
	static Scanner input = new Scanner(System.in);
	static boolean[] seatArray = new boolean[10];
	static int firstClassIndex = 0;
	static int EconomyIndex = 5;
	
	public static void main(String[] args) {
		
		int choice;
		
		do {
			System.out.println("Enter 1) First class2) Economy3) Take off:");
			choice = input.nextInt();
			
			if (choice==3)
				break;
			else {
				if (choice == 1)
					assignFirstClassSeat();
				else if (choice ==2)
					assignEconomySeat();
				
				displaySeats();
			}
			
			
		}while (firstClassIndex < 5 || EconomyIndex < 10);
		
		System.out.println("Bon voyage!");
	}

	private static void assignFirstClassSeat() {
		
		if (firstClassIndex <5) {
			seatArray[firstClassIndex] = true;
			firstClassIndex++;
		}else if (EconomyIndex < 10) {
			System.out.println("First class is full, wanna go to economy class?");
			
			String answer = input.next();
			
			if (answer.equalsIgnoreCase("y")) {
				seatArray[EconomyIndex] = true;
				EconomyIndex++;
			}else
				System.out.println("New flight leaves in 3 hours");
			
		}
		
		
	}

	private static void assignEconomySeat() {
		
		if (EconomyIndex <10) {
			seatArray[EconomyIndex] = true;
			EconomyIndex++;
		}else if (firstClassIndex < 5) {
			System.out.println("Economy class is full, wanna go to first class?");
			String answer = input.next();
			
			if (answer.equalsIgnoreCase("y")) {
				seatArray[firstClassIndex]=true;
				firstClassIndex++;
				
				
			}else 
				System.out.println("Next flight leaves in 3 hours");
		}
		
		
		
	}

	private static void displaySeats() {
		
		System.out.print("\nAirplane seat Status: ");
		
		for (boolean seat : seatArray)
			System.out.print(seat + " ");
		
		System.out.println();
		System.out.println();
		
			
		
		
	}
}
