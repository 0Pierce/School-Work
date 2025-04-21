package EstimatedValueLandPackage;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This class creates the growth panel which displays the year-over-year changes of the value between the current year the user is on
 * and the previous year (percentage increase/decreas), the name of the land, and its exact value. It also has a line graph at the
 * bottom displaying the growth in value of all regions between all years of avaliable data
 * 
 * @author Daphne Ho
 *
 */
public class LVGrowthPanel extends JPanel{
	
	// FIELDS
	public static final int GPANEL_WIDTH = 250;
	private JLabel titleLabel = new JLabel("YEAR-OVER-YEAR CHANGES");
	private JLabel yearLabel = new JLabel("2016");
	private JLabel valueLabel = new JLabel("$9580");
	private JLabel landNameLabel = new JLabel("Ontario");
	private JLabel percentageLabel = new JLabel();
	
	private LVLineGraph lineGraph = new LVLineGraph();
	
	// CONSTRUCTOR
	public LVGrowthPanel() {
		
		// panel
		setLayout(null);
		setBounds(LVFrame.PANELS_X + 710, LVFrame.PANELS_Y, GPANEL_WIDTH, LVFrame.PANELS_LENGTH);
		setBackground(Color.white);
		
		// title label
		titleLabel.setBounds(0, 15, GPANEL_WIDTH, 20);
		titleLabel.setFont(new Font("Helvectica", Font.BOLD, 11));
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		
		// land label
		landNameLabel.setBounds(0, 40, GPANEL_WIDTH, 20);
		landNameLabel.setFont(new Font("Helvetica", Font.BOLD, 18));
		landNameLabel.setHorizontalAlignment(JLabel.CENTER);
		
		yearLabel.setBounds(0, 65, GPANEL_WIDTH, 20);
		yearLabel.setFont(new Font("Helvetica", Font.BOLD, 20));
		yearLabel.setHorizontalAlignment(JLabel.CENTER);
		
		// percentage label
		percentageLabel.setBounds(0, 100, GPANEL_WIDTH, 40);
		percentageLabel.setFont(new Font("Arial Black", Font.BOLD, 30));
		percentageLabel.setHorizontalAlignment(JLabel.CENTER);
		setPercentageLabel(0,0);
		
		// value label
		valueLabel.setBounds(0, 85, GPANEL_WIDTH, 20);
		valueLabel.setHorizontalAlignment(JLabel.CENTER);
		
		// add elements to the frame
		add(titleLabel);
		add(landNameLabel);
		add(yearLabel);
		add(valueLabel);
		add(percentageLabel);
		add(lineGraph);
		
		// make the frame visible
		setVisible(true);
		
	}

	// SETTERS
	// all the methods setup/change the text in each of the labels when called
	public void setYearLabel(String year) {
		yearLabel.setText(year);
	}

	public void setLandNameLabel(int regionIndex, int valueIndex) {
		landNameLabel.setText(LVApplication.regionList[regionIndex].getName());
	}

	public void setPercentageLabel(int regionIndex, int valueIndex) {
		int[] percentageList = LVApplication.regionList[regionIndex].getPercentageList();
		percentageLabel.setText(String.valueOf(percentageList[valueIndex]) + "%");
		
		if (percentageList[valueIndex] > 0)
			percentageLabel.setForeground(Color.green);
		else
			percentageLabel.setForeground(Color.red);
		
	}
	
	public void setValueLabel(int regionIndex, int year) {
		int[] valueList = LVApplication.regionList[regionIndex].getValueList();
		valueLabel.setText("$" + String.valueOf(valueList[year]));
	}
	
}
