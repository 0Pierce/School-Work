package gui;

//imports all relevant classes
import java.awt.Component;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import logic.Piece;
import scotlandYard.CreateStartPositions;

import controller.*;


//Author: Aarib

//Creates the main gameboard as a panel so that it is easily integrated into the SurfaceGUI
@SuppressWarnings("serial")
public class MapPanel extends JPanel{

	// fields:
	
	// Creates every relevant image icon that is used in this class
	private Icon ferry = new ImageIcon("images/ferry.png");
	private Icon subway = new ImageIcon("images/Subway.png");
	private Icon bus = new ImageIcon("images/Bus.png");
	private Icon taxi = new ImageIcon("images/Taxi.png");
	private Icon mapBackground = new ImageIcon("images/Scotland Yard - Map (1).png");
	private Icon detective = new ImageIcon("images/detective piece.png");
	private Icon cop = new ImageIcon("images/cop piece.png");
	private Icon mrXRE = new ImageIcon("images/XrX.png");
	private Icon select = new ImageIcon("images/MultipleOptions.png");
	private static Icon exclaim = new ImageIcon("images/SNAKE.png");

	//Creates the JLabels for this Panel
	private JLabel A, B, C, D, X;
	private static JLabel map;
	private static JLabel here;
	private JLabel taxiLabel, busLabel, subwayLabel, ferryLabel, choiceLabel;

	//Creates the list of start positions
	private CreateStartPositions s = new CreateStartPositions();

	//Creates each player piece's piece object
	private Piece detectiveA;
	private Piece detectiveB;
	private Piece bobbyA;
	private Piece bobbyB;
	private static Piece mrX;
	
	//constructor method
	public MapPanel(MessageMapPanel helper) {
		
		//creates the panel
		setBounds(0, 0, 1018, 764);
		map = new JLabel(mapBackground);
		map.setBounds(0, 0, 1018, 764);
		add(map);
		
		//creates the pieces
		try {
			createPieces();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//sets up and adds all the player pieces
		setupImages();
		CreateA(helper);
		CreateB(helper);
		CreateC(helper);
		CreateD(helper);
		CreateX(helper);
		map.add(A);
		map.add(B);
		map.add(C);
		map.add(D);
		map.add(X);
		setVisible(true);
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//		UTILITY MEHTODS
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	//Creates the piece object for each player piece
	private void createPieces() throws FileNotFoundException {
		detectiveA = new Piece("detective",s);
		detectiveB = new Piece("detective",s);
		bobbyA = new Piece("bobby",s);
		bobbyB = new Piece("bobby",s);
		mrX = new Piece("MrX",s);
	}

	//Sets up and crops the images used in this panel
	private void setupImages() {
		Image imageP = ((ImageIcon) detective).getImage(); 
		Image newimgP = imageP.getScaledInstance(20, 40,  java.awt.Image.SCALE_SMOOTH);  
		detective = new ImageIcon(newimgP);
		Image imageC = ((ImageIcon) cop).getImage(); 
		Image newimgC = imageC.getScaledInstance(30, 40,  java.awt.Image.SCALE_SMOOTH);  
		cop = new ImageIcon(newimgC);
		Image imageX = ((ImageIcon) mrXRE).getImage(); 
		Image newimgX = imageX.getScaledInstance(20, 40,  java.awt.Image.SCALE_SMOOTH);  
		mrXRE = new ImageIcon(newimgX);
		Image imageF = ((ImageIcon) ferry).getImage(); 
		Image newimgF = imageF.getScaledInstance(60, 60,  java.awt.Image.SCALE_SMOOTH);  
		ferry = new ImageIcon(newimgF);
		Image imageS = ((ImageIcon) subway).getImage(); 
		Image newimgS = imageS.getScaledInstance(60, 60,  java.awt.Image.SCALE_SMOOTH);  
		subway = new ImageIcon(newimgS);
		Image imageB = ((ImageIcon) bus).getImage(); 
		Image newimgB = imageB.getScaledInstance(60, 60,  java.awt.Image.SCALE_SMOOTH);  
		bus = new ImageIcon(newimgB);
		Image imageT = ((ImageIcon) taxi).getImage(); 
		Image newimgT = imageT.getScaledInstance(60, 60,  java.awt.Image.SCALE_SMOOTH);  
		taxi = new ImageIcon(newimgT);
		Image imageM = ((ImageIcon) select).getImage(); 
		Image newimgM = imageM.getScaledInstance(60, 60,  java.awt.Image.SCALE_SMOOTH);  
		select = new ImageIcon(newimgM);
		Image imageE = ((ImageIcon) exclaim).getImage(); 
		Image newimgE = imageE.getScaledInstance(10, 40,  java.awt.Image.SCALE_SMOOTH);  
		exclaim = new ImageIcon(newimgE);
	}
	
	//Creates the player label for the first detective
	private void CreateA(MessageMapPanel helper) {
		A = new JLabel(detective);
		A.setBounds(detectiveA.getX()-10,detectiveA.getY()-20,20,40);
		
		//If clicked on, hides any previously made labels, and then creates this piece's possible moves 
		A.addMouseListener(new MouseAdapter() {
		      public void mouseClicked(MouseEvent me) {
		    	  hideMoves();
		    	  try {
					CreateMoves(detectiveA, 1, helper);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		      }
		});
	}
	
	//Creates the player label for the second detective
	private void CreateB(MessageMapPanel helper) {
		B = new JLabel(detective);
		B.setBounds(detectiveB.getX()-10,detectiveB.getY()-20,20,40);

		//If clicked on, hides any previously made labels, and then creates this piece's possible moves 
		B.addMouseListener(new MouseAdapter() {
		      public void mouseClicked(MouseEvent me) {
		    	  hideMoves();
		    	  try {
					CreateMoves(detectiveB, 2, helper);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		      }
		});
	}
	
	//Creates the player label for the first bobby
	private void CreateC(MessageMapPanel helper) {
		C = new JLabel(cop);
		C.setBounds(bobbyA.getX()-10,bobbyA.getY()-20,20,40);

		//If clicked on, hides any previously made labels, and then creates this piece's possible moves 
		C.addMouseListener(new MouseAdapter() {
		      public void mouseClicked(MouseEvent me) {
		    	 hideMoves();
		    	 try {
					CreateMoves(bobbyA, 3, helper);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		      }
		});
	}
	
	//Creates the player label for the second bobby
	private void CreateD(MessageMapPanel helper) {
		D = new JLabel(cop);
		D.setBounds(bobbyB.getX()-10,bobbyB.getY()-20,20,40);

		//If clicked on, hides any previously made labels, and then creates this piece's possible moves 
		D.addMouseListener(new MouseAdapter() {
		      public void mouseClicked(MouseEvent me) {
		    	  hideMoves();
		    	  try {
					CreateMoves(bobbyB, 4, helper);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		      }
		});
	}
	
	//Creates the player label for MrX
	private void CreateX(MessageMapPanel helper) {
		X = new JLabel(mrXRE);
		X.setBounds(mrX.getX()-10,mrX.getY()-20,20,40);

		//If clicked on, hides any previously made labels, and then creates this piece's possible moves 
		X.addMouseListener(new MouseAdapter() {
		      public void mouseClicked(MouseEvent me) {
		    	  hideMoves();
		    	  try {
					CreateMoves(mrX, 5, helper);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		      }
		});
	}
	
	//hides any previously made labels
	private void hideMoves() {
		
		//finds the number of JComponents on this panel, then sets them all to invisible
		Component[] components = map.getComponents();
		for (int i = components.length-1; i >= 0; i --) {
			components[i].setVisible(false);
		}
		
		//sets the player pieces to visible
		A.setVisible(true);
		B.setVisible(true);
		C.setVisible(true);
		D.setVisible(true);
		X.setVisible(GameBoard.b == 1);
	}

	//Creates JLables where the selected piece can go
	public void CreateMoves(Piece Number, int type, MessageMapPanel helper) throws FileNotFoundException {
		int [] moves;
		moves = Number.getPossibleMoves();
		
		//Does nothing if no moves are possible
		if(moves == null) {
			return;
		}
		
		//Creates a unique color and attributed label for every node that the \
		//selected piece can go
		for (int i = 0; i < 201; i++) {
			if(moves[i] == 1)
					addLabel(taxiLabel, i, Number, type, taxi,1, helper);
			if(moves[i] == 2) 
					addLabel(busLabel, i, Number, type, bus,2, helper);
			if(moves[i] == 3) 
					addLabel(subwayLabel, i, Number, type, subway,3, helper);
			if(moves[i] == 4) {
				//checks if the piece is MrX to see if it should show the option to go by ferry
				if(type == 5) {
					addLabel(ferryLabel, i, Number, type, ferry,4, helper);
				}
				
			//If the piece can use either a taxi or bus to go to the next node 
			} if(moves[i] == 101) 
				addLabel(choiceLabel, i, Number, type, select, moves[i], helper);
		}
	}

	//adds a label to the panel
	private void addLabel(JLabel d, int i, Piece Number, int type, Icon image, int j, MessageMapPanel helper) throws FileNotFoundException {
		//creates a non static JLabel for later use
		d = new JLabel(image);
		JLabel l = d;
		d.setBounds(Node.getNodeX(i)-30, Node.getNodeY(i)-30, 60, 60);
		
		//If the JLabel is clicked on, the program will send the value of it to the helper 
		//class for it to send it to the TicketBoard class
		d.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				helper.setValue(j);
				helper.setValueB(Number.getLocation(),i);
				
				//if the selected piece is a bobby, then it skips over the Ticket class
				if(Number.getType().equals("bobby")) {
					try {
						ChooseLabel(l, i, Number, type, image);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		
		//If it is not a bobby, then waits for a response from the TicketBoard class(for 
		//the player to use a ticket) before allowing the piece to move
		if(Number.getType().equals("detective") || Number.getType().equals("MrX")) {
			//more copied code
			helper.addPropertyChangeListener(e -> {
				if(e.getNewValue().equals(-1) && helper.getValueB()[i] == Number.getLocation()) {
					try {
						ChooseLabel(l, i, Number, type, image);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		}
		
		//adds the label to the panel
		map.add(d);
		d.setVisible(true);
		d.repaint();

	}

	//Chooses the selected label for the selected piece
	public void ChooseLabel(JLabel x, int i, Piece Number, int type, Icon image) throws FileNotFoundException{
	
	  //Sets the selected piece's new coordinates and location(then takes away one of it's moves)
	  Number.setX(Node.getNodeX(i));
  	  Number.setY(Node.getNodeY(i));
  	  Number.setLocation(i);  	 
  	  Number.setHasMoved(Number.getHasMoved()-1);
  	  
  	  //Recreates the JLabel of the chosen piece to show it's movement
  	  if(type == 1)
	  		  A.setBounds(Number.getX()-10,Number.getY()-20,20,40);
  	  if(type == 2)
	  		  B.setBounds(Number.getX()-10,Number.getY()-20,20,40);
  	  if(type == 3)
	  		  C.setBounds(Number.getX()-10,Number.getY()-20,20,40);
  	  if(type == 4)
	  		  D.setBounds(Number.getX()-10,Number.getY()-20,20,40);
  	  if(type == 5)
	  		  X.setBounds(Number.getX()-10,Number.getY()-20,20,40);
  	  
  	  //hides the rest of the possible moves
	  hideMoves();
	}
		
	//alerts the detectives of mr X's location
	public void showMrX() {
		try {
			//creates a JLabel above the node that mr X is at
			here = new JLabel(exclaim);
			here.setBounds(mrX.getX()-5, mrX.getY()-50, 20,30);
			here.setVisible(true);
			map.add(here);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//hides the alert of mr X's location
	public void HideMrX() {
		here.setVisible(false);
	}
	
	//getters and setters
	public Icon getCop() {
		return cop;
	}

	public void setCop(Icon cop) {
		this.cop = cop;
	}

	public Icon getMrXRE() {
		return mrXRE;
	}

	public void setMrXRE(Icon mrXRE) {
		this.mrXRE = mrXRE;
	}

	public Icon getSelect() {
		return select;
	}

	public void setSelect(Icon select) {
		this.select = select;
	}

	public JLabel getB() {
		return B;
	}

	public void setB(JLabel b) {
		B = b;
	}

	public JLabel getC() {
		return C;
	}

	public void setC(JLabel c) {
		C = c;
	}

	public JLabel getD() {
		return D;
	}

	public void setD(JLabel d) {
		D = d;
	}

	public void setX(JLabel x) {
		X = x;
	}

	public JLabel getTaxiLabel() {
		return taxiLabel;
	}

	public void setTaxiLabel(JLabel taxiLabel) {
		this.taxiLabel = taxiLabel;
	}

	public JLabel getBusLabel() {
		return busLabel;
	}

	public void setBusLabel(JLabel busLabel) {
		this.busLabel = busLabel;
	}

	public JLabel getSubwayLabel() {
		return subwayLabel;
	}

	public void setSubwayLabel(JLabel subwayLabel) {
		this.subwayLabel = subwayLabel;
	}

	public JLabel getFerryLabel() {
		return ferryLabel;
	}

	public void setFerryLabel(JLabel ferryLabel) {
		this.ferryLabel = ferryLabel;
	}

	public JLabel getChoiceLabel() {
		return choiceLabel;
	}

	public void setChoiceLabel(JLabel choiceLabel) {
		this.choiceLabel = choiceLabel;
	}

	public CreateStartPositions getS() {
		return s;
	}

	public void setS(CreateStartPositions s) {
		this.s = s;
	}

	public Piece getMrX() {
		return mrX;
	}

	public void setMrX(Piece mrX) {
		MapPanel.mrX = mrX;
	}
	
	public Icon getMapBackground() {
		return mapBackground;
	}

	public void setMapBackground(Icon mapBackground) {
		this.mapBackground = mapBackground;
	}



	public Icon getDetective() {
		return detective;
	}

	public void setDetective(Icon detective) {
		this.detective = detective;
	}

	public JLabel getA() {
		return A;
	}

	public void setA(JLabel a) {
		A = a;
	}

	public JLabel getMap() {
		return map;
	}

	public void setMap(JLabel map) {
		MapPanel.map = map;
	}

	public Piece getDetectiveA() {
		return detectiveA;
	}

	public void setDetectiveA(Piece detectiveA) {
		this.detectiveA = detectiveA;
	}

	public Piece getDetectiveB() {
		return detectiveB;
	}

	public void setDetectiveB(Piece detectiveB) {
		this.detectiveB = detectiveB;
	}

	public Piece getBobbyA() {
		return bobbyA;
	}

	public void setBobbyA(Piece bobbyA) {
		this.bobbyA = bobbyA;
	}

	public Piece getBobbyB() {
		return bobbyB;
	}

	public void setBobbyB(Piece bobbyB) {
		this.bobbyB = bobbyB;
	}
	
	public void setFerry(Icon ferry) {
		this.ferry = ferry;
	}

	public Icon getSubway() {
		return subway;
	}

	public void setSubway(Icon subway) {
		this.subway = subway;
	}

	public Icon getBus() {
		return bus;
	}

	public void setBus(Icon bus) {
		this.bus = bus;
	}

	public Icon getTaxi() {
		return taxi;
	}

	public void setTaxi(Icon taxi) {
		this.taxi = taxi;
	}
	
	public Icon getFerry() {
		return ferry;
	}

	public static Icon getExclaim() {
		return exclaim;
	}

	public static void setExclaim(Icon exclaim) {
		MapPanel.exclaim = exclaim;
	}

	public JLabel getHere() {
		return here;
	}

	public static void setHere(JLabel here) {
		MapPanel.here = here;
	}

	public void setXInvisible(boolean x) {
		X.setVisible(!x);
	}
	
}
