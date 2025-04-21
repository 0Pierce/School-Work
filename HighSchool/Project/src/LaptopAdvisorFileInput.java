
/*
 * Name(s): Pierce Pokorny, Daniel Ling, Jaffer Razavi
 * Date: January 18, 2021
 * Course code: ICS3U1-56 - Mr.Fernandes
 * Purpose: Inputs all of the data from the csv file and puts them into an array to be used in the GUIs
 * Major skills: File Input, GUIs, Arrays.
 * Extra features: ...
 * Areas of concern: ...
*/

/*
* This class is the application class
*
* author - Pierce Pokorny
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LaptopAdvisorFileInput {

	public LaptopAdvisorFileInput() {

		try {

			Scanner input = new Scanner(new File("laptop.csv"));
			input.useDelimiter(",");

			input.nextLine();

			int index = 0;

			while (input.hasNextLine()) {

				// Non ratings data

				// laptop
				LaptopAdvisorApplication.laptopArray[index] = new Laptop();

				LaptopAdvisorApplication.laptopArray[index].setBrand(input.next());
				LaptopAdvisorApplication.laptopArray[index].getRatings()[0] = input.nextInt();
				LaptopAdvisorApplication.laptopArray[index].setModel(input.next());
				// Type & Price
				LaptopAdvisorApplication.laptopArray[index].setType(input.next());
				LaptopAdvisorApplication.laptopArray[index].setPrice(input.nextDouble());

				// CPU
				LaptopAdvisorApplication.laptopArray[index].setCPU(input.next());
				LaptopAdvisorApplication.laptopArray[index].setCPUType(input.next());
				LaptopAdvisorApplication.laptopArray[index].getRatings()[1] = input.nextInt();

				// RAM/Storage
				LaptopAdvisorApplication.laptopArray[index].setRAM(input.nextInt());
				LaptopAdvisorApplication.laptopArray[index].setRAMType(input.next());
				LaptopAdvisorApplication.laptopArray[index].setDrive(input.nextInt());
				LaptopAdvisorApplication.laptopArray[index].setSSD(input.nextInt());

				// graphics
				LaptopAdvisorApplication.laptopArray[index].setGraphicsBrand(input.next());
				LaptopAdvisorApplication.laptopArray[index].setGraphicsType(input.next());
				LaptopAdvisorApplication.laptopArray[index].getRatings()[2] = input.nextInt();

				// IO
				LaptopAdvisorApplication.laptopArray[index].setIO(input.next());
				LaptopAdvisorApplication.laptopArray[index].getRatings()[3] = input.nextInt();

				// battery
				LaptopAdvisorApplication.laptopArray[index].setBattery(input.nextInt());
				LaptopAdvisorApplication.laptopArray[index].setSoftware(input.next());

				// display
				LaptopAdvisorApplication.laptopArray[index].setDisplay(input.nextDouble());
				LaptopAdvisorApplication.laptopArray[index].setResolutionW(input.nextInt());
				LaptopAdvisorApplication.laptopArray[index].setResolutionH(input.nextInt());
				LaptopAdvisorApplication.laptopArray[index].setTouch(input.nextBoolean());

				// Parameters
				LaptopAdvisorApplication.laptopArray[index].setDepth(input.nextDouble());
				LaptopAdvisorApplication.laptopArray[index].setWidth(input.nextDouble());
				LaptopAdvisorApplication.laptopArray[index].setHeight(input.nextDouble());
				LaptopAdvisorApplication.laptopArray[index].setWeight(input.nextDouble());

				// Warranty
				LaptopAdvisorApplication.laptopArray[index].setWarranty(input.next());

				// Last to be set Link and Image file
				LaptopAdvisorApplication.laptopArray[index].setHyperLink(input.next());
				LaptopAdvisorApplication.laptopArray[index].setImageFile("laptop" + index + ".jpg");

				// print laptop onto console
				System.out.println(LaptopAdvisorApplication.laptopArray[index]);

				index++;

			}

			input.close();

		} catch (FileNotFoundException error) {

			System.out.println("Sorry file not loading - please check the name/location");
		}
	}
}
