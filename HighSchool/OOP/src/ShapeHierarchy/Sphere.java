package ShapeHierarchy;

public class Sphere extends ThreeDShape {
	
	private double radius;

	//Constructor
	public Sphere(double radius) {
		super("Sphere");
		setRadius(radius);
	}

	
	//Getters and setters
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		
		if(radius > 0.0)
			this.radius = radius;
		else
			this.radius = 1.0;
		
		
	}

	@Override
	public String toString() {
		return "Sphere [radius=" + radius + "]";
	}
	
	//Helper methods to do the calculations
	@Override
	public double calcArea() {
		return 4 * Math.PI * Math.pow(radius, 2);
		
	}
	
	
	@Override
	public double calcVolume() {
		return (double) 4/3 * Math.PI * Math.pow(radius, 3);
	}
	
	

}
