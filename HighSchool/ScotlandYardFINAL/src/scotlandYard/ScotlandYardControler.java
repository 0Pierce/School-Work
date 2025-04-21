package scotlandYard;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


//Author: Aarib / Pierce(very little)

/*
 * Deals with creating the start screen of the program. Asks the player how many people 
 * are playing. If 2 players, then starts 2 player game. If one player, then asks who 
 * the player wants to play as, and then which difficulty they which to play against(not 
 * implemented correctly)
 */
@SuppressWarnings("serial")
public class ScotlandYardControler extends JFrame implements ActionListener{
	
	//fields:
	
	//Creates all image icons used
	private Icon oneP = new ImageIcon("images/oneplayer.png");
	private Icon twoP = new ImageIcon("images/twoplayer(2).png");
	private Icon police = new ImageIcon("images/DETECTIVE.png");
	private Icon spy = new ImageIcon("images/MRX.png");
	private Icon simple = new ImageIcon("images/EASY DIFFUCULTY.png");
	private Icon complex = new ImageIcon("images/HARD DIFICULTY.png");
	private Icon london = new ImageIcon("images/image.png");
	
	//Creates fields used in later/ prior methods
	private Stack<Integer> startPositionsDetectives = CreateStartPositions.getDetectives();
	private Stack<Integer> startPositionsMrX = CreateStartPositions.getMrX();
	private int playerNumbers;
	private int difficulty;

	//Creates all of the jComponents needed for this frame
	private JFrame players = new JFrame();
	private JButton onePlayer;
	private JButton twoPlayer;
	private JButton detective;
	private JButton mrX;
	private JButton easy;
	private JButton hard;
	private JLabel bg;
	
	//constructor - create and set panel and variables
	public ScotlandYardControler() {
		//set up variables
		playerNumbers = 0;
		difficulty = 0;
		
		//set up panel
		setLayout(null);
		setBackground(Color.BLUE);
		setTitle("Players");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,680);
		
		//methods set up buttons
		createPOneButton();
		createPTwoButton();

		//set up background image
		bg = new JLabel(london);
	    bg.setBounds(0,-50,800,730);
	    
	    //adds everything to panel
		add(onePlayer);
		add(twoPlayer);
		add(bg);
		setVisible(true);
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// 																UTILITY MEHTODS
// ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	//Creates the button to play as detective
	private void createDetectiveButton() {
		
		//Sets up size of the JButton's image
		Image image = ((ImageIcon) police).getImage(); 
		Image newimg = image.getScaledInstance(300, 630,  java.awt.Image.SCALE_SMOOTH);  
		police = new ImageIcon(newimg);
		
		//Creates the JButton with a action when clicked
		detective = new JButton(police);
		detective.setBackground(null);
		detective.setBorder(null);
		detective.setContentAreaFilled(false);
		detective.setBounds(5, 10, 300, 630);
		detective.setVisible(true);
		
		//When clicked, create the option select for difficulty
		detective.addActionListener(new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent e) {
            	System.out.print("OPEN GAME BOARD VS DETECTIVE");
            	createDifficulty(playerNumbers, "Detective");
            }
        });
		
	}

	//Creates the button to play as Mr X
	private void createMrXButton() {
		
		//Sets up size of the JButton's image
		Image image = ((ImageIcon) spy).getImage(); 
		Image newimg = image.getScaledInstance(300, 630,  java.awt.Image.SCALE_SMOOTH);  
		spy = new ImageIcon(newimg);
		
		//Creates the JButton with a action when clicked
		mrX = new JButton(spy);
		mrX.setBackground(null);
		mrX.setBorder(null);
		mrX.setContentAreaFilled(false);
		mrX.setBounds(480, 10, 300, 630);
		mrX.setVisible(true);
		
		//When clicked, create the option select for difficulty
		mrX.addActionListener(new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent e) {
            	System.out.print("OPEN GAME BOARD VS MR X");
            	createDifficulty(playerNumbers, "MrX");
            }
        });
		
	}

	//Sets up both buttons to pick the difficuty of the AI(Unimplemented)
	protected void createDifficulty(int playerNumbers, String playAs) {
		
		//Hides previous buttons
		mrX.setVisible(false);
		detective.setVisible(false);
		
		//Sets up size of the easy computer's JButton's image
		Image image = ((ImageIcon) simple).getImage(); 
		Image newimg = image.getScaledInstance(350, 630,  java.awt.Image.SCALE_SMOOTH);  
		simple = new ImageIcon(newimg);

		//Creates the easy computer's JButton with a action when clicked
		easy = new JButton(simple);
		easy.setBackground(null);
		easy.setBorder(null);
		easy.setContentAreaFilled(false);
		easy.setBounds(0, 10, 350, 630);
		easy.setVisible(true);
		
		//When clicked, Selects easy mode and ends the current JFrame
		easy.addActionListener(new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent e) {
            	System.out.print("OPEN GAME BOARD VS MR X");
            	difficulty=1;
        		new TurnSetup(playerNumbers, playAs, difficulty);
            	dispose();
            }
        });
		
		
		
		//Sets up size of the hard computer's JButton's image
		Image image2 = ((ImageIcon) complex).getImage(); 
		Image newimg2 = image2.getScaledInstance(350, 630,  java.awt.Image.SCALE_SMOOTH);  
		complex = new ImageIcon(newimg2);
		
		//Creates the hard computer's JButton with a action when clicked
		hard = new JButton(complex);
		hard.setBackground(null);
		hard.setBorder(null);
		hard.setContentAreaFilled(false);
		hard.setBounds(430, 10, 350, 630);
		hard.setVisible(true);
		
		//When clicked, Selects hard mode and ends the current JFrame
		hard.addActionListener(new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent e) {
            	System.out.print("OPEN GAME BOARD VS MR X");
            	difficulty=2;
        		new TurnSetup(playerNumbers, playAs, difficulty);
            	dispose();
            }
        });
		
		//adds both buttons to the JFrame
		add(easy);
		add(hard);
		
	}

	//Creates the button to play with 1 person
	private void createPOneButton() {
		
		//Sets up size of the JButton's image
		Image imageTwo = ((ImageIcon) twoP).getImage(); 
		Image newimgTwo = imageTwo.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH);  
		twoP = new ImageIcon(newimgTwo);
		
		//Creates the JButton with a action when clicked
		twoPlayer = new JButton(twoP);
		twoPlayer.setBackground(null);
		twoPlayer.setBorder(null);
		twoPlayer.setContentAreaFilled(false);
		twoPlayer.setBounds(300, 200, 200, 200);
		
		//When clicked, Creates the buttons to select who the player wants to play as
		twoPlayer.addActionListener(new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent e) {
				
				//Hides previous JComponents
				bg.setVisible(false);
				onePlayer.setVisible(false);
				twoPlayer.setVisible(false);
				
				//Creates both JButtons for who the player wants to play as
				createDetectiveButton();
				createMrXButton();
				playerNumbers = 1;

				//Adds both buttons to the JFrame
				add(mrX);
				add(detective);
			}
        });
	}

	//Creates the button to play with 2 people
	private void createPTwoButton() {

		//Sets up size of the JButton's image
		Image image = ((ImageIcon) oneP).getImage(); 
		Image newimg = image.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH);  
		oneP = new ImageIcon(newimg);		

		//Creates the JButton with a action when clicked
		onePlayer = new JButton(oneP);
		onePlayer.setBackground(null);
		onePlayer.setBorder(null);
		onePlayer.setContentAreaFilled(false);
		onePlayer.setBounds(80, 200, 200, 200);

		//When clicked, Selects 2 player mode and ends the current JFrame
		onePlayer.addActionListener(new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent e) {
            	System.out.print("OPEN GAME BOARD");
				playerNumbers = 2;
				new TurnSetup(playerNumbers);
            	dispose();
            }
        });
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	//Getter and Setter methods

	public Icon getOneP() {
		return oneP;
	}

	public void setOneP(Icon oneP) {
		this.oneP = oneP;
	}

	public Icon getTwoP() {
		return twoP;
	}

	public void setTwoP(Icon twoP) {
		this.twoP = twoP;
	}

	public Icon getPolice() {
		return police;
	}

	public void setPolice(Icon police) {
		this.police = police;
	}

	public Icon getSpy() {
		return spy;
	}

	public void setSpy(Icon spy) {
		this.spy = spy;
	}

	public Icon getLondon() {
		return london;
	}

	public void setLondon(Icon london) {
		this.london = london;
	}

	public Stack<Integer> getStartPositionsDetectives() {
		return startPositionsDetectives;
	}

	public void setStartPositionsDetectives(Stack<Integer> startPositionsDetectives) {
		this.startPositionsDetectives = startPositionsDetectives;
	}

	public Stack<Integer> getStartPositionsMrX() {
		return startPositionsMrX;
	}

	public void setStartPositionsMrX(Stack<Integer> startPositionsMrX) {
		this.startPositionsMrX = startPositionsMrX;
	}

	public int getPlayerNumbers() {
		return playerNumbers;
	}

	public void setPlayerNumbers(int playerNumbers) {
		this.playerNumbers = playerNumbers;
	}

	public JFrame getPlayers() {
		return players;
	}

	public void setPlayers(JFrame players) {
		this.players = players;
	}

	public JButton getOnePlayer() {
		return onePlayer;
	}

	public void setOnePlayer(JButton onePlayer) {
		this.onePlayer = onePlayer;
	}

	public JButton getTwoPlayer() {
		return twoPlayer;
	}

	public void setTwoPlayer(JButton twoPlayer) {
		this.twoPlayer = twoPlayer;
	}

	public JButton getDetective() {
		return detective;
	}

	public void setDetective(JButton detective) {
		this.detective = detective;
	}

	public JButton getMrX() {
		return mrX;
	}

	public void setMrX(JButton mrX) {
		this.mrX = mrX;
	}

	public JLabel getBg() {
		return bg;
	}

	public void setBg(JLabel bg) {
		this.bg = bg;
	}

}
