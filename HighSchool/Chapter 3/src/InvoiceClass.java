
public class InvoiceClass {
	
	private String partNumber;  //"12345" not 12345(integer)
	private String desc;        //"nail"
	private int quantity;
	private double pricePerItem;
	
	
	//constructor
	public InvoiceClass(String partNumber, String desc, int quantity, double pricePerItem) {
		super();
		this.partNumber = partNumber;
		this.desc = desc;
		this.quantity = quantity;
		this.pricePerItem = pricePerItem;
	}


	public String getPartNumber() {
		return partNumber;
	}


	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}


	public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}


	public int getQuantity() {
		
		return quantity;
	}


	public void setQuantity(int quantity) {
		
		if (quantity < 0)
			this.quantity = 0;
		else
			this.quantity = quantity;
	}


	public double getPricePerItem() {
		return pricePerItem;
	}


	public void setPricePerItem(double pricePerItem) {
		
		if (pricePerItem < 0)
			this.pricePerItem = 0.0;
		else
			this.pricePerItem = pricePerItem;
	}


	@Override
	public String toString() {
		return "InvoiceClass [partNumber=" + partNumber + ", desc=" + desc + ", quantity=" + quantity
				+ ", pricePerItem=" + pricePerItem + "]";
	}
	
	public double getInvoiceAmount() {
		
		return quantity * pricePerItem;
	}
	

}
