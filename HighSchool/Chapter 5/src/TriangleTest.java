
public class TriangleTest {
	
	public static void main (String[] args) {
		
		
		for (int row = 0; row <= 10; row++) {
			for (int space = 10; space > row; space--) {
				System.out.print(" ");
			}
			for(int star =1; star <(row*2); star++) {
				System.out.print("*");
				
			}
			System.out.println();	
			
			
		}
		

		
	}

}
