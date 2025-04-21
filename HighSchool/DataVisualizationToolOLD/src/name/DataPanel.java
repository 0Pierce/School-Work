package name;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

public class DataPanel extends JPanel {

	protected JPanel DataPanel;

	private int numOfUsers;
	private String[][] csvDataCopy;
	int rowCount;
	int rowIndex;

	private Data dataC;
	
	private JTable table;
	

	//private MainFrame mainFrame;

	

	public DataPanel() throws IOException {
		dataC = new Data();
		//mainFrame.getActionP()

		System.out.println("Entered DataPanel Constructor");
		DataPanel = new JPanel();
		DataPanel.setBackground(Color.LIGHT_GRAY);
		DataPanel.setBounds(0, 0, 470, 861);
		
		DataPanel.setLayout(null);
		
		
		//this.mainFrame = mainFrame;
		
		
		String Column[] = { "Usernames", "Passwords", "Screen Time", "Last Login", "Join Date" };
		table = new JTable(dataC.importData(), Column) {

			private boolean[] canEdit = new boolean[] { false, false, true, true, true};

			public boolean isCellEditable(int row, int column) {

				return canEdit[column];
			};

		};
		
		dataPanelGUI();

	}
	
	

	

	//Handles the GUI aspect of the DataPanel
	public void dataPanelGUI() throws IOException {
		
		System.out.println("DataPanelGUI");

		MatteBorder border = new MatteBorder(1, 1, 0, 0, Color.RED);

		// The user data is theoretically from a website where users can log in.
		// Because of this the last 3 columns cannot be created alongside a new user.

		// 50 = Row amount | 5 = Column Amount

		

		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(0).setMinWidth(100);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.RED, Color.RED));
		table.setBackground(Color.LIGHT_GRAY);
		table.getTableHeader().setBackground(Color.LIGHT_GRAY);
		table.getTableHeader().setFont(new Font("Arial Black", Font.BOLD, 11));
		// table.setRowSelectionAllowed(true);
		// table.setColumnSelectionAllowed(false);
		table.setSelectionBackground(Color.WHITE);
		System.out.println(table.getSelectedRow());

		table.setBounds(0, 0, 470, 861);
		table.setGridColor(Color.GRAY);
		// table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBackground(Color.LIGHT_GRAY);
		scrollPane.getVerticalScrollBar().setBackground(Color.LIGHT_GRAY);

		scrollPane.setBounds(0, 0, 470, 861);

		// data[2][1] = "Ola";

		DataPanel.add(scrollPane);
		rowCount = table.getRowCount();

		table.addMouseListener(new MouseAdapter() {

			// Checking if the mouse enteres the label
			public void mouseClicked(MouseEvent me) {
				// System.out.println(table.getValueAt(table.getSelectedRow(),
				// table.getSelectedRow()));
				System.out.println(table.getSelectedRow());
				rowIndex = table.getSelectedRow();
				// selectedCell();
				System.out.println();
				rowCount = table.getRowCount();

			}

		});
		
		getChange();

	}

	// Moves the data from the csvData Array to the data array which is used to
	// display the data on the JTable
	public void displayData(String csvData[][]) throws IOException {

		//Instead of displaying Empty on the JTable it will not display anything.
		for(int i =0; i < csvData.length; i++) {
			for(int j = 2; j < 5; j++) {
				if(csvData[i][j] != null) {
					if(csvData[i][j].equals("Empty")) {
						System.out.println("--Entered REPLACE EMPTY WITH NULL--");
						csvData[i][j] = null;
					}
				}
				
			}
		}
		
		
		csvDataCopy = Arrays.copyOf(csvData, numOfUsers);
		System.out.println("Row Count is" + rowCount);
		// csvDataCopy = Arrays.copyOf(csvData, csvData.length);
		// System.out.println(Arrays.deepToString(csvData));
		System.out.println("Entered displayData");
		// Takes the data from the csvData array and puts it into the data array which
		// will display the data
		for (int i = 0; i < rowCount; i++) {
			// System.out.println("Ran ILOOP");
			for (int j = 0; j < 5; j++) {
				// System.out.println("Ran JLOOP");
				// if(table.getValueAt(i, j) == null) {
				// System.out.println("Entered Table if");

				dataC.importData()[i][j] = csvData[i][j];

				// }

			}

		}

		dataPanelGUI();

	}

	// Helper/util method gets called whenever this is needed
	public int getSelectedCell() {

		// Returns the index of the row
		return rowIndex;
	}

	// Helper/util method used to get the amount of rows data is in
	public int getUsedRows() throws IOException {
		int rowCount = 0;
		for (int i = 0; i < dataC.importData().length; i++) {

			if (csvDataCopy[i][0] == null) {

			} else {
				rowCount++;
			}

		}

		return rowCount + 1;

	}

	JTable table2;
	
	
	
	
	//Imports any changes made to 3 last JTable collumn
	//Reads in their cells into an array
	public void getChange() throws IOException {
		
		String[] row = new String[5];
		
		System.out.println("USED ROWS----"+getUsedRows());
		
		//Saves the newly obtained data into the csvData array and into its corresponding indexes
		//Runs through cells that have a username in the row
		for(int i = 0; i < getUsedRows()-1; i++) {
			for(int j = 2; j < 5; j++) {
				
				//Makes sure it goes through only the needed columns
				//I used these two major ifs to avoid placing a comma as the first character
				//I slightly changed it so technically this if and else arent really needed
				//But i kept it for now
				if(j == 2) {
					//Makes sure there is a value inside the cell
					if(table.getModel().getValueAt(i, j) != null) {
						row[j] = (String) table.getModel().getValueAt(i, j);
					}else {
						//If its null then it will place a empty
						//This will then be saved into the csv file as an empty slot
						row[j] = "Empty";
					}
					
				}else {
					if(table.getModel().getValueAt(i, j) != null) {
						
						row[j] = table.getModel().getValueAt(i, j).toString();
					}else {
						row[j] = "Empty";
					}
					
				}
				
				csvDataCopy[i][j] = row[j];
				
			}
			
			

		}
		
		System.out.println("----------ADDED CELLS-------------");
		System.out.println(Arrays.deepToString(csvDataCopy));
		
		try {
			dataC.AddCellsToFile(csvDataCopy);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
}
