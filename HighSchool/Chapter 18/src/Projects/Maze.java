package Projects;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//Runs the Maze
public class Maze {

	// Intitializes the start of the row and column
	public static int rowStart;
	public static int colStart = 0;

	// Intitializes the directions of movement
	private static final int RIGHT = 0;
	private static final int UP = 1;
	private static final int DOWN = 2;
	private static final int LEFT = 3;

	private int moveNumber = 0; // Current move number

	private char[][] mazeArray; // Creates the mazeArray

	private Scanner input; // Enables user input to pick movement

	
	//Reads the file and creates the actual maze (Does not print)
	public Maze(String filename) {

		
		//Loops through the files to insert the maze
		try {

			//Tell the code the file name so it can use the file
			input = new Scanner(new File(filename));

			
			//Assigns the file values to variables
			int rows = input.nextInt();
			int columns = input.nextInt();

			//Inserts those variables into the array
			mazeArray = new char[rows][columns];

			//From what i believe:
			/*
			 * This loops through all the characters from the file and inserts
			 * them into the array so they can be used in the print method.
			 */
			for (int row = 0; row < mazeArray.length; row++) {

				//Inputs the maze characters?
				mazeArray[row] = input.next().toCharArray();

				//If the first index equals . then the row start now equals row
				//Honestly not too sure
				if (mazeArray[row][0] == ".")
					rowStart = row;
			}

			//Calls the printMaze method to actually display the maze
			printMaze();
			
			//Closes input
			input.close();

			//So you can type in the movement? I believe
			input = new Scanner(System.in);

			//Just here to throw an error incase the file is not found
		} catch (FileNotFoundException error) {
			System.out.println("File not found" + error);
		}

	}
}// Should be at the very end of all the code