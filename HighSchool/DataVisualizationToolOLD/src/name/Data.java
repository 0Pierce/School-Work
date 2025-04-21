package name;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Data {

	static String row = "";
	static String row2 = "";

	static PrintWriter out;
	PrintWriter out2;

	static String path = "files\\Data.csv";
	static String[][] csvData;
	static PrintWriter reWrite;

	private int numOfUsers;
	DataPanel dPanel;
	
	// Constructor
	public Data() {
		try {
			dPanel = new DataPanel();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		numOfUsers = ActionPanel.numOfUsers;

		csvData = new String[numOfUsers][5];

	}

	// Creates the file if there isnt one and writes to the CSV file
	public static void writeToFile(String data) throws IOException {

		boolean exists = false;

		row2 = data;
		String[] split = row2.split(",");

		System.out.println("Entered WriteToFile");
		System.out.println(split[0]);

		for (int i = 0; i < csvData.length; i++) {
			// Goes through the entire array and checks if there is a duplicate username
			if (split[0].equals(csvData[i][0])) {

				System.out.println("USERNAME ALREADY EXISTS");
				// importData();
				exists = true;

				File sound = new File("C:\\Users\\pierc\\Desktop\\DVTImages\\Sounds\\Duplicate.wav");
				try {
					Clip clip = AudioSystem.getClip();
					clip.open(AudioSystem.getAudioInputStream(sound));
					clip.start();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		}

		// If there isnt a duplicate the data gets written onto the csv
		if (exists == false) {
			// System.out.println("Entered createFile");
			out = new PrintWriter(new FileWriter(new File(path), true));
			out.println(data);
			out.close();

			// Plays a sound
			File sound = new File("C:\\Users\\pierc\\Desktop\\DVTImages\\Sounds\\UserAdded.wav");
			try {
				Clip clip = AudioSystem.getClip();
				clip.open(AudioSystem.getAudioInputStream(sound));
				clip.start();
			} catch (Exception e) {
				e.printStackTrace();
			}

			importData();
		}

		// System.out.println("PastForLoop");

	}

	// Reads the csv file and stores the data in a 2D csvData Array which is then
	// further used to display the data
	public static String[][] importData() throws IOException {

		// Creates the file directory
		File file = new File("Files");
		if (!file.isDirectory()) {
			file.mkdir();
		}

		// Creates the csv in the folder(If not already present) and closes its
		// writting.
		out = new PrintWriter(new FileWriter(new File(path), true));
		out.close();
		// A buffered reader
		BufferedReader br = new BufferedReader(new FileReader(path));
		int i = 0;
		// While the csv file has a line - Cannot have an empty line
		while ((row = br.readLine()) != null) {
			// Splits the strings by commas

			String[] temp = row.split(",");

			// ***NOTE***
			// If there is an error here check the CSV file
			// There most likely is a extra line.
			System.out.println(temp.length);

			// The i's are the rows and the 0 - 1 are the columns
			// This transfers the data into the csvDataArray

			if (1 > temp.length) {

			} else {
				csvData[i][0] = temp[0];
			}

			// System.out.println(temp[1]);

			if (2 > temp.length) {

			} else {
				csvData[i][1] = temp[1];
			}

			if (3 > temp.length) {

			} else {
				csvData[i][2] = temp[2];
			}

			// Checks if there is an index
			if (4 > temp.length) {
				System.out.println("EMPTY");
			} else {

				System.out.println("HAS STUFF");
				csvData[i][3] = temp[3];
			}

			// Checks if there is a 4th Index
			if (5 > temp.length) {

			} else {
				csvData[i][4] = temp[4];
			}

			// csvData[i][3] = temp[3];
			// Used for testing
			// System.out.println(csvData[i][0]);
			// System.out.println(csvData[i][1] + i);
			i++;

		}
		i = 0;
		// Calls the displayData and passes on the array in order to update the JTable
		//displayData(csvData);
		return csvData;
		

		// displayData()

	}

//Gets called to override the CSV file
	public void RemoveWriteToFile() throws IOException {

		// NOTE--------------------
		// USE ROW TO CHECK IF THEY PICKED A ROW!!

		System.out.println("-------------ENTERED REWRITE-----------------------");
		int row = dPanel.getSelectedCell();
		System.out.println(row);
		// Goes through the entire array and locates the Row

		for (int i = 0; i < csvData.length; i++) {
			if (i == row) {

				System.out.println("---Found Row---");
				System.out.println(row);
				for (int j = 0; j < 5; j++) {
					csvData[i][j] = null;
				}
				break;
			}

		}

		try {
			reWrite = new PrintWriter(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(dPanel.getUsedRows());
		// Goes through
		System.out.println(csvData.length);
		System.out.println("Above Forloop");
		System.out.println(Arrays.deepToString(csvData));

		// Assuming there is always a first value
		// Checks for null values and uses a sort of bubble sort to slowly get rid of
		// all of the arrays which are null
		for (int a = 0; a < csvData.length; a++) {

			// Makes sure there are indexes
			if (csvData[a][0] != null) {
				if (csvData[a + 1][0] == null) {
					String[] temp = new String[5];

					// Moves the indexes into temp array and nulls the existing array
					for (int b = 0; b < 5; b++) {
						temp[b] = csvData[a + 2][b];
						csvData[a + 2][b] = null;

					}
					// Moving A array to a different row with all of its indexes
					for (int c = 0; c < 5; c++) {
						csvData[a + 1][c] = temp[c];
					}

				}

			} else {
				break;
			}

		}

		System.out.println("-------------ARRAY SORTED--------------------");
		System.out.println(Arrays.deepToString(csvData));

		for (int i = 0; i < dPanel.getUsedRows() - 1; i++) {
			for (int j = 0; j < 5; j++) {

				System.out.println("Ran JLOOP");
				// Makes sure the empty row isnt being added onto the csv file
				if (csvData[i][j] != null) {
					System.out.println("Ran If");
					// Writes to the csv file and formats it accordingly
					// Makes sure that a row doesnt start off with a comma, nor end with one
					if (j == 0) {
						reWrite.print(csvData[i][j]);
					} else {
						reWrite.print("," + csvData[i][j]);
					}

				}

			}

			reWrite.println();
		}

		// Closes print writer
		reWrite.close();

		// Calls importData and begins the process of displaying the data
		try {
			importData();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

//Writes the updated array into the csv file
	public void AddCellsToFile(String[][] csvData) throws IOException {
		out2 = new PrintWriter(path);

		/*
		 * for(int i = 0; i < panel.getUsedRows()-1; i++) { for(int j = 2; j < 5; j++) {
		 * out.print(csvData[i][j]); } out.println(); }
		 */

		for (int i = 0; i < dPanel.getUsedRows() - 1; i++) {
			for (int j = 0; j < 5; j++) {

				System.out.println("Ran JLOOP");
				// Makes sure the empty row isnt being added onto the csv file
				if (csvData[i][j] != null) {
					System.out.println("Ran If");
					// Writes to the csv file and formats it accordingly
					// Makes sure that a row doesnt start off with a comma, nor end with one
					if (j == 0) {
						out2.print(csvData[i][j]);
					} else {
						out2.print("," + csvData[i][j]);
					}

				}

			}

			out2.println();
		}

		out2.close();

		importData();

	}



}
