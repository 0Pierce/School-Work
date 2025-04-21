package name;

import java.awt.Color;
import java.io.IOException;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainFrame extends JFrame {

	/******
	 * NOTE******* - Please read
	 * 
	 * **Transparency** I asked an online friend with much more talent than me how
	 * would he go about solving the issue i had Hes the one that suggested i do it
	 * this way. So i did not come up with this method of passing around the
	 * variables solely on my own.
	 * 
	 * I will explain how the following variables are passed around. NumOfUsers,
	 * csvData Due to the somewhat scattered nature of the getters and setters i
	 * will explain it here in one segment
	 *
	 **** Reasoning**** I had to change my previous class plan due to not being able to
	 * call Data subclasses due to stackoverflow. Because of this i have decided to
	 * scrap any direct relationship between MainFrame, Both Panels and Data. Due to
	 * this ive implemented this slightly bizzare system of passing around the
	 * needed fields. Inheritance in this project is displayed via the interfaces
	 * which further modulize the project allowing foreign csvData to be imported (NOT IMPLEMENTED)
	 *
	 **** Logic**** To start off the MainFrame constructor calls both panels and data
	 * in a very specific order. the field start2 begins this by calling the
	 * ActionPanel Constructor The constructor creates an object of mainframe
	 * allowing the panel to be placed onto the mainframe This then runs the
	 * resulting GUI Once this finishes the DataPanelGUI gets created, it works very
	 * similarly to the ActionPanel in this regard. For the data something slightly
	 * different happens. Call starts the Data and this passes on the DataPanel
	 * Object This object is then renamed to panel in the Data constructor which
	 * allows the vital transfer of NumOfUsers between the classes This panel object
	 * is then used to call on the various getters which enables the pass around of
	 * the variable. The same principal is used for csvData
	 * 
	 * All class objects also have their own getters which enables them to be called
	 * through the mainFrame object. This enables me to call any methods in any
	 * class
	 * 
	 * Thank you for reading.
	 */

	private Data call;

	private ActionPanel start2;
	private DataPanel start;

	//Constructor
	public MainFrame() {

		System.out.println("MainFrame Constructor");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 900);
		setResizable(false);

		this.getContentPane().setBackground(Color.DARK_GRAY);
		((JComponent) this.getContentPane()).setBorder(new EmptyBorder(5, 5, 5, 5));

		this.getContentPane().setLayout(null);

		// DataPanel start = new DataPanel(contentPane);
		start2 = new ActionPanel(this);
		start = new DataPanel(this);
		call = new Data(start);
		try {
			call.importData();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		setLayout(null);
		
		setVisible(true);

	}

	//Gets actionPanel
	public ActionPanel getActionP() {
		return start2;
	}

	//Gets dataPanel
	public DataPanel getDataP() {
		return start;
	}

	//Gets the data class
	public Data getData() {
		return call;
	}

}
