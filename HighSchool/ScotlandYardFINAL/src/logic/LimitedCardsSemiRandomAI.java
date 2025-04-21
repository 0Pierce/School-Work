package logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import controller.Move;
import controller.Node;
import controller.Ticket;

//Author Wilfred

public class LimitedCardsSemiRandomAI {
	public void decide(Piece x) {
		// create a list of the possible next positions
		List<Node> NodeList = new ArrayList<Node>();
		try {
			randomChoose(NodeList,x);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		

	protected int randomChoose(List<Node> nextNodeList, Piece x) throws Exception {
		// decide where to go randomly
		Random randomNode = new Random();
			//throw = special cases/exceptions
			//in this case nothing in the list
			if(nextNodeList.size()==0)
				throw new Exception();

			// decide where to go
			Move m = new Move();

			int [] PossibleNextMove = new int[10];
			int i = 1;
			for(int y = 0; y< 200; y++) {
				if(m.PossibleMoves(x.getLocation())[y] == 0 || m.PossibleMoves(x.getLocation())[y] == 1 || m.PossibleMoves(x.getLocation())[y] == 2 ||
					m.PossibleMoves(x.getLocation())[y] == 3 || m.PossibleMoves(x.getLocation())[y] == 4 || m.PossibleMoves(x.getLocation())[y] == 101) {
					PossibleNextMove[i] = y;
					i++;
				}else {
					nextNodeList.remove(y);
				}
			}
			
			int next = PossibleNextMove[randomNode.nextInt(10)];
			
			//check if the node has someone in it
			//if it is occupied delete this path and generate new path/ move
			if (!Move.getNotOccupied()[next]) {
				nextNodeList.remove(next);
				return randomChoose(nextNodeList,x);
			}
			
			// Find the tickets needed for the next node
			// I did this so I can check if it is possible to even go there(check if i have the requirements like tickets)
			// if ticket == 0 for that way of transport remove that node from possible list and choose again
			if (Ticket.detectiveStock[0][0] == 0 && Ticket.detectiveStock[1][0] == 0 && Ticket.detectiveStock[2][0] == 0) {
				nextNodeList.remove(next);
				return randomChoose(nextNodeList,x);
			}

			// Always uses any ticket that it can
			return next;
		}
	}

