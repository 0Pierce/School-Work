package WindowBuilder;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;

public class BaseFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BaseFrame frame = new BaseFrame();
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
	public BaseFrame() {
		
		Color TopBlue = Color.decode("#5FC1FD");
		Color BottomBlue = Color.decode("#CBE7FE");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnGraph = new JButton("Regional Graph");
		btnGraph.setFont(new Font("Consolas", Font.BOLD, 20));
		btnGraph.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		
		btnGraph.setBounds(39, 30, 207, 48);
		contentPane.add(btnGraph);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 217, 234));
		panel.setBounds(0, 0, 984, 200);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(449, 21, 0, 0);
		panel.add(lblNewLabel);
		
		JButton btn2001 = new JButton("2001");
		btn2001.setBackground(Color.CYAN);
		btn2001.setVerticalAlignment(SwingConstants.BOTTOM);
		btn2001.setBounds(10, 125, 104, 41);
		panel.add(btn2001);
		btn2001.setFont(new Font("Syastro", Font.BOLD, 25));
		
		JButton btn2006 = new JButton("2006");
		btn2006.setVerticalAlignment(SwingConstants.BOTTOM);
		btn2006.setFont(new Font("Consolas", Font.BOLD, 25));
		btn2006.setBounds(152, 125, 104, 41);
		panel.add(btn2006);
		
		JLabel lblTitle = new JLabel("");
		lblTitle.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DataMiningImages\\Title1.png"));
		lblTitle.setForeground(new Color(255, 255, 255));
		lblTitle.setBackground(new Color(0, 255, 0));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		lblTitle.setBounds(288, 11, 430, 62);
		panel.add(lblTitle);
		
		JButton btn2016 = new JButton("2016");
		btn2016.setVerticalAlignment(SwingConstants.BOTTOM);
		btn2016.setFont(new Font("Consolas", Font.BOLD, 25));
		btn2016.setBounds(870, 125, 104, 41);
		panel.add(btn2016);
		
		JButton btn2011 = new JButton("2011");
		btn2011.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btn2011.setVerticalAlignment(SwingConstants.BOTTOM);
		btn2011.setFont(new Font("Consolas", Font.BOLD, 25));
		btn2011.setBounds(728, 125, 104, 41);
		panel.add(btn2011);
		
		JLabel lblGrass = new JLabel("");
		lblGrass.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DataMiningImages\\Leafs.gif"));
		lblGrass.setBounds(10, -14, 515, 200);
		panel.add(lblGrass);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DataMiningImages\\Leafs.gif"));
		lblNewLabel_2_1.setBounds(514, 41, 515, 200);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblActualGrass = new JLabel("");
		lblActualGrass.setIcon(new ImageIcon("C:\\Users\\pierc\\Downloads\\kissclipart-cartoon-grass-png-clipart-clip-art-b77b15b24b32cfaa.png"));
		lblActualGrass.setBounds(87, 106, 984, 157);
		panel.add(lblActualGrass);
		
		JLabel lblTree = new JLabel("");
		lblTree.setBounds(-254, -14, 713, 435);
		panel.add(lblTree);
		lblTree.setIcon(new ImageIcon("C:\\Users\\pierc\\Pictures\\Tree3.png"));
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(883, 0, 101, 22);
		panel.add(menuBar);
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setBounds(761, 0, 101, 22);
		panel.add(menuBar_1);
		
		JLabel lblins = new JLabel("");
		lblins.setIcon(new ImageIcon("C:\\Users\\pierc\\Downloads\\cooltext411613571349350.png"));
		lblins.setBounds(328, 106, 332, 67);
		panel.add(lblins);
		
		JLabel lblNewLabel_21 = new JLabel("");
		lblNewLabel_21.setIcon(new ImageIcon("C:\\Users\\pierc\\Downloads\\cooltext411613839956150.png"));
		lblNewLabel_21.setBounds(351, 166, 280, 34);
		panel.add(lblNewLabel_21);
		
		JLabel lblTopBar = new JLabel("New label");
		lblTopBar.setIcon(new ImageIcon("C:\\Users\\pierc\\Downloads\\cooltext411759696341392.png"));
		lblTopBar.setBounds(-23, 177, 1018, 32);
		panel.add(lblTopBar);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 190, 585, 10);
		panel.add(panel_2);
		
		//-------------------------------------------------------------------
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(203, 231, 254));
		panel_1.setBounds(0, 0, 984, 861);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblWestern = new JLabel("");
		lblWestern.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DataMiningImages\\MapWestern.png"));
		lblWestern.setBounds(33, 481, 249, 377);
		panel_1.add(lblWestern);
		
		JLabel lblSouthern = new JLabel("");
		lblSouthern.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DataMiningImages\\MapSouthern.png"));
		lblSouthern.setBounds(183, 587, 284, 206);
		panel_1.add(lblSouthern);
		
		JLabel lblCentral = new JLabel("");
		lblCentral.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DataMiningImages\\MapCentral.png"));
		lblCentral.setBounds(224, 569, 209, 129);
		panel_1.add(lblCentral);
		
		JLabel lblNorthEastern = new JLabel("");
		lblNorthEastern.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DataMiningImages\\MapNorthEastern.png"));
		lblNorthEastern.setBounds(153, 374, 358, 290);
		panel_1.add(lblNorthEastern);
		
		JLabel lblNorthern = new JLabel("");
		lblNorthern.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DataMiningImages\\MapNorthern.png"));
		lblNorthern.setBounds(1, 306, 462, 179);
		panel_1.add(lblNorthern);
		
		JLabel lblEastern = new JLabel("");
		lblEastern.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DataMiningImages\\MapEastern.png"));
		lblEastern.setBounds(350, 334, 398, 290);
		panel_1.add(lblEastern);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(25, 321, 46, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(32, 361, 46, 14);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(130, 421, 46, 14);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(149, 441, 46, 14);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBounds(187, 430, 46, 14);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setBounds(195, 411, 46, 14);
		panel_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setBounds(204, 379, 46, 14);
		panel_1.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setBounds(240, 372, 46, 14);
		panel_1.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setBounds(285, 383, 46, 14);
		panel_1.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("New label");
		lblNewLabel_10.setBounds(340, 404, 46, 14);
		panel_1.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("New label");
		lblNewLabel_11.setBounds(368, 467, 46, 14);
		panel_1.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("New label");
		lblNewLabel_12.setBounds(396, 457, 46, 14);
		panel_1.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("New label");
		lblNewLabel_13.setBounds(401, 469, 46, 14);
		panel_1.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("New label");
		lblNewLabel_14.setBounds(413, 464, 46, 14);
		panel_1.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("New label");
		lblNewLabel_15.setBounds(407, 442, 46, 14);
		panel_1.add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("New label");
		lblNewLabel_16.setBounds(457, 413, 46, 14);
		panel_1.add(lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel("New label");
		lblNewLabel_17.setBounds(441, 368, 46, 14);
		panel_1.add(lblNewLabel_17);
		
		JLabel lblNewLabel_18 = new JLabel("New label");
		lblNewLabel_18.setBounds(395, 360, 46, 14);
		panel_1.add(lblNewLabel_18);
		
		JLabel lblNewLabel_19 = new JLabel("New label");
		lblNewLabel_19.setBounds(364, 309, 46, 14);
		panel_1.add(lblNewLabel_19);
		
		JLabel lblNewLabel_20 = new JLabel("New label");
		lblNewLabel_20.setBounds(25, 308, 46, 14);
		panel_1.add(lblNewLabel_20);
		
		JLabel lblChart = new JLabel("New label");
		lblChart.setBounds(457, 605, 500, 256);
		panel_1.add(lblChart);
		
		JLabel lblArrowD = new JLabel("");
		lblArrowD.setIcon(new ImageIcon("C:\\Users\\pierc\\Downloads\\image (1).png"));
		lblArrowD.setBounds(792, 499, 72, 74);
		panel_1.add(lblArrowD);
		
		JLabel lblArrow = new JLabel("");
		lblArrow.setIcon(new ImageIcon("C:\\Users\\pierc\\Downloads\\image (2).png"));
		lblArrow.setBounds(792, 344, 72, 74);
		panel_1.add(lblArrow);
		
		JLabel lblyr = new JLabel("");
		lblyr.setIcon(new ImageIcon("C:\\Users\\pierc\\Downloads\\cooltext411612702191628.png"));
		lblyr.setBounds(732, 224, 159, 62);
		panel_1.add(lblyr);
		
		JLabel lblAmount = new JLabel("5");
		lblAmount.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblAmount.setBounds(802, 415, 72, 87);
		panel_1.add(lblAmount);
		
		JLabel lblNewLabel_22 = new JLabel("New label");
		lblNewLabel_22.setBounds(1, 192, 46, 14);
		panel_1.add(lblNewLabel_22);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(1, 186, 983, 20);
		panel_1.add(panel_3);
		
		
		
		
		
		
		
		
	}
}
