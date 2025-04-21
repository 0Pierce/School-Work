package QuadrilateralHierarchy;

import java.awt.Point;

public class Rectangle extends Quadrilateral {

	

	public Rectangle(Point p1, Point p2, Point p3, Point p4) {
		super(p1, p2, p3, p4);
		


	}


	

	public double getWidth() {
		
		
		return super.getPointArray()[0].getDistance(super.getPointArray()[1]);

	}


	public double getHeight() {
		
		return super.getPointArray()[1].getDistance(super.getPointArray()[2]);
	}
	
	public double getArea() {
		
		return getWidth() * getHeight();
		
	}

}
