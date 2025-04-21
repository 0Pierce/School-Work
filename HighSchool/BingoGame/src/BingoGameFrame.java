import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;

//Created by yours truly Pierce
public class BingoGameFrame extends JFrame {

	//Create objects/fields
	private NumberPanel numberPanel = new NumberPanel();
	private BingoCardPanel cardPanel;
	
	//Builds the frame
	public BingoGameFrame() {
		
		//Sets up the frame
		setTitle("Bongo Game");
		setLayout(null);
		setSize(600, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	
		//Sets the bounds
		numberPanel.setBounds(0,0, 600, 100);
		add(numberPanel);
		
		//Not sure whats this?????
		cardPanel = new BingoCardPanel();
		
		cardPanel.setBounds(0, 100, 600, 600);
		add(cardPanel);
		
		setVisible(true);
		
	}
	
	
	
	//
	public BingoCardPanel getCardPanel() {
		return cardPanel;
	}
	
	public void setCardPanel(BingoCardPanel cardPanel) {
		this.cardPanel = cardPanel;
	}

	public NumberPanel getNumberPanel() {
		return numberPanel;
	}

	public void setNumberPanel(NumberPanel numberPanel) {
		this.numberPanel = numberPanel;
	}
	
	
	


}




