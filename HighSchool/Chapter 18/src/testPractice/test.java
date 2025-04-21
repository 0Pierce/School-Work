package testPractice;

public class test {

	public static void main(String[] args) {
		
		

	}
	
	
	private static int triangle(int row, int column) {
		
		if(row == 0 || row == column) {
			return 1;
			
		}else {
			return triangle(column--, row--) + triangle(row--, column);
		}
		
		
		
		
		
		
		
		
	}
	

}
