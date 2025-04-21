
//Direct subclass of the CommissioEmployee
//Indirect subclass of the employee
public class BasePlusCommissionEmployee extends CommissionEmployee {
	
	//Fields
	private double salary;

	//Once the superclass CommissionEmployee sees other parameters it will automatically pass them along to ITS own Superclass
	

	public double getSalary() {
		return salary;
	}

	public BasePlusCommissionEmployee(String firstName, String lastName, String socialSecurityNumber, Date date,
			double grossSales,double rate, double salary) {
		super(firstName, lastName, socialSecurityNumber, date, grossSales, rate);
		setSalary(salary);
	}

	public void setSalary(double salary) {
		if(salary > 0)
			this.salary = salary;
		else
			this.salary = 0;
	}

	@Override
	public String toString() {
		return "BasePlusCommissionEmployee [salary=" + salary + "]";
	}
	
	public double earnings() {
		return salary + super.earnings();
	}

}
