package UserSideP;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class CatBrowser extends JFrame {

	private JPanel contentPane;
	JLabel[][] CategoryLabelArray = new JLabel[3][5];
	static String row = "";;
	String[][] csvCategories = new String[3][5];
	JLabel[][] GameLabelArray;
	GamePreview preview = new GamePreview();
	
	//This will later be replaced by a file array which stores images
	//For now numbers will be used for testing
	//There are 15 categories and each can store 15 + game images (Will be a variable later)
	int[][]testNumArray = new int[16][15];
	
	// Constructor
	public CatBrowser() {
		System.out.println("test");

		CatBrowserGUI();

	}

	// Contains all the GUI components
	public void CatBrowserGUI() {
		
		try {
			importData();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// Label Array

		// Custom border
		Border border = BorderFactory.createLineBorder(new Color(6, 47, 255), 3);

		
		
		// Puts labels into the label array for the categories
		for (int i = 0; i < 3; i++) {
			for (int c = 0; c < 5; c++) {
				CategoryLabelArray[i][c] = new JLabel(csvCategories[i][c]);
			}
		}
		System.out.println("Launched GUI");
		// JFrame settings
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 870);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// GUI Components

		JPanel TopPanel = new JPanel();
		TopPanel.setBackground(Color.LIGHT_GRAY);
		TopPanel.setBounds(0, 0, 884, 181);
		contentPane.add(TopPanel);
		TopPanel.setLayout(null);

		JLabel Title = new JLabel("Category");
		Title.setBounds(0, 0, 884, 33);
		TopPanel.add(Title);

		JLabel ColumnBorderL = new JLabel("");
		ColumnBorderL.setBorder(border);
		ColumnBorderL.setForeground(Color.WHITE);
		ColumnBorderL.setBackground(Color.RED);
		ColumnBorderL.setBounds(0, 36, 280, 145);
		TopPanel.add(ColumnBorderL);

		JLabel ColumnBorderM = new JLabel("");
		ColumnBorderM.setBorder(border);
		ColumnBorderM.setBackground(Color.RED);
		ColumnBorderM.setBounds(302, 36, 280, 145);
		TopPanel.add(ColumnBorderM);

		JLabel ColumnBorderR = new JLabel("");
		ColumnBorderR.setBorder(border);
		ColumnBorderR.setBackground(Color.RED);
		ColumnBorderR.setBounds(604, 36, 280, 145);
		TopPanel.add(ColumnBorderR);

		JPanel CatPanelL = new JPanel();
		CatPanelL.setBounds(0, 36, 280, 145);
		TopPanel.add(CatPanelL);
		CatPanelL.setLayout(new GridLayout(5, 0, 0, 1));

		JPanel CatPanelM = new JPanel();
		CatPanelM.setBounds(302, 36, 280, 145);
		TopPanel.add(CatPanelM);
		CatPanelM.setLayout(new GridLayout(5, 0, 0, 1));

		JPanel CatPanelR = new JPanel();
		CatPanelR.setBounds(604, 36, 280, 145);
		TopPanel.add(CatPanelR);
		CatPanelR.setLayout(new GridLayout(5, 0, 0, 1));

		JPanel BottomPanel = new JPanel();
		BottomPanel.setBounds(0, 742, 884, 89);
		contentPane.add(BottomPanel);

		// Adds labels to all 3 columns
		// Left Column
		for (int c = 0; c < 5; c++) {

			CatPanelL.add(CategoryLabelArray[0][c]);
			CategoryLabelArray[0][c].setBorder(border);
			CategoryLabelArray[0][c].setVisible(true);
			
		}
		// Middle Column
		for (int c = 0; c < 5; c++) {
			CatPanelM.add(CategoryLabelArray[1][c]);
			CategoryLabelArray[1][c].setBorder(border);
			CategoryLabelArray[1][c].setVisible(true);
		}
		// Right Column
		for (int c = 0; c < 5; c++) {
			CatPanelR.add(CategoryLabelArray[2][c]);
			CategoryLabelArray[2][c].setBorder(border);
			CategoryLabelArray[2][c].setVisible(true);

		}

		JPanel GamePanel = new JPanel();
		GamePanel.setBackground(Color.DARK_GRAY);
		GamePanel.setBounds(0, 181, 884, 561);
		contentPane.add(GamePanel);
		GamePanel.setLayout(new GridLayout(3, 5, 1, 1));

		GameLabelArray = new JLabel[3][5];

		int count = 0;
		//For the game labels
		// Adds labels into the array
		for (int i = 0; i < 3; i++) {
			for (int c = 0; c < 5; c++) {
				GameLabelArray[i][c] = new JLabel("" + count);
				GameLabelArray[i][c].setHorizontalAlignment(SwingConstants.CENTER);
				GameLabelArray[i][c].setFont(new Font("Tahoma", Font.BOLD, 25));
				count++;
			}
		}

		
		
		for (int i = 0; i < 3; i++) {
			for (int c = 0; c < 5; c++) {
				GamePanel.add(GameLabelArray[i][c]);
				GameLabelArray[i][c].setBorder(border);
				GameLabelArray[i][c].setVisible(true);
			}
			// LabelArray[0][c] = new JLabel();

		}

		labelActions();

	}

	// Imports categoryData from csv file
	public void importData() throws IOException {
		System.out.println("---------------");
		String path = "Files\\Categories.csv";

		BufferedReader br = new BufferedReader(new FileReader(path));
		int i = 0;
		while ((row = br.readLine()) != null) {

			String[] temp = row.split(",");

			System.out.println("");
			System.out.println(temp[0]);
			System.out.println("");
			System.out.println(temp[1]);
			System.out.println("");
			System.out.println(temp[2]);
			System.out.println("");
			System.out.println(temp[3]);
			System.out.println("");
			System.out.println(temp[4]);
			System.out.println("---------");

			csvCategories[i][0] = temp[0];
			csvCategories[i][1] = temp[1];
			csvCategories[i][2] = temp[2];
			csvCategories[i][3] = temp[3];
			csvCategories[i][4] = temp[4];

			i++;
		}

		System.out.println(Arrays.deepToString(csvCategories));

		//Fills all the indexes of the testNumArray (Each number represents a individual image)
		int labelNum = 1;
		int count = 0;
		for(int x = 0; x < 15; x++) {
			while(count < 15) {
				//System.out.println("Test");
				testNumArray[x][count] = labelNum;
				count++;
				labelNum++;
			}
			count = 0;
			//System.out.println("Test2222222222222222");
			
		}
		
		System.out.println(Arrays.deepToString(testNumArray));
		
		
	}

	// Handles all the actions of the labels
	public void labelActions() {
		
		
//Category Labels
//-------------------------------------------------------------------------------------------

//Left Column	
//============================================================================================

		CategoryLabelArray[0][0].addMouseListener(new MouseAdapter() {
			// ImageIcon imageIcon = new ImageIcon(new
			// ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\LoginHover.png").getImage().getScaledInstance(249,
			// 74, Image.SCALE_DEFAULT));

			// Checking if the mouse enteres the label
			public void mouseEntered(MouseEvent me) {

				// Updates the border with a specific orange
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				CategoryLabelArray[0][0].setBorder(border);
				// Switches the lbl to a new image while mouse is hovering over JLabel
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\LoginHover2.png"));

				// System.out.println("Hovering");
			}

			// Checking if the mouse exited the JLabel bounds
			public void mouseExited(MouseEvent me) {

				Border border = BorderFactory.createLineBorder(Color.GREEN, 3);
				CategoryLabelArray[0][0].setBorder(border);
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\Login2.png"));

				// System.out.println("Not Hovering");
			}

			// Checks if the Jlabel is pressed and then released
			public void mousePressed(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				CategoryLabelArray[0][0].setBorder(border);
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\LoginPressed2.png"));

			}

			public void mouseReleased(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(Color.GREEN, 3);
				CategoryLabelArray[0][0].setBorder(border);
				int flag = 1;
				updateLabels(flag);
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\Login2.png"));

			}

		});

		CategoryLabelArray[0][1].addMouseListener(new MouseAdapter() {
			// ImageIcon imageIcon = new ImageIcon(new
			// ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\LoginHover.png").getImage().getScaledInstance(249,
			// 74, Image.SCALE_DEFAULT));

			// Checking if the mouse enteres the label
			public void mouseEntered(MouseEvent me) {

				// Updates the border with a specific orange
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				CategoryLabelArray[0][1].setBorder(border);
				// Switches the lbl to a new image while mouse is hovering over JLabel
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\LoginHover2.png"));

				// System.out.println("Hovering");
			}

			// Checking if the mouse exited the JLabel bounds
			public void mouseExited(MouseEvent me) {

				Border border = BorderFactory.createLineBorder(Color.GREEN, 3);
				CategoryLabelArray[0][1].setBorder(border);
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\Login2.png"));

				// System.out.println("Not Hovering");
			}

			// Checks if the Jlabel is pressed and then released
			public void mousePressed(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				CategoryLabelArray[0][1].setBorder(border);
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\LoginPressed2.png"));

			}

			public void mouseReleased(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(Color.GREEN, 3);
				CategoryLabelArray[0][1].setBorder(border);
				int flag = 2;
				updateLabels(flag);
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\Login2.png"));

			}

		});

		CategoryLabelArray[0][2].addMouseListener(new MouseAdapter() {
			// ImageIcon imageIcon = new ImageIcon(new
			// ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\LoginHover.png").getImage().getScaledInstance(249,
			// 74, Image.SCALE_DEFAULT));

			// Checking if the mouse enteres the label
			public void mouseEntered(MouseEvent me) {

				// Updates the border with a specific orange
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				CategoryLabelArray[0][2].setBorder(border);
				// Switches the lbl to a new image while mouse is hovering over JLabel
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\LoginHover2.png"));

				// System.out.println("Hovering");
			}

			// Checking if the mouse exited the JLabel bounds
			public void mouseExited(MouseEvent me) {

				Border border = BorderFactory.createLineBorder(Color.GREEN, 3);
				CategoryLabelArray[0][2].setBorder(border);
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\Login2.png"));

				// System.out.println("Not Hovering");
			}

			// Checks if the Jlabel is pressed and then released
			public void mousePressed(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				CategoryLabelArray[0][2].setBorder(border);
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\LoginPressed2.png"));

			}

			public void mouseReleased(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(Color.GREEN, 3);
				CategoryLabelArray[0][2].setBorder(border);
				int flag = 3;
				updateLabels(flag);
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\Login2.png"));

			}

		});

		CategoryLabelArray[0][3].addMouseListener(new MouseAdapter() {
			// ImageIcon imageIcon = new ImageIcon(new
			// ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\LoginHover.png").getImage().getScaledInstance(249,
			// 74, Image.SCALE_DEFAULT));

			// Checking if the mouse enteres the label
			public void mouseEntered(MouseEvent me) {

				// Updates the border with a specific orange
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				CategoryLabelArray[0][3].setBorder(border);
				// Switches the lbl to a new image while mouse is hovering over JLabel
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\LoginHover2.png"));

				// System.out.println("Hovering");
			}

			// Checking if the mouse exited the JLabel bounds
			public void mouseExited(MouseEvent me) {

				Border border = BorderFactory.createLineBorder(Color.GREEN, 3);
				CategoryLabelArray[0][3].setBorder(border);
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\Login2.png"));

				// System.out.println("Not Hovering");
			}

			// Checks if the Jlabel is pressed and then released
			public void mousePressed(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				CategoryLabelArray[0][3].setBorder(border);
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\LoginPressed2.png"));

			}

			public void mouseReleased(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(Color.GREEN, 3);
				CategoryLabelArray[0][3].setBorder(border);
				int flag = 4;
				updateLabels(flag);
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\Login2.png"));

			}

		});

		CategoryLabelArray[0][4].addMouseListener(new MouseAdapter() {
			// ImageIcon imageIcon = new ImageIcon(new
			// ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\LoginHover.png").getImage().getScaledInstance(249,
			// 74, Image.SCALE_DEFAULT));

			// Checking if the mouse enteres the label
			public void mouseEntered(MouseEvent me) {

				// Updates the border with a specific orange
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				CategoryLabelArray[0][4].setBorder(border);
				// Switches the lbl to a new image while mouse is hovering over JLabel
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\LoginHover2.png"));

				// System.out.println("Hovering");
			}

			// Checking if the mouse exited the JLabel bounds
			public void mouseExited(MouseEvent me) {

				Border border = BorderFactory.createLineBorder(Color.GREEN, 3);
				CategoryLabelArray[0][4].setBorder(border);
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\Login2.png"));

				// System.out.println("Not Hovering");
			}

			// Checks if the Jlabel is pressed and then released
			public void mousePressed(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				CategoryLabelArray[0][4].setBorder(border);
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\LoginPressed2.png"));

			}

			public void mouseReleased(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(Color.GREEN, 3);
				CategoryLabelArray[0][4].setBorder(border);
				int flag = 5;
				updateLabels(flag);
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\Login2.png"));

			}

		});

//Middle Column	
//============================================================================================

		CategoryLabelArray[1][0].addMouseListener(new MouseAdapter() {
			// ImageIcon imageIcon = new ImageIcon(new
			// ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\LoginHover.png").getImage().getScaledInstance(249,
			// 74, Image.SCALE_DEFAULT));

			// Checking if the mouse enteres the label
			public void mouseEntered(MouseEvent me) {

				// Updates the border with a specific orange
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				CategoryLabelArray[1][0].setBorder(border);
				// Switches the lbl to a new image while mouse is hovering over JLabel
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\LoginHover2.png"));

				// System.out.println("Hovering");
			}

			// Checking if the mouse exited the JLabel bounds
			public void mouseExited(MouseEvent me) {

				Border border = BorderFactory.createLineBorder(Color.GREEN, 3);
				CategoryLabelArray[1][0].setBorder(border);
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\Login2.png"));

				// System.out.println("Not Hovering");
			}

			// Checks if the Jlabel is pressed and then released
			public void mousePressed(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				CategoryLabelArray[1][0].setBorder(border);
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\LoginPressed2.png"));

			}

			public void mouseReleased(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(Color.GREEN, 3);
				CategoryLabelArray[1][0].setBorder(border);
				int flag = 6;
				updateLabels(flag);
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\Login2.png"));

			}

		});

		CategoryLabelArray[1][1].addMouseListener(new MouseAdapter() {
			// ImageIcon imageIcon = new ImageIcon(new
			// ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\LoginHover.png").getImage().getScaledInstance(249,
			// 74, Image.SCALE_DEFAULT));

			// Checking if the mouse enteres the label
			public void mouseEntered(MouseEvent me) {

				// Updates the border with a specific orange
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				CategoryLabelArray[1][1].setBorder(border);
				// Switches the lbl to a new image while mouse is hovering over JLabel
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\LoginHover2.png"));

				// System.out.println("Hovering");
			}

			// Checking if the mouse exited the JLabel bounds
			public void mouseExited(MouseEvent me) {

				Border border = BorderFactory.createLineBorder(Color.GREEN, 3);
				CategoryLabelArray[1][1].setBorder(border);
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\Login2.png"));

				// System.out.println("Not Hovering");
			}

			// Checks if the Jlabel is pressed and then released
			public void mousePressed(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				CategoryLabelArray[1][1].setBorder(border);
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\LoginPressed2.png"));

			}

			public void mouseReleased(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(Color.GREEN, 3);
				CategoryLabelArray[1][1].setBorder(border);
				int flag = 7;
				updateLabels(flag);
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\Login2.png"));

			}

		});

		CategoryLabelArray[1][2].addMouseListener(new MouseAdapter() {
			// ImageIcon imageIcon = new ImageIcon(new
			// ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\LoginHover.png").getImage().getScaledInstance(249,
			// 74, Image.SCALE_DEFAULT));

			// Checking if the mouse enteres the label
			public void mouseEntered(MouseEvent me) {

				// Updates the border with a specific orange
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				CategoryLabelArray[1][2].setBorder(border);
				// Switches the lbl to a new image while mouse is hovering over JLabel
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\LoginHover2.png"));

				// System.out.println("Hovering");
			}

			// Checking if the mouse exited the JLabel bounds
			public void mouseExited(MouseEvent me) {

				Border border = BorderFactory.createLineBorder(Color.GREEN, 3);
				CategoryLabelArray[1][2].setBorder(border);
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\Login2.png"));

				// System.out.println("Not Hovering");
			}

			// Checks if the Jlabel is pressed and then released
			public void mousePressed(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				CategoryLabelArray[1][2].setBorder(border);
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\LoginPressed2.png"));

			}

			public void mouseReleased(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(Color.GREEN, 3);
				CategoryLabelArray[1][2].setBorder(border);
				int flag = 8;
				updateLabels(flag);
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\Login2.png"));

			}

		});

		CategoryLabelArray[1][3].addMouseListener(new MouseAdapter() {
			// ImageIcon imageIcon = new ImageIcon(new
			// ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\LoginHover.png").getImage().getScaledInstance(249,
			// 74, Image.SCALE_DEFAULT));

			// Checking if the mouse enteres the label
			public void mouseEntered(MouseEvent me) {

				// Updates the border with a specific orange
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				CategoryLabelArray[1][3].setBorder(border);
				// Switches the lbl to a new image while mouse is hovering over JLabel
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\LoginHover2.png"));

				// System.out.println("Hovering");
			}

			// Checking if the mouse exited the JLabel bounds
			public void mouseExited(MouseEvent me) {

				Border border = BorderFactory.createLineBorder(Color.GREEN, 3);
				CategoryLabelArray[1][3].setBorder(border);
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\Login2.png"));

				// System.out.println("Not Hovering");
			}

			// Checks if the Jlabel is pressed and then released
			public void mousePressed(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				CategoryLabelArray[1][3].setBorder(border);
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\LoginPressed2.png"));

			}

			public void mouseReleased(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(Color.GREEN, 3);
				CategoryLabelArray[1][3].setBorder(border);
				int flag = 9;
				updateLabels(flag);
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\Login2.png"));

			}

		});

		CategoryLabelArray[1][4].addMouseListener(new MouseAdapter() {
			// ImageIcon imageIcon = new ImageIcon(new
			// ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\LoginHover.png").getImage().getScaledInstance(249,
			// 74, Image.SCALE_DEFAULT));

			// Checking if the mouse enteres the label
			public void mouseEntered(MouseEvent me) {

				// Updates the border with a specific orange
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				CategoryLabelArray[1][4].setBorder(border);
				// Switches the lbl to a new image while mouse is hovering over JLabel
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\LoginHover2.png"));

				// System.out.println("Hovering");
			}

			// Checking if the mouse exited the JLabel bounds
			public void mouseExited(MouseEvent me) {

				Border border = BorderFactory.createLineBorder(Color.GREEN, 3);
				CategoryLabelArray[1][4].setBorder(border);
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\Login2.png"));

				// System.out.println("Not Hovering");
			}

			// Checks if the Jlabel is pressed and then released
			public void mousePressed(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				CategoryLabelArray[1][4].setBorder(border);
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\LoginPressed2.png"));

			}

			public void mouseReleased(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(Color.GREEN, 3);
				CategoryLabelArray[1][4].setBorder(border);
				int flag = 10;
				updateLabels(flag);
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\Login2.png"));

			}

		});

//Right Column	
//============================================================================================

		CategoryLabelArray[2][0].addMouseListener(new MouseAdapter() {
			// ImageIcon imageIcon = new ImageIcon(new
			// ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\LoginHover.png").getImage().getScaledInstance(249,
			// 74, Image.SCALE_DEFAULT));

			// Checking if the mouse enteres the label
			public void mouseEntered(MouseEvent me) {

				// Updates the border with a specific orange
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				CategoryLabelArray[2][0].setBorder(border);
				// Switches the lbl to a new image while mouse is hovering over JLabel
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\LoginHover2.png"));

				// System.out.println("Hovering");
			}

			// Checking if the mouse exited the JLabel bounds
			public void mouseExited(MouseEvent me) {

				Border border = BorderFactory.createLineBorder(Color.GREEN, 3);
				CategoryLabelArray[2][0].setBorder(border);
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\Login2.png"));

				// System.out.println("Not Hovering");
			}

			// Checks if the Jlabel is pressed and then released
			public void mousePressed(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				CategoryLabelArray[2][0].setBorder(border);
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\LoginPressed2.png"));

			}

			public void mouseReleased(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(Color.GREEN, 3);
				CategoryLabelArray[2][0].setBorder(border);
				int flag = 11;
				updateLabels(flag);
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\Login2.png"));

			}

		});

		CategoryLabelArray[2][1].addMouseListener(new MouseAdapter() {
			// ImageIcon imageIcon = new ImageIcon(new
			// ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\LoginHover.png").getImage().getScaledInstance(249,
			// 74, Image.SCALE_DEFAULT));

			// Checking if the mouse enteres the label
			public void mouseEntered(MouseEvent me) {

				// Updates the border with a specific orange
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				CategoryLabelArray[2][1].setBorder(border);
				// Switches the lbl to a new image while mouse is hovering over JLabel
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\LoginHover2.png"));

				// System.out.println("Hovering");
			}

			// Checking if the mouse exited the JLabel bounds
			public void mouseExited(MouseEvent me) {

				Border border = BorderFactory.createLineBorder(Color.GREEN, 3);
				CategoryLabelArray[2][1].setBorder(border);
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\Login2.png"));

				// System.out.println("Not Hovering");
			}

			// Checks if the Jlabel is pressed and then released
			public void mousePressed(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				CategoryLabelArray[2][1].setBorder(border);
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\LoginPressed2.png"));

			}

			public void mouseReleased(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(Color.GREEN, 3);
				CategoryLabelArray[2][1].setBorder(border);
				int flag = 12;
				updateLabels(flag);
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\Login2.png"));

			}

		});

		CategoryLabelArray[2][2].addMouseListener(new MouseAdapter() {
			// ImageIcon imageIcon = new ImageIcon(new
			// ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\LoginHover.png").getImage().getScaledInstance(249,
			// 74, Image.SCALE_DEFAULT));

			// Checking if the mouse enteres the label
			public void mouseEntered(MouseEvent me) {

				// Updates the border with a specific orange
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				CategoryLabelArray[2][2].setBorder(border);
				// Switches the lbl to a new image while mouse is hovering over JLabel
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\LoginHover2.png"));

				// System.out.println("Hovering");
			}

			// Checking if the mouse exited the JLabel bounds
			public void mouseExited(MouseEvent me) {

				Border border = BorderFactory.createLineBorder(Color.GREEN, 3);
				CategoryLabelArray[2][2].setBorder(border);
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\Login2.png"));

				// System.out.println("Not Hovering");
			}

			// Checks if the Jlabel is pressed and then released
			public void mousePressed(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				CategoryLabelArray[2][2].setBorder(border);
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\LoginPressed2.png"));

			}

			public void mouseReleased(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(Color.GREEN, 3);
				CategoryLabelArray[2][2].setBorder(border);
				int flag = 13;
				updateLabels(flag);
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\Login2.png"));

			}

		});

		CategoryLabelArray[2][3].addMouseListener(new MouseAdapter() {
			// ImageIcon imageIcon = new ImageIcon(new
			// ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\LoginHover.png").getImage().getScaledInstance(249,
			// 74, Image.SCALE_DEFAULT));

			// Checking if the mouse enteres the label
			public void mouseEntered(MouseEvent me) {

				// Updates the border with a specific orange
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				CategoryLabelArray[2][3].setBorder(border);
				// Switches the lbl to a new image while mouse is hovering over JLabel
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\LoginHover2.png"));

				// System.out.println("Hovering");
			}

			// Checking if the mouse exited the JLabel bounds
			public void mouseExited(MouseEvent me) {

				Border border = BorderFactory.createLineBorder(Color.GREEN, 3);
				CategoryLabelArray[2][3].setBorder(border);
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\Login2.png"));

				// System.out.println("Not Hovering");
			}

			// Checks if the Jlabel is pressed and then released
			public void mousePressed(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				CategoryLabelArray[2][3].setBorder(border);
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\LoginPressed2.png"));

			}

			public void mouseReleased(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(Color.GREEN, 3);
				CategoryLabelArray[2][3].setBorder(border);
				int flag = 14;
				updateLabels(flag);
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\Login2.png"));

			}

		});

		CategoryLabelArray[2][4].addMouseListener(new MouseAdapter() {
			// ImageIcon imageIcon = new ImageIcon(new
			// ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\LoginHover.png").getImage().getScaledInstance(249,
			// 74, Image.SCALE_DEFAULT));

			// Checking if the mouse enteres the label
			public void mouseEntered(MouseEvent me) {

				// Updates the border with a specific orange
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				CategoryLabelArray[2][4].setBorder(border);
				// Switches the lbl to a new image while mouse is hovering over JLabel
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\LoginHover2.png"));

				// System.out.println("Hovering");
			}

			// Checking if the mouse exited the JLabel bounds
			public void mouseExited(MouseEvent me) {

				Border border = BorderFactory.createLineBorder(Color.GREEN, 3);
				CategoryLabelArray[2][4].setBorder(border);
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\Login2.png"));

				// System.out.println("Not Hovering");
			}

			// Checks if the Jlabel is pressed and then released
			public void mousePressed(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				CategoryLabelArray[2][4].setBorder(border);
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\LoginPressed2.png"));

			}

			public void mouseReleased(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(Color.GREEN, 3);
				CategoryLabelArray[2][4].setBorder(border);
				int flag = 15;
				updateLabels(flag);
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\Login2.png"));

			}

		});

		
		
//Game Icon Labels
//-------------------------------------------------------------------------------------------
		
//Top Row
//============================================================================================
		GameLabelArray[0][0].addMouseListener(new MouseAdapter() {
			// ImageIcon imageIcon = new ImageIcon(new
			// ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\LoginHover.png").getImage().getScaledInstance(249,
			// 74, Image.SCALE_DEFAULT));

			// Checking if the mouse enteres the label
			public void mouseEntered(MouseEvent me) {

				// Updates the border with a specific orange
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				GameLabelArray[0][0].setBorder(border);
				// Switches the lbl to a new image while mouse is hovering over JLabel
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\LoginHover2.png"));
			
				// System.out.println("Hovering");
			}

			// Checking if the mouse exited the JLabel bounds
			public void mouseExited(MouseEvent me) {

				Border border = BorderFactory.createLineBorder(Color.CYAN, 3);
				GameLabelArray[0][0].setBorder(border);
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\Login2.png"));

				// System.out.println("Not Hovering");
			}

			// Checks if the Jlabel is pressed and then released
			public void mousePressed(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				GameLabelArray[0][0].setBorder(border);
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\LoginPressed2.png"));

			}

			public void mouseReleased(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(Color.CYAN, 3);
				GameLabelArray[0][0].setBorder(border);
				//Sends the gameIconNumber to the preview class
				preview.gamePreviewGUI(Integer.parseInt(GameLabelArray[0][0].getText()));
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\Login2.png"));

			}

		});
		
		GameLabelArray[0][1].addMouseListener(new MouseAdapter() {
			// ImageIcon imageIcon = new ImageIcon(new
			// ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\LoginHover.png").getImage().getScaledInstance(249,
			// 74, Image.SCALE_DEFAULT));

			// Checking if the mouse enteres the label
			public void mouseEntered(MouseEvent me) {

				// Updates the border with a specific orange
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				GameLabelArray[0][1].setBorder(border);
				// Switches the lbl to a new image while mouse is hovering over JLabel
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\LoginHover2.png"));
				

				// System.out.println("Hovering");
			}

			// Checking if the mouse exited the JLabel bounds
			public void mouseExited(MouseEvent me) {

				Border border = BorderFactory.createLineBorder(Color.CYAN, 3);
				GameLabelArray[0][1].setBorder(border);
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\Login2.png"));

				// System.out.println("Not Hovering");
			}

			// Checks if the Jlabel is pressed and then released
			public void mousePressed(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				GameLabelArray[0][1].setBorder(border);
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\LoginPressed2.png"));

			}

			public void mouseReleased(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(Color.CYAN, 3);
				GameLabelArray[0][1].setBorder(border);
				preview.gamePreviewGUI(Integer.parseInt(GameLabelArray[0][1].getText()));
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\Login2.png"));

			}

		});
		
		GameLabelArray[0][2].addMouseListener(new MouseAdapter() {
			// ImageIcon imageIcon = new ImageIcon(new
			// ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\LoginHover.png").getImage().getScaledInstance(249,
			// 74, Image.SCALE_DEFAULT));

			// Checking if the mouse enteres the label
			public void mouseEntered(MouseEvent me) {

				// Updates the border with a specific orange
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				GameLabelArray[0][2].setBorder(border);
				// Switches the lbl to a new image while mouse is hovering over JLabel
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\LoginHover2.png"));
				
				// System.out.println("Hovering");
			}

			// Checking if the mouse exited the JLabel bounds
			public void mouseExited(MouseEvent me) {

				Border border = BorderFactory.createLineBorder(Color.CYAN, 3);
				GameLabelArray[0][2].setBorder(border);
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\Login2.png"));

				// System.out.println("Not Hovering");
			}

			// Checks if the Jlabel is pressed and then released
			public void mousePressed(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				GameLabelArray[0][2].setBorder(border);
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\LoginPressed2.png"));

			}

			public void mouseReleased(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(Color.CYAN, 3);
				GameLabelArray[0][2].setBorder(border);
				preview.gamePreviewGUI(Integer.parseInt(GameLabelArray[0][2].getText()));
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\Login2.png"));

			}

		});
		
		GameLabelArray[0][3].addMouseListener(new MouseAdapter() {
			// ImageIcon imageIcon = new ImageIcon(new
			// ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\LoginHover.png").getImage().getScaledInstance(249,
			// 74, Image.SCALE_DEFAULT));

			// Checking if the mouse enteres the label
			public void mouseEntered(MouseEvent me) {

				// Updates the border with a specific orange
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				GameLabelArray[0][3].setBorder(border);
				// Switches the lbl to a new image while mouse is hovering over JLabel
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\LoginHover2.png"));
				
				// System.out.println("Hovering");
			}

			// Checking if the mouse exited the JLabel bounds
			public void mouseExited(MouseEvent me) {

				Border border = BorderFactory.createLineBorder(Color.CYAN, 3);
				GameLabelArray[0][3].setBorder(border);
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\Login2.png"));

				// System.out.println("Not Hovering");
			}

			// Checks if the Jlabel is pressed and then released
			public void mousePressed(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				GameLabelArray[0][3].setBorder(border);
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\LoginPressed2.png"));

			}

			public void mouseReleased(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(Color.CYAN, 3);
				GameLabelArray[0][3].setBorder(border);
				preview.gamePreviewGUI(Integer.parseInt(GameLabelArray[0][3].getText()));
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\Login2.png"));

			}

		});
		
		GameLabelArray[0][4].addMouseListener(new MouseAdapter() {
			// ImageIcon imageIcon = new ImageIcon(new
			// ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\LoginHover.png").getImage().getScaledInstance(249,
			// 74, Image.SCALE_DEFAULT));

			// Checking if the mouse enteres the label
			public void mouseEntered(MouseEvent me) {

				// Updates the border with a specific orange
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				GameLabelArray[0][4].setBorder(border);
				// Switches the lbl to a new image while mouse is hovering over JLabel
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\LoginHover2.png"));
				// System.out.println("Hovering");
			}

			// Checking if the mouse exited the JLabel bounds
			public void mouseExited(MouseEvent me) {

				Border border = BorderFactory.createLineBorder(Color.CYAN, 3);
				GameLabelArray[0][4].setBorder(border);
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\Login2.png"));

				// System.out.println("Not Hovering");
			}

			// Checks if the Jlabel is pressed and then released
			public void mousePressed(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				GameLabelArray[0][4].setBorder(border);
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\LoginPressed2.png"));

			}

			public void mouseReleased(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(Color.CYAN, 3);
				GameLabelArray[0][4].setBorder(border);
				preview.gamePreviewGUI(Integer.parseInt(GameLabelArray[0][4].getText()));
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\Login2.png"));

			}

		});
		
		
//Middle Row
//============================================================================================
		
		GameLabelArray[1][0].addMouseListener(new MouseAdapter() {
			// ImageIcon imageIcon = new ImageIcon(new
			// ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\LoginHover.png").getImage().getScaledInstance(249,
			// 74, Image.SCALE_DEFAULT));

			// Checking if the mouse enteres the label
			public void mouseEntered(MouseEvent me) {

				// Updates the border with a specific orange
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				GameLabelArray[1][0].setBorder(border);
				// Switches the lbl to a new image while mouse is hovering over JLabel
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\LoginHover2.png"));
			
				// System.out.println("Hovering");
			}

			// Checking if the mouse exited the JLabel bounds
			public void mouseExited(MouseEvent me) {

				Border border = BorderFactory.createLineBorder(Color.CYAN, 3);
				GameLabelArray[1][0].setBorder(border);
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\Login2.png"));

				// System.out.println("Not Hovering");
			}

			// Checks if the Jlabel is pressed and then released
			public void mousePressed(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				GameLabelArray[1][0].setBorder(border);
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\LoginPressed2.png"));

			}

			public void mouseReleased(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(Color.CYAN, 3);
				GameLabelArray[1][0].setBorder(border);
				preview.gamePreviewGUI(Integer.parseInt(GameLabelArray[1][0].getText()));
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\Login2.png"));

			}

		});
		
		GameLabelArray[1][1].addMouseListener(new MouseAdapter() {
			// ImageIcon imageIcon = new ImageIcon(new
			// ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\LoginHover.png").getImage().getScaledInstance(249,
			// 74, Image.SCALE_DEFAULT));

			// Checking if the mouse enteres the label
			public void mouseEntered(MouseEvent me) {

				// Updates the border with a specific orange
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				GameLabelArray[1][1].setBorder(border);
				// Switches the lbl to a new image while mouse is hovering over JLabel
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\LoginHover2.png"));
				

				// System.out.println("Hovering");
			}

			// Checking if the mouse exited the JLabel bounds
			public void mouseExited(MouseEvent me) {

				Border border = BorderFactory.createLineBorder(Color.CYAN, 3);
				GameLabelArray[1][1].setBorder(border);
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\Login2.png"));

				// System.out.println("Not Hovering");
			}

			// Checks if the Jlabel is pressed and then released
			public void mousePressed(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				GameLabelArray[1][1].setBorder(border);
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\LoginPressed2.png"));

			}

			public void mouseReleased(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(Color.CYAN, 3);
				GameLabelArray[1][1].setBorder(border);
				preview.gamePreviewGUI(Integer.parseInt(GameLabelArray[1][1].getText()));
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\Login2.png"));

			}

		});
		
		GameLabelArray[1][2].addMouseListener(new MouseAdapter() {
			// ImageIcon imageIcon = new ImageIcon(new
			// ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\LoginHover.png").getImage().getScaledInstance(249,
			// 74, Image.SCALE_DEFAULT));

			// Checking if the mouse enteres the label
			public void mouseEntered(MouseEvent me) {

				// Updates the border with a specific orange
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				GameLabelArray[1][2].setBorder(border);
				// Switches the lbl to a new image while mouse is hovering over JLabel
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\LoginHover2.png"));
				
				// System.out.println("Hovering");
			}

			// Checking if the mouse exited the JLabel bounds
			public void mouseExited(MouseEvent me) {

				Border border = BorderFactory.createLineBorder(Color.CYAN, 3);
				GameLabelArray[1][2].setBorder(border);
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\Login2.png"));

				// System.out.println("Not Hovering");
			}

			// Checks if the Jlabel is pressed and then released
			public void mousePressed(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				GameLabelArray[1][2].setBorder(border);
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\LoginPressed2.png"));

			}

			public void mouseReleased(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(Color.CYAN, 3);
				GameLabelArray[1][2].setBorder(border);
				preview.gamePreviewGUI(Integer.parseInt(GameLabelArray[1][2].getText()));
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\Login2.png"));

			}

		});
		
		GameLabelArray[1][3].addMouseListener(new MouseAdapter() {
			// ImageIcon imageIcon = new ImageIcon(new
			// ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\LoginHover.png").getImage().getScaledInstance(249,
			// 74, Image.SCALE_DEFAULT));

			// Checking if the mouse enteres the label
			public void mouseEntered(MouseEvent me) {

				// Updates the border with a specific orange
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				GameLabelArray[1][3].setBorder(border);
				// Switches the lbl to a new image while mouse is hovering over JLabel
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\LoginHover2.png"));
				
				// System.out.println("Hovering");
			}

			// Checking if the mouse exited the JLabel bounds
			public void mouseExited(MouseEvent me) {

				Border border = BorderFactory.createLineBorder(Color.CYAN, 3);
				GameLabelArray[1][3].setBorder(border);
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\Login2.png"));

				// System.out.println("Not Hovering");
			}

			// Checks if the Jlabel is pressed and then released
			public void mousePressed(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				GameLabelArray[1][3].setBorder(border);
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\LoginPressed2.png"));

			}

			public void mouseReleased(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(Color.CYAN, 3);
				GameLabelArray[1][3].setBorder(border);
				preview.gamePreviewGUI(Integer.parseInt(GameLabelArray[1][3].getText()));
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\Login2.png"));

			}

		});
		
		GameLabelArray[1][4].addMouseListener(new MouseAdapter() {
			// ImageIcon imageIcon = new ImageIcon(new
			// ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\LoginHover.png").getImage().getScaledInstance(249,
			// 74, Image.SCALE_DEFAULT));

			// Checking if the mouse enteres the label
			public void mouseEntered(MouseEvent me) {

				// Updates the border with a specific orange
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				GameLabelArray[1][4].setBorder(border);
				// Switches the lbl to a new image while mouse is hovering over JLabel
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\LoginHover2.png"));
				// System.out.println("Hovering");
			}

			// Checking if the mouse exited the JLabel bounds
			public void mouseExited(MouseEvent me) {

				Border border = BorderFactory.createLineBorder(Color.CYAN, 3);
				GameLabelArray[1][4].setBorder(border);
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\Login2.png"));

				// System.out.println("Not Hovering");
			}

			// Checks if the Jlabel is pressed and then released
			public void mousePressed(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				GameLabelArray[1][4].setBorder(border);
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\LoginPressed2.png"));

			}

			public void mouseReleased(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(Color.CYAN, 3);
				GameLabelArray[1][4].setBorder(border);
				preview.gamePreviewGUI(Integer.parseInt(GameLabelArray[1][4].getText()));
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\Login2.png"));

			}

		});
		
//Bottom Row
//============================================================================================
		
		GameLabelArray[2][0].addMouseListener(new MouseAdapter() {
			// ImageIcon imageIcon = new ImageIcon(new
			// ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\LoginHover.png").getImage().getScaledInstance(249,
			// 74, Image.SCALE_DEFAULT));

			// Checking if the mouse enteres the label
			public void mouseEntered(MouseEvent me) {

				// Updates the border with a specific orange
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				GameLabelArray[2][0].setBorder(border);
				// Switches the lbl to a new image while mouse is hovering over JLabel
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\LoginHover2.png"));
			
				// System.out.println("Hovering");
			}

			// Checking if the mouse exited the JLabel bounds
			public void mouseExited(MouseEvent me) {

				Border border = BorderFactory.createLineBorder(Color.CYAN, 3);
				GameLabelArray[2][0].setBorder(border);
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\Login2.png"));

				// System.out.println("Not Hovering");
			}

			// Checks if the Jlabel is pressed and then released
			public void mousePressed(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				GameLabelArray[1][0].setBorder(border);
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\LoginPressed2.png"));

			}

			public void mouseReleased(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(Color.CYAN, 3);
				GameLabelArray[2][0].setBorder(border);
				preview.gamePreviewGUI(Integer.parseInt(GameLabelArray[2][0].getText()));
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\Login2.png"));

			}

		});
		
		GameLabelArray[2][1].addMouseListener(new MouseAdapter() {
			// ImageIcon imageIcon = new ImageIcon(new
			// ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\LoginHover.png").getImage().getScaledInstance(249,
			// 74, Image.SCALE_DEFAULT));

			// Checking if the mouse enteres the label
			public void mouseEntered(MouseEvent me) {

				// Updates the border with a specific orange
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				GameLabelArray[2][1].setBorder(border);
				// Switches the lbl to a new image while mouse is hovering over JLabel
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\LoginHover2.png"));
				

				// System.out.println("Hovering");
			}

			// Checking if the mouse exited the JLabel bounds
			public void mouseExited(MouseEvent me) {

				Border border = BorderFactory.createLineBorder(Color.CYAN, 3);
				GameLabelArray[2][1].setBorder(border);
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\Login2.png"));

				// System.out.println("Not Hovering");
			}

			// Checks if the Jlabel is pressed and then released
			public void mousePressed(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				GameLabelArray[2][1].setBorder(border);
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\LoginPressed2.png"));

			}

			public void mouseReleased(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(Color.CYAN, 3);
				GameLabelArray[2][1].setBorder(border);
				preview.gamePreviewGUI(Integer.parseInt(GameLabelArray[2][1].getText()));
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\Login2.png"));

			}

		});
		
		GameLabelArray[2][2].addMouseListener(new MouseAdapter() {
			// ImageIcon imageIcon = new ImageIcon(new
			// ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\LoginHover.png").getImage().getScaledInstance(249,
			// 74, Image.SCALE_DEFAULT));

			// Checking if the mouse enteres the label
			public void mouseEntered(MouseEvent me) {

				// Updates the border with a specific orange
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				GameLabelArray[2][2].setBorder(border);
				// Switches the lbl to a new image while mouse is hovering over JLabel
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\LoginHover2.png"));
				
				// System.out.println("Hovering");
			}

			// Checking if the mouse exited the JLabel bounds
			public void mouseExited(MouseEvent me) {

				Border border = BorderFactory.createLineBorder(Color.CYAN, 3);
				GameLabelArray[2][2].setBorder(border);
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\Login2.png"));

				// System.out.println("Not Hovering");
			}

			// Checks if the Jlabel is pressed and then released
			public void mousePressed(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				GameLabelArray[2][2].setBorder(border);
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\LoginPressed2.png"));

			}

			public void mouseReleased(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(Color.CYAN, 3);
				GameLabelArray[2][2].setBorder(border);
				preview.gamePreviewGUI(Integer.parseInt(GameLabelArray[2][2].getText()));
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\Login2.png"));

			}

		});
		
		GameLabelArray[2][3].addMouseListener(new MouseAdapter() {
			// ImageIcon imageIcon = new ImageIcon(new
			// ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\LoginHover.png").getImage().getScaledInstance(249,
			// 74, Image.SCALE_DEFAULT));

			// Checking if the mouse enteres the label
			public void mouseEntered(MouseEvent me) {

				// Updates the border with a specific orange
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				GameLabelArray[2][3].setBorder(border);
				// Switches the lbl to a new image while mouse is hovering over JLabel
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\LoginHover2.png"));
				
				// System.out.println("Hovering");
			}

			// Checking if the mouse exited the JLabel bounds
			public void mouseExited(MouseEvent me) {

				Border border = BorderFactory.createLineBorder(Color.CYAN, 3);
				GameLabelArray[2][3].setBorder(border);
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\Login2.png"));

				// System.out.println("Not Hovering");
			}

			// Checks if the Jlabel is pressed and then released
			public void mousePressed(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				GameLabelArray[2][3].setBorder(border);
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\LoginPressed2.png"));

			}

			public void mouseReleased(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(Color.CYAN, 3);
				GameLabelArray[2][3].setBorder(border);
				preview.gamePreviewGUI(Integer.parseInt(GameLabelArray[2][3].getText()));
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\Login2.png"));

			}

		});
		
		GameLabelArray[2][4].addMouseListener(new MouseAdapter() {
			// ImageIcon imageIcon = new ImageIcon(new
			// ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\LoginHover.png").getImage().getScaledInstance(249,
			// 74, Image.SCALE_DEFAULT));

			// Checking if the mouse enteres the label
			public void mouseEntered(MouseEvent me) {

				// Updates the border with a specific orange
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				GameLabelArray[2][4].setBorder(border);
				// Switches the lbl to a new image while mouse is hovering over JLabel
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\LoginHover2.png"));
				// System.out.println("Hovering");
			}

			// Checking if the mouse exited the JLabel bounds
			public void mouseExited(MouseEvent me) {

				Border border = BorderFactory.createLineBorder(Color.CYAN, 3);
				GameLabelArray[2][4].setBorder(border);
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\Login2.png"));

				// System.out.println("Not Hovering");
			}

			// Checks if the Jlabel is pressed and then released
			public void mousePressed(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				GameLabelArray[2][4].setBorder(border);
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\LoginPressed2.png"));

			}

			public void mouseReleased(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(Color.CYAN, 3);
				GameLabelArray[2][4].setBorder(border);
				
				preview.gamePreviewGUI(Integer.parseInt(GameLabelArray[2][4].getText()));
				// CategoryLabelArray[0][0].setIcon(new
				// ImageIcon("DVTImages\\Login\\Login2.png"));

			}

		});
		
		
	}

	//Updates all the labels based on the category chosen
	public void updateLabels(int category) {
		
		
		//The -1 is there just to adjust for the counting. As by accident i started the count at 1 instead of 0 (Was lazy to re-type all those flags)
		//the +5 is there so that the entire array gets displayed instead of having duplicate cows
		System.out.println("Category is:"+category);
		for(int i = 0; i < 5; i ++) {
			System.out.println("test");
			GameLabelArray[0][i].setText(""+testNumArray[category-1][i]);
		}
		
		for(int i = 0; i < 5; i ++) {
			GameLabelArray[1][i].setText(""+testNumArray[category-1][i+5]);
		}
		
		for(int i = 0; i < 5; i ++) { 
			GameLabelArray[2][i].setText(""+testNumArray[category-1][i+10]);
		}
		System.out.println("Updated Labels");
		
	}
	
	
	
	
	
	
}



