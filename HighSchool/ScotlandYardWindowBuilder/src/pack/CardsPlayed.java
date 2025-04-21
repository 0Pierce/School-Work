package pack;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.ScrollPaneConstants;
import java.awt.Font;

public class CardsPlayed extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CardsPlayed frame = new CardsPlayed();
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
	public CardsPlayed() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 900);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl1st_Row1 = new JLabel("");
		lbl1st_Row1.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\ScotlandYardImages\\Tube.png"));
		lbl1st_Row1.setBounds(30, 140, 35, 34);
		contentPane.add(lbl1st_Row1);
		
		JLabel lbl6th_Row1 = new JLabel("");
		lbl6th_Row1.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\ScotlandYardImages\\Tube.png"));
		lbl6th_Row1.setBounds(10, 386, 119, 66);
		contentPane.add(lbl6th_Row1);
		
		JLabel lbl7th_Row1 = new JLabel("");
		lbl7th_Row1.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\ScotlandYardImages\\TaxiTicket.png"));
		lbl7th_Row1.setBounds(10, 451, 119, 66);
		contentPane.add(lbl7th_Row1);
		
		JLabel lbl8th_Row1 = new JLabel("");
		lbl8th_Row1.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\ScotlandYardImages\\BusTicket.png"));
		lbl8th_Row1.setBounds(10, 516, 119, 66);
		contentPane.add(lbl8th_Row1);
		
		JLabel lbl11th_Row1 = new JLabel("");
		lbl11th_Row1.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\ScotlandYardImages\\BusTicket.png"));
		lbl11th_Row1.setBounds(10, 705, 119, 66);
		contentPane.add(lbl11th_Row1);
		
		JLabel lbl10th_Row1 = new JLabel("");
		lbl10th_Row1.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\ScotlandYardImages\\Tube.png"));
		lbl10th_Row1.setBounds(10, 643, 119, 66);
		contentPane.add(lbl10th_Row1);
		
		JLabel lbl9th_Row1 = new JLabel("");
		lbl9th_Row1.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\ScotlandYardImages\\TaxiTicket.png"));
		lbl9th_Row1.setBounds(10, 580, 119, 66);
		contentPane.add(lbl9th_Row1);
		
//-----------------------------------------------------------------------------------------------------------------------		
		
		JLabel lbl11th_Row2 = new JLabel("");
		lbl11th_Row2.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\ScotlandYardImages\\Tube.png"));
		lbl11th_Row2.setBounds(293, 705, 119, 66);
		contentPane.add(lbl11th_Row2);
		
		JLabel lbl10th_Row2 = new JLabel("");
		lbl10th_Row2.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\ScotlandYardImages\\TaxiTicket.png"));
		lbl10th_Row2.setBounds(293, 643, 119, 66);
		contentPane.add(lbl10th_Row2);
		
		JLabel lbl9th_Row2 = new JLabel("");
		lbl9th_Row2.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\ScotlandYardImages\\TaxiTicket.png"));
		lbl9th_Row2.setBounds(293, 580, 119, 66);
		contentPane.add(lbl9th_Row2);
		
		JLabel lbl8th_Row2 = new JLabel("");
		lbl8th_Row2.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\ScotlandYardImages\\BusTicket.png"));
		lbl8th_Row2.setBounds(293, 516, 119, 66);
		contentPane.add(lbl8th_Row2);
		
		JLabel lbl7th_Row2 = new JLabel("");
		lbl7th_Row2.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\ScotlandYardImages\\BusTicket.png"));
		lbl7th_Row2.setBounds(293, 451, 119, 66);
		contentPane.add(lbl7th_Row2);
		
		JLabel lbl6th_Row2 = new JLabel("");
		lbl6th_Row2.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\ScotlandYardImages\\Tube.png"));
		lbl6th_Row2.setBounds(293, 386, 119, 66);
		contentPane.add(lbl6th_Row2);
		
		JLabel lbl1st_Row2 = new JLabel("");
		lbl1st_Row2.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\ScotlandYardImages\\Tube.png"));
		lbl1st_Row2.setBounds(293, 67, 119, 66);
		contentPane.add(lbl1st_Row2);
		
		JLabel lbl12th_Row1 = new JLabel("");
		lbl12th_Row1.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\ScotlandYardImages\\TaxiTicket.png"));
		lbl12th_Row1.setBounds(10, 771, 119, 66);
		contentPane.add(lbl12th_Row1);
		
		JLabel lbl12th_Row2 = new JLabel("");
		lbl12th_Row2.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\ScotlandYardImages\\Tube.png"));
		lbl12th_Row2.setBounds(293, 771, 119, 66);
		contentPane.add(lbl12th_Row2);
		
		JLabel lbTitle = new JLabel("");
		lbTitle.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\ScotlandYardImages\\TravelLog.png"));
		lbTitle.setBounds(110, 11, 346, 57);
		contentPane.add(lbTitle);
		
		JLabel lblNewLabel_1 = new JLabel("1)");
		lblNewLabel_1.setForeground(new Color(30, 144, 255));
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(46, 99, 35, 34);
		contentPane.add(lblNewLabel_1);
		
		JLabel lbl1st_Row1_1 = new JLabel("11)");
		lbl1st_Row1_1.setBounds(421, 99, 35, 34);
		contentPane.add(lbl1st_Row1_1);
		
		JLabel lbCloud = new JLabel("New label");
		lbCloud.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\ScotlandYardImages\\Clouds.gif"));
		lbCloud.setBounds(40, 0, 494, 517);
		contentPane.add(lbCloud);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\pierc\\Documents\\ScotlandYardImages\\BluredLog.png"));
		lblNewLabel.setBounds(0, 0, 584, 861);
		contentPane.add(lblNewLabel);
	}
}
