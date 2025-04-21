package QuadrilateralHierarchy;

import java.awt.Point;

public class Parallelogram extends Quadrilateral {
	
	public Parallelogram (Point p1, Point p2, Point p3, Point p4) {
		super(p1, p2, p3, p4); 
		
		
		
	}
	
	
	public double getWidth() {
		
		return super.getPointArray()[0].getDistance(super.getPointArray()[1]);
		
		
	}
	
	public double getHeight() {
		Point p = new Point(super.getPointArray()[0].getX(),super.getPointArray()[0].getY() - super.getPointArray()[3].getY());
		return super.getPointArray()[0].getDistance(p);
		
	}
	
	public double getArea() {
		
		return getWidth() * getHeight();
		
		
	}
	

}
