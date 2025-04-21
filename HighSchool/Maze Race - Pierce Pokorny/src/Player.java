import javax.swing.ImageIcon;

public class Player extends Cell {
	
	public Player(String fileName) {
		//Gets the file
		setIcon(new ImageIcon(fileName));
	}
	
	
	//helps move the player according to the text file
	public void move(int dRow, int dCol) {
		
		setRow(getRow() + dRow);
		setColumn(getColumn() + dCol);
		
	}

}
