package QuadrilateralHierarchy;

import java.awt.Point;

public class Trapezoid extends Quadrilateral {
	
	//constructor
	public Trapezoid(Point p1, Point p2, Point p3, Point p4) {
		super(p1, p2, p3, p4); 
		
		
		
	}
	
	
	
	
	public double getBaseandArea() {
		
		double b = super.getPointArray()[2].getDistance(super.getPointArray()[3]);
		
		double a = super.getPointArray()[0].getDistance(super.getPointArray()[1]);
		
		return (a + b) / 2 * getHeight();
		
		
	}
	
	public double getHeight() { 
		
		//Assings p to x then | y - y gets the difference and then calculates the height
		Point p = new Point(super.getPointArray()[0].getX(),super.getPointArray()[0].getY() - super.getPointArray()[3].getY());
		return super.getPointArray()[0].getDistance(p);
	}
	
	
	

}


