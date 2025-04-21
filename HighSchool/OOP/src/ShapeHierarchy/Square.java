package ShapeHierarchy;

public class Square extends TwoDShape {

	private double side;

	public Square(double s) {
		super("Square");
		this.side = s;

	}

	public double getSide() {
		return side;
	}

	public void setSide(double s) {

		if (side > 0) {
			this.side = s;
		} else
			this.side = 1.0;

	}
	
	@Override
	public String toString() {
		return "Square [side=" + side + "]";
	}

	@Override
	public double calcArea() {

		
		return Math.pow(side, 2);
	}

	
	
	
	

}
