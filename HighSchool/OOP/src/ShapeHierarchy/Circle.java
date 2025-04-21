package ShapeHierarchy;

public class Circle extends TwoDShape {
	
	private double radius;
	
	
	public Circle(double radius) {
		super("Circle");
		
		
		setRadius(radius);
		
	}
	
	
	public double getRadius() {
		return radius;
	}
	
	public void setRadius(double radius) {
		
		if(radius > 0.0)
			this.radius = radius;
		else
			this.radius = 1.0; //If its not bigger then 0 defaults to 0
		
	}
	

	@Override
	
	public String toString() {
		return "Circle [Radius =" + radius +"]";
		
		
	}
	
	//Util methods
	
	@Override
	public double calcArea() {
		return Math.PI * Math.pow(radius, 2);
	}
	
	
	
}
