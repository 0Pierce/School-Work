package PartA;

public class Rectangle {

	// Attributes, properties, fields, instance, variables, charactericstics


	private double length;
	private double width;
	
	

	// Constructor method
	public Rectangle(double length, double width) {

		// Associate the fields with the parameter values
		this.length = length;
		this.width = width;

	}

	// Default
	public Rectangle() {

		length = 1;
		width = 1;

	}

	//SET(mutator) and GET(accessor) METHODS
	public void setLength(double length) {
		
		if(length > 0.0 && length < 20.0)
			this.length = length;
		else
			this.length = 1.0;
	}
	
	public double getLength() {
		return length;
	}
	
public void setWidth(double Width) {
		
		if(Width > 0.0 && Width < 20.0)
			this.width = Width;
		else
			this.width = 1.0;
	
	
		this.length = Width;
	}
	
	public double getWidth() {
		return length;
	}
	
	
	// Utility methods (Helper methods)

	public double getPerimeter() {
	
		return 2*(length + width);
		
		
		
	}

	public double getArea() {
	
		return length * width;
		
		
		
	}

	
	
	
	
	
	
}


