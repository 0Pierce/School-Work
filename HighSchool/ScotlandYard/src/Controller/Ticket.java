package controller;
public class Ticket {
	//constants
	private final static int BUSTICKET = 16,TAXITICKET=20,SUBWAYTICKET=8,BLACKTICKET=5, DOUBLETURN=2;
	//the stocks for either one
	public static int [][] detectiveStock = new int[3][2];
	public static int [][] mrXStock = new int[3][2];
	//this turns off and on making the turns vary
	public static boolean mrXTurn =true;
	//sets the board up
	public static void giveTicket() {
		int giveTicket=0;
		for (int i = 0;i<3;i++) {
			
			if (i==0) {
				giveTicket=TAXITICKET;
			}
			else if (i==1) {
				giveTicket=BUSTICKET;
			}
			else if (i==2) {
				giveTicket=SUBWAYTICKET;
			}
			detectiveStock[i][0]=giveTicket;
		}
		mrXStock[0][0]=BLACKTICKET;
		mrXStock[1][0]=DOUBLETURN;
	}
	//this method uses the stocks and inputs them into the used pile 
	public static void useSubway() {
		
		if (mrXTurn) {
			mrXStock[2][1]++;
		}
		else {
			detectiveStock[2][0]-=1;
			detectiveStock[2][1]++;
		}
		
	}
	public static void useBus() {
		if (mrXTurn) {
			mrXStock[1][1]++;
		}
		else {
			detectiveStock[1][0]-=1;
			detectiveStock[1][1]++;
		}
	}
	public static void useTaxi() {
		if (mrXTurn) {
			mrXStock[0][1]++;
		}
		else {
			detectiveStock[0][0]-=1;
			detectiveStock[0][1]++;
		}
	}
	public static void useBlackTicket() {
		mrXStock[0][0]-=1;
		mrXStock[0][1]++;
	}
	public static void use2xTicket() {
		mrXStock[1][0]-=1;
		mrXStock[1][1]++;
	}
	
	//returns the numbers
	public int[][] getDetectiveStock() {
		return detectiveStock;
	}
	public void setDetectiveStock(int[][] detectiveStock) {
		Ticket.detectiveStock = detectiveStock;
	}
	public int[][] getMrXStock() {
		return mrXStock;
	}
	public void setMrXStock(int[][] mrXStock) {
		Ticket.mrXStock = mrXStock;
	}
	public static boolean isMrXTurn() {
		return mrXTurn;
	}
	public static void setMrXTurn(boolean mrXTurn) {
		Ticket.mrXTurn = mrXTurn;
	}
	public int getBUSTICKET() {
		return BUSTICKET;
	}
	public int getTAXITICKET() {
		return TAXITICKET;
	}
	public int getSUBWAYTICKET() {
		return SUBWAYTICKET;
	}
	public int getBLACKTICKET() {
		return BLACKTICKET;
	}
	public int getDOUBLETURN() {
		return DOUBLETURN;
	}
	
}
