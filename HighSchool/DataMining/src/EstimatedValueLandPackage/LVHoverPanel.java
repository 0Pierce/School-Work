package EstimatedValueLandPackage;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * This class creates the panel that pops up when a user hovers over a bar in the bar graph. The panel contains additional information 
 * about the certain bar (name and exact value)
 * 
 * @author Daphne Ho
 *
 */
public class LVHoverPanel extends JPanel {
	
	// FIELDS
	private JTextArea nameLabel = new JTextArea();
	private JLabel valueLabel = new JLabel("Value: $");
	
	// CONSTRUCTOR
	public LVHoverPanel() {
		
		// setup panel
		setLayout(null);
		setSize(95, 50);
		setBackground(LVFrame.LIGHT_BLUE);
		setBorder(BorderFactory.createLineBorder(Color.gray));
		
		// name label
		nameLabel.setBounds(5, 1, 90, 40);
		nameLabel.setEditable(false); // makes textbox uneditable
		nameLabel.setLineWrap(true); // makes sure the wrapping does not break up words
		nameLabel.setWrapStyleWord(true); // makes the text fit neatly into the area of the text box ("text wrapping")
		nameLabel.setOpaque(false);
		nameLabel.setFont(new Font("Helvetica", Font.BOLD, 11));
		
		// value label
		valueLabel.setBounds(5, 25, 90, 25);
		valueLabel.setFont(new Font("Helvetica", Font.PLAIN, 10));
		
		// add elements
		add(valueLabel);
		add(nameLabel);
		
	}

	// GETTERS AND SETTERS
	// setters - just set the text in the label/text area
	public JTextArea getNameLabel() {
		return nameLabel;
	}

	public void setNameLabel(int index) {
		nameLabel.setText(LVApplication.regionList[index].getName());
	}

	public JLabel getValueLabel() {
		return valueLabel;
	}

	public void setValueLabel(int index, int year) {
		int [] valueList = LVApplication.regionList[index].getValueList();
		valueLabel.setText("Value: $" + valueList[year]);
	}
	
	
}
