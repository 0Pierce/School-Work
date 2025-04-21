
public class Testing2 {
	
	public static void main (String[] args) {
		
		
		int numouterstars =1;
		int numouterspaces =9;
		int nummiddlestars = 10;
		int nummiddlespaces = 0;
		
		for (int row = 1; row <=10; row++) {
			
			for (int star = 1; star <= numouterstars; star++)
				System.out.print("*");
			
			for (int space = 1; space <= numouterspaces; space++)
				System.out.print(" ");
			
			for (int star = 1; star <= nummiddlestars; star++)
				System.out.print("*");
			
			for (int space = 1; space <= nummiddlespaces; space++)
				System.out.print(" ");
			
			for (int star = 1; star <= nummiddlestars; star++)
				System.out.print("*");
			
		
			
			System.out.println();
			
			
			
			
			
			numouterstars++;
			numouterspaces--;
			nummiddlestars--;
			nummiddlespaces +=2;
		
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
		
		
		
		
	}
	
	
		
		

}
