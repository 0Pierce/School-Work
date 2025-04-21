package ShapeHierarchy;

public abstract class ThreeDShape extends shape {

	// Fields
	// 3D has a property that 2d doesnt so we make a field

	private double volume;

	public ThreeDShape(String name) {

		super(name);

	}

	// Getters and setters
	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {

		this.volume = volume;
	}
	
	
	public abstract double calcVolume();

}
