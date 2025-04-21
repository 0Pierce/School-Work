import javax.swing.JLabel;
//This is a template class that hold the image for each cell
public class Cell extends JLabel {
	
	private int row;
	private int column;
	
	public Cell(int row, int column) {
		
		
		this.row = row;
		this.column = column;
		
	}
	
	
	//default constructor
	public Cell() {
		
	}
	
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getColumn() {
		return column;
	}
	public void setColumn(int column) {
		this.column = column;
		
	}
	
	
	
	@Override
	public String toString() {
		return "Cell [row=" + row + ", column=" + column + "]";
	}
	
	
	
	
}