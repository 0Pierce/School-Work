import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import com.sun.tools.javac.util.List;

public class Game {

	public static void main(String[] args) {

		//Prints out the game board with labeled spots 1-9
		char[][] gameBoard = {{ '1','|', '2', '|', '3' }, 
							 { '_', '+', '_', '+', '_' },
							 { '4', '|', '5', '|', '6' }, 
							 { '_', '+', '_', '+', '_' }, 
							 { '7', '|', '8', '|', '9' }};
		
		printGameBoard(gameBoard);
		
		//User input of choices
		
		
		
		//A loop so we can constantly check for player input and have
		//CPU respond to that position
		while(true) {
			
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter your choice (1-9)");
			int playerPos = scan.nextInt();
			
			
			
			placePiece(gameBoard, playerPos, "player");
			
			//Generates a random number
			Random rand = new Random();
			int cpuPos = rand.nextInt(9) + 1;
			
			//Puts down a X or O 
			placePiece(gameBoard, cpuPos, "cpu");
			
		
			
			//Calls on the "printGameBoard" method to print the board
			printGameBoard(gameBoard);
			
		}
		

	}


	//Prints the actual board
	public static void printGameBoard(char[][] gameBoard) {
		for (char[] row : gameBoard) {
			for (char c : row) {
				System.out.print(c);
				
			}
			System.out.println();
		}
		
	}
	
	public static void placePiece(char[][] gameBoard, int pos, String user) {
		
		char symbol = ' ';
		
		if(user.equals("player")) {
			symbol = 'x';
			
		}else if(user.equals("cpu")) {
			symbol = 'O';
		}
		switch(pos) {
		
			// the first 0 is the row 2nd zero is column
			// Replaces an empty square with X

			//Top row
			case 1:
				gameBoard[0][0] = symbol;
				break;
			case 2:
				gameBoard[0][2] = symbol;
				break;
			case 3:
				gameBoard[0][4] = symbol;
				break;
				
			//Second row
			case 4:
				gameBoard[2][0] = symbol;
				break;
			case 5:
				gameBoard[2][2] = symbol;
				break;
			case 6:
				gameBoard[2][4] = symbol;
				break;
				
				//Third row
			case 7:
				gameBoard[4][0] = symbol;
				break;
			case 8:
				gameBoard[4][2] = symbol;
				break;
			case 9:
				gameBoard[4][4] = symbol;
				break;
			default:
				break;
		}
		
	}
	
	public static String checkWinner() {
		
		List topRow = Arrays.asList(1 ,2 ,3 );
		List midRow = Arrays.asList(1 ,2 ,3 );
		List botRow = Arrays.asList(1 ,2 ,3 );
		List leftCol = Arrays.asList(1,4,7);
		List MidCol = Arrays.asList(2,5,8);
		List RightCal = Arrays.asList(3,6,9);
		
		
		
		return "";
		
	}

}















//Gay shit under



























































