
public class SalariedEmployee extends Employee {

	//Fields
	private double salary;

	//Constructor
	public SalariedEmployee(String firstName, String lastName, String socialSecurityNumber,Date birthDate, double salary) {
		super(firstName, lastName, socialSecurityNumber, birthDate);
		setSalary(salary);
	}

	//Setters and Getters
	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		if(salary > 0) {
			this.salary = salary;
		}else
			this.salary = 0; //default
	}

	
	
	@Override
	public String toString() {
		return "Salaried [salary=" + salary + "]";
	}

	@Override
	public double earnings() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}
