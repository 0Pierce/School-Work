
public class Testing {

	public static void main(String[] args) {

		int numspaces = 1;
		int numstars = 1;
		int row1 = 0;

		
		while (row1 < 7) {
			System.out.print("*");
			row1++;
		}
		System.out.println();
		
		for (int rows = 1; rows <= 9; rows++) {
			for (int space = 0; space <=numspaces; space++ ) {
				System.out.print(" ");
			}
			for (int star = 0; star < 1; star++) {
				System.out.print("*");
			}
			System.out.println();
		}


	}
}
