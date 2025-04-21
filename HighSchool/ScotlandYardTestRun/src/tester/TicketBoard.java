package tester;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//Pierce

public class TicketBoard extends SurfaceGUI {

	private JPanel contentPane;

	private int XTaxiAmount = 100, XBusAmount = 100, XTubeAmount = 100;

	TicketBoard frameA;

	public void executeOnce4() {
		// System.out.println("Entered Execute");

		// Runs only once to prevent a duplicate GameBoard
		if (isExecuted4) {
			return;
		} else {

			// System.out.println("SetsupBoard");
			// Count equals 4 because Mr.X does not have any cards yet and needs to be able
			// to end turn once he picked a position
			// Since this is done in the ticketboard i cannot make sure he makes a first
			// move so that is a problem, however,
			// due to time constraints there isnt time to fix this, and realistically it
			// isnt a big problem as this only occurs once
			// For more on the count flag look around in GameBoard and TicketBoard

			System.out.println("Created TicketBoard");

			this.frameA = new TicketBoard();
			frameA.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

			frameA.setVisible(true);
			frameA.setResizable(false);

			isExecuted4 = true;

		}
	}

	public TicketBoard() {

		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		System.out.println("Entered ticket Constructor");
		CardsAvailableGUI();

	}

	// Setsup the GUI panel and does the button logic
	public void CardsAvailableGUI() {

		setBounds(100, 100, 496, 400);
		// setVisible(true);
		setResizable(false);
		setLayout(null);

//-------------------------------------------------------------------------------

		JLabel TicketBoard = new JLabel("");
		TicketBoard.setIcon(new ImageIcon("images/TicketBoard.png"));
		TicketBoard.setBounds(0, 0, 480, 90);
		TicketBoard
				.setToolTipText("After selecting a piece and your destination simply click on the ticket to go there ");
		contentPane.add(TicketBoard);

//-----------------------------------------------------------------------------------------------

		

		// Thought process
		/*
		 * Person clicks on point they wanna go to, Ticketboard updates and only shows
		 * available cards, then a card is picked and the player moves to that spot via
		 * that card
		 * 
		 * There will be Ifs and a flag that comes from the moves class that will
		 * determine which card will be visible
		 *
		 * Will have to be implemented during code fusion to see how it all works
		 * together
		 * 
		 */
		
		
		JLabel lblLightRain = new JLabel("");
		lblLightRain.setIcon(new ImageIcon("images/LightRain.gif"));
		lblLightRain.setBounds(0, 107, 480, 361);
		contentPane.add(lblLightRain);
		

		JLabel lblTaxi = new JLabel("");
		lblTaxi.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {

				// If b = 1 that means its Mr.Xs turn, this will then check the count and
				// display none if there are no cards
				// If b = 0 it means its the detectives turn and the same thing happens
				// Pretty much the same for every other button

				//The count lets me be able to ensure that Mr.X can only play one card
				//and that the detectives can play twice since there are 2 detectives on the board.
				
				//If Mr.x triggers the 2X card then he will be able to play 3 times
				//(First time was the 2X card, then the other 2 times are the two moves he can make
				//Sadly this is not implemented into the actual game logic since i am waiting for that to be finished
				if (b == 0 && DTaxiAmount >= 1 && count >= 2) {
					
					
					
					moveFlag = 1;

					//Plays the sound
					File sound = new File("CardPick.wav");
					try {
						Clip clip = AudioSystem.getClip();
						clip.open(AudioSystem.getAudioInputStream(sound));
						clip.start();
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					//---------------------------------------------------
					// System.out.println("Entered Taxi 0 IF");
					DTaxiAmount--;

					count--;

					//Updates the detective taxi lbl
					lblTaxiDAmount.setText("" + DTaxiAmount);
					makeMove();
					
					
				} else if (b == 0 && DTaxiAmount < 1) {
					lblTaxiDAmount.setText("None");

				}

				//B == 1 (Mr.X)
				if (b == 1 && XTaxiAmount >= 1 && count == 3) {

					moveFlag = 1;
					
					
					File sound = new File("CardPick.wav");
					try {
						Clip clip = AudioSystem.getClip();
						clip.open(AudioSystem.getAudioInputStream(sound));
						clip.start();
					} catch (Exception e) {
						e.printStackTrace();
					}

					int c = 1;
					turncount++;
					count = 0;
					sendCard(c);
					// System.out.println("Entered Taxi 1 IF");
					XTaxiAmount--;

					
					lblTaxiDAmount.setText("" + DTaxiAmount);
				} else if (b == 0 && XTaxiAmount < 1) {
					lblTaxiXAmount.setText("None");

				}

			}
		});
		lblTaxi.setIcon(new ImageIcon("images/TaxiTicket.png"));
		lblTaxi.setBounds(38, 210, 107, 62);
		contentPane.add(lblTaxi);

//----------------------------------------------------------------------------------------------------------------

		JLabel lblBus = new JLabel("");
		lblBus.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {

				System.out.println(XBusAmount);

				if (b == 0 && DBusAmount >= 1 && count >= 2) {
					
					
					moveFlag = 2;

					File sound = new File("CardPick.wav");
					try {
						Clip clip = AudioSystem.getClip();
						clip.open(AudioSystem.getAudioInputStream(sound));
						clip.start();
					} catch (Exception e) {
						e.printStackTrace();
					}

					// System.out.println("Entered Bus 0 IF");
					DBusAmount--;

					count--;

					lblBusDAmount.setText("" + DBusAmount);
					// lblBusXAmount.setText("" + XBusAmount);
				} else if (b == 0 && DBusAmount < 1) {
					lblBusDAmount.setText("None");

				}

				if (b == 1 && XBusAmount > 1 && count >= 3 && count <= 5) {

					
					moveFlag = 2;
					
					// System.out.println("Entered Bus 1 IF");

					File sound = new File("CardPick.wav");
					try {
						Clip clip = AudioSystem.getClip();
						clip.open(AudioSystem.getAudioInputStream(sound));
						clip.start();
					} catch (Exception e) {
						e.printStackTrace();
					}

					int c = 2;
					turncount++;
					count = 0;
					sendCard(c);
					XBusAmount--;

					lblBusDAmount.setText("" + DBusAmount);
					// lblBusXAmount.setText("" + XBusAmount);
				} else if (b == 0 && XBusAmount < 1) {
					lblBusDAmount.setText("None");

				}

			}
		});
		lblBus.setIcon(new ImageIcon("images/BusTicket.png"));
		lblBus.setBounds(185, 210, 107, 62);
		contentPane.add(lblBus);

//---------------------------------------------------------------------------------------------------------------------

		JLabel lblTube = new JLabel("");
		lblTube.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {

				System.out.println(count);

				
				
				//Add the flag which will determine if the card can be used
				//While the turn is 0 (Detective and the amount of cards is > 1 & count >
				if (b == 0 && DTubeAmount >= 1 && count >= 2) {
					
					moveFlag = 3;
					
					//If valid move = call makeMove();

					System.out.println("Entered TUBE 0 IF");

					//Plays a sound
					File sound = new File("CardPick.wav");
					try {
						Clip clip = AudioSystem.getClip();
						clip.open(AudioSystem.getAudioInputStream(sound));
						clip.start();
					} catch (Exception e) {
						e.printStackTrace();
					}

					count--;
					DTubeAmount--;
					lblTubeDAmount.setText("" + DTubeAmount);
					// lblTubeXAmount.setText("" + XTubeAmount);
				} else if (b == 0 && DTubeAmount < 1) {
					lblTubeDAmount.setText("None");

				}

				if (b == 1 && XTubeAmount > 1 && count >= 3 && count <= 5) {

					moveFlag = 3;
					
					File sound = new File("CardPick.wav");
					try {
						Clip clip = AudioSystem.getClip();
						clip.open(AudioSystem.getAudioInputStream(sound));
						clip.start();
					} catch (Exception e) {
						e.printStackTrace();
					}

					int c = 3;
					turncount++;
					count--;

					sendCard(c);
					// lblTubeXAmount.setText("" + XTubeAmount);
					lblTubeDAmount.setText("" + DTubeAmount);
				}

			}
		});

		lblTube.setIcon(new ImageIcon("images/TubeTicket.png"));
		lblTube.setBounds(335, 210, 107, 62);
		contentPane.add(lblTube);

		// Setsup the special tickets
		lbBlackTicket.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {

				System.out.println(b);
				System.out.println(XBlackAmount);
				System.out.println(count + "Count");

				if (b == 1 && XBlackAmount > 1 && count == 3) {

					File sound = new File("CardPick.wav");
					try {
						Clip clip = AudioSystem.getClip();
						clip.open(AudioSystem.getAudioInputStream(sound));
						clip.start();
					} catch (Exception e) {
						e.printStackTrace();
					}

					XBlackAmount--;
					lbBlackTicketAmount.setText("" + XBlackAmount);
					int c = 4;
					turncount++;
					count = 0;
					System.out.println("Entered BlackTicket");

					sendCard(c);
					// lbBlackTicketAmount.setText("" + XBlackAmount);

				}

			}
		});
		lbBlackTicket.setIcon(new ImageIcon("images/BlackTicket.png"));
		lbBlackTicket.setBounds(0, 97, 120, 73);
		lbBlackTicket.setToolTipText("Lets you hide your mode of transportation on the travel log");
		contentPane.add(lbBlackTicket);

		X2TicketIcon.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {

				// Lets the player chose 2 cards after they pick this one
				if (b == 1 && X2TicketAmount > 1 && count == 3) {

					File sound = new File("CardPick.wav");
					try {
						Clip clip = AudioSystem.getClip();
						clip.open(AudioSystem.getAudioInputStream(sound));
						clip.start();
					} catch (Exception e) {
						e.printStackTrace();
					}

					int c = 5;
					turncount++;
					count++;

					System.out.println("Entered X2TICKET");

					sendCard(c);
					X2TicketAmount--;
					X2Amount.setText("" + X2TicketAmount);

				}

			}
		});
		X2TicketIcon.setIcon(new ImageIcon("images/DoubleMove.png"));
		X2TicketIcon.setBounds(380, 101, 100, 73);
		X2TicketIcon.setToolTipText("Lets you make two moves, make sure you have two other cards available");
		contentPane.add(X2TicketIcon);

//-----------------------------------------------------------------------------------------------------------

		JLabel lblRemaining = new JLabel("");
		lblRemaining.setIcon(new ImageIcon("images/Remaining.png"));
		lblRemaining.setBounds(95, 101, 289, 69);
		contentPane.add(lblRemaining);

//Creates the taxi label for Mr.X and Detective
//------------------------------------------------------------------------------------
		lblTaxiDAmount.setForeground(Color.YELLOW);
		lblTaxiDAmount.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblTaxiDAmount.setBounds(38, 283, 107, 67);
		lblTaxiDAmount.setHorizontalAlignment(JLabel.CENTER);
		contentPane.add(lblTaxiDAmount);
		lblTaxiDAmount.setVisible(false);

		lblTaxiXAmount.setForeground(Color.YELLOW);
		lblTaxiXAmount.setIcon(new ImageIcon("images/Infinity.png"));

		lblTaxiXAmount.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblTaxiXAmount.setBounds(38, 283, 107, 67);
		lblTaxiXAmount.setHorizontalAlignment(JLabel.CENTER);
		contentPane.add(lblTaxiXAmount);

//Creates the Bus label for Mr.X and Detective
//---------------------------------------------------------------------------

		lblBusDAmount.setForeground(Color.CYAN);
		lblBusDAmount.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblBusDAmount.setBounds(185, 283, 107, 67);
		lblBusDAmount.setHorizontalAlignment(JLabel.CENTER);
		contentPane.add(lblBusDAmount);
		lblBusDAmount.setVisible(false);

		lblBusXAmount.setForeground(Color.CYAN);
		lblBusXAmount.setIcon(new ImageIcon("images/Infinity.png"));
		lblBusXAmount.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblBusXAmount.setBounds(185, 283, 107, 67);
		lblBusXAmount.setHorizontalAlignment(JLabel.CENTER);
		contentPane.add(lblBusXAmount);

//Creates the Bus Label for Mr.X and Detective
//------------------------------------------------------------------------------------

		lblTubeDAmount.setForeground(Color.RED);
		lblTubeDAmount.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblTubeDAmount.setBounds(335, 283, 107, 67);
		lblTubeDAmount.setHorizontalAlignment(JLabel.CENTER);
		contentPane.add(lblTubeDAmount);
		lblTubeDAmount.setVisible(false);

		lblTubeXAmount.setForeground(Color.RED);
		lblTubeXAmount.setIcon(new ImageIcon("images/Infinity.png"));
		lblTubeXAmount.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblTubeXAmount.setBounds(335, 283, 107, 67);
		lblTubeXAmount.setHorizontalAlignment(JLabel.CENTER);
		contentPane.add(lblTubeXAmount);

		lbBlackTicketAmount.setFont(new Font("Tahoma", Font.BOLD, 30));
		lbBlackTicketAmount.setHorizontalAlignment(JLabel.CENTER);
		lbBlackTicketAmount.setBounds(10, 159, 93, 48);
		lbBlackTicketAmount.setForeground(Color.BLUE);
		contentPane.add(lbBlackTicketAmount);

		X2Amount.setFont(new Font("Tahoma", Font.BOLD, 30));
		X2Amount.setHorizontalAlignment(JLabel.CENTER);
		X2Amount.setForeground(Color.BLUE);
		X2Amount.setBounds(387, 159, 93, 48);
		contentPane.add(X2Amount);
		
		
		

	}

	public void sendCard(int c) {

		// System.out.println("Entered sendCard in TBoard");
		super.TravelLogPlaceCard(c);
	}

}
