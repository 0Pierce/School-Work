
public class PythogoreanTriples {
	
	public static void main (String[] args) {
		
		int count = 0;
		
		for (int side1 = 1; side1 <= 500; side1++) {
			
			for (int side2 = side1 + 1; side2 <= 500; side2++) {
				
				for (int side3 = side2 + 1; side3 <= 500; side3++) {
					
					if ((Math.pow(side1, 2) + Math.pow(side2, 2)) == Math.pow(side3, 2)) {
						
						System.out.printf("The tripes are: %d %d %d", side1, side2, side3);
						count++;
					}
				}
			}
		}
		
		System.out.printf(" The number of tripes is %d", count);
	}

}
