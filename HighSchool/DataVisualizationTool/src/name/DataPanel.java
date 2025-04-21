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
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;

public class DataPanel {

	protected JPanel DataPanel;

	private int numOfUsers;
	private String[][] csvDataCopy;
	int rowCount;
	int rowIndex;

	DefaultTableModel model = new DefaultTableModel();

	
	String data[][];
	JTable table;
	JScrollPane scrollPane;
	private MainFrame mainFrame;

	//Sets the number of users
	

	//Constructor
	public DataPanel(MainFrame mainFrame) {

		System.out.println("Entered DataPanel Constructor");
		DataPanel = new JPanel();
		DataPanel.setBackground(Color.LIGHT_GRAY);
		DataPanel.setBounds(0, 0, 470, 861);
		mainFrame.add(DataPanel);
		DataPanel.setLayout(null);
		numOfUsers = mainFrame.getActionP().getNumOfUsers();
		this.mainFrame = mainFrame;
		data = new String[numOfUsers][5];
		
		//Sets up the tables column and gives it the needed information
		String Column[] = { "Usernames", "Passwords", "Screen Time", "Last Login", "Join Date" };
		
		table = new JTable(data, Column) {

			
			private boolean[] canEdit = new boolean[] { false, false, true, true, true};

			public boolean isCellEditable(int row, int column) {

				//Makes sure the 3 last colums can be edited
				return canEdit[column];
			};

		};
		scrollPane = new JScrollPane(table);
		
		System.out.println(table.getRowCount());
		System.out.println(table.getColumnCount());
		//DataPanel.add(table);
		dataPanelGUI();

	}

	//Gets the action Panel
	public ActionPanel getActionP() {

		return mainFrame.getActionP();
	}
	
	//Sets the number of users and passes it onto the data array
	public void setNumOfUsers(int numOfUsers) {
		this.numOfUsers = numOfUsers;

		data = new String[numOfUsers][5];
	}
	

	//Handles table related GUI things
	public void dataPanelGUI() {
		System.out.println(table.getModel().getClass());
		System.out.println(table.getColumnCount());
		//table.getColumn(0).setResizable(false);
		//table.setColumnModel(new DefaultTableColumnModel());
		//table.getColumn(new DefaultTableModel());
		
		
		
		System.out.println("DataPanelGUI");

		MatteBorder border = new MatteBorder(1, 1, 0, 0, Color.RED);

		
		// The user data is theoretically from a website where users can log in.
		// Because of this the last 3 columns cannot be created alongside a new user.

		
	
		
		//Handles all the column settings
		
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
		
		table.setSelectionBackground(Color.WHITE);
		System.out.println(table.getSelectedRow());

		table.setBounds(0, 0, 470, 861);
		table.setGridColor(Color.GRAY);
		

		
		
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBackground(Color.LIGHT_GRAY);
		scrollPane.getVerticalScrollBar().setBackground(Color.LIGHT_GRAY);

		scrollPane.setBounds(0, 0, 470, 861);

		

		DataPanel.add(scrollPane);
		rowCount = table.getRowCount();

		//Updates the selected row upon user click
		table.addMouseListener(new MouseAdapter() {

			// Checking if the mouse enteres the label
			public void mouseClicked(MouseEvent me) {
				// System.out.println(table.getValueAt(table.getSelectedRow(),
				// table.getSelectedRow()));
				System.out.println(table.getSelectedRow());
				rowIndex = table.getSelectedRow();
				// selectedCell();
				System.out.println();
				//rowCount = table.getRowCount();

			}

		});
		
		

	}

	//Moves the data into another array called data which is used for the JTable
	// Moves the data from the csvData Array to the data array which is used to
	// display the data on the JTable
	public void displayData(String csvData[][]) {

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
		
		System.out.println("Entered displayData");
		// Takes the data from the csvData array and puts it into the data array which
		// will display the data
		for (int i = 0; i < rowCount; i++) {
			// System.out.println("Ran ILOOP");
			for (int j = 0; j < 5; j++) {
				// System.out.println("Ran JLOOP");
				// if(table.getValueAt(i, j) == null) {
				// System.out.println("Entered Table if");

				data[i][j] = csvData[i][j];

				// }

			}

		}

		//Refreshes the GUI
		dataPanelGUI();

	}

	
	//Returns the index of a selectedRow
	// Helper/util method gets called whenever this is needed
	public int getSelectedCell() {

		// Returns the index of the row
		return rowIndex;
	}

	//Goes through the rows and gets the amount of used rows
	// Helper/util method used to get the amount of rows data is in
	public int getUsedRows() {
		int rowCount = 0;
		for (int i = 0; i < data.length; i++) {

			if (csvDataCopy[i][0] == null) {

			} else {
				rowCount++;
			}

		}

		return rowCount + 1;

	}

	
	
	//Gets the table
	public JTable getTable() {
		
		return table;
		
		
		
		
	}

	//This is suppose to change the amount of rows display for the JTable (Does not work)
	public void setTableRows(int numOfRows) {
		System.out.println("----------- NEW ROW COUNT-------------");
		System.out.println(numOfRows);
		//model = new DefaultTableModel();
		
		//table.getModel();
		
		//model.setRowCount(numOfRows);
		//table.getModel()).setRowCount(numOfRows);
		model.setRowCount(numOfRows);
		table.setModel(model);
		dataPanelGUI();
		
	}
	
	//This scans the cells for text and saves them into a 2D array
	public void getChange() {
		
		String[] row = new String[5];
		
		System.out.println("USED ROWS----"+getUsedRows());
		
		//Saves the newly obtained data into the csvData array and into its corresponding indexes
		//Runs through cells that have a username in the row
		for(int i = 0; i < getUsedRows()-1; i++) {
			for(int j = 2; j < 5; j++) {
				
				//Makes sure there isnt a comma as the first character
				if(j == 2) {
					//Makes sure there is a value inside the cell
					if(table.getModel().getValueAt(i, j) != null) {
						row[j] = (String) table.getModel().getValueAt(i, j);
					}else {
						//If its null then it will place Empty
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
			mainFrame.getData().AddCellsToFile(csvDataCopy);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
