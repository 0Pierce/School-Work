
//Concrete class does not have abstract in it to allow people to be hired as Employees without determining their pay
//Super class
public abstract class Employee implements Payable {
	
	//fields
	private String firstName;
	private String lastName;
	private String socialSecurityNumber;
	private Date birthDate;
	
	//Constructor
	public Employee(String firstName, String lastName, String socialSecurityNumber, Date birthDate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.socialSecurityNumber = socialSecurityNumber;
		this.birthDate = birthDate;
	
		
	}

	

	//Setters and Getters
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

	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	public void setSocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}

	
	
	
	

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	
	
	


	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", socialSecurityNumber="
				+ socialSecurityNumber + ", birthDate=" + birthDate + "]";
	}


	public abstract double earnings();
	
	public double getPaymentAmount() {
		
		return earnings();
	}
	
	

}
