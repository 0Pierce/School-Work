package name;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import Helpers.RoundedJTextField;

public class ActionPanel {

	protected JTextField textFieldUsername;
	protected JTextField textFieldPassword;

	protected JPanel actionPanel;

	private MainFrame mainFrame;

	JLabel lblAdd = new JLabel("");
	JLabel lblRemove = new JLabel("");

	JLabel lblUsername = new JLabel("");
	JLabel lblPassword = new JLabel("");
	JLabel lblCreateUser = new JLabel("");
	JLabel lblConfirm = new JLabel("");
	JLabel lblContinue = new JLabel("");
	JLabel lblCancel = new JLabel("");
	JLabel lblCancel2 = new JLabel("");

	JLabel lblSave = new JLabel("");
	JLabel lblUserOptions = new JLabel("");

	JLabel lblRowCount = new JLabel("");
	JLabel lblUP = new JLabel("");
	JLabel lblDOWN = new JLabel("");
	JLabel lblLine = new JLabel("");
	JLabel lblHover = new JLabel("");

	protected int numOfUsers = 100;

	//Gets the number of users
	public int getNumOfUsers() {
		return numOfUsers;
	}

	// Constructor
	public ActionPanel(MainFrame mainFrame) {

		System.out.println("ActionP Constructor");
		this.mainFrame = mainFrame;

		actionPanel = new JPanel();
		actionPanel.setBackground(Color.DARK_GRAY);
		actionPanel.setBounds(468, 0, 616, 861);
		mainFrame.add(actionPanel);
		actionPanel.setLayout(null);
		actionPanelGUI();

	}

	// Handles all of the JLabel actions
	public void actionPanelGUI() {

		Border border2 = BorderFactory.createLineBorder(Color.RED, 3);

		JLabel lblTitle = new JLabel("");
		lblTitle.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\MainFrame\\TitleMain.png"));
		lblTitle.setBounds(3, 4, 606, 77);
		lblTitle.setToolTipText("<html>" + "HOW TO USE:" + "<br>" + "Click 'Add' to add new users" + "<br>"
				+ "Select a row and Click 'Remove' to remove users" + "<br>"
				+ "To change or add information besides Usernames and Passwords click on the cells and then click save"
				+ "<br>" + "To change the number of rows simply press the arrows" + "<br>"
				+ "Do not enter commas ',' into the text fields or cells");
		actionPanel.add(lblTitle);

		
		//Below are a bunch of JLabels acting as buttons / just labels
		lblAdd.setIcon(new ImageIcon("DVTImages\\MainFrame\\Add.png"));
		lblAdd.setBounds(15, 750, 205, 104);
		lblAdd.setBorder(border2);
		actionPanel.add(lblAdd);
		lblAdd.addMouseListener(new MouseAdapter() {
			// ImageIcon imageIcon = new ImageIcon(new
			// ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\LoginHover.png").getImage().getScaledInstance(249,
			// 74, Image.SCALE_DEFAULT));

			// Checking if the mouse enteres the label
			public void mouseEntered(MouseEvent me) {

				// Updates the border with a specific orange
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);

				lblAdd.setBorder(border);
				// Switches the lbl to a new image while mouse is hovering over JLabel
				lblAdd.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\MainFrame\\AddHover.png"));

				// System.out.println("Hovering");
			}

			// Checking if the mouse exited the JLabel bounds
			public void mouseExited(MouseEvent me) {

				Border border = BorderFactory.createLineBorder(Color.RED, 3);
				lblAdd.setBorder(border);
				lblAdd.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\MainFrame\\Add.png"));

				// System.out.println("Not Hovering");
			}

			// Checks if the Jlabel is pressed and then released
			public void mousePressed(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				lblAdd.setBorder(border);
				lblAdd.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\"));

			}

			public void mouseReleased(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(Color.RED, 3);
				lblAdd.setBorder(border);
				lblAdd.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\MainFrame\\Add.png"));

				lblAdd.setVisible(false);
				lblRemove.setVisible(false);
				lblSave.setVisible(false);
				lblUserOptions.setVisible(false);

				lblRowCount.setVisible(false);
				lblUP.setVisible(false);
				lblDOWN.setVisible(false);
				lblLine.setVisible(false);
				lblHover.setVisible(false);

				lblUsername.setVisible(true);
				lblPassword.setVisible(true);
				textFieldUsername.setVisible(true);
				textFieldPassword.setVisible(true);
				lblCreateUser.setVisible(true);
				lblCancel2.setVisible(true);

			}

		});

		lblRemove.setIcon(new ImageIcon("DVTImages\\MainFrame\\Remove.png"));
		lblRemove.setBounds(234, 750, 372, 104);
		lblRemove.setBorder(border2);
		actionPanel.add(lblRemove);
		lblRemove.addMouseListener(new MouseAdapter() {

			// Checking if the mouse enteres the label
			public void mouseEntered(MouseEvent me) {

				// Updates the border with a specific orange
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				lblRemove.setBorder(border);
				// Switches the lbl to a new image while mouse is hovering over JLabel
				lblRemove.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\MainFrame\\RemoveHover.png"));

				// System.out.println("Hovering");
			}

			// Checking if the mouse exited the JLabel bounds
			public void mouseExited(MouseEvent me) {

				Border border = BorderFactory.createLineBorder(Color.RED, 3);
				lblRemove.setBorder(border);
				lblRemove.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\MainFrame\\Remove.png"));

				// System.out.println("Not Hovering");
			}

			// Checks if the Jlabel is pressed and then released
			public void mousePressed(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				lblRemove.setBorder(border);
				lblRemove.setIcon(new ImageIcon(""));

			}

			public void mouseReleased(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(Color.RED, 3);
				lblRemove.setBorder(border);
				lblRemove.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\MainFrame\\Remove.png"));

				if (mainFrame.getDataP().getSelectedCell() > 0) {

					lblAdd.setVisible(false);
					lblRemove.setVisible(false);
					lblSave.setVisible(false);
					lblUserOptions.setVisible(false);

					lblRowCount.setVisible(false);
					lblUP.setVisible(false);
					lblDOWN.setVisible(false);
					lblLine.setVisible(false);
					lblHover.setVisible(false);

					lblCancel.setVisible(true);
					lblConfirm.setVisible(true);

				} else {
					System.out.println("No Row Selected");
				}

			}

		});

		lblConfirm.setIcon(new ImageIcon("DVTImages\\MainFrame\\Confirm.png"));
		lblConfirm.addMouseListener(new MouseAdapter() {

			// Checking if the mouse enteres the label
			public void mouseEntered(MouseEvent me) {

				// Updates the border with a specific orange
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				lblConfirm.setBorder(border);
				// Switches the lbl to a new image while mouse is hovering over JLabel
				lblConfirm.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\MainFrame\\ConfirmHover.png"));

				// System.out.println("Hovering");
			}

			// Checking if the mouse exited the JLabel bounds
			public void mouseExited(MouseEvent me) {

				Border border = BorderFactory.createLineBorder(Color.RED, 3);
				lblConfirm.setBorder(border);
				lblConfirm.setIcon(new ImageIcon("DVTImages\\MainFrame\\Confirm.png"));

				// System.out.println("Not Hovering");
			}

			// Checks if the Jlabel is pressed and then released
			public void mousePressed(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				lblConfirm.setBorder(border);
				lblConfirm.setIcon(new ImageIcon(""));

			}

			public void mouseReleased(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(Color.RED, 3);
				lblConfirm.setBorder(border);
				lblConfirm.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\MainFrame\\Confirm.png"));

				// Makes sure there is data in the csvData Array which will then be altered
				try {
					mainFrame.getData().importData();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				lblAdd.setVisible(true);
				lblRemove.setVisible(true);
				lblUserOptions.setVisible(true);
				lblSave.setVisible(true);

				lblRowCount.setVisible(true);
				lblUP.setVisible(true);
				lblDOWN.setVisible(true);
				lblLine.setVisible(true);
				lblHover.setVisible(true);

				lblCancel.setVisible(false);
				lblConfirm.setVisible(false);

				mainFrame.getData().RemoveWriteToFile();

			}

		});
		lblConfirm.setBounds(56, 139, 500, 104);
		lblConfirm.setBorder(border2);
		actionPanel.add(lblConfirm);
		lblConfirm.setVisible(false);

		lblContinue.setIcon(new ImageIcon("DVTImages\\MainFrame\\Continue.png"));

		lblContinue.setBounds(61, 348, 490, 88);
		actionPanel.add(lblContinue);
		lblContinue.setVisible(false);

		lblCancel.setIcon(new ImageIcon("DVTImages\\MainFrame\\Cancel.png"));
		lblCancel.setBounds(109, 753, 394, 97);
		actionPanel.add(lblCancel);
		lblCancel.setBorder(border2);
		lblCancel.addMouseListener(new MouseAdapter() {

			// Checking if the mouse enteres the label
			public void mouseEntered(MouseEvent me) {

				// Updates the border with a specific orange
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				lblCancel.setBorder(border);
				// Switches the lbl to a new image while mouse is hovering over JLabel
				lblCancel.setIcon(new ImageIcon("DVTImages\\MainFrame\\CancelHover.png"));

				// System.out.println("Hovering");
			}

			// Checking if the mouse exited the JLabel bounds
			public void mouseExited(MouseEvent me) {

				Border border = BorderFactory.createLineBorder(Color.RED, 3);
				lblCancel.setBorder(border);
				lblCancel.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\MainFrame\\Cancel.png"));

				// System.out.println("Not Hovering");
			}

			// Checks if the Jlabel is pressed and then released
			public void mousePressed(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				lblCancel.setBorder(border);
				lblCancel.setIcon(new ImageIcon(""));

			}

			public void mouseReleased(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(Color.RED, 3);
				lblCancel.setBorder(border);
				lblCancel.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\MainFrame\\Cancel.png"));

				lblAdd.setVisible(true);
				lblRemove.setVisible(true);
				lblUserOptions.setVisible(true);
				lblSave.setVisible(true);

				lblRowCount.setVisible(true);
				lblUP.setVisible(true);
				lblDOWN.setVisible(true);
				lblLine.setVisible(true);
				lblHover.setVisible(true);

				lblCancel.setVisible(false);
				lblConfirm.setVisible(false);

			}

		});
		lblCancel.setVisible(false);

		lblUsername.setIcon(new ImageIcon("DVTImages\\MainFrame\\UsernameA.png"));
		lblUsername.setBounds(204, 236, 210, 51);
		actionPanel.add(lblUsername);
		lblUsername.setVisible(false);

		lblPassword.setIcon(new ImageIcon("DVTImages\\MainFrame\\PasswordA.png"));
		lblPassword.setBounds(204, 333, 210, 51);
		actionPanel.add(lblPassword);
		lblPassword.setVisible(false);

		textFieldUsername = new RoundedJTextField(10);
		textFieldUsername.setBounds(175, 288, 266, 34);
		actionPanel.add(textFieldUsername);
		textFieldUsername.setBorder(new LineBorder(Color.RED, 2));
		textFieldUsername.setForeground(Color.RED);
		textFieldUsername.setBackground(Color.gray);
		textFieldUsername.setFont(new Font("Comic Sans", Font.BOLD, 15));
		textFieldUsername.setColumns(10);
		textFieldUsername.setVisible(false);

		textFieldPassword = new RoundedJTextField(10);
		textFieldPassword.setColumns(10);
		textFieldPassword.setBounds(175, 381, 266, 34);
		actionPanel.add(textFieldPassword);
		textFieldPassword.setBorder(new LineBorder(Color.RED, 2));
		textFieldPassword.setForeground(Color.RED);
		textFieldPassword.setBackground(Color.gray);
		textFieldPassword.setFont(new Font("Comic Sans", Font.BOLD, 15));
		textFieldPassword.setVisible(false);

		lblCreateUser.setIcon(new ImageIcon("DVTImages\\MainFrame\\Create.png"));
		lblCreateUser.addMouseListener(new MouseAdapter() {

			// Checking if the mouse enteres the label
			public void mouseEntered(MouseEvent me) {

				// Updates the border with a specific orange
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				lblCreateUser.setBorder(border);
				// Switches the lbl to a new image while mouse is hovering over JLabel
				lblCreateUser
						.setIcon(new ImageIcon("DVTImages\\MainFrame\\CreateUserHover.png"));

				// System.out.println("Hovering");
			}

			// Checking if the mouse exited the JLabel bounds
			public void mouseExited(MouseEvent me) {

				Border border = BorderFactory.createLineBorder(Color.RED, 3);
				lblCreateUser.setBorder(border);
				lblCreateUser.setIcon(new ImageIcon("DVTImages\\MainFrame\\Create.png"));

				// System.out.println("Not Hovering");
			}

			// Checks if the JLabel is pressed and then released
			public void mousePressed(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				lblCreateUser.setBorder(border);
				lblCreateUser.setIcon(new ImageIcon(""));

			}

			public void mouseReleased(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(Color.RED, 3);
				lblCreateUser.setBorder(border);
				lblCreateUser.setIcon(new ImageIcon("DVTImages\\MainFrame\\Create.png"));

				try {
					addUser();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});
		lblCreateUser.setBounds(110, 437, 391, 82);
		actionPanel.add(lblCreateUser);
		lblCreateUser.setBorder(border2);
		lblCreateUser.setVisible(false);

		lblCancel2.setIcon(new ImageIcon("DVTImages\\MainFrame\\Cancel.png"));
		lblCancel2.setBounds(109, 753, 394, 97);
		actionPanel.add(lblCancel2);
		lblCancel2.setBorder(border2);
		lblCancel2.setVisible(false);
		lblCancel2.addMouseListener(new MouseAdapter() {

			// Checking if the mouse enteres the label
			public void mouseEntered(MouseEvent me) {

				// Updates the border with a specific orange
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				lblCancel2.setBorder(border);
				// Switches the lbl to a new image while mouse is hovering over JLabel
				lblCancel2.setIcon(new ImageIcon("DVTImages\\MainFrame\\CancelHover.png"));

				// System.out.println("Hovering");
			}

			// Checking if the mouse exited the JLabel bounds
			public void mouseExited(MouseEvent me) {

				Border border = BorderFactory.createLineBorder(Color.RED, 3);
				lblCancel2.setBorder(border);
				lblCancel2.setIcon(new ImageIcon("DVTImages\\MainFrame\\Cancel.png"));

				// System.out.println("Not Hovering");
			}

			// Checks if the Jlabel is pressed and then released
			public void mousePressed(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				lblCancel2.setBorder(border);
				lblCancel2.setIcon(new ImageIcon(""));

			}

			public void mouseReleased(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(Color.RED, 3);
				lblCancel2.setBorder(border);
				lblCancel2.setIcon(new ImageIcon("DVTImages\\MainFrame\\Cancel.png"));

				lblAdd.setVisible(true);
				lblRemove.setVisible(true);
				lblSave.setVisible(true);
				lblUserOptions.setVisible(true);

				lblRowCount.setVisible(true);
				lblUP.setVisible(true);
				lblDOWN.setVisible(true);
				lblLine.setVisible(true);
				lblHover.setVisible(true);

				lblUsername.setVisible(false);
				lblPassword.setVisible(false);
				textFieldUsername.setVisible(false);
				textFieldPassword.setVisible(false);
				lblCreateUser.setVisible(false);
				lblCancel2.setVisible(false);

			}

		});

		lblSave.setIcon(new ImageIcon("DVTImages\\MainFrame\\Save.png"));
		lblSave.setBounds(101, 597, 411, 138);
		actionPanel.add(lblSave);
		lblSave.setBorder(border2);
		lblSave.addMouseListener(new MouseAdapter() {

			// Checking if the mouse enteres the label
			public void mouseEntered(MouseEvent me) {

				// Updates the border with a specific orange
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				lblSave.setBorder(border);
				// Switches the lbl to a new image while mouse is hovering over JLabel
				lblSave.setIcon(new ImageIcon("DVTImages\\MainFrame\\SaveHover.png"));

				// System.out.println("Hovering");
			}

			// Checking if the mouse exited the JLabel bounds
			public void mouseExited(MouseEvent me) {

				Border border = BorderFactory.createLineBorder(Color.RED, 3);
				lblSave.setBorder(border);
				lblSave.setIcon(new ImageIcon("DVTImages\\MainFrame\\Save.png"));

				// System.out.println("Not Hovering");
			}

			// Checks if the Jlabel is pressed and then released
			public void mousePressed(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				lblSave.setBorder(border);
				lblSave.setIcon(new ImageIcon(""));

			}

			public void mouseReleased(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(Color.RED, 3);
				lblSave.setBorder(border);
				lblSave.setIcon(new ImageIcon("DVTImages\\MainFrame\\Save.png"));

				mainFrame.getDataP().getChange();

			}

		});

		lblRowCount.setIcon(new ImageIcon("DVTImages\\MainFrame\\RowCount.png"));
		lblRowCount.setBounds(24, 234, 565, 120);
		actionPanel.add(lblRowCount);

		lblUP.setIcon(new ImageIcon("DVTImages\\MainFrame\\ArrowUp.png"));
		lblUP.setBounds(244, 119, 124, 99);
		actionPanel.add(lblUP);
		// lblUP.setBorder(border2);
		lblUP.addMouseListener(new MouseAdapter() {

			// Checking if the mouse enteres the label
			public void mouseEntered(MouseEvent me) {

				// Updates the border with a specific orange
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				// lblUP.setBorder(border);
				// Switches the lbl to a new image while mouse is hovering over JLabel
				lblUP.setIcon(new ImageIcon("DVTImages\\MainFrame\\ArrowUpHover.png"));

				// System.out.println("Hovering");
			}

			// Checking if the mouse exited the JLabel bounds
			public void mouseExited(MouseEvent me) {

				Border border = BorderFactory.createLineBorder(Color.RED, 3);
				// lblUP.setBorder(border);
				lblUP.setIcon(new ImageIcon("DVTImages\\MainFrame\\ArrowUp.png"));

				// System.out.println("Not Hovering");
			}

			// Checks if the JLabel is pressed and then released
			public void mousePressed(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				// lblUP.setBorder(border);
				lblUP.setIcon(new ImageIcon(""));

			}

			public void mouseReleased(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(Color.RED, 3);
				// lblUP.setBorder(border);
				lblUP.setIcon(new ImageIcon("DVTImages\\MainFrame\\ArrowUp.png"));

				numOfUsers = numOfUsers + 5;
				mainFrame.getDataP().setTableRows(numOfUsers);
			}

		});

		lblDOWN.setIcon(new ImageIcon("DVTImages\\MainFrame\\ArrowDown.png"));
		lblDOWN.setBounds(244, 361, 124, 104);
		actionPanel.add(lblDOWN);
		// lblDOWN.setBorder(border2);
		lblDOWN.addMouseListener(new MouseAdapter() {

			// Checking if the mouse enteres the label
			public void mouseEntered(MouseEvent me) {

				// Updates the border with a specific orange
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				// lblDOWN.setBorder(border);
				// Switches the lbl to a new image while mouse is hovering over JLabel
				lblDOWN.setIcon(new ImageIcon("DVTImages\\MainFrame\\ArrowDownHover.png"));

				// System.out.println("Hovering");
			}

			// Checking if the mouse exited the JLabel bounds
			public void mouseExited(MouseEvent me) {

				Border border = BorderFactory.createLineBorder(Color.RED, 3);
				// lblDOWN.setBorder(border);
				lblDOWN.setIcon(new ImageIcon("DVTImages\\MainFrame\\ArrowDown.png"));

				// System.out.println("Not Hovering");
			}

			// Checks if the JLabel is pressed and then released
			public void mousePressed(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				// lblDOWN.setBorder(border);
				lblDOWN.setIcon(new ImageIcon(""));

			}

			public void mouseReleased(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(Color.RED, 3);
				// lblDOWN.setBorder(border);
				lblDOWN.setIcon(new ImageIcon("DVTImages\\MainFrame\\ArrowDown.png"));
				numOfUsers = numOfUsers - 5;
				// System.out.println(NumOfUsers);
				mainFrame.getDataP().setTableRows(numOfUsers);
				// changeRowCount(null, 1);

			}

		});

		lblLine.setIcon(new ImageIcon("DVTImages\\MainFrame\\Spacer.png"));
		lblLine.setBounds(-21, 481, 652, 33);
		actionPanel.add(lblLine);

		lblHover.setIcon(new ImageIcon("DVTImages\\MainFrame\\ins.png"));
		lblHover.setBounds(150, 48, 312, 43);
		actionPanel.add(lblHover);

		lblUserOptions.setIcon(new ImageIcon("DVTImages\\MainFrame\\UserOptions.png"));
		lblUserOptions.setBounds(11, 500, 590, 122);
		actionPanel.add(lblUserOptions);

	}

	// Adds in new users through checking the JText fields and adding them onto the
	// data Array
	public void addUser() throws IOException {

		boolean check = false;

		System.out.println("Entered addUser");

		// Checks for blank Jtext fields
		if (textFieldUsername.getText().isBlank() || textFieldPassword.getText().isBlank()) {

			check = true;
			File sound = new File("DVTImages\\Sounds\\Blank.wav");
			try {
				Clip clip = AudioSystem.getClip();
				clip.open(AudioSystem.getAudioInputStream(sound));
				clip.start();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		// If there arent any duplicates then it writes the data
		if (check != true) {

			System.out.println("JTEXTFIELDS ARENT NULL");

			String temp = textFieldUsername.getText() + "," + textFieldPassword.getText();

			mainFrame.getData().WriteToFile(temp);

			// out.println(temp);

			// out.println(textFieldUsername.getText());
			// out.println(textFieldPassword.getText());

			// Resets the GUI to its default state
			lblAdd.setVisible(true);
			lblRemove.setVisible(true);
			lblSave.setVisible(true);
			lblUserOptions.setVisible(true);

			lblRowCount.setVisible(true);
			lblUP.setVisible(true);
			lblDOWN.setVisible(true);
			lblLine.setVisible(true);
			lblHover.setVisible(true);

			lblUsername.setVisible(false);
			lblPassword.setVisible(false);
			textFieldUsername.setVisible(false);
			textFieldPassword.setVisible(false);
			lblCreateUser.setVisible(false);
			lblCancel2.setVisible(false);

			System.out.println("Finished");

		}

	}

}
