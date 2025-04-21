package UserSideP;

import java.awt.Color;
import java.awt.Font;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;



public class GamePreview extends JFrame {
	
	private JPanel contentPane;
	JLabel gameImage;
	//Constructor
	public GamePreview() {
		
	}
	
	//This class will import a csv file containing game images and their corresponding numbers
	//[1] = gameImage 1 | [256] = gameImage 256
	//This will then be used to display the correct image in the preview
	public void importData() {
		
	}
	
	
	//GUI
	public void gamePreviewGUI(int num) {
		
		System.out.println("Entered GamePreviewGUI");
		System.out.println(num);
		
		setBounds(100, 100, 699, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
		
		//Displays the ganeIcon number based on which game is selected in CatBrowser
		Border border = BorderFactory.createLineBorder(new Color(6, 47, 255), 3);
		gameImage = new JLabel("" + num);
		gameImage.setBounds(0, 0, 683, 350);
		gameImage.setHorizontalAlignment(SwingConstants.CENTER);
		gameImage.setVisible(true);
		gameImage.setFont(new Font("Tahoma", Font.BOLD, 25));
		gameImage.setBorder(border);
		contentPane.add(gameImage);
		
		
		
	}
	
	//Displays the correct image that corresponds with the game clicked in Category Browser
	
	//Will later be replaced with File image
	

}
