package QuadrilateralHierarchy;



public class Point {
	
	private double x;
	private double y;
	
	public Point(double x, double y) {
		super();
		
		this.x = x;
		this.y = y;
	}



	//Getters and setters
	public double getX() {
		return x;
	}



	public void setX(double x) {
		this.x = x;
	}



	public double getY() {
		return y;
	}



	public void setY(double y) {
		this.y = y;
	}

	
	
	
	public double getDistance(Point p2) {
		
		return Math.sqrt(Math.pow(this.x - p2.x, 2) + Math.pow(this.y - p2.y, 2));
	}
	


}
