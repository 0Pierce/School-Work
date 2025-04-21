import java.util.Scanner;

	
	public static void main(String[] args) {
	
		int yes;
		do{
			
			Scanner gay = new Scanner(System.in);
			
			double Oprice,SPrice,sale,profit,count,tax;
			
			
			System.out.print("enter original price: ");
			Oprice = gay.nextDouble();
			
			System.out.print("Enter sale Price: ");
			SPrice = gay.nextDouble();
			
			System.out.print("Enter amount: ");
			count = gay.nextDouble();
			
			sale = SPrice * count;
			
		
			profit = sale - (Oprice * count);
			double tax4;
			
			double OSale2;
			double tax3;
			double tax2;
			double overallsale;
			double overallprofit,margin;
			tax2 = sale / 10;
			tax = tax2 / 2;
			tax3 = tax2 + tax;
			tax4 = tax3 * count;
			
			
			
			sale = SPrice * count;
			overallsale = sale - tax3;
			overallprofit = profit - tax3;
			OSale2 = Oprice * count;
			
			//margin = OSale2 / overallprofit * 10;
			
			System.out.printf("Profit = %.1f | total sale = %.1f | You pay = %.1f | ", overallprofit, overallsale,OSale2);
			
			//System.out.printf("Tax4 = %.1f ", tax4);
			//System.out.printf("Tax3 = %.1f ", tax3);
			//System.out.printf("Tax2 = %.1f ", tax2);
			//System.out.printf("Tax = %.1f ", tax);
			//System.out.printf("NoTaxSale = %.1f ", sale);
			//System.out.printf("NoTaxProfit = %.1f ", profit);
			System.out.println(" Wanna go again? (Enter 0 if no)");
			yes = gay.nextInt();
			
		}while(yes > 1);
	
	
	


	
	
		
		
		
		
		
		
		
		
		
		
	}
}

