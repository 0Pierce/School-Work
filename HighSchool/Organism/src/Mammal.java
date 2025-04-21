
public class Mammal extends Animal {
	
	public int numLegs;


	/*
	 * Constructor
	 * -------------------------------------------------------------------
	 */

	public Mammal(String name, String foodType, int numLegs) {
		super(name, foodType);
		this.numLegs = numLegs;
	}
	

	/*
	 * Setters and Getters
	 * -------------------------------------------------------------------
	 */

	public int getNumLegs() {
		return numLegs;
	}

	public void setNumLegs(int numLegs) {
		if(numLegs > 0) {
			this.numLegs = numLegs;
			
		}else
			this.numLegs = 2;
	}


	
	public String toString() {
		return "[Mammal] Name: "+name + ", Food Type: " + foodType + ", Number of Legs: " + numLegs;
	}


	
	
	
	

}
