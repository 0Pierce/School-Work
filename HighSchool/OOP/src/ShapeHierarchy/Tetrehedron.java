package ShapeHierarchy;

public class Tetrehedron extends ThreeDShape {

	private double side1, side2,side3, height;
	
	public Tetrehedron(double s1, double s2, double s3, double h) {
		super("Tetrahedron");
		this.side1 = s1;
		this.side2 = s2;
		this.side3 = s3;
		this.height = h;
		
		
	}
	
	
	
	
	
	
	

	public double getSide1() {
		return side1;
	}








	public void setSide1(double s1) {
		
		
		if(side1 > 0.0) {
			this.side1 = s1;
		}
		else
			this.side1 = 1.0;
	}








	public double getSide2() {
		return side2;
	}








	public void setSide2(double s2) {
		if(side2 > 0.0) {
			this.side1 = s2;
		}
		else
			this.side2 = 1.0;
	}








	public double getSide3() {
		return side3;
	}








	public void setSide3(double s3) {
		if(side3 > 0.0) {
			this.side3 = s3;
		}
		else
			this.side3 = 1.0;
	}








	public double getHeight() {
		return height;
	}








	public void setHeight(double h) {
		if(side1 > 0.0) {
			this.height = h;
		}
		else
			this.height = 1.0;
	}




	public double calcSideArea() {
		double s = (side1 + side2 + side3) / 2;
		return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
		
		
	}



	@Override
	public double calcVolume() {
		return calcSideArea() * height / 3;
		
	}

	@Override
	public double calcArea() {
		return 4 * calcSideArea();
	}
	
	
	
	

}
