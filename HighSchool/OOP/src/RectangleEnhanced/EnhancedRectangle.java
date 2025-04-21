package RectangleEnhanced;

import java.util.Arrays;

public class EnhancedRectangle {

	private Point[] point = new Point[4];

	//Constructor
	public EnhancedRectangle(Point[] point) {
		setPoints(point);
		
		

	}

	public Point[] getPoint() {
		return point;
	}

	//Checks if points are in rage - If not the points are set to 0.0
	public void setPoints(Point[] point) {
		
		//Dont understand what ":" does 
		//- Instead of writting out the different points it just uses the entire Array and gives
		//it the variable p
		for(Point p : point) {
			
			if(p.getX() < 0.0 || p.getX() > 20.0 || p.getY() < 0.0 || p.getY() > 20.0) {
				
				p.setX(0.0);
				p.setY(0.0);
			}else {
				this.point = point;
			}
			
		}
		
		
	}
	
	//ToString method
	
	public String toString() {
		
		return "EnhancedRectangle [point=" + Arrays.toString(point) + "]";
	}
	
	//Utility methods
	
	public boolean isRect() {
		
		//If the diagonals of a parallelogram are congruent, then its a rec
		if(Double.compare(point[0].distanceTo(point[2]), point[1].distanceTo(point[3])) == 0)
			return true;
		else
			return false;
	}
	
	public boolean isSquare() {
		
		if(Double.compare(getLength(), getWidth()) == 0) {
			return true;
		}else {
			return false;
		}
			
	}
	
	public double getLength() {
		
		double side1 = point[0].distanceTo(point[1]);
		double side2 = point[1].distanceTo(point[2]);
		
		if(side1 > side2) {
			return side1;
			
		}else {
			return side2;
		}
		
		
		
	}
	
	
	public double getWidth() {
		
		double side1 = point[0].distanceTo(point[1]);
		double side2 = point[1].distanceTo(point[2]);
		
		if(side1 > side2) {
			return side2;
			
		}else {
			return side1;
		}
	}
	
	public double getPerimeter() {
		
		double side1 = point[0].distanceTo(point[1]);
		double side2 = point[1].distanceTo(point[2]);
		
		return 2 * (side1 + side2);
	}
	
	
	
	public double getArea() {
		
		double side1 = point[0].distanceTo(point[1]);
		double side2 = point[1].distanceTo(point[2]);
		
		return side1 * side2;
	}
	
	
	
	
	
	

}
