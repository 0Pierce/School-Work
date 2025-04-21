/*
 * Description: This class displays the data (in bar graphs) of the ratio of estimated rental rate
 * per acre to estimated value of per acre. The graph displayed on the left is the summary for each
 * province, while the graph on the right displays the some of the data (15 counties). Both graphs 
 * display the data between the years of 1991 - 2016.
 */
//package
package RentalRateLandValuePackage;

//import
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import Controller.MenuFrame;
import FarmAreaPackage.FarmArea;

//class
public class RatioFrame extends JFrame implements ActionListener {

// VISUAL COMPONENTS//
	// background images
	private JLabel back = new JLabel("");

// --------------------------------------------------------------------------------------------------------------------------------------------
//REGION BAR PANEL YEARS//
	// 1991
	private ChartPanel year1ChartPanel;

	// 1996
	private ChartPanel year2ChartPanel;

	// 2001
	private ChartPanel year3ChartPanel;

	// 2006
	private ChartPanel year4ChartPanel;

	// 2011
	private ChartPanel year5ChartPanel;

	// 2016
	private ChartPanel year6ChartPanel;

//COUNTY BAR PANEL YEARS//
	// 1991
	private ChartPanel year1ChartCountyPanel;

	// 1996
	private ChartPanel year2ChartCountyPanel;

	// 2001
	private ChartPanel year3ChartCountyPanel;

	// 2006
	private ChartPanel year4ChartCountyPanel;

	// 2011
	private ChartPanel year5ChartCountyPanel;

	// 2016
	private ChartPanel year6ChartCountyPanel;
	
	//main panel
	private JPanel mainPanel = new JPanel();
// --------------------------------------------------------------------------------------------------------------------------------------------
	// menu bar
	private JMenu frameMenu = new JMenu("Farm Data");
	private JMenuBar menuBar = new JMenuBar();
	private JMenuItem[] dataArray = new JMenuItem[3];
	private JLabel background = new JLabel("");

// --------------------------------------------------------------------------------------------------------------------------------------------

	// statistics bar
	private JMenu titleMenu = new JMenu("Years");
	private JMenuBar dropMenu = new JMenuBar();
	private JMenuItem[] yearArray = new JMenuItem[7];

	// constructor
	public RatioFrame() {

		// VISUAL COMPONENTS//
		// frame
		setLayout(null);
		setSize(1000, 800);
		setResizable(false);
		setVisible(true);

		// TITLE//
		// Main frame
		setTitle("Farmland Data Set");
		setLayout(null);
		setSize(1000, 800);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		//main panel - image
		mainPanel.setBounds(0, 200, 1009, 563);
		add(mainPanel);
			
// --------------------------------------------------------------------------------------------------------------------------------------------	
//REGION BAR GRAPHS/DATA//
		// 1991 panel/graph 
		JFreeChart year1Chart = ChartFactory.createBarChart(
				"Rental Rate : Land Value", 
				"Region", 
				"Percent",
				createDataset1991(), 
				PlotOrientation.VERTICAL, 
				true, 
				true, 
				false);
		
		//CREATION OF CHART - VISUAL//
		year1ChartPanel = new ChartPanel(year1Chart);
		year1ChartPanel.setBounds(0, 205, 520, 555);
		add(year1ChartPanel);
		year1ChartPanel.setVisible(false);
		
		
		// 1996 panel/graph
		JFreeChart year2Chart = ChartFactory.createBarChart(
				"Rental Rate : Land Value", 
				"Region", 
				"Percent",
				createDataset1996(), 
				PlotOrientation.VERTICAL, 
				true, 
				true, 
				false);
		
		//CREATION OF CHART - VISUAL//
		year2ChartPanel = new ChartPanel(year2Chart);
		year2ChartPanel.setBounds(0, 205, 520, 555);
		add(year2ChartPanel);
		year2ChartPanel.setVisible(false);
		
		
		// 2001 panel/graph
		JFreeChart year3Chart = ChartFactory.createBarChart(
				"Rental Rate : Land Value", 
				"Region", 
				"Percent",
				createDataset2001(), 
				PlotOrientation.VERTICAL,
				true, 
				true, 
				false);
		
		//CREATION OF CHART - VISUAL//
		year3ChartPanel = new ChartPanel(year3Chart);
		year3ChartPanel.setBounds(0, 205, 520, 555);
		add(year3ChartPanel);
		year3ChartPanel.setVisible(false);

		
		// 2006 panel/graph
		JFreeChart year5Chart = ChartFactory.createBarChart(
				"Rental Rate : Land Value", 
				"Region", 
				"Percent",
				createDataset2011(), 
				PlotOrientation.VERTICAL, 
				true, 
				true, 
				false);
		
		//CREATION OF CHART - VISUAL//
		year5ChartPanel = new ChartPanel(year5Chart);
		year5ChartPanel.setBounds(0, 205, 520, 555);
		add(year5ChartPanel);
		year5ChartPanel.setVisible(false);

		
		// 2011 panel/graph
		JFreeChart year4Chart = ChartFactory.createBarChart(
				"Rental Rate : Land Value", 
				"Region", "Percent",
				createDataset2006(), 
				PlotOrientation.VERTICAL, 
				true, 
				true, 
				false);
		
		//CREATION OF CHART - VISUAL//
		year4ChartPanel = new ChartPanel(year4Chart);
		year4ChartPanel.setBounds(0, 205, 520, 555);
		add(year4ChartPanel);
		year4ChartPanel.setVisible(false);
		
		
		//2016 panel/graph
		JFreeChart year6Chart = ChartFactory.createBarChart(
				"Rental Rate : Land Value", 
				"Region", 
				"Percent",
				createDataset2016(), 
				PlotOrientation.VERTICAL, 
				true, 
				true, 
				false);

		//CREATION OF CHART - VISUAL//
		year6ChartPanel = new ChartPanel(year6Chart);
		year6ChartPanel.setBounds(0, 205, 520, 555);
		add(year6ChartPanel);
		year6ChartPanel.setVisible(false);

// --------------------------------------------------------------------------------------------------------------------------------------------
//COUNTY BAR GRAPH//		
		//ONLY SOME OF THE DATA - NOT ALL DATA WAS USED//
		// 1991 County panel/graph 
				JFreeChart year1CountyChart = ChartFactory.createBarChart(
						"Rental Rate : Land Value", 
						"County", 
						"Percent",
						createCountyDataset1991(), 
						PlotOrientation.VERTICAL, 
						true, 
						true, 
						false);
				
				//CREATION OF CHART - VISUAL//
				year1ChartCountyPanel = new ChartPanel(year1CountyChart);
				year1ChartCountyPanel.setBounds(520, 205, 463, 555);
				add(year1ChartCountyPanel);
				year1ChartCountyPanel.setVisible(false);
				
				
				// 1996 County panel/graph
				JFreeChart year2CountyChart = ChartFactory.createBarChart(
						"Rental Rate : Land Value", 
						"County", 
						"Percent",
						createCountyDataset1996(), 
						PlotOrientation.VERTICAL, 
						true, 
						true, 
						false);
				
				//CREATION OF CHART - VISUAL//
				year2ChartCountyPanel = new ChartPanel(year2CountyChart);
				year2ChartCountyPanel.setBounds(520, 205, 463, 555);
				add(year2ChartCountyPanel);
				year2ChartCountyPanel.setVisible(false);

				
				// 2001 County panel/graph
				JFreeChart year3CountyChart = ChartFactory.createBarChart(
						"Rental Rate : Land Value", 
						"County", 
						"Percent",
						createCountyDataset2001(), 
						PlotOrientation.VERTICAL,
						true, 
						true, 
						false);
				
				//CREATION OF CHART - VISUAL//
				year3ChartCountyPanel = new ChartPanel(year3CountyChart);
				year3ChartCountyPanel.setBounds(520, 205, 463, 555);
				add(year3ChartCountyPanel);
				year3ChartCountyPanel.setVisible(false);

				
				// 2006 County panel/graph
				JFreeChart year5CountyChart = ChartFactory.createBarChart(
						"Rental Rate : Land Value", 
						"County", 
						"Percent",
						createCountyDataset2011(), 
						PlotOrientation.VERTICAL, 
						true, 
						true, 
						false);
				
				//CREATION OF CHART - VISUAL//
				year5ChartCountyPanel = new ChartPanel(year5CountyChart);
				year5ChartCountyPanel.setBounds(520, 205, 463, 555);
				add(year5ChartCountyPanel);
				year5ChartCountyPanel.setVisible(false);

				
				// 2011 County panel/graph
				JFreeChart year4CountyChart = ChartFactory.createBarChart(
						"Rental Rate : Land Value", 
						"County", 
						"Percent",
						createCountyDataset2006(), 
						PlotOrientation.VERTICAL, 
						true, 
						true, 
						false);
				
				//CREATION OF CHART - VISUAL//
				year4ChartCountyPanel = new ChartPanel(year4CountyChart);
				year4ChartCountyPanel.setBounds(520, 205, 463, 555);
				add(year4ChartCountyPanel);
				year4ChartCountyPanel.setVisible(false);
				
				
				//2016 County panel/graph
				JFreeChart year6CountyChart = ChartFactory.createBarChart(
						"Rental Rate : Land Value", 
						"County", 
						"Percent",
						createCountyDataset2016(), 
						PlotOrientation.VERTICAL, 
						true, 
						true, 
						false);

				//CREATION OF CHART - VISUAL//
				year6ChartCountyPanel = new ChartPanel(year6CountyChart);
				year6ChartCountyPanel.setBounds(520, 205, 463, 555);
				add(year6ChartCountyPanel);
				year6ChartCountyPanel.setVisible(false);
// --------------------------------------------------------------------------------------------------------------------------------------------
// MENU BAR DISPLAY//

		// data list
		dataArray[0] = new JMenuItem("Total Farm Area");
		dataArray[1] = new JMenuItem("Estimated Value of Land");
		dataArray[2] = new JMenuItem("Estimated Rental Rate");
		//dataArray[3] = new JMenuItem("Rental Rate : Land Value");

		// implements items into array
		for (JMenuItem item : dataArray) {
			frameMenu.add(item);
			item.addActionListener(this);

		}

		// VISUAL COMPONENTS//
		// adds frame
		menuBar.add(frameMenu);
		menuBar.setBounds(0, 0, 1000, 30);
		add(menuBar);
		setVisible(true);

// --------------------------------------------------------------------------------------------------------------------------------------------
// GRAPH BAR/STATISITCS DISPLAY//

		// years - drop down selection
		yearArray[0] = new JMenuItem("Main Menu");
		yearArray[1] = new JMenuItem("1991");
		yearArray[2] = new JMenuItem("1996");
		yearArray[3] = new JMenuItem("2001");
		yearArray[4] = new JMenuItem("2006");
		yearArray[5] = new JMenuItem("2011");
		yearArray[6] = new JMenuItem("2016");

		// implements items into array
		for (JMenuItem item : yearArray) {
			titleMenu.add(item);
			item.addActionListener(this);

		}

		// VISUAL COMPONENTS//
		// adds frame
		dropMenu.add(titleMenu);
		dropMenu.setBounds(0, 180, 1000, 25);
		add(dropMenu);
		setVisible(true);

// --------------------------------------------------------------------------------------------------------------------------------------------
// IMAGES//

		// background image
		try {
			BufferedImage board = ImageIO.read(new File("images\\back.png"));
			back.setIcon(new ImageIcon(board));
			back.setBounds(0, 0, 1000, 800);
			setVisible(true);
			add(back);

		} catch (Exception e) {
			System.out.println(e);
			
		}

		//image
			JLabel mainPanelImage = new JLabel("hello");
			mainPanelImage.setIcon(new ImageIcon("images\\mainPanelImage.png"));
			add(mainPanelImage);
			mainPanel.add(mainPanelImage);
			mainPanelImage.setVisible(true);
	}

// --------------------------------------------------------------------------------------------------------------------------------------------
// ACTION LISTENER//

	// https://stackoverflow.com/questions/15556893/how-to-open-a-new-jframe-window-when-jmenuitem-is-clicked
	@Override
	public void actionPerformed(ActionEvent e) {

		// THE FOLLOWING 4 BELOW ARE THE LISTNERS FOR THE FARM DATA SET//
		if ("Total Farm Area".equals(e.getActionCommand())) {
			setVisible(false);
			MenuFrame.FarmArea2.setVisible(true);

		}

		if ("Estimated Value of Land".equals(e.getActionCommand())) {
			setVisible(false);
			MenuFrame.LVApplication.LVFrame.setVisible(true);

		}

		if ("Estimated Rental Rate".equals(e.getActionCommand())) {
			setVisible(false);
			MenuFrame.RentalRateFrame.setVisible(true);

		}

// ---------------------------------------------------------------------------------------------------------------------------------------------
// THE FOLLOWING BELOW ARE LISTENERS FOR THE YEARS LIST//

		// website assistance for the visibility of the panel
		// https://stackoverflow.com/questions/5600051/java-swing-how-to-toggle-panels-visibility

		//main menu panel
		if ("Main Menu".equals(e.getActionCommand())) {
			mainPanel.setVisible(true);
		} else {
			mainPanel.setVisible(false);
		}
		if ("1991".equals(e.getActionCommand())) {
			System.out.println("YEAR1CHART"); //tests
		//1991 region chart panel
			year1ChartPanel.setVisible(true);
		} else {
			year1ChartPanel.setVisible(false);

		}

		if ("1996".equals(e.getActionCommand())) {
		//1996 region chart panel	
			year2ChartPanel.setVisible(true);
		} else {
			year2ChartPanel.setVisible(false);

		}

		if ("2001".equals(e.getActionCommand())) {
		//2001 region chart panel
			year3ChartPanel.setVisible(true);
		} else {
			year3ChartPanel.setVisible(false);

		}

		if ("2006".equals(e.getActionCommand())) {
		//2006 region chart panel
			year4ChartPanel.setVisible(true);
		} else {
			year4ChartPanel.setVisible(false);

		}

		if ("2011".equals(e.getActionCommand())) {
			System.out.println("ENTERED 2011"); //test
		//2011 region chart panel
			year5ChartPanel.setVisible(true);
		} else {
			year5ChartPanel.setVisible(false);

		}

		if ("2016".equals(e.getActionCommand())) {
		//2016 region chart panel	
			year6ChartPanel.setVisible(true);
		} else {
			year6ChartPanel.setVisible(false);

	//COUNTY DISPLAY//
		}
		if ("1991".equals(e.getActionCommand())) {
		//1991 County chart panel
			year1ChartCountyPanel.setVisible(true);
		} else {
			year1ChartCountyPanel.setVisible(false);

		}

		if ("1996".equals(e.getActionCommand())) {
		//1996 County chart panel	
			year2ChartCountyPanel.setVisible(true);
		} else {
			year2ChartCountyPanel.setVisible(false);

		}

		if ("2001".equals(e.getActionCommand())) {
		//2001 County chart panel
			year3ChartCountyPanel.setVisible(true);
		} else {
			year3ChartCountyPanel.setVisible(false);

		}

		if ("2006".equals(e.getActionCommand())) {
		//2006 County chart panel
			year4ChartCountyPanel.setVisible(true);
		} else {
			year4ChartCountyPanel.setVisible(false);

		}

		if ("2011".equals(e.getActionCommand())) {
		//2011 County chart panel
			year5ChartCountyPanel.setVisible(true);
		} else {
			year5ChartCountyPanel.setVisible(false);

		}

		if ("2016".equals(e.getActionCommand())) {
		//2016 County chart panel	
			year6ChartCountyPanel.setVisible(true);
		} else {
			year6ChartCountyPanel.setVisible(false);

		}
	}

//----------------------------------------------------------------------------------------------------------------------------
//BAR GRAPH - DATA IMPORTING (REGIONS)//
	// method - 1991
	private CategoryDataset createDataset1991() {

		DefaultCategoryDataset barGraph1 = new DefaultCategoryDataset();

		try {
			Scanner input = new Scanner(new File("dataset.csv"));
			while (input.hasNext()) {
				String line = input.nextLine();
				String[] values = line.split(",");

				// 1991
				barGraph1.addValue(Double.parseDouble(values[1]), values[0], "1991");

			}

		} catch (FileNotFoundException error) {
			System.out.println("Error finding CSV file.");
		}

		return barGraph1;

	}

	// method - 1996
	private CategoryDataset createDataset1996() {

		DefaultCategoryDataset barGraph2 = new DefaultCategoryDataset();

		try {
			Scanner input = new Scanner(new File("dataset.csv"));
			while (input.hasNext()) {
				String line = input.nextLine();
				String[] values = line.split(",");

				// 1996
				barGraph2.addValue(Double.parseDouble(values[2]), values[0], "1996");

			}

		} catch (FileNotFoundException error) {
			System.out.println("Error finding CSV file.");
		}

		return barGraph2;

	}

	// method - 2001
	private CategoryDataset createDataset2001() {

		DefaultCategoryDataset barGraph3 = new DefaultCategoryDataset();

		try {
			Scanner input = new Scanner(new File("dataset.csv"));
			while (input.hasNext()) {
				String line = input.nextLine();
				String[] values = line.split(",");

				// 2001
				barGraph3.addValue(Double.parseDouble(values[3]), values[0], "2001");

			}

		} catch (FileNotFoundException error) {
			System.out.println("Error finding CSV file.");
		}

		return barGraph3;

	}

	// method - 2006
	private CategoryDataset createDataset2006() {

		DefaultCategoryDataset barGraph4 = new DefaultCategoryDataset();

		try {
			Scanner input = new Scanner(new File("dataset.csv"));
			while (input.hasNext()) {
				String line = input.nextLine();
				String[] values = line.split(",");

				// 2006
				barGraph4.addValue(Double.parseDouble(values[4]), values[0], "2006");

			}

		} catch (FileNotFoundException error) {
			System.out.println("Error finding CSV file.");
		}

		return barGraph4;
	}

	// method - 2011
	private CategoryDataset createDataset2011() {

		DefaultCategoryDataset barGraph5 = new DefaultCategoryDataset();

		try {
			Scanner input = new Scanner(new File("dataset.csv"));
			while (input.hasNext()) {
				String line = input.nextLine();
				String[] values = line.split(",");

				// 2011
				barGraph5.addValue(Double.parseDouble(values[5]), values[0], "2011");

			}

		} catch (FileNotFoundException error) {
			System.out.println("Error finding CSV file.");
		}

		return barGraph5;
	}

	// method - 2016
	private CategoryDataset createDataset2016() {

		DefaultCategoryDataset barGraph6 = new DefaultCategoryDataset();

		try {
			Scanner input = new Scanner(new File("dataset.csv"));
			while (input.hasNext()) {
				String line = input.nextLine();
				String[] values = line.split(",");

				// 2016
				barGraph6.addValue(Double.parseDouble(values[6]), values[0], "2016");

			}

		} catch (FileNotFoundException error) {
			System.out.println("Error finding CSV file.");
		}

		return barGraph6;

	}
//----------------------------------------------------------------------------------------------------------------------------
	//BAR GRAPH - DATA IMPORTING (COUNTY)//
	// method - 1991
		private CategoryDataset createCountyDataset1991() {

			DefaultCategoryDataset barGraphCounty1 = new DefaultCategoryDataset();

			try {
				Scanner input = new Scanner(new File("Counties.csv"));
				while (input.hasNext()) {
					String line = input.nextLine();
					String[] values = line.split(",");
					System.out.println(values[1]);

					// 1991
					barGraphCounty1.addValue(Double.parseDouble(values[1]), values[0], "1991");

				}

			} catch (FileNotFoundException error) {
				System.out.println("Error finding CSV file.");
			}

			return barGraphCounty1;

		}

		// method - 1996
		private CategoryDataset createCountyDataset1996() {

			DefaultCategoryDataset barGraphCounty2 = new DefaultCategoryDataset();

			try {
				Scanner input = new Scanner(new File("Counties.csv"));
				while (input.hasNext()) {
					String line = input.nextLine();
					String[] values = line.split(",");

					// 1996
					barGraphCounty2.addValue(Double.parseDouble(values[2]), values[0], "1996");

				}

			} catch (FileNotFoundException error) {
				System.out.println("Error finding CSV file.");
			}

			return barGraphCounty2;

		}

		// method - 2001
		private CategoryDataset createCountyDataset2001() {

			DefaultCategoryDataset barGraphCounty3 = new DefaultCategoryDataset();

			try {
				Scanner input = new Scanner(new File("Counties.csv"));
				while (input.hasNext()) {
					String line = input.nextLine();
					String[] values = line.split(",");

					// 2001
					barGraphCounty3.addValue(Double.parseDouble(values[3]), values[0], "2001");

				}

			} catch (FileNotFoundException error) {
				System.out.println("Error finding CSV file.");
			}

			return barGraphCounty3;

		}

		// method - 2006
		private CategoryDataset createCountyDataset2006() {

			DefaultCategoryDataset barGraphCounty4 = new DefaultCategoryDataset();

			try {
				Scanner input = new Scanner(new File("Counties.csv"));
				while (input.hasNext()) {
					String line = input.nextLine();
					String[] values = line.split(",");

					// 2006
					barGraphCounty4.addValue(Double.parseDouble(values[4]), values[0], "2006");

				}

			} catch (FileNotFoundException error) {
				System.out.println("Error finding CSV file.");
			}

			return barGraphCounty4;
		}

		// method - 2011
		private CategoryDataset createCountyDataset2011() {

			DefaultCategoryDataset barGraphCounty5 = new DefaultCategoryDataset();

			try {
				Scanner input = new Scanner(new File("Counties.csv"));
				while (input.hasNext()) {
					String line = input.nextLine();
					String[] values = line.split(",");

					// 2011
					barGraphCounty5.addValue(Double.parseDouble(values[5]), values[0], "2011");

				}

			} catch (FileNotFoundException error) {
				System.out.println("Error finding CSV file.");
			}

			return barGraphCounty5;
		}

		// method - 2016
		private CategoryDataset createCountyDataset2016() {

			DefaultCategoryDataset barGraphCounty6 = new DefaultCategoryDataset();

			try {
				Scanner input = new Scanner(new File("Counties.csv"));
				while (input.hasNext()) {
					String line = input.nextLine();
					String[] values = line.split(",");

					// 2016
					barGraphCounty6.addValue(Double.parseDouble(values[6]), values[0], "2016");

				}

			} catch (FileNotFoundException error) {
				System.out.println("Error finding CSV file.");
			}

			return barGraphCounty6;

		}
	
}