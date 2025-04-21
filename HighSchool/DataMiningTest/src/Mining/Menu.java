package Mining;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class Menu extends JFrame {

	private JPanel contentPane;
	public int amountofData = 10;
	
	//IMPORTANT - MUST BE ADDED TO THE FINAL MENU
	JLabel lblyr2001 = new JLabel("");
	JLabel lblyr2006 = new JLabel("");
	JLabel lblyr2011 = new JLabel("");
	JLabel lblyr2016 = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Menu frame = new Menu();
		frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public Menu() {
		


		//IMPORTANT - MUST BE ADDED TO THE FINAL MENU
		lblyr2001.setVisible(false);
		lblyr2006.setVisible(false);
		lblyr2011.setVisible(false);
		lblyr2016.setVisible(false);
		
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JButton btntest = new JButton("Open");
		btntest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//Frame
				FarmAreaOriginal frame = new FarmAreaOriginal();
				frame.setVisible(true);
				frame.setResizable(false);
				
				

			}
		});
		contentPane.add(btntest, BorderLayout.CENTER);
	}
	
	

}
