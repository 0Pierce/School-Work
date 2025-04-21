import java.util.Scanner;

public class CirclePractice {
	
	public static void main(String [] args) {
		
		int radius = input ();
		double area = processing(radius);
		output(area);

	}
	
	public static int input () {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter the radius");
		int radius = scan.nextInt();
		
		return radius;
		
	}
	
	public static double processing(int radius) {
		
		double area = Math.PI * Math.pow(radius,2);
		
		return area;
		
	}
	
	public static void output(double area) {
		
		double rounded = Math.round(area*100.0)/100.0;
		System.out.printf("Your area is %.2f", rounded);
		
		
	}
	
	
	

}
