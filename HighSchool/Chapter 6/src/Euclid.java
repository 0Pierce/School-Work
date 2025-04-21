import java.util.Scanner;
public class Euclid {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner (System.in);
		
		int num1,num2;
		
		System.out.println("Enter the two numbers");
		num1 = input.nextInt();
		num2 = input.nextInt();
		
		System.out.printf("The GCD of %d and %d is %d",  num1 , num2, gcs(num1,num2));
	}

	private static int gcs(int num1, int num2) {
		
		while(num1 != num2) {
			
			if (num1 > num2)
				num1 = num1 - num2;
			else 
				num2 = num2 - num1;
					
		}
		
		
		
		return num1;
	}

}
