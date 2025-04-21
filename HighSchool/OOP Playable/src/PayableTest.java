import java.util.ArrayList;
import java.util.Calendar;

public class PayableTest {

	public static void main(String[] args) {
		
		ArrayList<Payable> payableList = new ArrayList<Payable>();
		
		payableList.add(new SalariedEmployee ("John", "Smith", "111-11-1111", new Date(13,7,1970), 800.00));
		payableList.add(new HourlyEmployee("Karen", "Price", "222-22-2222", new Date(11,2,2001), 16.75, 40));
		payableList.add(new CommissionEmployee ("Sue", "Jones", "333-333333", new Date(2,3, 2010), 10000, 0.06));
		payableList.add(new BasePlusCommissionEmployee ("Bob", "Lewis", "444-44-4444", new Date(1, 10, 2003), 5000, 0.04, 300));
		payableList.add(new PieceWorkerEmployee ("Frank", "Richards", "555-555555", new Date(1, 10,2010), 10.00,25));
		payableList.add(new Invoice ("01234","Seat", 2, 250.00));
		payableList.add(new Invoice ("56789", "Tire", 4, 80.00));
		
		
		
		
		for(Payable currentPayable : payableList) {
			
			System.out.println(currentPayable);
			
			if(currentPayable instanceof Employee) {
				
				//casting down
				Employee employee = (Employee)currentPayable;
				
				System.out.printf("Earbubgs due: $%.2f\n", employee.getPaymentAmount());

				
				//Allows access to the OS calendar
				Calendar calendar = new Calendar.getInstance();

				//Computer systems month is one off so we add a +1 
				if(employee.getBirthDate().getMonth() == calendar.get(Calendar.MONTH) + 1) {
					
					System.out.printf("Happy Birth Month! New earnings will be: $%.2f \n", employee.getPaymentAmount() +100);
					
					
				}
				
			}else {
				System.out.printf("Payment due: $%.2f", currentPayable.getPaymentAmount());
			}
				
			System.out.println();
		}

	}

}
