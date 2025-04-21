package ShapeHierarchy;

//Superclass of the Hierarchy 
public abstract class shape {
	
	//fields
	private String name;
	private double area;
	
	
	//Constructor
	
	public shape(String name) {
		super(); //Calls the constructor of the super class(This class) (Runs either way)
		
		this.name = name;
		
		
		
	}

	//Setters and getters
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getArea() {
		return area;
	}


	public void setArea(double area) {
		this.area = area;
	}

	//Output
	@Override
	public String toString() {
		return "shape [name=" + name + ", area=" + area + "]";
	}
	
	
	//Abstract method - Implementation will be down the Hierarchy
	
	public abstract double calcArea();
	
	
	
	
	
	

}
