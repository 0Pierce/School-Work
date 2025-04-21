

public class MinimumValueArray {
	
	public static void main(String[] args) {
		
		int[] array = new int[] {55,3,5,79};
		
		int index = 0;
		int temp = 10000;
		
		recMin(array,index,temp);
		
	}
	
	public static void recMin(int [] array, int index, int temp) {
	
		//System.out.println(index);
		
		
		
		//System.out.println("good");
		
		
		
		if(array[index] < temp ) {
			
			temp = array[index];
			
			
			//System.out.println("If");
			//System.out.println(index + " index");
			//System.out.println(temp + " temp");
			index++;
			recMin(array,index,temp);
		}else {
			System.out.println(temp + " Is the smallest number");
			
		}
		
		
			
			
		
		
			
		
		
		
		
		
		
		
	}

}
