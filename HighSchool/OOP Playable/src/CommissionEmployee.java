//Another sub class
public class CommissionEmployee extends Employee {
	
	
	private double rate;
	private double grossSales;
	public CommissionEmployee(String firstName, String lastName, String socialSecurityNumber,Date date, double rate, double grossSales) {
		super(firstName, lastName, socialSecurityNumber, date);
		setRate(rate);
		setGrossSales(grossSales);
	}
	
	
	//Getters and Setters
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		if(rate > 0) {
			this.rate = rate;
		}else
			this.rate = 0; //default
	}
	public double getGrossSales() {
		return grossSales;
	}
	public void setGrossSales(double grossSales) {
		if(grossSales > 0) {
			this.grossSales = grossSales;
		}else
			this.grossSales = 0; //default;
	}
	
	//ToString
	@Override
	public String toString() {
		return "Commission [rate=" + rate + ", grossSales=" + grossSales + "]";
	}
	
	
	public double earnings() {
		return grossSales * rate;
	}
	

}
