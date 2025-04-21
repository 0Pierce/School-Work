import java.util.Scanner;

public class GCD {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		
		System.out.println("Enter two numbers");
		int x = input.nextInt();
		int y = input.nextInt();
		
		gcd(x,y);
		
		
		int answer = gcd(x,y);
		System.out.println(answer);
	}
	
	public static int gcd(int x, int y) {
		
		if(y == 0) {
			System.out.println("Entered if");
			System.out.printf("x = %d y = %d %n",x, y);
			return x;
			
		}
		else {
			System.out.println("Entered else");
			System.out.printf("x = %d y = %d %n",x, y);
			return gcd(y,x % y);
		}
		
		
		
		
		
		
	}

}
