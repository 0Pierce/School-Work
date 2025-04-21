package ShapeHierarchy;

public class Triangle extends TwoDShape {

	private double side1, side2, side3;

	public Triangle(double s1, double s2, double s3) {
		super("Triangle");
		this.side1 = s1;
		this.side2 = s2;
		this.side3 = s3;

	}

	public double getSide1() {
		return side1;
	}

	public void setSide1(double s1) {
		if (s1 > 0) {
			this.side1 = s1;
		} else
			this.side1 = 1.0;
	}

	public double getSide2() {
		return side2;
	}

	public void setSide2(double s2) {
		if (s2 > 0) {
			this.side2 = s2;
		} else
			this.side2 = 1.0;
	}

	public double getSide3() {
		return side3;
	}

	public void setSide3(double s3) {
		if (s3 > 0) {
			this.side3 = s3;
		} else
			this.side3 = 1.0;
	}
	
	
	

	@Override
	public String toString() {
		return "Triangle [side1=" + side1 + ", side2=" + side2 + ", side3=" + side3 + "]";
	}

	
	@Override
	public double calcArea() {
		
		double side = side1 + side2 + side3 / 2;
		return Math.sqrt(side*(side - side1)*(side - side2)*(side - side3));
		
	}

	
	

}
