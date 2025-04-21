package QuadrilateralHierarchy;

import java.awt.Point;

public abstract class Quadrilateral {
	
	private Point[] pointArray = new Point[4];
	
	public Quadrilateral(Point p1, Point p2, Point p3, Point p4) {
		super();
		pointArray[0] = p1;
		pointArray[1] = p2;
		pointArray[2] = p3;
		pointArray[3] = p4;
	}

	public Point[] getPointArray() {
		return pointArray;
	}

	public void setPointArray(Point[] pointArray) {
		this.pointArray = pointArray;
	}
			
			
			
			
	

}
