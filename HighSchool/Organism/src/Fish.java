
public class Fish extends Animal {
	
	public String group;

	
	

	/*
	 * Constructor
	 * -------------------------------------------------------------------
	 */
	
	public Fish(String name, String foodType, String group) {
		super(name, foodType);
		this.group = group;
	}
	

	/*
	 * Getters and Setters
	 * -------------------------------------------------------------------
	 */

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}


	
	public String toString() {
		return "[Fish] Name: "+ name + ", Food Type: " + foodType + ", Group: " + group;
	}
	
	
	
	

}
