/*
 * Name(s): Pierce Pokorny, Daniel Ling, Jaffer Razavi
 * Date: January 8, 2021
 * Course code: ICS3U1-56 - Mr.Fernandes
 * Purpose: To create an application that finds a laptop according to the users needs
 * Major skills: File Input, GUIs, Arrays, Weighted Decision Matrix...
 * Extra features: ...
 * Areas of concern: ...
*/

/*
* This class is the application class
*
* author - Jaffer Razavi
*/

public class LaptopAdvisorApplication {

// A list of laptops that is read from an external csv file into a ‘global’ array that is used by the rest 
// of the classes in the program
	public static Laptop[] laptopArray = new Laptop[30];
	
	public static User user = new User();

//used to run the File Input and User Ratings GUI
	public static void main(String[] args) {

		new LaptopAdvisorFileInput();

//run any of the GUIs directly from here using "new [GUIname]
		
		new LaptopAdvisorGUIReport();

	}

}




