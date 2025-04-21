import java.util.Scanner;

public class Parking {
	public static void main (String[] args) {
		
		Scanner input = new Scanner(System.in);
		double hours;
		double charges = 0;
		double totalCharges =0;
		String answer;
		
		do {
			System.out.println("How many hours did you park");
			 hours = input.nextDouble();
			 
			charges = calculateCharges(hours);
			
			totalCharges += charges;
			
			System.out.printf("Your charges for %.1f hours was $%.2f\n", hours,charges);
			
			
			System.out.println("Is there another customer? y/n ?");
			answer = input.next();
			
			
			
			
		} while (answer.equalsIgnoreCase("y"));
		System.out.printf("The total charges was $%.2f", totalCharges);
		
	}
	
	private static double calculateCharges(double hours) {
		
		double charge;
		if (hours <= 3)
			charge = 2.00;
		
		else {
			charge = 2.00 + Math.ceil(hours - 3) * 0.50; //Math.ceil any number up to the next int (3.1 => 4 and 3.9 =>4	
		}
		
		if (charge > 10.00)
			charge = 10.00;
		
		
		return charge;	
	}
	
    
}
