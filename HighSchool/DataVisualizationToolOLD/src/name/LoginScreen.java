package name;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Helpers.RoundedJPasswordField;
import Helpers.RoundedJTextField;


public class LoginScreen extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUser;
	private JTextField textFieldPassword;
	private int Horizontal;
	private int Vertical;
	boolean isExecuted;

	// Constructor
	// ---------------------------------------------------------------------
	public LoginScreen() {


		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\pierc\\Desktop\\DVTImages\\Login\\FrameIcon.png"));
		setTitle("DVT Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 520);
		setVisible(true);
		setMinimumSize(new Dimension(600, 520));
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		LoginScreenGUI();
	}

	// Starts the gui
	// ---------------------------------------------------------------------
	public void LoginScreenGUI() {


		JLabel lblTitle = new JLabel("", SwingConstants.CENTER);
		lblTitle.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\Login\\Title.png"));

		JLabel lblUsername = new JLabel("", SwingConstants.CENTER);
		lblUsername.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\Login\\Username.png"));

		textFieldUser = new RoundedJTextField(10);
		

		JLabel lblPassword = new JLabel("", SwingConstants.CENTER);
		lblPassword.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\Login\\Password.png"));

		
		
		
		textFieldPassword = new RoundedJPasswordField(10);
		//textFieldPassword.setColumns(10);

		JLabel lblLogin = new JLabel("", SwingConstants.CENTER);
		lblLogin.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\Login\\Login2.png"));
		// Just so it appears without you having to hover over the login button
		Border border = BorderFactory.createLineBorder(Color.RED, 3);
		lblLogin.setBorder(border);

		GroupLayout gl_contentPane = new GroupLayout(contentPane);

		// Sets the contentPane groups
		// ---------------------------------------------------------------------
		// These groups let the program be able to reasize all the components and keep
		// it together and organized
		// Horizontal Group
		gl_contentPane.setHorizontalGroup(

				gl_contentPane.createParallelGroup(Alignment.TRAILING)
						// Adds various components to the horizontal group
				.addGroup(gl_contentPane.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblTitle, GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
						.addGap(0))
					.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(150)
						.addComponent(lblUsername, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(151))
					.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(156)
						.addComponent(lblPassword, GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
						.addGap(145))
					.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(99)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addComponent(textFieldPassword, GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
							.addComponent(textFieldUser, GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE))
						.addGap(78))
					.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
						.addGap(179)
						.addComponent(lblLogin, GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
						.addGap(146))
					.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
						.addGap(246))
						

		);

		System.out.println("MIDDLE");

		// Vertical Group
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				// Adds various components to the Vertical group
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(lblTitle)
						.addGap(45)
						.addComponent(lblUsername, GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(textFieldUser, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(lblPassword, GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(textFieldPassword, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addGap(10)
						.addComponent(lblLogin, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(0))

		);
		
		
		//textFieldPassword.setEchoChar("*");
		
		contentPane.setLayout(gl_contentPane);

		// Login Button Logic
		// ---------------------------------------------------------------------
		System.out.println("Above Scale");

		System.out.println("Reached Scale");
		
		textFieldUser.setBorder(new LineBorder(Color.RED, 2));
		textFieldUser.setBackground(Color.gray);
		textFieldUser.setForeground(Color.RED);
		textFieldUser.setFont(new Font("Comic Sans",Font.BOLD, 15));
		
		
		textFieldPassword.setBorder(new LineBorder(Color.RED, 2));
		textFieldPassword.setForeground(Color.RED);
		textFieldPassword.setBackground(Color.gray);
		textFieldPassword.setFont(new Font("Comic Sans",Font.BOLD, 15));
		
		

		//Adds a keyListener to both textfields so the user can just click enter upon typing in their information
		textFieldUser.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				
				//Sorts out the keycode stuff - Ensures the specific key is pressed before any action
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					//Just calls CheckCredencials method with the text entered into the text fields
					CheckCreds(textFieldUser.getText(), textFieldPassword.getText());
				}
				
				
				
			}
			
		});
		
		textFieldPassword.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					CheckCreds(textFieldUser.getText(), textFieldPassword.getText());
				}
				
				
				
			}
			
		});
		
		
		
		lblLogin.addMouseListener(new MouseAdapter() {
			// ImageIcon imageIcon = new ImageIcon(new
			// ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\LoginHover.png").getImage().getScaledInstance(249,
			// 74, Image.SCALE_DEFAULT));

			// Checking if the mouse enteres the label
			public void mouseEntered(MouseEvent me) {

				// Updates the border with a specific orange
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				lblLogin.setBorder(border);
				// Switches the lbl to a new image while mouse is hovering over JLabel
				lblLogin.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\Login\\LoginHover2.png"));

				//System.out.println("Hovering");
			}

			//Checking if the mouse exited the JLabel bounds
			public void mouseExited(MouseEvent me) {

				Border border = BorderFactory.createLineBorder(Color.RED, 3);
				lblLogin.setBorder(border);
				lblLogin.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\Login\\Login2.png"));

				//System.out.println("Not Hovering");
			}

			//Checks if the Jlabel is pressed and then released
			public void mousePressed(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(new Color(212, 94, 0), 3);
				lblLogin.setBorder(border);
				lblLogin.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\Login\\LoginPressed2.png"));

				CheckCreds(textFieldUser.getText(), textFieldPassword.getText());
			}

			public void mouseReleased(MouseEvent me) {
				Border border = BorderFactory.createLineBorder(Color.RED, 3);
				lblLogin.setBorder(border);
				lblLogin.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\Login\\Login2.png"));

			}

		});

	}

	public void CheckCreds(String ans1, String ans2) {

		//System.out.println(ans1);
		//System.out.println(ans2);

		//Currently only one login
		//I didnt think it was important to add in multiple logins or the creation of new logins.
		//Realistically there would be a way to create a new login but for time purposes i chose not to do it.
		String username = "a";
		String password = "s";

		if (ans1.equals(username) && ans2.equals(password)) {

			File sound = new File("C:\\Users\\pierc\\Desktop\\DVTImages\\Sounds\\Granted.wav");
			try {
				Clip clip = AudioSystem.getClip();
				clip.open(AudioSystem.getAudioInputStream(sound));
				clip.start();
			} catch (Exception e) {
				e.printStackTrace();
			}

			
			dispose();
			
			
			MainFrame start = new MainFrame();

			
			
			
			

		}else if(ans1 != username || ans2 != password) {
			//System.out.println("Entered denied");
			
			
			
			File sound = new File("C:\\Users\\pierc\\Desktop\\DVTImages\\Sounds\\Denied.wav");
			try {
				Clip clip = AudioSystem.getClip();
				clip.open(AudioSystem.getAudioInputStream(sound));
				clip.start();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}

	}
	
	
	
	
	
	

}
