//Sub class of Employee Super class
public class HourlyEmployee extends Employee implements Payable {
	
	//Fields
	private double wage;
	private double hours;
	
	//Constructor
	public HourlyEmployee(String firstName, String lastName, String socialSecurityNumber,Date date, double wage, double hours) {
		super(firstName, lastName, socialSecurityNumber, date);
		setWage(wage);
		setHours(hours);
	}
	public double getWage() {
		return wage;
	}
	public void setWage(double wage) {
		
		if(wage > 0) {
			this.wage = wage;
		}else
			this.wage = 0; //default
		
		
		
	}
	public double getHours() {
		return hours;
	}
	public void setHours(double hours) {
		if(hours > 0) {
			this.hours = hours;
		}else
			this.hours = 0; //default
	}
	@Override
	public String toString() {
		return "HourlyEmployee [wage=" + wage + ", hours=" + hours + "]";
	}
	@Override
	public double earnings() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
