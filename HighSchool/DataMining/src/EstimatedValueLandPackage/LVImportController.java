package EstimatedValueLandPackage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class imports all the data from the csv files into its desinated arrays
 * 
 * @author Daphne Ho
 *
 */
public class LVImportController {

	/**
	 * This method imports the regions (Southern Ontario, Northern Ontario, etc.), their avg farm land value and percent increase/decrease
	 * throughout the years
	 */
	public void importRegions() {

		try {

			// create scanner to read the region file
			Scanner input = new Scanner(new File("files/LVRegions.csv"));
			input.useDelimiter(",|\r\n"); 	// seperate file by commas and new lines
			
			// used to keep track of the index in the value list
			int listIndex = 0;

			while (input.hasNext()) {

				// create list to hold the values
				int valueList[] = new int[6];
				int percentageList[] = new int[6];

				// variable to hold the region name
				String name = input.next();

				// add data into value list
				for (int index = 0; index < 6; index++)
					valueList[index] = input.nextInt();
				
				// add data into percent list
				for (int index = 0; index < 6; index++)
					percentageList[index] = input.nextInt();

				// import into region list
				LVApplication.regionList[listIndex] = (new Land(name, valueList, percentageList));

				// import to the next list
				listIndex++;

			}

			// close scanner
			input.close();

		} catch (FileNotFoundException error) {

			// if cvs file is not found
			System.out.println("Error importing 'LVRegions.csv'");
		}

	}
	

	/**
	 * This method imports the smaller divisons within the regions and their avg land value
	 * (I didn't end up using this data though)
	 */
	public void importDivisons() {

		try {

			// create scanner to read the divisions files
			Scanner input = new Scanner(new File("files/LVDivision.csv"));
			input.useDelimiter(";|\r\n"); 

			// 0 - southern , 1 - western, 2 - central, 3 - eastern, 4 - nothern
			// used to direct importing to the correct region list
			int region = 0;

			while (input.hasNext()) {

				// used for checking if data should be imported into the next list
				String word = input.next();
				char[] wordChar = word.toCharArray();

				// check if we have entered a new region of importing ("-" in the csv file splits the data into its regions)
				if (wordChar[0] == '-')
					region++;

				// if not, keep importing to the current list
				else {
					
					String name = word;

					int valueList[] = new int[6];
					int percentageList[] = new int[6]; // created percentage list but didn't end up importing the percentage list
													   // only here to construct the object

					for (int index = 0; index < 6; index++)
						valueList[index] = input.nextInt();

					// import the data into the correct list
					if (region == 0)
						LVApplication.southernRegionList.add(new Land(name, valueList, percentageList));

					else if (region == 1)
						LVApplication.westernRegionList.add(new Land(name, valueList, percentageList));

					else if (region == 2)
						LVApplication.centralRegionList.add(new Land(name, valueList, percentageList));

					else if (region == 3)
						LVApplication.easternRegionList.add(new Land(name, valueList, percentageList));

					else if (region == 4)
						LVApplication.northernRegionList.add(new Land(name, valueList, percentageList));

				}

			}

			// close scanner
			input.close();

		} catch (FileNotFoundException error) {

			// if cvs file is not found
			System.out.println("Error importing 'LVDivision.csv'");
		}
	}
}
