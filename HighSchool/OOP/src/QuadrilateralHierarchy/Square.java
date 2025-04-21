package QuadrilateralHierarchy;

import java.awt.Point;

public class Square extends Quadrilateral {
	
	//Since its a square no need for 4 points
	public Square(Point p1, Point p2) {
		super(p1, p2, p2, p2);
		

	}
	
	
	
	
	public double getArea() {
		
		return Math.pow(super.getPointArray()[1].getDistance(super.getPointArray()[2]), 2);
		
	}
	

}
