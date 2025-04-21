import java.util.Scanner;
public class AreaCircle {
	
	public static void main (String[] args) {
		
		double radius,area;
		
		radius = getRadius(); // () Means this is a method
		
		area = calculateArea(radius);
		
		showResults(area);
	}
//input
	private static double getRadius() {
		
		Scanner input = new Scanner(System.in);
		
		double radius;
		
		System.out.print("Enter the radius: ");
		radius = input.nextInt();
		
		
		return radius;
	}
//processing
	private static double calculateArea(double radius) { // Radius is a parameter here
		
		double area;
		
		area = Math.PI * Math.pow(radius,2);
		
		return area;
		
	}
//output
	private static void showResults(double area) {
		System.out.printf("The area is %.2f units squared", area);
		
		
	}

}
