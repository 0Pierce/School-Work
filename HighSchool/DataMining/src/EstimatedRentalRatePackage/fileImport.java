package EstimatedRentalRatePackage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



public class fileImport {
	//fields
	private static percentStorage year1991[] = new percentStorage[58];
	private static percentStorage year1996[] = new percentStorage[58];
	private static percentStorage year2001[] = new percentStorage[58];
	private static percentStorage year2006[] = new percentStorage[58];
	private static percentStorage year2011[] = new percentStorage[58];
	private static percentStorage year2016[] = new percentStorage[58];
	private static percentStorage year1991TO2016[] = new percentStorage[58];
	private static int counter= 0;
	private static String name;
	private static int percent;
	private static int money;
	
	private static moneyStorage moneyYear1991[] = new moneyStorage[58];
	private static moneyStorage moneyYear1996[] = new moneyStorage[58];
	private static moneyStorage moneyYear2001[] = new moneyStorage[58];
	private static moneyStorage moneyYear2006[] = new moneyStorage[58];
	private static moneyStorage moneyYear2011[] = new moneyStorage[58];
	private static moneyStorage moneyYear2016[] = new moneyStorage[58];
	private static moneyStorage moneyYear1991TO2016[] = new moneyStorage[58];


	public static percentStorage [] importPercentYear1991() {
		//reset counter so it does not get affected by other methods
		counter = 0;

		try {
			//scan and input data into object
			Scanner input = new Scanner(new File("File/year1Percent.csv"));
			input.useDelimiter(",|\r\n"); 
			
			while(input.hasNext()) { 
				name = input.next();
				percent = input.nextInt();
				year1991 [counter] = new percentStorage (percent,name);
				counter++;
				
			}
			
			
			input.close();

		} catch (FileNotFoundException error) {
			System.out.println("error");

		}
		return year1991;

	}
	public static percentStorage [] importPercentYear1996() {
		counter = 0;

		try {
			Scanner input = new Scanner(new File("File/year2Percent.csv"));
			input.useDelimiter(",|\r\n"); 
			while(input.hasNext()) { 
				name = input.next();
				percent = input.nextInt();
				year1996 [counter] = new percentStorage (percent,name);
				counter++;
				
			}
			
			
			input.close();

		} catch (FileNotFoundException error) {
			System.out.println("error");

		}
		return year1996;

	}
	public static percentStorage [] importPercentYear2001() {
		counter = 0;

		try {
			Scanner input = new Scanner(new File("File/year3Percent.csv"));
			input.useDelimiter(",|\r\n"); 
			while(input.hasNext()) { 
				name = input.next();
				percent = input.nextInt();
				year2001 [counter] = new percentStorage (percent,name);
				counter++;
				
			}
			
			
			input.close();

		} catch (FileNotFoundException error) {
			System.out.println("error");

		}
		return year2001;

	}
	public static percentStorage [] importPercentYear2006() {
		counter =0;


		try {
			Scanner input = new Scanner(new File("File/year4Percent.csv"));
			input.useDelimiter(",|\r\n"); 
			while(input.hasNext()) { 
				name = input.next();
				percent = input.nextInt();
				year2006 [counter] = new percentStorage (percent,name);
				counter++;
				
			}
			
			
			input.close();

		} catch (FileNotFoundException error) {
			System.out.println("error");

		}
		return year2006;

	}
	public static percentStorage [] importPercentYear2011() {
		counter =0;


		try {
			Scanner input = new Scanner(new File("File/year5Percent.csv"));
			input.useDelimiter(",|\r\n"); 
			while(input.hasNext()) { 
				name = input.next();
				percent = input.nextInt();
				year2011 [counter] = new percentStorage (percent,name);
				counter++;
				
			}
			
			
			input.close();

		} catch (FileNotFoundException error) {
			System.out.println("error");

		}
		return year2011;

	}
	public static percentStorage [] importPercentYear2016() {
		counter =0;


		try {
			Scanner input = new Scanner(new File("File/year6Percent.csv"));
			input.useDelimiter(",|\r\n"); 
			while(input.hasNext()) { 
				name = input.next();
				percent = input.nextInt();
				year2016 [counter] = new percentStorage (percent,name);
				counter++;
				
			}
			
			
			input.close();

		} catch (FileNotFoundException error) {
			System.out.println("error");

		}
		return year2016;

	}
	public static percentStorage [] importPercentYear1991TO2016() {
		counter =0;

		try {
			Scanner input = new Scanner(new File("File/year7Percent.csv"));
			input.useDelimiter(",|\r\n"); 
			while(input.hasNext()) { 
				name = input.next();
				percent = input.nextInt();
				year1991TO2016 [counter] = new percentStorage (percent,name);
				counter++;
				
			}
			
			
			input.close();

		} catch (FileNotFoundException error) {
			System.out.println("error");

		}
		return year1991TO2016;

	}
	public static moneyStorage [] importMoneyYear1991() {
		counter = 0;

		try {
			Scanner input = new Scanner(new File("File/moneyYear1991.csv"));
			input.useDelimiter(",|\r\n"); 
			
			while(input.hasNext()) { 
				name = input.next();
				money = input.nextInt();
				moneyYear1991 [counter] = new moneyStorage (money,name);
				counter++;
				
			}
			
			
			input.close();

		} catch (FileNotFoundException error) {
			System.out.println("error");

		}
		return moneyYear1991;

	}
	public static moneyStorage [] importMoneyYear1996() {
		counter = 0;

		try {
			Scanner input = new Scanner(new File("File/moneyYear1996.csv"));
			input.useDelimiter(",|\r\n"); 
			
			while(input.hasNext()) { 
				name = input.next();
				money = input.nextInt();
				moneyYear1996 [counter] = new moneyStorage (money,name);
				counter++;
				
			}
			
			
			input.close();

		} catch (FileNotFoundException error) {
			System.out.println("error");

		}
		return moneyYear1996;

	}
	public static moneyStorage [] importMoneyYear2001() {
		counter = 0;

		try {
			Scanner input = new Scanner(new File("File/moneyYear2001.csv"));
			input.useDelimiter(",|\r\n"); 
			
			while(input.hasNext()) { 
				name = input.next();
				money = input.nextInt();
				moneyYear2001 [counter] = new moneyStorage (money,name);
				counter++;
				
			}
			
			
			input.close();

		} catch (FileNotFoundException error) {
			System.out.println("error");

		}
		return moneyYear2001;

	}
	public static moneyStorage [] importMoneyYear2006() {
		counter = 0;

		try {
			Scanner input = new Scanner(new File("File/moneyYear2006.csv"));
			input.useDelimiter(",|\r\n"); 
			
			while(input.hasNext()) { 
				name = input.next();
				money = input.nextInt();
				moneyYear2006 [counter] = new moneyStorage (money,name);
				counter++;
				
			}
			
			
			input.close();

		} catch (FileNotFoundException error) {
			System.out.println("error");

		}
		return moneyYear2006;

	}
	public static moneyStorage [] importMoneyYear2011() {
		counter = 0;

		try {
			Scanner input = new Scanner(new File("File/moneyYear2011.csv"));
			input.useDelimiter(",|\r\n"); 
			
			while(input.hasNext()) { 
				name = input.next();
				money = input.nextInt();
				moneyYear2011 [counter] = new moneyStorage (money,name);
				counter++;
				
			}
			
			
			input.close();

		} catch (FileNotFoundException error) {
			System.out.println("error");

		}
		return moneyYear2011;

	}
	public static moneyStorage [] importMoneyYear2016() {
		counter = 0;

		try {
			Scanner input = new Scanner(new File("File/moneyYear2016.csv"));
			input.useDelimiter(",|\r\n"); 
			
			while(input.hasNext()) { 
				name = input.next();
				money = input.nextInt();
				moneyYear2016 [counter] = new moneyStorage (money,name);
				counter++;
				
			}
			
			
			input.close();

		} catch (FileNotFoundException error) {
			System.out.println("error");

		}
		return moneyYear2016;

	}
	

}