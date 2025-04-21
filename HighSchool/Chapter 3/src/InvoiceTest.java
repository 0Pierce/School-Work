
public class InvoiceTest {

	public static void main(String[] args) {
		
		
		InvoiceClass invoice1 = new Invoice("12345","nail", 300, 0.15);
		
		System.out.println(invoice1);
		
		
		System.out.printf("$%.2f", invoice1.getInvoiceAmount());
		

	}

}
