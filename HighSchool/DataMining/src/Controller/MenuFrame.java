package Controller;

import java.awt.EventQueue;
import java.awt.Font;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

import EstimatedValueLandPackage.LVApplication;
import FarmAreaPackage.FarmArea;
import EstimatedRentalRatePackage.RentalRateFrame;
import RentalRateLandValuePackage.RatioFrame;

/*Names: Pierce Pokorny(25%), Daphne Ho(25%), Chloe Wong(25%), Philip Wu(25%)

Date: May 28, 2022

Course Code:ICS4U1 Mr.Fernandes

Title: SDP#2 FarmLand

Description: 
A data visualization tool that displays information about Ontario farmlands, including statistics on its total farm area, its estimated value, its rental rate per acre, and its rental rate to estimated value ratio. Data tools are split up between different years and categorized into cardinal regions of Ontario (Northern Ontario, Southern Ontario, etc.) and divisions (Munclipatilies, Counties, etc.) within those regions. 

Features: 
Reads in CSV files and displays data via multiple graphs.
Displays the data over various years which can be selected
Pierce - Uses an interactive map to display data per region and per year.

Major Skills:
OOP
Data storage & manipulation (Arrays)
File Scanner
JFreeChart
Swing(GUI)
Pierce - 2D Graphics


Areas of Concern:
None that we are aware of
*/


public class MenuFrame extends JFrame implements ActionListener {
	
	
	public static void main(String[] args) {
		new MenuFrame();
	}
	

	// VISUAL COMPONENTS
	// menu buttons
	private JButton farmArea = new JButton("Total Farm Area");
	private JButton ratioRate = new JButton("Rental Rate : Land Value");
	private JButton landValue = new JButton("Estimated Value of Land");
	private JButton rentalRate = new JButton("Estimated Rental Rate");
	private JLabel title = new JLabel("Welcome to Group 1 Data Set");
	private JLabel backgroundLabel = new JLabel(new ImageIcon("images/background.png"));
	
	
	public static LVApplication LVApplication = new LVApplication();
	public static RentalRateFrame RentalRateFrame = new RentalRateFrame();
	public static RatioFrame RatioFrame = new RatioFrame();
	public static FarmArea FarmArea2 = new FarmArea();


	
	
	// background image
	private JLabel background = new JLabel("");

	public MenuFrame() {
		

		// TITLE//
		// Main frame
		setTitle("Farmland Data Set");
		setLayout(null);
		setSize(1000, 800);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		// setup frames
		FarmArea2.setVisible(false);
		LVApplication.LVFrame.setVisible(false);
		RentalRateFrame.setVisible(false);
		RatioFrame.setVisible(false);
		
		
		// TITLE DISPLAY//
		// title
		title.setBounds(255, 250, 800, 100);
		title.setOpaque(false);
		title.setFont(new Font("Comic Sans", Font.BOLD, 50));
		add(title);

//--------------------------------------------------------------------------------------------------------------------------------------------
// BUTTON DISPLAY//

		// farm area - button
		farmArea.setBounds(100, 450, 200, 50);
		farmArea.addActionListener(this);
		add(farmArea);

		// area rented - button
		ratioRate.setBounds(100, 550, 200, 50);
		ratioRate.addActionListener(this);
		add(ratioRate);

		// land value - button
		landValue.setBounds(350, 450, 200, 50);
		landValue.addActionListener(this);
		add(landValue);

		// ratio - button
		rentalRate.setBounds(350, 550, 200, 50);
		rentalRate.addActionListener(this);
		add(rentalRate);
//--------------------------------------------------------------------------------------------------------------------------------------------
// VISUAL COMPONENTS//

		backgroundLabel.setBounds(0,0, 1000, 800);
		add(backgroundLabel);

	}

	//https://stackoverflow.com/questions/5936261/how-to-add-action-listener-that-listens-to-multiple-buttons
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == farmArea) {
			setVisible(false);
			FarmArea2.setVisible(true);
			
		}
		
		else if(e.getSource() == landValue) {
			setVisible(false);
			LVApplication.LVFrame.setVisible(true);
			
		}
		
		if(e.getSource() == ratioRate) {
			setVisible(false);
			RatioFrame.setVisible(true);
			
		}
		else if(e.getSource() == rentalRate) {
			setVisible(false);
			RentalRateFrame.setVisible(true);
		}
	
		 

	}

}