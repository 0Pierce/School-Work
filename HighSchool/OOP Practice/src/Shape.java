
public class Shape {
	
	public double base;
	public String name;
	
	
	public Shape(double base, String name) {
		super();
		setBase(base);
		this.name = name;
	}


	public double getBase() {
		return base;
	}


	public void setBase(double base) {
		if(base > 0) {
			this.base = base;
		}else
			this.base = 1;
		
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	

}
