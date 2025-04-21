package gui;

import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/*
 * Author: Pierce
 */

@SuppressWarnings("serial")
public class GameBoard extends SurfaceGUI {

	// Creates the JPanel Object
	private JPanel contentPane;

	private String checkCloseBy = "True";

	// Makes button and some Labels fields so they can be easily accessed throughout
	// the class, makes it overall easier
	JLabel lblBlur = new JLabel("");
	JLabel Map = new JLabel("");
	JLabel detective = new JLabel("");
	JLabel mrX = new JLabel("");
	JButton btnMoves = new JButton("Moves");
	JButton btnCardsAvailable = new JButton("Cards Available");
	JButton btnEndTurn = new JButton("End Turn");
	JButton btnTravelLog = new JButton("Travel Log");
	JButton btnNo = new JButton("");
	JButton btnYes = new JButton("");
	
	

	// Constructor
	public GameBoard() {

		// Used to keep track of everything
		// System.out.println("Construcotr");
		// Sets up the panel and Frame only once, needs to be in a constructor
		setTitle("The ScotlandYard BoardGame");
		setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1018, 1000);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		// Just calls the GUI

		executeOnce20();
		GameBoardGUI();

		

	}

	Color CustomBlue = Color.decode("#30D5C8");

	
	
	
	
//GameBoard GUI visuals
//------------------------------------------------------------------------------------------
	public void GameBoardGUI() {
//------------------------------------------------------------------------------------------

//----Setsup map--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

//------------------------------------------------------------------------------------------			
		lblBlur.setIcon(new ImageIcon("images/Blurv3.png"));
		lblBlur.setBounds(0, 0, 1002, 961); // 0, 0, 884, 878
		contentPane.add(lblBlur);
		lblBlur.setVisible(false);

		// Used for quick testing
		System.out.println("GameboardGUIs");

		// Adds the map

		map2.setBounds(0, 199, 1018, 764);
		contentPane.add(map2);
		
		
		
		
//------------------------------------------------------------------------------------------	

		// Creates the rain animation
		JLabel lblRain = new JLabel("");
		lblRain.setIcon(new ImageIcon("GIFS/Rain.gif"));
		lblRain.setBounds(0, 0, 1002, 598);
		contentPane.add(lblRain);

//----Buttons below----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

//------------------------------------------------------------------------------------------	
//TravelLog Button Available
//------------------------------------------------------------------------------------------
		//Both TravelLog and TickedBoard should be opened prior to switching turns otherwise will cause visual problems
		//They do not automatically open so the users screen isnt overwhelmed and they are in separate windows so they can be minimized if wanted
		btnTravelLog.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		btnTravelLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int i = 1;
				ButtonActions(i);

			}
		});
		btnTravelLog.setBounds(157, 121, 146, 46);
		btnEndTurn.setToolTipText("Opens Mr.X's travel log");
		btnTravelLog.setForeground(CustomBlue);
		btnTravelLog.setBackground(Color.GRAY);
		btnTravelLog.setToolTipText("Stores all of your moves and used cards, open before switching turns");
		contentPane.add(btnTravelLog);

//------------------------------------------------------------------------------------------
//Cards Available Button
//------------------------------------------------------------------------------------------
		btnCardsAvailable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {

				int i = 3;

				ButtonActions(i);
			}
		});
		btnCardsAvailable.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		btnCardsAvailable.setToolTipText("Shows you your available cards, open before switching turns");
		btnCardsAvailable.setBounds(157, 45, 146, 46);
		btnCardsAvailable.setBackground(Color.GRAY);
		btnCardsAvailable.setForeground(CustomBlue);
		contentPane.add(btnCardsAvailable);
//------------------------------------------------------------------------------------------
//End Turn button
//------------------------------------------------------------------------------------------		
		btnEndTurn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				map2.setVisible(false);
				lblRain.setVisible(false);
				int i = 4;
				ButtonActions(i);

			}
		});
		btnEndTurn.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		btnEndTurn.setBounds(606, 50, 100, 37);
		btnEndTurn.setToolTipText("Once you are done your turn press this button for the next player to play");
		btnEndTurn.setBackground(Color.GRAY);
		btnEndTurn.setForeground(CustomBlue);
		contentPane.add(btnEndTurn);
//------------------------------------------------------------------------------------------
//Pop up No button (Activates when end turn is pressed)
//------------------------------------------------------------------------------------------
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {

				btnNo.setVisible(false);
				btnYes.setVisible(false);
				map2.setVisible(true);
				lblRain.setVisible(true);

				lblBlur.setVisible(false);
				btnMoves.setVisible(true);
				btnCardsAvailable.setVisible(true);
				btnEndTurn.setVisible(true);
				btnTravelLog.setVisible(true);
				Map.setVisible(true);

				System.out.println("B == " + b);

			}
		});
		btnNo.setBackground(Color.DARK_GRAY);
		btnNo.setIcon(new ImageIcon("images/No.png"));
		btnNo.setBounds(187, 511, 170, 100);
		contentPane.add(btnNo);
		btnNo.setVisible(false);
//------------------------------------------------------------------------------------------
//Pop up Yes button (Activates when end turn is pressed)
//------------------------------------------------------------------------------------------
		btnYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {

			

				// Turns off the screenblur/transition components and sets the standard
				// components back to visible
				btnNo.setVisible(false);
				btnYes.setVisible(false);
				map2.setVisible(true);
				lblRain.setVisible(true);

				lblBlur.setVisible(false);
				btnMoves.setVisible(true);
				btnCardsAvailable.setVisible(true);
				btnEndTurn.setVisible(true);
				btnTravelLog.setVisible(true);
				Map.setVisible(true);

//Determines the turn on default b = 0 but no action is taken
//once end turn is pressed action is taken and its the detectives turn
//Then b = 1 it is detectives turn
//Sets the label visibility
//Since b == 1 means its the detective turn it hides Mr.X labels and shows Detective Labels
//-----------------------------------------------------------------
				if (b == 1 && count < 3) {

					// Plays a sound whenever the turn is done and yes is clicked
					//It is here so the sound only plays when the turn infact switches otherwise
					//it would play whenever the yes button is clicked
					File sound = new File("sounds/TurnSwitch.wav");
					try {
						Clip clip = AudioSystem.getClip();
						clip.open(AudioSystem.getAudioInputStream(sound));
						clip.start();
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					
					
					count = 3;
					mrX.setVisible(false);
					detective.setVisible(true);
					
					map2.setXInvisible(true);
					map2.getDetectiveA().setHasMoved(1);
					map2.getDetectiveB().setHasMoved(1);
					map2.getBobbyA().setHasMoved(1);
					map2.getBobbyB().setHasMoved(1);
					
					turncounter++;
					if(turncounter == 3 || turncounter == 8 || turncounter == 13 || turncounter == 18 || turncounter == 24) {
						map2.showMrX();
					} else {
						if(map2.getHere()!=null)
							map2.getHere();
					}

					lblTaxiDAmount.setVisible(true);
					lblTaxiXAmount.setVisible(false);

					lblBusDAmount.setVisible(true);
					lblBusXAmount.setVisible(false);

					lblTubeDAmount.setVisible(true);
					lblTubeXAmount.setVisible(false);

					lbBlackTicket.setVisible(false);
					X2TicketIcon.setVisible(false);

					lbBlackTicketAmount.setVisible(false);
					X2Amount.setVisible(false);

					

					b = 0;


//Since b == 1 means its Mr.Xs turn, it shows Mr.X labels and hides Detective Labels
//The count = 1 makes sure Mr.X and the Detective make a move (The flag trigger can be found in TicketBoard)
//Since im using the ticketBoard to make sure of this and my GUI does not interact with the Bobbies in any way
//I cannot setup the same flag for the bobbies, that needs to be done in the Map subclass(Creates clickable nodes/overlay for the GUI). Which needed to prioritize
//the overall map working
//---------------------------------------------------------------------
				} else if (b == 0 && count == 1) {
					
					
					// Plays a sound whenever the turn is done and yes is clicked
					File sound = new File("sounds/TurnSwitch.wav");
					try {
						Clip clip = AudioSystem.getClip();
						clip.open(AudioSystem.getAudioInputStream(sound));
						clip.start();
					} catch (Exception e) {
						e.printStackTrace();
					}
					

					// System.out.println("Entered GameB B==0");
					count = 3;
					mrX.setVisible(true);
					detective.setVisible(false);
					
					//sets up mrX in MapPanel
					map2.setXInvisible(false);
					map2.getMrX().setHasMoved(1);
					
					// Tests the victory screen
					// turncounter = 24;

					lblTaxiDAmount.setVisible(false);
					lblTaxiXAmount.setVisible(true);

					lblBusDAmount.setVisible(false);
					lblBusXAmount.setVisible(true);

					lblTubeDAmount.setVisible(false);
					lblTubeXAmount.setVisible(true);

					lbBlackTicket.setVisible(true);
					X2TicketIcon.setVisible(true);

					lbBlackTicketAmount.setVisible(true);
					X2Amount.setVisible(true);

					VictoryCheck();

					b = 1;

					// System.out.println("GameBoard B = " + b);

				}

			}
		});
		btnYes.setIcon(new ImageIcon("images/Yes2.png"));
		btnYes.setBackground(Color.DARK_GRAY);
		btnYes.setBounds(647, 511, 170, 100);
		btnYes.setToolTipText("Remember, you must move all of your pieces");

		contentPane.add(btnYes);
		btnYes.setVisible(false);

		

//------------------------------------------------------------------------------------------

//----Labels below----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

//------------------------------------------------------------------------------------------	
// Creates the scotlandyard icon on the top right of the screen
//------------------------------------------------------------------------------------------	
		
		JLabel rules = new JLabel("");
		rules.setIcon(new ImageIcon("images/YardRules.png"));
		//rules.setToolTipText(" +"2| Detectives only see Mr.X log when he surfaces /n" +"3| Bobbies do not use cards /n"+ "4|Mr.X wins when he plays 22 moves \n"+"5| Detectives win if Mr.X is surrounded or they are on top of him");
		rules.setToolTipText("<html>" + "1| You must make a move" + "<br>" + "2| Detectives only see Mr.X log when he surfaces" + "<br>" + "3| Bobbies do not use cards" + "<br>" + "4| Mr.X wins when he plays 22 moves" + "<br>" + "5| Detectives win if Mr.X is surrounded or they are on top of him" + "<br>"+ "6| Mr.X can use black tickets to travel via ferry" + "<br>"+ "7| If Mr.X uses a double card and he must reveal himself on the first move, he will for a short period and then make his second move" + "<br>"+ "8| To make a move select the point you wish to go to then select the ticket you wish to use" + "<br>"+ "9| If a multi color circle appears it means you can use multiple transportation cards" + "<html>");
		rules.setBounds(21, 78, 123, 46);
		contentPane.add(rules);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon("images/ScotlandYardIcon.jpg"));
		logo.setBounds(828, 47, 100, 97);
		contentPane.add(logo);

		// Creates the title at the top middle of the screen
		JLabel title = new JLabel("");
		title.setIcon(new ImageIcon("GIFS/title.gif"));
		title.setBounds(732, 0, 270, 46);
		contentPane.add(title);

		// Creates the turn image
		JLabel Turn = new JLabel("");
		Turn.setIcon(new ImageIcon("images/Turn3.png"));
		Turn.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		Turn.setForeground(Color.WHITE);
		Turn.setBounds(385, 27, 231, 68);
		contentPane.add(Turn);

//------------------------------------------------------------------------------------------	
		// Creates the two Mr.X and Detective image text which will be swapped out
		// depending on whos turn it is
//------------------------------------------------------------------------------------------	
		// Creates the MR X image/text - Will need to be altered

		mrX.setIcon(new ImageIcon("images/MrX2.png"));
		mrX.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		mrX.setForeground(Color.WHITE);
		mrX.setBounds(395, 92, 374, 75);
		contentPane.add(mrX);

		// Creates Detective Image/text

		detective.setIcon(new ImageIcon("images/Detective3.png"));
		detective.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		detective.setForeground(Color.WHITE);
		detective.setBounds(395, 92, 374, 75);
		contentPane.add(detective);
		// Detective is hidden on start
		detective.setVisible(false);

	}

//------------------------------------------------------------------------------------------
//Button Logic below
//------------------------------------------------------------------------------------------
	// Handles the logic for buttons using a flag in this case it is i
	public void ButtonActions(int i) {

		if (i == 1) {
			// i = 0;\
			System.out.println("Entered I == 1");
			super.TravelLog();

			// Spare Else if will leave for future expandibility
		} else if (i == 2) {
			// i = 0;

		} else if (i == 3) {
			// i = 0;
			super.CAvailabale();

			// Hide buttons makes BLUR visible (TURNS BLUR ON)
		} else if (i == 4) {

			System.out.println("Entered GB Super BLUR");

			btnNo.setVisible(true);
			btnYes.setVisible(true);
			lblBlur.setVisible(true);
			btnMoves.setVisible(false);
			btnCardsAvailable.setVisible(false);
			btnEndTurn.setVisible(false);
			btnTravelLog.setVisible(false);
			Map.setVisible(false);
			i = 0;
			// super.EndTurnS();

		} else if (i == 5) {

			btnNo.setVisible(false);
			btnYes.setVisible(false);

			lblBlur.setVisible(false);
			btnMoves.setVisible(true);
			btnCardsAvailable.setVisible(false);
			btnEndTurn.setVisible(true);
			btnTravelLog.setVisible(true);

		}

	}

	public void VictoryCheck() {

		System.out.println("Entered VictoryCheck");

		//If Mr.X survives for this number of rounds then he has won
		if (turncounter >= 22) {

			System.out.println("Entered If VictoryCheck");

			GameBoard frameV = new GameBoard();
			frameV.setVisible(true);

			frameV.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frameV.setBounds(100, 100, 450, 300);
			contentPane = new JPanel();
			contentPane.setBackground(Color.DARK_GRAY);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			frameV.setContentPane(contentPane);
			contentPane.setLayout(null);

			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon("images/Victor.png"));
			lblNewLabel.setBounds(50, 11, 333, 49);
			contentPane.add(lblNewLabel);

			JLabel lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon("images/MrX2.png"));
			lblNewLabel_1.setBounds(47, 117, 336, 74);
			contentPane.add(lblNewLabel_1);

			JLabel lblNewLabel_2 = new JLabel("");
			lblNewLabel_2.setIcon(new ImageIcon("GIFS/giphy (1).gif"));
			lblNewLabel_2.setBounds(0, 0, 434, 261);
			contentPane.add(lblNewLabel_2);

			//This check does not work as i lack others code as it was not completed yet
			//But the flag should indicate if the detective have surrounded MR.x or are on top of him
			//If it is true then the detectives win
		} else if (checkCloseBy == "true") {

			GameBoard frameV = new GameBoard();
			frameV.setVisible(true);

			frameV.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frameV.setBounds(100, 100, 450, 300);
			contentPane = new JPanel();
			contentPane.setBackground(Color.DARK_GRAY);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			frameV.setContentPane(contentPane);
			contentPane.setLayout(null);

			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon("images/Victor.png"));
			lblNewLabel.setBounds(50, 11, 333, 49);
			contentPane.add(lblNewLabel);

			JLabel lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon("images/Detective3.png"));
			lblNewLabel_1.setBounds(47, 117, 336, 74);
			contentPane.add(lblNewLabel_1);

			JLabel lblNewLabel_2 = new JLabel("");
			lblNewLabel_2.setIcon(new ImageIcon("GIFS/giphy (1).gif"));
			lblNewLabel_2.setBounds(0, 0, 434, 261);
			contentPane.add(lblNewLabel_2);

		}

	}

//------------------------------------------------------------------------------------------

}
