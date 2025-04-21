
public abstract class Plant extends Organism implements Growable {

	//Fields
	public double height;
	public String type;
	public double growth;

	/*
	 * Constructor
	 * -------------------------------------------------------------------
	 */
	public Plant(String name, double height, String type) {
		super(name);
		this.height = height;
		this.growth = growth;
		setType(type);
	}
	

	/*
	 * Getters and Setters
	 * -------------------------------------------------------------------
	 */

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		if (height > 0) {
			this.height = height;
		} else
			this.height = 1;
	}

	public String isType() {
		return type;
	}

	public void setType(String type) {
		if (type == "flowering") {
			this.type = "yes";
		} else
			this.type = "no";
	}


	/*GrowthRate to determine all the stuffs
	 * -------------------------------------------------------------------
	 */
	
	@Override
	public double growthRate() {
		
		if(this.type == "yes" && this.height < 100 ) {
			return 0.1;
			
		}else if(this.type == "yes" && this.height >= 100) {
			return 0.05;
		}else
			return 0.02;
		
		
	}
	
	public double heightGrowth() {
		
		return growth = height + (height * growthRate());
		
		
		
	}

	/*Output
	 * -------------------------------------------------------------------
	 */

	
	public String toString() {
		return "[Plant] Name: " +name + ", Flowering: " + type + ", Height: " + heightGrowth();
	}

	
	
	
	
}
