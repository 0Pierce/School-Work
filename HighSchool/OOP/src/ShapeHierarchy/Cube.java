package ShapeHierarchy;

public class Cube extends ThreeDShape {
	
	
	private double edge;
	
	
	
	public Cube(double edge) {
		super("Cube");
		setEdge(edge);
		
		
	}



	public double getEdge() {
		return edge;
	}



	public void setEdge(double edge) {
		
		if(edge > 0.0) {
			this.edge = edge;
		}else
			this.edge = 1.0;
		
	}



	@Override
	public String toString() {
		return "Cube [edge=" + edge + "]";
	}
	
	public double calcArea() {
		return 6 * Math.pow(edge, 2);
		
	}
	
	public double calcVolume() {
		return Math.pow(edge, 3);
		
	}
	
	
	

}
