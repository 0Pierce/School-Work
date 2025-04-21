import java.util.Scanner;

public class SalaryTable {

	static int[] salesArray = new int[11]; // 9 categories, but the first will be in index 2 (200-299)
											// we will not use index

	public static void main(String[] args) {

		

		setSalaryrange();

		displaySalaryTable();

	}

	private static void setSalaryrange() {
		
		Scanner input = new Scanner(System.in);
		String answer;
		double sales;
		
		do {
			
			System.out.println("How much was sold?");
			sales = input.nextDouble();
			
			int salary = (int)(200 +0.09*sales);
			
			//if the salary is $1000+ - They all go to index 10
			
			if (salary >= 1000)
				salesArray[10]++;
			else
				salesArray[salary/100]++;
			
			System.out.println("Are there more sales people?");
			answer = input.next();
			
		}while(answer.equals("y"));
		

	}

	private static void displaySalaryTable() {
		
		//Display the headings
		System.out.printf("Salary Range/t/tCount/n");
		
		//Display the data
		for(int index = 2; index <= 10; index++) {
			System.out.printf("$d00-%d99/t/t%d/n", index,index, salesArray[index]);
		}
		
		System.out.printf("$1000 and over/t/t%d/n", salesArray[10]);
		

	}

}
