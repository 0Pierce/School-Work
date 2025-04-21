import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class PTPTest1 {

	// Create the treaty array

	private static PTP1[] treatyArray = new PTP1[8];

	public static void main(String[] args) {

		fillArray();
		displayTitle();
		displayArray();
		getYear();
		displaynumTreatyGroups(getYear());

	}

	private static void fillArray() {
		// TODO Auto-generated method stub

		treatyArray[0] = new PTP1("Douglass Treaties", 14, 1850, 1954);
		treatyArray[1] = new PTP1("Numbered Treaties", 14, 1850, 1954);
		treatyArray[2] = new PTP1("Robinson Treaties", 14, 1850, 1954);
		treatyArray[3] = new PTP1("Robinson Treaties", 14, 1850, 1954);
		treatyArray[4] = new PTP1("Williams Treaties", 14, 1850, 1954);
		treatyArray[5] = new PTP1("Upper Canada land Surrenders", 14, 1850, 1954);
		treatyArray[6] = new PTP1("Peace & Neutrality Treaties", 14, 1850, 1954);
		treatyArray[7] = new PTP1("Douglass Treaties", 14, 1850, 1954);

	}

	private static void displayTitle() {
		// TODO Auto-generated method stub

		System.out.println("Historic treaties in Canada");
		System.out.println("===========================");

	}

	private static void displayArray() {
		// TODO Auto-generated method stub

		Arrays.sort(treatyArray, Comparator.comparing(PTP1::getNumber));

		for (PTP1 treaty : treatyArray)
			System.out.println(treaty);

	}

	private static int getYear() {
		
		Scanner input = new Scanner (System.in);
		int year;
		
		while (true) {
			
			System.out.println("Enter the year you wish to see?");
			year = input.nextInt();
			
			if (year >= 0 && year <= 2020) {
				input.close();
				return year;
			}else
					System.out.println("Invalid year");
			
			
			
			
		}
		
		
		
		
	}

	private static void displaynumTreatyGroups(int year) {
		// TODO Auto-generated method stub
		
		int count = 0;
		
		for (int index = 0; index <treatyArray.length;index++)
				if (year >= treatyArray[index]. getStartYear() && year <= treatyArray[index].getEndYear())count++;
		
		if (count ==0)
			System.out.printf("No treaty groups were signed during %d", year);
		else
			System.out.printf("%d treaty groups were signed during $d", count,year);

	}

}
