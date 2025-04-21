
public class EmployeeTest {

	public static void main(String[] args) {
		
		Employee employee1 = new Employee("Fred", "Flinstone", 2000);
		Employee employee2 = new Employee("Jeff", "bob", 1000);
		
		System.out.println("employee1");
		System.out.println("employee2");
		
		employee2.raise(3000);
		System.out.println("employee2");
		

	}

}
