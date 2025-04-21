import java.util.Arrays;

public class User {

	//fields
	private String name;
	private int[] weighting = new int[8];
	
	//getters and setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int[] getWeighting() {
		return weighting;
	}
	public void setWeighting(int[] weighting) {
		this.weighting = weighting;
	}
	
	//toString
	@Override
	public String toString() {
		return "User [name=" + name + ", weighting=" + Arrays.toString(weighting) + "]";
	}


}
