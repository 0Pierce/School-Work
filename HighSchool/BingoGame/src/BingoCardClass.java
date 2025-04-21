import java.util.Arrays;
import java.util.Random;
public class BingoCardClass{
	//for the grid we will use a random number generator to 
	//make the card
	private Random random = new Random();
	//constant variable SQUARESIZE 
	public final int SQUARESIZE = 5;
	public final int RANDOM_GENERATION_UPPERBOUND=75;
	//Fields/ attributes
	private int[][] Grid;
	private int temp = random.nextInt(1,RANDOM_GENERATION_UPPERBOUND);
	private boolean[][] bingo;
	
	//constructor
	public BingoCardClass(int first, int second) {
		setGrid(first,second);
	}
	
	//getters and setters
	public int[][] getGrid() {
		return Grid;
	}
	
	public void setGrid(int first, int second) {
		//default
		if (first < 0 && second < 0) {
			Grid =  new int[SQUARESIZE][SQUARESIZE];
		}
		//if the first is a invalid input
		else if(first < 0 && second > 0){
			Grid = new int [second][second];
		}
		//if the second is the invalid input
		else if(first > 0 && second < 0){
			Grid = new int [first][first];
		}
		//if it is all valid
		else {
			Grid = new int [first] [second];
		}
		
	}

	@Override
	public String toString() {
		return "BingoCardClass [Grid=" + Arrays.toString(Grid) + "]";
	}
	
	//it has everything set false and will set to true if the 
	//number had been taken
	private boolean [] usedNum = new boolean[75];
	//creates the card
	public void createCard() {
		generateRows();
	}
	
	//--------------------------------------------------------
	//helper method to generate random numbers for each squares
	private void generateRows() {
	//generates a random number the entire grid for each row and column
		for (int i=0; i < Grid.length;i++) {
			for (int j : Grid [i]) {
				Grid[i][j]=checkUsedNum();
			}
		}
	}
	//uses usedNum boolean array to check if the current number has been used
	private int checkUsedNum() {
		//once it just so happens to role on a same time 
		//for 1 in 75 in 25 tries it rerolls just so the card is not broke
		if (usedNum[temp]) {
			temp = random.nextInt(1,RANDOM_GENERATION_UPPERBOUND);
			checkUsedNum();
		}
		//if the number hasn't been used it will be sent back 
		// and the array will be set to true so that it will 
		// not be reused 
		usedNum[temp]=true;
		return temp;
	}
	
	
	//!!!!!!!!!!!!!!!!!!!!!! important 
	//use this before checkForBingo to input a true if there is a match 
	//between the grid and the number that had been rolled in the number
	public void scanForMatch(int currentnum) {
		for (int i=0; i < Grid.length;i++) {
			for (int j : Grid [i]) {
				if(Grid[i][j] == currentnum) {
					bingo [i][j]=true;
				}
			}
		}
	}
	
	
	//-------------------------------------------------------------------------------
	//this checks for a bingo and returns true if there is
	public boolean checkForBingo() {
	//this scans every row or column
		
		for (int i=0; i < Grid.length;i++) {
			checkRow(i);
			checkColumn(i);
		}
		//this scans the 2 diagonals that are possible on a 5x5
		checkdiagonals();
		return false;
	}
	//this checks and adds up if the row has consecetive bingos
	//the other two work similarly
	private boolean checkRow(int row) {
		int inRow=0;
		for (int i=0; i < Grid.length;i++) {
			if (bingo [row][i]) {
				inRow++;
			}
			else {
				break;
			}
		}
		if (inRow==Grid.length) {
			return true;
		}
		return false;
	}
	
	
	private boolean checkColumn(int column) {
		int inColumn=0;
		for (int i=0; i < Grid.length;i++) {
			if (bingo [i][column]) {
				inColumn++;
			}
			else {
				break;
			}
		}
		if (inColumn==Grid.length) {
			return true;
		}
		return false;
	}
	
	
	
	private boolean checkdiagonals() {
		int diagonal=0;
		for (int i=0; i < Grid.length;i++) {
			if (bingo [i][i]) {
				diagonal++;
			}
			else {
				break;
			}
		}
		if (diagonal==Grid.length) {
			return true;
		}
		for (int i=Grid.length; i > 0;i--) {
			if (bingo [i][i]) {
				diagonal++;
			}
			else {
				break;
			}
		}
		if (diagonal==Grid.length) {
			return true;
		}
		return false;
	}
}