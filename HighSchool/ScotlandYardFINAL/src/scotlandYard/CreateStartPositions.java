package scotlandYard;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;


//Author: Aarib

public class CreateStartPositions {

	//fields:
	private static Scanner input;
	private static Stack<Integer> mrX = new Stack<Integer>();
	private static Stack<Integer> detectives = new Stack<Integer>();
	
	//Constructor Class
	public CreateStartPositions() {
			try {
				
				// point scanner to read the text file for Mr X's start positions
				input = new Scanner(new File("text files/Scotland Yard - MrX Start Positions (1).txt"));
				
				// create an array for the list of Mr X's start positions					
				for (int i = 0; i < 13; i++) {
					mrX.add(input.nextInt());
				}
				
				// point scanner to read the text file for the detective's/bobbie's start positions
				input = new Scanner(new File("text files/Scotland Yard - Detective Bobbie Start Positions (1).txt"));
				
				// create an array for the list of the detective's/ bobbie's start positions
				for (int i = 0; i < 16; i++) {
					detectives.add(input.nextInt());
				}
				
				//randomize
				Collections.shuffle(detectives);
				Collections.shuffle(mrX);
				
				// close scanner
				input.close();
				
			// display an error message if the file cannot be found	
			}	catch (FileNotFoundException error) {
				System.out.println("File not found" + error);
			}

	}

	//Getters And Setters
	public static Stack<Integer> getMrX() {
		return mrX;
	}

	public static void setMrX(Stack<Integer> mrX) {
		CreateStartPositions.mrX = mrX;
	}

	public static Stack<Integer> getDetectives() {
		return detectives;
	}

	public static void setDetectives(Stack<Integer> detectives) {
		CreateStartPositions.detectives = detectives;
	}
}

