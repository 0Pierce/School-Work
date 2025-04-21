
public class PrintArray {
	
	
	
	public static void main(String[] args) {
		int[] array = new int[] {6,7,8,4,10};
		
		int num = 0;
		
		printArray(array,num);
		
		
	}
	
	public static int printArray(int[] array, int num) {
		
		if(array.length != num) {
			System.out.print(array[0] + num + "     ");
			num++;
			printArray(array, num);
		
		}
		
		return 1;
	
	
		
		
		
		
		
		
		


		
		
		
	}

}
