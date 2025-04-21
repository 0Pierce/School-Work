
public class Triangle extends TwoD {

	public Triangle(double base, String name, double height) {
		super(base, name, height);
		
	}
	
	
	public double getArea() {
		
		return (Math.pow(base, height) * base) / 2;
		
	}
	
	
	
	
	
	public String toString() {
		return "Rectangle Area is: " + getArea();
	}
	
	

}
