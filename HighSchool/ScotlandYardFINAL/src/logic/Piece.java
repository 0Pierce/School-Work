package logic;

import controller.Move;
import controller.Node;
import java.io.FileNotFoundException;
import scotlandYard.CreateStartPositions;

//Creates the object "Piece" which stores all of the logic information 
//needed for the player pieces

//Author: Wilfred

@SuppressWarnings({ "static-access" })
public class Piece{

	//fields:
	private int hasMoved = 1;
	private int[] moves;
	private int movesLeft;
	private int counter;
	private int x;
	private int y;
	private int location;
	private Node n = new Node();
	private Move m = new Move();
	private String type;

	//Constructor Class
	public Piece(String type, CreateStartPositions s) throws FileNotFoundException {
		
		//Sets up the variables for the object
		this.type = type;
		movesLeft = 0;
		
		//If not Mr X then sets up start position and locations, while restricting it's movement
		if(type.equals("bobby") || type.equals("detective")) {
			hasMoved = 0;
			location = s.getDetectives().pop();
			x = n.getNodeX(location);
			y = n.getNodeY(location);
			
		//If Mr X then sets up start position and locations, while allowing it to move
		} else {
			location = s.getMrX().pop();
			x = n.getNodeX(location);
			y = n.getNodeY(location);
		}
	}
	
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//		UTILITY MEHTODS
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	//gets the possible moves for the piece if it can still move as an int array
	public int[] getPossibleMoves() throws FileNotFoundException {
		if(hasMoved > 0) {
			moves = m.PossibleMoves(location);
			return moves;
		}
		return null;
	}
	
	//getters and setters	
	public int getX() {
		return x;
	}


	public int getHasMoved() {
		return hasMoved;
	}

	public void setHasMoved(int hasMoved) {
		this.hasMoved = hasMoved;
	}

	public Node getN() {
		return n;
	}

	public void setN(Node n) {
		this.n = n;
	}

	public Move getM() {
		return m;
	}

	public void setM(Move m) {
		this.m = m;
	}

	public int getMovesLeft() {
		return movesLeft;
	}

	public void setMovesLeft(int movesLeft) {
		this.movesLeft = movesLeft;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	public int[] getMoves() {
		return moves;
	}

	public void setMoves(int[] moves) {
		this.moves = moves;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
