package pack;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.jdi.event.EventQueue;
import javax.swing.JTextField;

public class ScotlandYardFrameWindowBuilder extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScotlandYardFrameWindowBuilder frame = new ScotlandYardFrameWindowBuilder();
				
					
					
					
					frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ScotlandYardFrameWindowBuilder() {
		setTitle("Scotland Yard BoardGame");
		
		ScotlandYardFrameWindowBuilder frame = new ScotlandYardFrameWindowBuilder();

		frame.setResizable(false);
		frame.setVisible(true);
		
		
		//Setsup the panel
		frame.setTitle("The ScotlandYard BoardGame");
		setBackground(Color.MAGENTA);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1018, 1000);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Adds the map
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\ScotlandYardImages\\TheSMap.png"));
		lblNewLabel.setBounds(676, 833, 305, 75);
		contentPane.add(lblNewLabel);
		
		//The Cards Played Button
		JButton btnNewButton = new JButton("TravelLog");
		btnNewButton.setForeground(new Color(102, 255, 0));
		btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(157, 121, 146, 46);
		contentPane.add(btnNewButton);
		
		JButton btnCardsAvailable = new JButton("Cards Available");
		btnCardsAvailable.setToolTipText("Cannot be closed until game has ended");
		btnCardsAvailable.setForeground(new Color(0, 102, 51));
		btnCardsAvailable.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		btnCardsAvailable.setBounds(157, 45, 146, 46);
		contentPane.add(btnCardsAvailable);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\ScotlandYardImages\\title.gif"));
		lblNewLabel_2.setBounds(732, 0, 270, 46);
		contentPane.add(lblNewLabel_2);
		
		//Turn
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\ScotlandYardImages\\Turn3.png"));
		lblNewLabel_3.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(385, 27, 231, 68);
		contentPane.add(lblNewLabel_3);
		
		//MRX
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\ScotlandYardImages\\Detective3.png"));
		lblNewLabel_4.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(395, 92, 374, 75);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\ScotlandYardImages\\ScotlandYardIcon.jpg"));
		lblNewLabel_1.setBounds(828, 47, 100, 97);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("End Turn");
		btnNewButton_1.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		btnNewButton_1.setBounds(606, 50, 100, 37);
		contentPane.add(btnNewButton_1);
		
		JButton btnNO = new JButton("");
		btnNO.setBackground(Color.DARK_GRAY);
		btnNO.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\ScotlandYardImages\\No.png"));
		btnNO.setBounds(187, 511, 170, 100);
		contentPane.add(btnNO);
		
		JButton btnYES = new JButton("");
		btnYES.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\ScotlandYardImages\\Yes2.png"));
		btnYES.setBackground(Color.DARK_GRAY);
		btnYES.setBounds(647, 511, 170, 100);
		contentPane.add(btnYES);
		
		JLabel lblRules = new JLabel("New label");
		lblRules.setIcon(new ImageIcon("C:\\Users\\pierc\\Downloads\\YardRules.png"));
		lblRules.setBounds(21, 78, 123, 46);
		contentPane.add(lblRules);
	}
}
