package EstimatedValueLandPackage;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import Controller.MenuFrame;

/**
 * This class creates the frame used to display all the data about farmland values
 * @author Daphne Ho
 *
 */
public class LVFrame extends JFrame implements ActionListener {

	// CONSTANTS
	public static final int PANELS_X = 10;
	public static final int PANELS_Y = 200;
	public static final int PANELS_LENGTH = 430;
	
	public static final Color BLUE = new Color(153, 217, 234);
	public static final Color LIGHT_BLUE = new Color(241, 246, 251);

	// FIELDS
	private JLabel titleLabel = new JLabel("Estimated Value of Land");
	private JButton[] yearButtons = new JButton[6];
	private JPanel titlePanel = new JPanel();
	private JLayeredPane dataPane = new JLayeredPane();

	public static LVBarGraphPanel barGraphPanel = new LVBarGraphPanel();
	public static LVGrowthPanel growthPanel = new LVGrowthPanel();

	private JMenuBar menubar = new JMenuBar();
	private JMenu LVMenu = new JMenu("Menu");
	private JMenuItem[] LVdatabaseArray = new JMenuItem[3];


	// CONSTRUCTOR
	public LVFrame() {
		
		// frame setup
		setLayout(null);
		setTitle("Estimated Value of Land");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(LIGHT_BLUE);
		setSize(1000, 900);
		setResizable(false);

		// MENU
		// array for menu items - used to switch between graphs
		LVdatabaseArray[0] = new JMenuItem("Total Farm Area");
		LVdatabaseArray[1] = new JMenuItem("Estimated Rental Rate");
		LVdatabaseArray[2] = new JMenuItem("Rental Rate : Land Value");

		// adding items to the menu
		for (JMenuItem item : LVdatabaseArray) {
			LVMenu.add(item);
			item.addActionListener(this);
		}

		menubar.add(LVMenu);
		setJMenuBar(menubar);

		// BUTTONS
		setupYearButtons();

		// HEADER
		titleLabel.setBounds(225, 10, 600, 100);
		titleLabel.setFont(new Font("helvetica", Font.BOLD, 30));

		titlePanel.add(titleLabel);
		titlePanel.setBackground(BLUE);
		titlePanel.setBounds(0, 0, 1000, 100);
		
		dataPane.setBounds(0, 0, 1000, 900);
		dataPane.setOpaque(true);
		dataPane.setBackground(LIGHT_BLUE);
		
		// add elements to frame
		add(titlePanel);
		dataPane.add(barGraphPanel, Integer.valueOf(0));
		dataPane.add(growthPanel, Integer.valueOf(0));
		add(dataPane);
		
		// make frame visible
		setVisible(false);
	}

	/**
	 * This method sets up the year buttons 
	 */
	private void setupYearButtons() {

		// create a string array to hold the text for each year button
		String[] yearArray = { "1991", "1996", "2001", "2006", "2011", "2016" };

		// starting coordinates
		int x = 275;
		int y = 110;

		// create buttons
		for (int index = 0; index < 6; index++) {

			// separate the button locations
			if (index > 0)
				x += 75;

			// setup and create buttons
			yearButtons[index] = new JButton();
			yearButtons[index].setBounds(x, y, 60, 20);
			yearButtons[index].setBackground(BLUE);
			yearButtons[index].setText(yearArray[index]);
			yearButtons[index].setFont(new Font("helvetica", Font.BOLD, 15));
			yearButtons[index].setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
			yearButtons[index].setForeground(Color.white);
			yearButtons[index].addActionListener(this);
			add(yearButtons[index]);

		}
		
		// disable 2016 button - the 2016 user will be automatically on
		yearButtons[5].setEnabled(false);

	}

	/**
	 * This method runs the code when an action is performed (year button or menu is clicked)
	 */
	public void actionPerformed(ActionEvent event) {

		// JMenu items - used to switch between other graphs
		// downcasting - check if the source is coming form the drop down menu
		if (event.getSource() instanceof JMenuItem) {

			JMenuItem menuItem = (JMenuItem) event.getSource();

			// get the item menu's text
			String dataType;
			dataType = menuItem.getText();

			// show the frame according to the item the user chose
			if (dataType == "Total Farm Area") {
				setVisible(false);
				MenuFrame.FarmArea2.setVisible(true);


				
			}

			else if (dataType == "Estimated Rental Rate") {
				System.out.println("Entered ERR");
				setVisible(false);
				MenuFrame.RentalRateFrame.setVisible(true);

			}

			else if (dataType == "Rental Rate : Land Value") {
				System.out.println("Entered RRLV");
				setVisible(false);
				MenuFrame.RatioFrame.setVisible(true);

				
			}

		}

		// ActionListener for the buttons
		// used to switch between graph display of different years
		if (event.getSource() instanceof JButton) {

			// enable all buttons
			for (int index = 0; index < 6; index ++) 
				yearButtons[index].setEnabled(true);
			
			JButton currentButton = (JButton) event.getSource();

			// get the text in the button
			int yearNum = Integer.valueOf(currentButton.getText());

			int indexNum;
			
			// change the data being displayed accordingly
			if (yearNum == 1991) {
				
				indexNum = 0;
				
				// change bar graph
				barGraphPanel.setCurrentYear(0);
				barGraphPanel.setBarGraph();
				barGraphPanel.setupBarLabels();
				
				// change growth panel
				growthPanel.setYearLabel(String.valueOf(yearNum));
				growthPanel.setPercentageLabel(0, indexNum);
				growthPanel.setValueLabel(0, indexNum);
				
				// disable clicked button
				yearButtons[indexNum].setEnabled(false);
				
			}

			else if (yearNum == 1996) {
				
				indexNum = 1;
				
				barGraphPanel.setCurrentYear(1);
				barGraphPanel.setBarGraph();
				barGraphPanel.setupBarLabels();
				growthPanel.setYearLabel(String.valueOf(yearNum));
				
				growthPanel.setYearLabel(String.valueOf(yearNum));
				growthPanel.setPercentageLabel(0, indexNum);
				growthPanel.setValueLabel(0, indexNum);
				
				yearButtons[indexNum].setEnabled(false);
			}
				
			else if (yearNum == 2001) {
				
				indexNum = 2;
				
				barGraphPanel.setCurrentYear(2);
				barGraphPanel.setBarGraph();
				barGraphPanel.setupBarLabels();
				growthPanel.setYearLabel(String.valueOf(yearNum));
				
				growthPanel.setYearLabel(String.valueOf(yearNum));
				growthPanel.setPercentageLabel(0, indexNum);
				growthPanel.setValueLabel(0, indexNum);
				
				yearButtons[indexNum].setEnabled(false);
			}
			
			else if (yearNum == 2006) {
				
				indexNum = 3;
				
				barGraphPanel.setCurrentYear(3);
				barGraphPanel.setBarGraph();
				barGraphPanel.setupBarLabels();
				growthPanel.setYearLabel(String.valueOf(yearNum));
				
				growthPanel.setYearLabel(String.valueOf(yearNum));
				growthPanel.setPercentageLabel(0, indexNum);
				growthPanel.setValueLabel(0, indexNum);
				
				yearButtons[indexNum].setEnabled(false);
			}
				
			
			else if (yearNum == 2011) {
				
				indexNum = 4;
				
				barGraphPanel.setCurrentYear(4);
				barGraphPanel.setBarGraph();
				barGraphPanel.setupBarLabels();
				growthPanel.setYearLabel(String.valueOf(yearNum));
				
				growthPanel.setYearLabel(String.valueOf(yearNum));
				growthPanel.setPercentageLabel(0, indexNum);
				growthPanel.setValueLabel(0, indexNum);
				
				yearButtons[indexNum].setEnabled(false);
			}
			
			else if (yearNum == 2016) {
				
				indexNum = 5;
				
				barGraphPanel.setCurrentYear(5);
				barGraphPanel.setBarGraph();
				barGraphPanel.setupBarLabels();
				growthPanel.setYearLabel(String.valueOf(yearNum));
				
				growthPanel.setYearLabel(String.valueOf(yearNum));
				growthPanel.setPercentageLabel(0, indexNum);
				growthPanel.setValueLabel(0, indexNum);
				
				yearButtons[indexNum].setEnabled(false);
			}

		}
	}
	

}
