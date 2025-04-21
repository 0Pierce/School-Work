import java.util.Scanner;
public class RightTriangle {
	public static void main(String[] args) {
		
		Scanner input = new Scanner (System.in);
		
		double side1, side2;
		
		String responce;
		
		do {
			System.out.println("Enter side 1: ");
			side1 = input.nextDouble();
			
			System.out.println("Enter side 2: ");
			side2 = input.nextDouble();
			
			System.out.printf("The hypoteneus is %.2f \n ", hypotenuse(side1,side2));
			
			System.out.println("Do you want to go again? (Y/N)?");
			responce = input.next();
			
		}while(responce.equalsIgnoreCase("Y"));
		
	}

	private static double hypotenuse(double side1, double side2) {
		
		return Math.sqrt(Math.pow(side1,2) + Math.pow(side2,2));
	}

}
