/* Name:Pierce Pokorny  
 * Date:January 26th
 * Course Code:ICS3U1
 * Title:Pierce's Maze Runner
 * Desc:Opens a GUI maze Runner which the player has to collect 10 coins the quickest they can
 * 
 * Added Optional Features: 
 * 1) Added Sonic icon changes direction depending on input(goes left icon looks left) 
 * 2) Added JOptionPane to announce the player has won.
 * 3) Added when the user closes the JOptionPane the game closes
 * 4) Added a ready check to ask the user if their ready, if not the program shuts down, if yes the game will begin.
 * 5) Added labels for the time and score  (Timer = 5    Score = 6 etc)
 * 6) Added a header in the score board ("Pierce's Maze")
 * 7) Added a font for the Timer and score label
 * 8) Added character selection (Mario/Sonic) (Selection is done through a JOptionPane) 
 * 9) Added a sound effect for when the game begins (WARNING - is fairly loud)
 * 10) Added a sound effect for the ending of the game 
 * 11) Added a sound effect for the pick up of a coin
 * 12) Added a more precise timer
 * 
 * Major Skills: GUI panels including ,JFrame, JLabel etc. All kinds of loops including if statements
 * Constant variables and image / file importing. ActionListener for key inputs. Many methods and getters and setters.
 * Multiple classes
 * 
 * 
 * 
 * Areas Of concern:
 * None
 * 
 * 
 */

import java.awt.Font;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import javax.print.attribute.standard.Media;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

//This class has all the code for the maze GUI

public class MazeRaceGUI extends JFrame implements KeyListener, ActionListener {

	

	
	private static final int NUM_COINS = 0;

	// Constants
	private final int CELL_SIZE = 25;
	private final int CELL_COINS = 10;
	private final int NUM_CELLS_WIDTH = 27;
	private final int NUM_CELLS_HEIGHT = 27;
	
	
	public static final int MILSECS = 1000;
    
    //60 secs in a min
    public static final int SECS = 60;
    
    //
    public static final int MIN = 60;
    
    //mins:secs:millisecs
    private static final String TIME_FORMAT = "%02d:%02d:%03d";
    
    //delays the start of the timer
    private static final int TIMER_DELAY = 15;
	
	

	private final ImageIcon WALL = new ImageIcon("images/red square.png");
	private final ImageIcon OUT_OF_BOUNDS = new ImageIcon("images/black square.png");
	private final ImageIcon PATH = new ImageIcon("images/grey square.png");
	private final ImageIcon COIN = new ImageIcon("images/gold coin.gif");

	// Sets the image of the default player
	private Player player1 = new Player("images/sonic1.gif");
	private int ANSWER;
	

	private int numCoinsCollected = 0;
	private int time = 0;

	// Creates the labels
	private JPanel scoreboardPanel = new JPanel(null);
	
	private Timer gameTimer = new Timer(TIMER_DELAY, this);
	private JLabel gametime = new JLabel("0");
	private long startTime;
	private JLabel scoreLabel = new JLabel("0");
	//Score and time Labels
	private JLabel scoreDesc = new JLabel("Coins =");
	private JLabel timerDesc = new JLabel("Time =");
	private JLabel header = new JLabel("Pierce's Maze");

	// Variables
	private JPanel mazePanel = new JPanel(new GridBagLayout());
	private GridBagConstraints gridConstraints = new GridBagConstraints();
	private Cell[][] maze = new Cell[NUM_CELLS_WIDTH][NUM_CELLS_HEIGHT];
	

	
	
	
	

	

	// Constructor Method
	public MazeRaceGUI() {
		// Methods
		scoreboardPanelSetup();
		mazePanelSetup();
		frameSetup();
	}

	// This is at the top of the GUI showing the time and score
	private void scoreboardPanelSetup() {

		// Creates a font variable that can be used to be assigned to labels
		Font font1 = new Font("SansSerif", Font.ITALIC, 16);

		// Assigns this font to the labels
		scoreDesc.setFont(font1);
		timerDesc.setFont(font1);

		// Bounds of the score board panel
		scoreboardPanel.setLayout(null);
		scoreboardPanel.setBounds(0, 0, CELL_SIZE * NUM_CELLS_WIDTH, 50);

		// Score board bounds
		header.setBounds(scoreboardPanel.getWidth() / 2, 5, 100, 20);
		
		// Centers the header
		header.setHorizontalAlignment(JTextField.CENTER);
		scoreboardPanel.add(gametime);
		// Bounds of the score labels
		scoreDesc.setBounds(scoreboardPanel.getWidth() / 50, 5, 100, 20);
		timerDesc.setBounds(scoreboardPanel.getWidth() / 50, 30, 100, 20);
		
		// Bounds of the score numbers
		scoreLabel.setBounds(scoreboardPanel.getWidth() / 8, 5, 100, 20);
		gametime.setBounds(scoreboardPanel.getWidth() / 8, 30, 100, 20);
		
		header.setFont(font1);
		scoreDesc.setFont(font1);
		timerDesc.setFont(font1);
		
		// Makes the labels visible on the score board panel
		scoreboardPanel.add(scoreLabel);
		
		scoreboardPanel.add(scoreDesc);
		scoreboardPanel.add(timerDesc);
		scoreboardPanel.add(header);

		// Opens up the JOptionPane and asks the user for the character of their choice
		Object[] choices = { "Mario", "Sonic" };
		Object defaultChoice = choices[0];
		int Charresult1 = JOptionPane.showOptionDialog(this, "Pick a character", "", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, choices, defaultChoice);

		// If they pick Mario a value will be asigned to a variable and then used for
		// the gif in code below
		if (Charresult1 == JOptionPane.YES_OPTION) {
			ANSWER = 1;

		}

	}

	// Sets up the maze and makes the methods
	private void mazePanelSetup() {
		//Sets the bounds of the maze panel
		mazePanel.setBounds(0, 50, CELL_SIZE * NUM_CELLS_WIDTH, CELL_SIZE * NUM_CELLS_HEIGHT);
		
		// Calls the methods
		loadMaze();
		placeCoins();
		placePlayer();

		// Grabs the file
		

	}

	// Loads up the maze and intitializes everything
	private void loadMaze() {

		int row = 0;
		char[] line;
		
		// tries to find the text file
		try {

			Scanner input = new Scanner(new File("maze.txt"));
			// loops around to read the file
			while (input.hasNext()) {

				line = input.nextLine().toCharArray();

				for (int column = 0; column < line.length; column++)
					fillCell(line[column], row, column);

				row++;

			}

			input.close();

		} catch (FileNotFoundException error) {

			System.out.println("File error:" + error);
		}

	}

	// Places the coins in a random spot
	private void placeCoins() {

		// Plops up a JOptionPane to ready check the user
		
		
		int result = JOptionPane.showConfirmDialog(null, "Are you ready??", "Ready Check", JOptionPane.YES_NO_OPTION);
		
		// If the user clicks no, the program will shut down
		if (result == JOptionPane.NO_OPTION) {
			System.exit(0);

		}

		// Adds the coins into the maze
		for (int coin = -9; coin <= NUM_COINS; coin++) {

			Cell cell = findEmptyCell(); // Finds an empty cell on a pathway to find the coin

			maze[cell.getRow()][cell.getColumn()].setIcon(COIN);

		}

	}

	// Places the player in a random position
	private void placePlayer() {

		Cell cell = findEmptyCell();

		// Keeps track of the player, so it knows where it is

		player1.setRow(cell.getRow());
		player1.setColumn(cell.getColumn());

		// Sets the character without the need of any key input.
		// If the player picks Mario then Mario will appear(default sonic) without the
		// need of them to move the character for it to update
		if (ANSWER < 1) {
			player1.setIcon(new ImageIcon("images/sonic1.gif"));
		} else {
			player1.setIcon(new ImageIcon("images/mario1.gif"));
		}
		// Gets the icon of the character
		maze[cell.getRow()][cell.getColumn()].setIcon(player1.getIcon());

	}

	// Distinguishes from empty and occupied cells(coins)
	private Cell findEmptyCell() {

		Cell cell = new Cell();// Create an empty cell

		// Does the math and locates empty cells from the text file
		do {

			cell.setRow((int) (Math.random() * 24) + 2);
			cell.setColumn((int) (Math.random() * 24) + 2);

		} while (maze[cell.getRow()][cell.getColumn()].getIcon() != PATH);

		return cell;
	}

	// Fills the cells
	private void fillCell(char character, int row, int column) {

		maze[row][column] = new Cell(row, column);
		// Renders the barriers
		if (character == 'W')
			maze[row][column].setIcon(WALL);
		else if (character == '.')
			maze[row][column].setIcon(PATH);
		else if (character == 'X')
			maze[row][column].setIcon(OUT_OF_BOUNDS);
		// Sets the constraints
		gridConstraints.gridx = column;
		gridConstraints.gridy = row;
		mazePanel.add(maze[row][column], gridConstraints);

	}

	// Sets up the frame
	private void frameSetup() {
		// Sets the title
		setTitle("Pierce's Maze Race");
		setSize(mazePanel.getWidth(), mazePanel.getHeight() + scoreboardPanel.getHeight() + CELL_SIZE);
		setLayout(null);
		// Adds the score board panel and maze
		add(scoreboardPanel);
		add(mazePanel);

		addKeyListener(this);
		// Sets them as visible and non resizable
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		// Timer begins
		gameTimer.start();

	}

	// Triggers the timer
	@Override
	public void actionPerformed(ActionEvent event) {

		if (startTime == 0L) {
            startTime = System.currentTimeMillis();
         } else {
			
			
			  //takes the current time in milliseconds
            long currentTime = System.currentTimeMillis();
            int diffTime = (int) (currentTime - startTime);
            //Sets the Mseconds
            int mSecs = diffTime % MILSECS;
            diffTime /= MILSECS;
            //Sets the Seconds
            int sec = diffTime % SECS;
            diffTime /= SECS;
            //Sets the minutes
            int min = diffTime % MIN;
            diffTime /= MIN;

            //sets the value of the time
            String time = String.format(TIME_FORMAT, min, sec, mSecs);

            //sets the time
            gametime.setText(time);
			

		}

	}

	// Sets the player keybinds(WASD) and enables movement
	@Override
	public void keyPressed(KeyEvent key) {
		// If they pick Mario then the value is 1 and it skips this and goes onto the
		// other controls
		if (ANSWER < 1) {

			// To register the key press from all of the directions
			// Moves up
			if (key.getKeyCode() == KeyEvent.VK_W
					&& maze[player1.getRow() - 1][player1.getColumn() + 0].getIcon() != WALL) {

				player1.setIcon(new ImageIcon("images/sonic0.gif"));
				movePlayer(-1, 0);

				// Move Right
			} else if (key.getKeyCode() == KeyEvent.VK_D
					&& maze[player1.getRow() + 0][player1.getColumn() + 1].getIcon() != WALL) { // If you want the
																								// player to
				// Overrides the default image
				player1.setIcon(new ImageIcon("images/sonic1.gif"));
				movePlayer(0, 1);

				// Move down
			} else if (key.getKeyCode() == KeyEvent.VK_S
					&& maze[player1.getRow() + 1][player1.getColumn() + 0].getIcon() != WALL) { // If you want the
																								// player to

				player1.setIcon(new ImageIcon("images/sonic2.gif"));
				movePlayer(1, 0);

				// move left
			} else if (key.getKeyCode() == KeyEvent.VK_A
					&& maze[player1.getRow() + 0][player1.getColumn() - 1].getIcon() != WALL) { // If you want the
																								// player to

				player1.setIcon(new ImageIcon("images/sonic3.gif"));
				movePlayer(0, -1);

			}

			// Depending on the users choice either Mario or Sonic will show up using these
			// If they choose Mario, the program ignores the Sonic input and the Sonic
			// images and only takes in account the Mario Images

		} else {
			if (key.getKeyCode() == KeyEvent.VK_W
					&& maze[player1.getRow() - 1][player1.getColumn() + 0].getIcon() != WALL) {

				player1.setIcon(new ImageIcon("images/mario0.gif"));
				movePlayer(-1, 0);

				// Move Right
			} else if (key.getKeyCode() == KeyEvent.VK_D
					&& maze[player1.getRow() + 0][player1.getColumn() + 1].getIcon() != WALL) { // If you want the
																								// player to
				// Overrides the default image
				player1.setIcon(new ImageIcon("images/mario1.gif"));
				movePlayer(0, 1);

				// Move down
			} else if (key.getKeyCode() == KeyEvent.VK_S
					&& maze[player1.getRow() + 1][player1.getColumn() + 0].getIcon() != WALL) { // If you want the
																								// player to

				player1.setIcon(new ImageIcon("images/mario2.gif"));
				movePlayer(1, 0);

				// move left
			} else if (key.getKeyCode() == KeyEvent.VK_A
					&& maze[player1.getRow() + 0][player1.getColumn() - 1].getIcon() != WALL) { // If you want the
																								// player to

				player1.setIcon(new ImageIcon("images/mario3.gif"));
				movePlayer(0, -1);

			}

		}

	}

	// Moves the player according to the keyboard input
	private void movePlayer(int dRow, int dColumn) {

		maze[player1.getRow()][player1.getColumn()].setIcon(PATH);

		// Checking what the player is stepping on
		if (maze[player1.getRow() + dRow][player1.getColumn() + dColumn].getIcon() == COIN) {

			numCoinsCollected++;
			File sound2 = new File("coinp.wav");

			// Runs the audio clip at the start of the game
			try {
				Clip clip = AudioSystem.getClip();
				clip.open(AudioSystem.getAudioInputStream(sound2));
				clip.start();
			} catch (Exception e) {
				e.printStackTrace();
			}
			scoreLabel.setText(Integer.toString(numCoinsCollected));

			//

		}

		// Moves the player to a new location also updates icon
		player1.move(dRow, dColumn);
		maze[player1.getRow()][player1.getColumn()].setIcon(player1.getIcon());

		// If there are 10 coins then the user wins
		if (numCoinsCollected == 10) {
			// Grabs the file
			File sound = new File("end.wav");

			// Runs the audio clip at the start of the game
			try {
				Clip clip = AudioSystem.getClip();
				clip.open(AudioSystem.getAudioInputStream(sound));
				clip.start();
			} catch (Exception e) {
				e.printStackTrace();
			}

			// Stops the timer
			gameTimer.stop();
			// Displays the JOPtionPane
			JOptionPane.showMessageDialog(null, "You won!");
			// Closes all windows once the JOptionPane is closed
			System.exit(0);

		}

	}

	@Override // To know when a key is released
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override // To know when a key is pressed or being held
	public void keyTyped(KeyEvent arg0) {

		// TODO Auto-generated method stub

	}
	
	
}
