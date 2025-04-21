import java.util.Scanner;

import jdk.internal.misc.FileSystemOption;

public class Distance {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		double x1,x2,y1,y2;

		System.out.println("Enter the values of the 2 point (x1,y1) first and second");
		x1 = input.nextDouble();
		y1 = input.nextDouble();
		x2 = input.nextDouble();
		y2 = input.nextDouble();
		
		System.out.printf("The distance between the two points is: %.2f", distance(x1,y1,x2,y2));
		
		
	}
	                 
	private static double distance(double x1, double y1, double x2, double y2) {
		
		return Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1,2));
	}

}
