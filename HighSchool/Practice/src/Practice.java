import java.util.Arrays;
import java.util.Scanner;

public class Practice {
	
	public static void main(String[] args) {
		
		
		//Array the size of 10
		int[] num = new int[5];
		
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter numbers");
		
		//For loop to get the 10 answers
		for(int i = 0; i < 5; i++) {
			
			//Answers go straight into array 
			
			
			
			//i is the position variable
			//If i = 0 array position is 0
			num[i] = scan.nextInt();
			
		}
		
		//Prints ALL contents of array
		System.out.println(Arrays.toString(num));
		
		
	}

}
