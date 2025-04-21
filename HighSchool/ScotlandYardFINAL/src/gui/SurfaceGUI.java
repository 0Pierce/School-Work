package gui;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;



//Author: Pierce

@SuppressWarnings("serial")
public class SurfaceGUI extends PlayingPieces {

	
	
	//All of these could have been created within their respective classes and then i could have used
	//getters and setters to access them, but due to the sheer amount of variables i though it would just be easier
	//and more straightforward to make them fields
	public static int b = 1;
	protected static int DTaxiAmount =20, DBusAmount = 16, DTubeAmount = 8, XBlackAmount = 5, X2TicketAmount = 2;
	protected static int XTaxiAmount = 0, XBusAmount = 0, XTubeAmount = 0,count = 3;
	protected ArrayList<Integer> MrXTicketsContain = new ArrayList<Integer>();
	protected static int turncount;
	protected int cardFlag;
	protected int moveFlag;
	public static int turncounter;

	
	//Creates the number labels
//------------------------------------------
	protected static JLabel lblTaxiDAmount = new JLabel(""+ DTaxiAmount);
	protected static JLabel lblTaxiXAmount = new JLabel("");
	
	protected static JLabel lblBusDAmount = new JLabel(""+ DBusAmount);
	protected static JLabel lblBusXAmount = new JLabel("");
	
	protected static JLabel lblTubeDAmount = new JLabel(""+ DTubeAmount);
	protected static JLabel lblTubeXAmount = new JLabel("");
	
	protected static JLabel lbBlackTicketAmount = new JLabel(""+ XBlackAmount);
	protected static JLabel X2Amount = new JLabel(""+ X2TicketAmount);
	
	protected static JLabel lbBlackTicket = new JLabel("");
	protected static JLabel X2TicketIcon = new JLabel("");
	
	protected JPanel contentPane = new JPanel();
	
//----------------------------------------------
	
	protected static TravelLogX FrameT;
	protected static MapPanel map2;
	protected static MessageMapPanel helper;
	
	
	
	

	
	
	
	//Gets called by the controller to start the GameBoard only once
	public void executeOnce() {
		//System.out.println("Entered Execute");
		
		//Runs only once to prevent a duplicate GameBoard
		if(isExecuted) {
			return;
		}else {
			
			//System.out.println("SetsupBoard");
			//Count equals 4 because Mr.X does not have any cards yet and needs to be able to end turn once he picked a position
			//Since this is done in the ticketboard i cannot make sure he makes a first move so that is a problem, however,
			//due to time constraints there isnt time to fix this, and realistically it isnt a big problem as this only occurs once
			//For more on the count flag look around in GameBoard and TicketBoard
			this.frame = new GameBoard();
			
			frame.setVisible(true);
			frame.setResizable(false);
			
			isExecuted = true;
			
		}
	}
	
	public void executeOnce20() {
		if(isExecuted5) {
			return;
		}else {
			
			//System.out.println("SetsupBoard");
			//Count equals 4 because Mr.X does not have any cards yet and needs to be able to end turn once he picked a position
			//Since this is done in the ticketboard i cannot make sure he makes a first move so that is a problem, however,
			//due to time constraints there isnt time to fix this, and realistically it isnt a big problem as this only occurs once
			//For more on the count flag look around in GameBoard and TicketBoard
	
			helper = new MessageMapPanel();
			map2 = new MapPanel(helper);
			isExecuted = true;
		}
	}

	


	/*
	 * They get called depending on which button is pressed in Gameboard Then then
	 * call the GUI that needs to open
	 * 
	 */
	// -------------------------------------------------------------
	// Opens the TravelLogFrame
	public void TravelLog() {
		
		System.out.println("TravelLog Call");
		if(FrameT == null)
			FrameT = new TravelLogX();
		
		

	}
	
	//Places a card on the travelLog (Uses the flag called C)
	public void TravelLogPlaceCard(int c) {
		System.out.println("Entered PlaceCard SurfaceGUI");
		
		FrameT.determineTransport(c);
	}

	// Opens the Moves GUI and closes the CardsPlayed GUI
	

	//Opens the Cards Available GUI once called
	public void CAvailabale() {
		System.out.println("Entered SGUI CAvail");
		TicketBoard available = new TicketBoard();
		available.executeOnce4();

	}
	
	
	
	public void makeMove() {
		
		
		
	}

	



	// --------------------------------------------------

}
