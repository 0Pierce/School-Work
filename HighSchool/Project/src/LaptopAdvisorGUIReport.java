
/*
 * Name(s): Pierce Pokorny, Daniel Ling, Jaffer Razavi
 * Date: January 18, 2021
 * Course code: ICS3U1-56 - Mr.Fernandes
 * Purpose: Creates the final GUI and presents the users with a choice of 3 laptops depending on their selections
 * Major skills: Opens the GUI, provides laptop links, Gives the 3 laptops based on previous information, etc...
 * Extra features: Added a border color of black and also a background of gray including a font 
 * Areas of concern: Text in output isnt formatted very nicely /// Possibly missing 2 -3 images due to daniel
*/

/*
* This class is the application class
*
* author - Pierce Pokorny
*/

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class LaptopAdvisorGUIReport extends JFrame implements ActionListener {

//Text arrays

	JButton[] laptopImageButton = new JButton[3];
	JTextArea[] laptopTextAreaArray = new JTextArea[3];

//Settings up the panels and menubar
	JPanel reportPanel = new JPanel();
	JLabel reportPanelLabel = new JLabel();
	JMenuBar menubar = new JMenuBar();
	Border border = BorderFactory.createLineBorder(Color.BLACK, 50);

	public LaptopAdvisorGUIReport() {

//methods
		reportPanelSetup();
		frameSetup();
		createReport();
		rankLaptops();
	}

//opening up the report panel and setting its boundries
	private void reportPanelSetup() {

//The report panels and their bounds or other parameters like color etc
		reportPanel.setBounds(0, 0, 1250, 800);
		reportPanel.setLayout(null);
		reportPanel.setBackground(Color.GRAY);
		reportPanel.setBorder(border);
		reportPanelLabel.setBounds(575, 25, 200, 25);
		reportPanel.add(reportPanelLabel);

//Images and text area bounds including an action listener for the image so its clickable
		for (int index = 0; index < laptopTextAreaArray.length; index++) {
			laptopImageButton[index] = new JButton();
			laptopImageButton[index].addActionListener(this);
			laptopImageButton[index].setBounds(100 + 400 * index, 75, 250, 200);
			reportPanel.add(laptopImageButton[index]);

			// Sets up the Arrays
			laptopTextAreaArray[index] = new JTextArea();
			laptopTextAreaArray[index].setBounds(100 + 400 * index, 350, 250, 385);
			reportPanel.add(laptopTextAreaArray[index]);
			laptopTextAreaArray[index].setFont(new Font("SansSerif", Font.BOLD, 12));

		}

	}

//Opening the frame
	private void frameSetup() {
//sets the size
		setSize(1250, 800);
		setLayout(null);

		setJMenuBar(menubar);

		add(reportPanel);
//makes sure it will all be visible
		setVisible(true);

	}

//Creating the report
	private void createReport() {

		rankLaptops();

		add(reportPanel);
		repaint();
	}

//Ratting the laptops using the overall score
	private void rankLaptops() {

		for (Laptop currentLaptop : LaptopAdvisorApplication.laptopArray)
			currentLaptop.setOverallScore(wdm(currentLaptop));

		// sorts in a descending order
		Arrays.sort(LaptopAdvisorApplication.laptopArray, Comparator.comparing(Laptop::getOverallScore).reversed());

//gets the images into the gui including their position and which images should be where
		for (int index = 0; index < laptopTextAreaArray.length; index++) {
			laptopTextAreaArray[index].setText(LaptopAdvisorApplication.laptopArray[index].toString());
			laptopImageButton[index].setIcon(new ImageIcon(
					new ImageIcon("./images/" + LaptopAdvisorApplication.laptopArray[index].getImageFile()).getImage()
							.getScaledInstance(250, 200, 0)));
		}

	}

//getting the ratings for the current laptop from the advisorApp
	private int wdm(Laptop currentLaptop) {

		int totalScore = 0;
//Gets the rattings from AdApplication
		for (int index = 0; index < currentLaptop.getRatings().length; index++)
			totalScore += currentLaptop.getRatings()[index] * LaptopAdvisorApplication.user.getWeighting()[index];

		return totalScore;

	}

//Sends the infomation about a click to openwebbrowser 
	public void actionPerformed(ActionEvent event) {

//For loop for the click
		for (int index = 0; index < laptopImageButton.length; index++) {
			if (event.getSource() == laptopImageButton[index])

				openWebBrowser(index);
		}
	}

//Opens the browser link of the laptops
	private void openWebBrowser(int index) {
//Makes sure the program is supported
		if (Desktop.isDesktopSupported()) {
			try {
				Desktop.getDesktop().browse(new URI(LaptopAdvisorApplication.laptopArray[index].getHyperLink()));

			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (URISyntaxException e1) {
				e1.printStackTrace();
			}
		}
	}

}
