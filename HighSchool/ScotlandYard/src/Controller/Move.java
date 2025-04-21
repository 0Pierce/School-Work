package controller;

import java.io.*;
//this class is a class that makes a "virtual" map and helps the program visualize the 
//connections and paths

//if you are doing Ai this class would be pretty useful to read through
//to help judge the distances and how to make the next move
public class Move {
	//notoccupied is for the detectives since mr x can't colide himself with one
	private static boolean[] notOccupied;
	public static int[][] moves;
	private static int moveIndex = 1;
	public static int [] tempBeside;
	
	//possible moves 
	//use checkMove to determine the possibilities nearby
	//returns the nodes that can be traveled to in an array
	@SuppressWarnings("null")
	public int[] PossibleMoves(int currentNode) throws FileNotFoundException{
		int [] listOfMoves = new int [201];
		for(int j=0; j < 200; j++)
		{
			if (Node.checkCloseBy(currentNode,j)[currentNode][j]!=null && currentNode!= j)
		    listOfMoves[j] = CheckMove(j,currentNode);
		}
		return listOfMoves;
	}
	
	//checkMove makes sure the move is legal for mr.X
	//by making sure the node is one space away, and of the same attribute
	public int CheckMove(int nextMove, int currentNode) throws FileNotFoundException {
			if(nextTo(currentNode,nextMove).equals("T"))
				return 1;
			else if(nextTo(currentNode,nextMove).equals("B"))
				return 2;
			else if(nextTo(currentNode,nextMove).equals("U"))
				return 3;
			else if(nextTo(currentNode,nextMove).equals("F"))
				return 4;
			else
				//detectives can't go on the ferry accross the river
				//switched to a multi ticket spot(use either bus or taxi)
				return 101;
		
	}
	public int CheckMoveX(int nextMove, int currentNode) throws FileNotFoundException {
		//checks if there is collison
		if(nextTo(currentNode,nextMove).equals("T") && notOccupied[currentNode])
			return 1;
		else if(nextTo(currentNode,nextMove).equals("B") && notOccupied[currentNode])
			return 2;
		else if(nextTo(currentNode,nextMove).equals("U") &&  notOccupied[currentNode])
			return 3;
		else if(nextTo(currentNode,nextMove).equals("F") &&  notOccupied[currentNode])
			return 4;
		else
			if (isSurrounded(currentNode)) {
				//he cannot move if he is surrounded
				return 0;
			}
		//if none of this happens this must mean he is taking a ferry
		return 101;
	
	}
	//isSurrounded checks the current node if they are surrounded
	//input: the node number you want to check
	//output: true or false
	public boolean isSurrounded (int currentNode) throws FileNotFoundException {
		//this splits the nextTo which returns a string of close-by nodes if there isn't a perfect
		//niegbor then decrypts the string int array
		String[] data = nextTo(currentNode, 0).split(" ");
		//later uses it to form a loop unntil the amount of close by nodes are occupied
		for (int i = 0 ;i<data.length;i++) {
			//translates it to the not occupied to check if that node is occupied 
			//from the array of close-by node numbers
			if (notOccupied[Integer.parseInt(data[i])]) {
				return false;
			}
		}
		return true;
	}
	//nextTo checks if the current posistion and the posistion you want to check
	//is next to each other
	//input: current node number
	//output: "T"(taxi) "B"(bus) "U"(undergroud) "S"(ship)
	//if the two mentioned nodes are beside each other
	//"(locations of things nearby)" if it has somthing beside it but it is not the "nextMove" node
	//and use Split if we are trying to extract the numbers
	//"nope" if it is not beside anything
	//(NOTE: it is a string because I made the checkCloseBy 
	// able to do a lot of things so it would be more convient for me to reuse it
	// and be able to deliver the transport methods)
	//{to get around this not being a boolean use (nextTo!="nope") to find if it next to somthing}
	
	public String nextTo(int currentNode, int nextMove) throws FileNotFoundException {
		//later used for creating a list for the is surrounded code
		String answer= ""; 
		//this checks for the special item in my array that should never be able to be reached
		//through normal means and uses that as a special indicator 
		//whether or not if it is directly besides the current node and the node you want to check
		if (Node.checkCloseBy(currentNode,nextMove)[201][201]=="True") {
			//returns a method of transportation
			String x =Node.checkCloseBy(currentNode,nextMove)[currentNode][nextMove];
			return x;
		}
		//checks if there are no nearby nodes
		else if (Node.checkCloseBy(currentNode,nextMove)[currentNode].length!=0) {
			//makes a loop that checks for the entire array if there is a node that is close
			for (int i = 0 ; i<201;i++){
				//gives a node if it is close-by and adds it into the string
				if (Node.checkCloseBy(currentNode,nextMove)[currentNode][i]!=null) {
					answer+=" "+ Node.checkCloseBy(currentNode,nextMove)[currentNode][i];
				}
			}
			return answer;
		}
		//this should be techniqually impossible to reach becuase every node should be connected
		return "nope";
	}
	
	//StoreMoves stores moves that were made by mr X
	//has Visble moves, and hidden moves
	//the lower the array number the longer the move was made
	//input: the current piece's node number
	//output: inserts a node number to an array for storage
	public static void registerMoveX(int nodenum,int previousNode) {
		//stores the move in an array
		moves[moveIndex][0]=nodenum;
		moveIndex++;
	}
	//for the dectectives and bobbies where you don't need to track previous moves
	public static void registerMove(int nodenum,int previousNode) {
		//un occupies the last
		notOccupied [previousNode]=true;
		//occupies the next
		notOccupied [nodenum]=false;
		moveIndex++;
	}

}
