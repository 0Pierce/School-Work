import java.util.Scanner;

public class GasPractice {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		
		
		int tLiteres = 0, tKil = 0;
		int answer;
		System.out.println("How many tanks? ");
		answer = scan.nextInt();
		
		float TOTALTANK = 0;
		int count = 1;
		int i = 0;
		
		do {
			
			//Count check - for debugging
			//System.out.printf("%d times \n" , count);
			
			float tank;
			
			//Input
			int literes, kil;
			System.out.println("Enter the kilometers driven \n");
			kil = scan.nextInt();
			
			System.out.println("Enter the literes used ");
			literes = scan.nextInt();
			
			
			//Processing
			 //Converts int into float
			tank = (float) kil/ (float) literes;
			
			//Partial Output
			System.out.printf("Your results are %.2f for tank %d ", tank, count);
			
			//Collects the obtained result
			TOTALTANK += tank;
		
			
			count++;
			i++;
			
		}while(answer > i);
		
		
		
		
		System.out.printf(" and the total result are %.2f", TOTALTANK);
		
		
		
		
		
		
	}

}
