import java.util.Arrays;

public class Laptop {

	// non ratings data
	private String brand;
	private String model;
	private String type;
	private double price;
	private String CPU;
	private String CPUType;
	private int RAM;
	private String RAMType;
	private int drive;
	private int SSD;
	private String graphicsBrand;
	private String graphicsType;
	private String IO;
	private int battery;
	private String software;
	private double display;
	private int resolutionW;
	private int resolutionH;
	private boolean touch;
	private double depth;
	private double width;
	private double height;
	private double weight;
	private String warranty;

	// link
	private String hyperLink;
	private String imageFile;

	private int[] ratings = new int[8];
	private int overallScore;

	// getters and setters
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCPU() {
		return CPU;
	}

	public void setCPU(String cPU) {
		CPU = cPU;
	}

	public String getCPUType() {
		return CPUType;
	}

	public void setCPUType(String cPUType) {
		CPUType = cPUType;
	}

	public int getRAM() {
		return RAM;
	}

	public void setRAM(int rAM) {
		RAM = rAM;
	}

	public String getRAMType() {
		return RAMType;
	}

	public void setRAMType(String rAMType) {
		RAMType = rAMType;
	}

	public int getDrive() {
		return drive;
	}

	public void setDrive(int drive) {
		this.drive = drive;
	}

	public int getSSD() {
		return SSD;
	}

	public void setSSD(int sSD) {
		SSD = sSD;
	}

	public String getGraphicsBrand() {
		return graphicsBrand;
	}

	public void setGraphicsBrand(String graphicsBrand) {
		this.graphicsBrand = graphicsBrand;
	}

	public String getGraphicsType() {
		return graphicsType;
	}

	public void setGraphicsType(String graphicsType) {
		this.graphicsType = graphicsType;
	}

	public String getIO() {
		return IO;
	}

	public void setIO(String iO) {
		IO = iO;
	}

	public int getBattery() {
		return battery;
	}

	public void setBattery(int battery) {
		this.battery = battery;
	}

	public String getSoftware() {
		return software;
	}

	public void setSoftware(String software) {
		this.software = software;
	}

	public double getDisplay() {
		return display;
	}

	public void setDisplay(double display) {
		this.display = display;
	}

	public int getResolutionW() {
		return resolutionW;
	}

	public void setResolutionW(int resolutionW) {
		this.resolutionW = resolutionW;
	}

	public int getResolutionH() {
		return resolutionH;
	}

	public void setResolutionH(int resolutionH) {
		this.resolutionH = resolutionH;
	}

	public boolean isTouch() {
		return touch;
	}

	public void setTouch(boolean touch) {
		this.touch = touch;
	}

	public double getDepth() {
		return depth;
	}

	public void setDepth(double depth) {
		this.depth = depth;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getWarranty() {
		return warranty;
	}

	public void setWarranty(String warranty) {
		this.warranty = warranty;
	}

	public String getHyperLink() {
		return hyperLink;
	}

	public void setHyperLink(String hyperLink) {
		this.hyperLink = hyperLink;
	}

	public String getImageFile() {
		return imageFile;
	}

	public void setImageFile(String imageFile) {
		this.imageFile = imageFile;
	}

	public int[] getRatings() {
		return ratings;
	}

	public void setRatings(int[] ratings) {
		this.ratings = ratings;
	}

	public int getOverallScore() {
		return overallScore;
	}

	public void setOverallScore(int overallScore) {
		this.overallScore = overallScore;
	}

	// toString
	@Override
	public String toString() {
		return "LaptopBrand=" + brand + "\n model=" + model + "\n type=" + type + "\n price=" + price + "\n CPU=" + CPU
				+ "\n CPUType=" + CPUType + "\n RAM=" + RAM + "\n RAMType=" + RAMType + "\n drive=" + drive + "\n SSD="
				+ SSD + "\n graphicsBrand=" + graphicsBrand + "\n graphicsType=" + graphicsType + "\n IO=" + IO
				+ "\n battery=" + battery + "\n software=" + software + "\n display=" + display + "\n resolutionW="
				+ resolutionW + "\n resolution" + resolutionH + "\n touch=" + touch + "\n depth=" + depth + "\n width="
				+ width + "\n height=" + height + "\n weight=" + weight + "\n warranty=" + warranty +"\n imageFile="
				+ imageFile + "\n ratings=" + Arrays.toString(ratings) + "\n overallScore=" + overallScore + "]";
	}

}
