package pack;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;

public class TicketBoard extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TicketBoard frame = new TicketBoard();
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
	public TicketBoard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 496, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\ScotlandYardImages\\TicketBoard.png"));
		lblNewLabel.setBounds(0, 0, 480, 90);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\ScotlandYardImages\\TaxiTicket.png"));
		lblNewLabel_1.setBounds(38, 210, 107, 62);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\ScotlandYardImages\\BusTicket.png"));
		lblNewLabel_1_1.setBounds(185, 210, 107, 62);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\ScotlandYardImages\\TubeTicket.png"));
		lblNewLabel_1_1_1.setBounds(335, 210, 107, 62);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setToolTipText("Testing Tooltips");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\ScotlandYardImages\\Remaining.png"));
		lblNewLabel_2.setBounds(95, 101, 289, 69);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("5");
		lblNewLabel_3.setForeground(Color.YELLOW);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_3.setBounds(38, 283, 107, 67);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("5");
		lblNewLabel_3_1.setForeground(Color.CYAN);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_3_1.setBounds(185, 283, 107, 67);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("5");
		lblNewLabel_3_1_1.setForeground(Color.RED);
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_3_1_1.setBounds(335, 283, 107, 67);
		contentPane.add(lblNewLabel_3_1_1);
		
		JLabel lbBlackTicket = new JLabel("");
		lbBlackTicket.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\ScotlandYardImages\\BlackTicket.png"));
		lbBlackTicket.setBounds(0, 101, 120, 73);
		contentPane.add(lbBlackTicket);
		
		JLabel X2Ticket = new JLabel("");
		X2Ticket.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\ScotlandYardImages\\DoubleMove.png"));
		X2Ticket.setBounds(380, 101, 100, 73);
		contentPane.add(X2Ticket);
		
		JLabel lbBlackTicketAmount = new JLabel("5");
		lbBlackTicketAmount.setFont(new Font("Tahoma", Font.BOLD, 30));
		lbBlackTicketAmount.setBounds(10, 159, 93, 48);
		contentPane.add(lbBlackTicketAmount);
		
		JLabel lbX2 = new JLabel("5");
		lbX2.setFont(new Font("Tahoma", Font.BOLD, 30));
		lbX2.setBounds(387, 159, 93, 48);
		contentPane.add(lbX2);
		
		JLabel lblLightRain = new JLabel("New label");
		lblLightRain.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\ScotlandYardImages\\LightRain.gif"));
		lblLightRain.setBounds(0, 107, 480, 361);
		contentPane.add(lblLightRain);
	}
}
