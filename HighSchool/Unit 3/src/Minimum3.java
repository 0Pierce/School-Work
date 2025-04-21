
public class Minimum3 {
	public static void main (String[] args) {
		
		System.out.println(minimum3(3.7 , 1.2 , 0.6));
		
	}

	private static double minimum3(double num1, double num2, double num3) {
		
		return Math.min(Math.min(num1,num2),num3);
	}

}
