import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.SwingConstants;

public class CatBrowser extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CatBrowser frame = new CatBrowser();
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
	public CatBrowser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 870);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel GamePanel = new JPanel();
		GamePanel.setBackground(Color.DARK_GRAY);
		GamePanel.setBounds(0, 181, 884, 561);
		contentPane.add(GamePanel);
		GamePanel.setLayout(new GridLayout(0, 4, 1, 1));
		
		JLabel lblNewLabel_8 = new JLabel("1");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 20));
		GamePanel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		GamePanel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		GamePanel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		GamePanel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		GamePanel.add(lblNewLabel_7);
		
		JPanel TopPanel = new JPanel();
		TopPanel.setBackground(Color.LIGHT_GRAY);
		TopPanel.setBounds(0, 0, 884, 181);
		contentPane.add(TopPanel);
		TopPanel.setLayout(null);
		
		JLabel Title = new JLabel("Category");
		Title.setBounds(0, 0, 884, 33);
		TopPanel.add(Title);
		
		JPanel CatPanelL = new JPanel();
		CatPanelL.setBounds(0, 36, 280, 145);
		TopPanel.add(CatPanelL);
		CatPanelL.setLayout(new GridLayout(5, 0, 0, 1));
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		CatPanelL.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		CatPanelL.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		CatPanelL.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		CatPanelL.add(lblNewLabel_4);
		
		JLabel lblNewLabel = new JLabel("New label");
		CatPanelL.add(lblNewLabel);
		
		JPanel CatPanelM = new JPanel();
		CatPanelM.setBounds(302, 36, 280, 145);
		TopPanel.add(CatPanelM);
		CatPanelM.setLayout(new GridLayout(5, 0, 0, 0));
		
		JPanel CatPanelR = new JPanel();
		CatPanelR.setBounds(604, 36, 280, 145);
		TopPanel.add(CatPanelR);
		CatPanelR.setLayout(new GridLayout(5, 0, 0, 0));
		
		JPanel BottomPanel = new JPanel();
		BottomPanel.setBounds(0, 742, 884, 89);
		contentPane.add(BottomPanel);
	}
}
