
public abstract class Animal extends Organism {
	
	

	public String foodType;

	

	public Animal(String name, String foodType) {
		super(name);
		this.foodType = foodType;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	

	
	
	
	
	
}



