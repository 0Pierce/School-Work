import java.util.Scanner;

public class TreatiesAppPractice {

	public static void main(String[] args) {

		Scanner gay = new Scanner(System.in);
		
		
		
		int i = 0;
		
		
		//Extra function
		do {
			System.out.print("enter number");
			
			
			//Input
			int num5 = gay.nextInt();
			int num3 = gay.nextInt();
			
			
			//Process
			int hot = num5 + num3;
			
			
			//output
			System.out.println(hot);
			
			System.out.print("Do you want to continue, if so enter 5");
			i = gay.nextInt();
			
		}while(i == 5);
		
	
	

	}

}
