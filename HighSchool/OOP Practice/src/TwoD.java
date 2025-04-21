
public class TwoD extends Shape {
	
	public double height;

	public TwoD(double base, String name, double height) {
		super(base, name);
		setHeight(height);
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		if(height > 0) {
			this.height = height;
		}else
			this.height = 1;
	}
	
	
	
	
	

}
