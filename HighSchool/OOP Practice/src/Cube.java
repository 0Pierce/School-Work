
public class Cube extends ThreeD {

	public Cube(double base, String name, double depth) {
		super(base, name, depth);
		
	}

	
	
	
	public double getArea() {
		
		return Math.pow(6 * base, 2);
		
		
	}
	
	public double getVolume() {
		
		return Math.pow(base, 3);
	}
	
	
	
}
