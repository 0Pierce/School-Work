
public class Rectangle extends TwoD {

	public Rectangle(double base, String name, double height) {
		super(base, name, height);
		
	}
	
	
	
	
	public double getArea() {
		return base * height;
		
	}
	
	public double getPerimeter() {
		return 2*(base * height);
		
	}




	@Override
	public String toString() {
		return "Rectangle Area is: " + getArea() + "Perimeter is: " + getPerimeter();
	}
	
	
	
	

}
