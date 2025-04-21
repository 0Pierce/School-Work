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

public class ActionPanel extends JPanel {
	
	protected JTextField textFieldUsername;
	protected JTextField textFieldPassword;
	
	
	
	
	
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
	JLabel lblEditing = new JLabel("");
	
	JLabel lblRowCount = new JLabel("");
	JLabel lblUP = new JLabel("");
	JLabel lblDOWN = new JLabel("");
	JLabel lblLine = new JLabel("");
	JLabel lblHover = new JLabel("");
	
	DataPanel dPanel;
	Data dataC = new Data();
	
	static int numOfUsers = 100;
	
	

	//Gets the number of users
	

	//Constructor
	public ActionPanel() throws IOException {
		
		System.out.println("ActionP Constructor");
		
		dPanel = new DataPanel();
		dataC = new Data();
		
		setBackground(Color.DARK_GRAY);
		setBounds(468, 0, 616, 861);
		
		setLayout(null);
		ActionPanelGUI();
		
	}
	
	
	//Handles all of the JLabel actions 
	public void ActionPanelGUI() {
		
		Border border2 = BorderFactory.createLineBorder(Color.RED, 3);
		
		JLabel lblTitle = new JLabel("");
		lblTitle.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\MainFrame\\TitleMain.png"));
		lblTitle.setBounds(3, 4, 606, 77);
		add(lblTitle);
		
		
		lblAdd.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\MainFrame\\Add.png"));
		lblAdd.setBounds(15, 750, 205, 104);
		lblAdd.setBorder(border2);
		add(lblAdd);
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

				//System.out.println("Hovering");
			}

			//Checking if the mouse exited the JLabel bounds
			public void mouseExited(MouseEvent me) {

				Border border = BorderFactory.createLineBorder(Color.RED, 3);
				lblAdd.setBorder(border);
				lblAdd.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\MainFrame\\Add.png"));

				//System.out.println("Not Hovering");
			}

			//Checks if the Jlabel is pressed and then released
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
		
		
		lblRemove.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\MainFrame\\Remove.png"));
		lblRemove.setBounds(234, 750, 372, 104);
		lblRemove.setBorder(border2);
		add(lblRemove);
		lblRemove.addMouseListener(new MouseAdapter() {
			

			// Checking if the mouse enteres the label
			public void mouseEntered(MouseEvent me) {

				// Updates the border with a specific orange
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				lblRemove.setBorder(border);
				// Switches the lbl to a new image while mouse is hovering over JLabel
				lblRemove.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\MainFrame\\RemoveHover.png"));

				//System.out.println("Hovering");
			}

			//Checking if the mouse exited the JLabel bounds
			public void mouseExited(MouseEvent me) {

				Border border = BorderFactory.createLineBorder(Color.RED, 3);
				lblRemove.setBorder(border);
				lblRemove.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\MainFrame\\Remove.png"));

				//System.out.println("Not Hovering");
			}

			//Checks if the Jlabel is pressed and then released
			public void mousePressed(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				lblRemove.setBorder(border);
				lblRemove.setIcon(new ImageIcon(""));

				
			}

			public void mouseReleased(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(Color.RED, 3);
				lblRemove.setBorder(border);
				lblRemove.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\MainFrame\\Remove.png"));
				
				if(dPanel.getSelectedCell() > 0) {
					
					
					
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
					
				}else {
					System.out.println("No Row Selected");
				}
				
				
				

			}

		});
		
		lblConfirm.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\MainFrame\\Confirm.png"));
		lblConfirm.addMouseListener(new MouseAdapter() {
			

			// Checking if the mouse enteres the label
			public void mouseEntered(MouseEvent me) {

				// Updates the border with a specific orange
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				lblConfirm.setBorder(border);
				// Switches the lbl to a new image while mouse is hovering over JLabel
				lblConfirm.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\MainFrame\\ConfirmHover.png"));

				//System.out.println("Hovering");
			}

			//Checking if the mouse exited the JLabel bounds
			public void mouseExited(MouseEvent me) {

				Border border = BorderFactory.createLineBorder(Color.RED, 3);
				lblConfirm.setBorder(border);
				lblConfirm.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\MainFrame\\Confirm.png"));

				//System.out.println("Not Hovering");
			}

			//Checks if the Jlabel is pressed and then released
			public void mousePressed(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				lblConfirm.setBorder(border);
				lblConfirm.setIcon(new ImageIcon(""));

				
			}

			public void mouseReleased(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(Color.RED, 3);
				lblConfirm.setBorder(border);
				lblConfirm.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\MainFrame\\Confirm.png"));
				
				//Makes sure there is data in the csvData Array which will then be altered
				try {
					dataC.importData();
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
				
				try {
					dataC.RemoveWriteToFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				

			}

		});
		lblConfirm.setBounds(56, 139, 500, 104);
		lblConfirm.setBorder(border2);
		add(lblConfirm);
		lblConfirm.setVisible(false);
		
		lblContinue.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\MainFrame\\Continue.png"));
		
		lblContinue.setBounds(61, 348, 490, 88);
		add(lblContinue);
		lblContinue.setVisible(false);
		
		lblCancel.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\MainFrame\\Cancel.png"));
		lblCancel.setBounds(109, 753, 394, 97);
		add(lblCancel);
		lblCancel.setBorder(border2);
		lblCancel.addMouseListener(new MouseAdapter() {
			

			// Checking if the mouse enteres the label
			public void mouseEntered(MouseEvent me) {

				// Updates the border with a specific orange
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				lblCancel.setBorder(border);
				// Switches the lbl to a new image while mouse is hovering over JLabel
				lblCancel.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\MainFrame\\CancelHover.png"));

				//System.out.println("Hovering");
			}

			//Checking if the mouse exited the JLabel bounds
			public void mouseExited(MouseEvent me) {

				Border border = BorderFactory.createLineBorder(Color.RED, 3);
				lblCancel.setBorder(border);
				lblCancel.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\MainFrame\\Cancel.png"));

				//System.out.println("Not Hovering");
			}

			//Checks if the Jlabel is pressed and then released
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
		

		
		
		
		
		
		
		lblUsername.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\MainFrame\\UsernameA.png"));
		lblUsername.setBounds(204, 236, 210, 51);
		add(lblUsername);
		lblUsername.setVisible(false);
		
		
		lblPassword.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\MainFrame\\PasswordA.png"));
		lblPassword.setBounds(204, 333, 210, 51);
		add(lblPassword);
		lblPassword.setVisible(false);
		
		
		textFieldUsername = new RoundedJTextField(10);
		textFieldUsername.setBounds(175, 288, 266, 34);
		add(textFieldUsername);
		textFieldUsername.setBorder(new LineBorder(Color.RED, 2));
		textFieldUsername.setForeground(Color.RED);
		textFieldUsername.setBackground(Color.gray);
		textFieldUsername.setFont(new Font("Comic Sans",Font.BOLD, 15));
		textFieldUsername.setColumns(10);
		textFieldUsername.setVisible(false);
		
		textFieldPassword = new RoundedJTextField(10);
		textFieldPassword.setColumns(10);
		textFieldPassword.setBounds(175, 381, 266, 34);
		add(textFieldPassword);
		textFieldPassword.setBorder(new LineBorder(Color.RED, 2));
		textFieldPassword.setForeground(Color.RED);
		textFieldPassword.setBackground(Color.gray);
		textFieldPassword.setFont(new Font("Comic Sans",Font.BOLD, 15));
		textFieldPassword.setVisible(false);
		
		
		
		
		lblCreateUser.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\MainFrame\\Create.png"));
		lblCreateUser.addMouseListener(new MouseAdapter() {
			

			// Checking if the mouse enteres the label
			public void mouseEntered(MouseEvent me) {

				// Updates the border with a specific orange
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				lblCreateUser.setBorder(border);
				// Switches the lbl to a new image while mouse is hovering over JLabel
				lblCreateUser.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\MainFrame\\CreateUserHover.png"));

				//System.out.println("Hovering");
			}

			//Checking if the mouse exited the JLabel bounds
			public void mouseExited(MouseEvent me) {

				Border border = BorderFactory.createLineBorder(Color.RED, 3);
				lblCreateUser.setBorder(border);
				lblCreateUser.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\MainFrame\\Create.png"));

				//System.out.println("Not Hovering");
			}

			//Checks if the JLabel is pressed and then released
			public void mousePressed(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				lblCreateUser.setBorder(border);
				lblCreateUser.setIcon(new ImageIcon(""));

				
			}

			public void mouseReleased(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(Color.RED, 3);
				lblCreateUser.setBorder(border);
				lblCreateUser.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\MainFrame\\Create.png"));

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
		add(lblCreateUser);
		lblCreateUser.setBorder(border2);
		lblCreateUser.setVisible(false);
		
	
		
		lblCancel2.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\MainFrame\\Cancel.png"));
		lblCancel2.setBounds(109, 753, 394, 97);
		add(lblCancel2);
		lblCancel2.setBorder(border2);
		lblCancel2.setVisible(false);
		lblCancel2.addMouseListener(new MouseAdapter() {
			

			// Checking if the mouse enteres the label
			public void mouseEntered(MouseEvent me) {

				// Updates the border with a specific orange
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				lblCancel2.setBorder(border);
				// Switches the lbl to a new image while mouse is hovering over JLabel
				lblCancel2.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\MainFrame\\CancelHover.png"));

				//System.out.println("Hovering");
			}

			//Checking if the mouse exited the JLabel bounds
			public void mouseExited(MouseEvent me) {

				Border border = BorderFactory.createLineBorder(Color.RED, 3);
				lblCancel2.setBorder(border);
				lblCancel2.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\MainFrame\\Cancel.png"));

				//System.out.println("Not Hovering");
			}

			//Checks if the Jlabel is pressed and then released
			public void mousePressed(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				lblCancel2.setBorder(border);
				lblCancel2.setIcon(new ImageIcon(""));

				
			}

			public void mouseReleased(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(Color.RED, 3);
				lblCancel2.setBorder(border);
				lblCancel2.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\MainFrame\\Cancel.png"));
				
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
		
		
		lblSave.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\MainFrame\\Save.png"));
		lblSave.setBounds(101, 597, 411, 138);
		add(lblSave);
		lblSave.setBorder(border2);
		lblSave.addMouseListener(new MouseAdapter() {
			

			// Checking if the mouse enteres the label
			public void mouseEntered(MouseEvent me) {

				// Updates the border with a specific orange
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				lblSave.setBorder(border);
				// Switches the lbl to a new image while mouse is hovering over JLabel
				lblSave.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\MainFrame\\SaveHover.png"));

				//System.out.println("Hovering");
			}

			//Checking if the mouse exited the JLabel bounds
			public void mouseExited(MouseEvent me) {

				Border border = BorderFactory.createLineBorder(Color.RED, 3);
				lblSave.setBorder(border);
				lblSave.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\MainFrame\\Save.png"));

				//System.out.println("Not Hovering");
			}

			//Checks if the Jlabel is pressed and then released
			public void mousePressed(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				lblSave.setBorder(border);
				lblSave.setIcon(new ImageIcon(""));

				
			}

			public void mouseReleased(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(Color.RED, 3);
				lblSave.setBorder(border);
				lblSave.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\MainFrame\\Save.png"));
				
				try {
					dPanel.getChange();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				
				
				
				

			}

		});
	
	
		lblRowCount.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\MainFrame\\RowCount.png"));
		lblRowCount.setBounds(24, 234, 565, 120);
		add(lblRowCount);

		lblUP.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\MainFrame\\ArrowUp.png"));
		lblUP.setBounds(244, 119, 124, 99);
		add(lblUP);
		// lblUP.setBorder(border2);
		lblUP.addMouseListener(new MouseAdapter() {

			// Checking if the mouse enteres the label
			public void mouseEntered(MouseEvent me) {

				// Updates the border with a specific orange
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				// lblUP.setBorder(border);
				// Switches the lbl to a new image while mouse is hovering over JLabel
				lblUP.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\MainFrame\\ArrowUpHover.png"));

				// System.out.println("Hovering");
			}

			// Checking if the mouse exited the JLabel bounds
			public void mouseExited(MouseEvent me) {

				Border border = BorderFactory.createLineBorder(Color.RED, 3);
				// lblUP.setBorder(border);
				lblUP.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\MainFrame\\ArrowUp.png"));

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
				lblUP.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\MainFrame\\ArrowUp.png"));

				//NumOfUsers = NumOfUsers + 5;
				System.out.println(ActionPanel.numOfUsers);
				/*
				 * getDataP().setNumOfUsers(NumOfUsers);
				 * getDataP().DataPanelGUI(); try { getData().importData();
				 * } catch (IOException e) { // TODO Auto-generated catch block
				 * e.printStackTrace(); }
				 */
				// changeRowCount(null, 1);
			}

		});

		lblDOWN.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\MainFrame\\ArrowDown.png"));
		lblDOWN.setBounds(244, 361, 124, 104);
		add(lblDOWN);
		// lblDOWN.setBorder(border2);
		lblDOWN.addMouseListener(new MouseAdapter() {

			// Checking if the mouse enteres the label
			public void mouseEntered(MouseEvent me) {

				// Updates the border with a specific orange
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				// lblDOWN.setBorder(border);
				// Switches the lbl to a new image while mouse is hovering over JLabel
				lblDOWN.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\MainFrame\\ArrowDownHover.png"));

				// System.out.println("Hovering");
			}

			// Checking if the mouse exited the JLabel bounds
			public void mouseExited(MouseEvent me) {

				Border border = BorderFactory.createLineBorder(Color.RED, 3);
				// lblDOWN.setBorder(border);
				lblDOWN.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\MainFrame\\ArrowDown.png"));

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
				lblDOWN.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\MainFrame\\ArrowDown.png"));
				//NumOfUsers = NumOfUsers - 5;
				//System.out.println(NumOfUsers);

				// changeRowCount(null, 1);

			}

		});

		lblLine.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\MainFrame\\Spacer.png"));
		lblLine.setBounds(-21, 481, 652, 33);
		add(lblLine);
		
	
	
		
	
		lblEditing.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\MainFrame\\Editing.png"));
		lblEditing.setBounds(11, 274, 590, 88);
		add(lblEditing);
		lblEditing.setVisible(false);
		
		lblUserOptions.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\MainFrame\\UserOptions.png"));
		lblUserOptions.setBounds(11, 500, 590, 122);
		add(lblUserOptions);
	
		
		
		
	}
	
	
	
	//Adds a new user to the JTable
	public void addUser() throws IOException {
		
		boolean check = false;
		
		System.out.println("Entered addUser");
		
		
	
		//Checks for blanks
		if(textFieldUsername.getText().isBlank() || textFieldPassword.getText().isBlank() ) {
			
			check = true;
			File sound = new File("C:\\Users\\pierc\\Desktop\\DVTImages\\Sounds\\Blank.wav");
			try {
				Clip clip = AudioSystem.getClip();
				clip.open(AudioSystem.getAudioInputStream(sound));
				clip.start();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		//If there arent any blanks it gets the text from the JFields and reads it onto the file
		if(check != true) {
			
			System.out.println("JTEXTFIELDS ARENT NULL");
			
			String temp = textFieldUsername.getText() + "," + textFieldPassword.getText();
			
			Data.writeToFile(temp);
			
			//out.println(temp);
			
			//out.println(textFieldUsername.getText());
			//out.println(textFieldPassword.getText());
			
			
			
			//Resets the gui
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
