package EstimatedRentalRatePackage;
import java.util.Arrays;

public class percentStorage {
	private int percentChange;
	private String area;
	public percentStorage(int percentChange, String area) {
		super();
		this.percentChange = percentChange;
		this.area = area;
	}
	public int getPercentChange() {
		return percentChange;
	}
	public void setPercentChange(int percentChange) {
		this.percentChange = percentChange;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	@Override
	public String toString() {
		return "percentStorage [percentChange=" + percentChange + ", area=" + area + "]";
	}
	
	
	

}
