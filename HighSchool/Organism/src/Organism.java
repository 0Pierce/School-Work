
public abstract class Organism {
	
	public String name;


	/*
	 * Constructor
	 * -------------------------------------------------------------------
	 */

	public Organism(String name) {
		super();
		this.name = name;
	}


	/*
	 * Setters and Getters
	 * -------------------------------------------------------------------
	 */
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "Organism [name=" + name + "]";
	}

	
	
	
	

}
