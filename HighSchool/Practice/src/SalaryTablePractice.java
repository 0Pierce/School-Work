import java.util.Scanner;

public class SalaryTablePractice {

	public static void main(String[] args) {

		int[] array = new int[] { 86, 79, 58, 56, 79, 92, 62, 90, 74, 71, 65, 66, 46, 48, 50, 67, 90, 87, 72, 68, 59,
				58, 70, 71, 75, 77, 84, 81, 73, 83};
		
		int ten = 50;
		int range = ten -10;
		
		for(int i = 0; i <= array.length -1; i++) {
			System.out.printf("Range %d - %d %n", range, ten);
			
			for(int j =0; j <= array.length -1; j++) {
				
				
				if(array[j] < ten && array[j] > ten -11) {
					
					System.out.println(array[j]);
					
				}
				
				
			}
			
			ten = ten + 10;
			range = ten -10;
			
		}
		
		
		
		

	}

}
