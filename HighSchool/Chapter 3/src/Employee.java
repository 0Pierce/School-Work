
public class Employee {
	
	//fields
	private String firstName;
	private String lastName;
	private double monthlySalary;
	
	//constructor
	public Employee(String firstName, String lastName, double monthlySalary) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		setMonthlySalary(monthlySalary);
	}
//getters and setters
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getMonthlySalary() {
		return monthlySalary;
	}

	public void setMonthlySalary(double monthlySalary) {
		
		//Data validation
		if (monthlySalary < 0)
			this.monthlySalary = 0.0;
		else	
			this.monthlySalary = monthlySalary;
	}
	//toString method
	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", monthlySalary=" + monthlySalary + "]";
	}
	
	
	//utility method
	
	public void raise(double raiseAmount) {
		
		this.monthlySalary+=raiseAmount;
	}

		
	

}
