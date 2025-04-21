
public class ThreeD extends Shape {
	
	public double depth;

	public ThreeD(double base, String name, double depth) {
		super(base, name);
		this.depth = depth;
	}

	public double getDepth() {
		return depth;
	}

	public void setDepth(double depth) {
		this.depth = depth;
	}
	
	

}
