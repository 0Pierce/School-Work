import java.awt.Color;
import java.awt.Font;
import java.util.Stack;

import javax.swing.JLabel;

public class BingoCardPanel extends BingoGameFrame {
	
	private JLabel cardLabel;
	private JLabel[][] numberJLabelArray;
	
	public BingoCardPanel() {
		
		setLayout(null);
		cardLabel.setLayout(null);
		AddNumberLabels();
		
		//Makes the bounds for the label
		cardLabel.setBounds(0, 0, 600, 600);
		add(cardLabel);
		
	
	}

	public JLabel getCardLabel() {
		return cardLabel;
	}

	public void setCardLabel(JLabel cardLabel) {
		this.cardLabel = cardLabel;
	}

	public JLabel[][] getNumberJLabelArray() {
		return numberJLabelArray;
	}

	public void setNumberJLabelArray(JLabel[][] numberJLabelArray) {
		this.numberJLabelArray = numberJLabelArray;
	}
	

	public void AddNumberLabels() {
		
		//To place all the rows
		for(int row = 0; row < numberJLabelArray.length; row++) {
			
			//To place all the columns it goes through all the columns and
			for(int column = 0; column < numberJLabelArray[row].length; column++) {
				
				//Dont really understand
				//Assuming this is telling the numbers their attributes? Like size, font etc etc??
				numberJLabelArray[row][column] = new JLabel();
				numberJLabelArray[row][column].setFont(new Font("Serif", Font.BOLD, 36 ));
				numberJLabelArray[row][column].setOpaque(true);
				numberJLabelArray[row][column].setBackground(Color.MAGENTA);
				
				//Sets the empty number spot
				if(row == 2 && column == 2) {
					numberJLabelArray[row][column].setBackground(Color.BLUE);
					numberJLabelArray[row][column].setText(" X ");
					numberJLabelArray[row][column].setFont(new Font("Serif", Font.BOLD, 36));
					


				}
				
				//Completely clueless here
				numberJLabelArray[row][column].setBounds(85 + column * 100, 75 + row * 100, 50, 50);
				cardLabel.add(numberJLabelArray[row][column]);
				
			}
				
			
		}
		
		
		
	}
	
	
}
