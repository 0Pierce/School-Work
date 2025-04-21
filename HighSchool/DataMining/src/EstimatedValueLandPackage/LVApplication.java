package EstimatedValueLandPackage;
import java.awt.GraphicsEnvironment;

import java.util.ArrayList;

/**
 * This class starts up the application displaying the data of average farm land value in across all regions of Ontario
 * 
 * @author Daphne Ho
 *
 */
public class LVApplication {

	// FIELDS
	// regions and divisions
	public static Land [] regionList = new Land [6];
	public static ArrayList<Land> easternRegionList = new ArrayList<Land>();
	public static ArrayList<Land> centralRegionList = new ArrayList<Land>();
	public static ArrayList<Land> southernRegionList = new ArrayList<Land>();
	public static ArrayList<Land> northernRegionList = new ArrayList<Land>();
	public static ArrayList<Land> westernRegionList = new ArrayList<Land>();
	
	// importer
	private static LVImportController importer = new LVImportController();
	
	// frame
	public static LVFrame LVFrame;
	
	// Main method
	public LVApplication() {
		
		// import data
		importer.importRegions();
		importer.importDivisons();
		
		// create frame
		LVFrame = new LVFrame();
		
	}
		 
}
