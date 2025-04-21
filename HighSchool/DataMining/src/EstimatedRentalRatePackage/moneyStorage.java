package EstimatedRentalRatePackage;

public class moneyStorage {
	private int rentRate;
	private String area;
	public moneyStorage(int rentRate, String area) {
		super();
		this.rentRate = rentRate;
		this.area = area;
	}
	public int getRentRate() {
		return rentRate;
	}
	public void setRentRate(int rentRate) {
		this.rentRate = rentRate;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	@Override
	public String toString() {
		return "moneyStorage [rentRate=" + rentRate + ", area=" + area + "]";
	}
	
	

}
