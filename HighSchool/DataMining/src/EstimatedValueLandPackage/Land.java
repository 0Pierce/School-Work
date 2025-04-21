package EstimatedValueLandPackage;
import java.util.Arrays;

/**
 * This class creates Land objects to store data
 * 
 * @author Daphne Ho
 *
 */
public class Land {

	// FIELDS
	private String name;
	
	/**
	 * Holds the avg value of land of each year based on the index number of the array
	 * 
	 * valueList[0] = 1991 value
	 * valueList[1] = 1996 value
	 * valueList[2] = 2001 value
	 * valueList[3] = 2006 value
	 * valueList[4] = 2011 value
	 * valueList[5] = 2016 value
	 */
	private int [] valueList = new int[6];
	
	/**
	 * Holds the year-over-year change percentage of land of each year based on the index number of the array
	 * 
	 * percentageList[0] = 1991 value
	 * percentageList[1] = 1996 value
	 * percentageList[2] = 2001 value
	 * percentageList[3] = 2006 value
	 * percentageList[4] = 2011 value
	 * percentageList[5] = 2016 value
	 */
	private int [] percentageList = new int[6];
	

	
	// CONSTRUCTOR METHOD
	public Land(String name, int[] valueList, int[] percentageList) {
		super();
		this.name = name;
		this.valueList = valueList;
		this.percentageList = percentageList;
	}
	
	
	// default
	public Land() {
		
	}

	
	// GETTERS AND SETTERS
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int[] getValueList() {
		return valueList;
	}

	public void setValueList(int[] valueList) {
		this.valueList = valueList;
	}

	public int[] getPercentageList() {
		return percentageList;
	}

	public void setPercentageList(int[] percentageList) {
		this.percentageList = percentageList;
	}

	// toString method
	@Override
	public String toString() {
		return "Land [name=" + name + ", valueList=" + Arrays.toString(valueList) + ", percentageList="
				+ Arrays.toString(percentageList) + "]";
	}
		
	
	
}
