import java.util.Scanner;

public class SalesTable {

	static double[][] salesTotalMatrix = new double[5][6];

	public static void main(String[] args) {

		getsales();
		Calculate();
		display();

	}

	private static void getsales() {

		Scanner input = new Scanner(System.in);

		System.out.println("Enter the salesperson # (1-4): ");
		int Sperson = input.nextInt();

		System.out.println("Enter the product # (1-5): ");
		int Pnum = input.nextInt();

		System.out.printf("Enter the total dollar value of product %d sold by the salesperson %d today: ", Pnum,
				Sperson);
		salesTotalMatrix[Sperson - 1][Pnum - 1] = input.nextDouble();

	}

	private static void Calculate() {
		
		for (int row = 0; row<4; row++) {
			
			for (int column = 0; column <5; column++) {
				
				salesTotalMatrix[row][5] += salesTotalMatrix[row][column];
			}
		}
		
		for (int column = 0;column <5;column++) {
			
			for(int row=0;row<4;row++) {
				
				salesTotalMatrix[4][column] += salesTotalMatrix[row][column];
			}
		}

	}

	private static void display() {
		
		System.out.printf("\t\t\t\t\tTable of sales \n\t\t");
		
		for(int number = 0; number < salesTotalMatrix[0].length-1;number++)
			System.out.printf("Product %d/t",number+1);
		
		System.out.println("Total");
		
		for(int row=0;row<salesTotalMatrix.length;row++) {
			
			if (row < salesTotalMatrix.length -1)
				System.out.printf("Sales person %d\t", row+1);
			else
				System.out.printf("Total\t\t");
			
			for(int column = 0; column < salesTotalMatrix[row].length;column++)
				System.out.printf("%.2f\t\t", salesTotalMatrix[row][column]);
			
			System.out.println();
				
		}

	}

}
