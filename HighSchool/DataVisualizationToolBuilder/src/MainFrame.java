import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 900);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel DataPanel = new JPanel();
		DataPanel.setBackground(Color.LIGHT_GRAY);
		DataPanel.setBounds(0, 0, 470, 861);
		contentPane.add(DataPanel);
		DataPanel.setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, "", null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Usernames", "Passwords", "Screen Time", "Last Login", "Join Date"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(95);
		table.getColumnModel().getColumn(0).setMinWidth(95);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.RED, Color.RED));
		table.setBackground(Color.LIGHT_GRAY);
		table.setBounds(0, 0, 470, 861);
		DataPanel.add(table);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 470, 861);
		DataPanel.add(scrollPane);
		
		JButton button = new JButton("New button");
		scrollPane.setViewportView(button);
		
		JPanel ActionPanel = new JPanel();
		ActionPanel.setBackground(Color.DARK_GRAY);
		ActionPanel.setBounds(471, 0, 613, 861);
		contentPane.add(ActionPanel);
		ActionPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\MainFrame\\TitleMain.png"));
		lblNewLabel.setBounds(0, 0, 606, 77);
		ActionPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\Add.png"));
		lblNewLabel_1.setBounds(15, 103, 205, 104);
		ActionPanel.add(lblNewLabel_1);
		
		JLabel lblRemove = new JLabel("");
		lblRemove.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblRemove.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\Login\\LoginPressed2.png"));
		lblRemove.setBounds(235, 103, 367, 104);
		ActionPanel.add(lblRemove);
		
		JLabel lblUsername = new JLabel("");
		lblUsername.setIcon(new ImageIcon("C:\\Users\\pierc\\Downloads\\cooltext412844536184409.png"));
		lblUsername.setBounds(229, 536, 210, 51);
		ActionPanel.add(lblUsername);
		
		JLabel lblConfirm = new JLabel("");
		lblConfirm.setIcon(new ImageIcon("C:\\Users\\pierc\\Downloads\\Confirm.png"));
		lblConfirm.setBounds(56, 139, 500, 104);
		ActionPanel.add(lblConfirm);
		
		JLabel lblContinue = new JLabel("");
		lblContinue.setIcon(new ImageIcon("C:\\Users\\pierc\\Downloads\\Continue.png"));
		lblContinue.setBounds(61, 348, 490, 88);
		ActionPanel.add(lblContinue);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBackground(Color.RED);
		lblNewLabel_5.setForeground(Color.RED);
		lblNewLabel_5.setBounds(306, 4, 11, 708);
		ActionPanel.add(lblNewLabel_5);
		
		JLabel lblRowCount = new JLabel("");
		lblRowCount.setIcon(new ImageIcon("C:\\Users\\pierc\\Downloads\\cooltext413211746530527.png"));
		lblRowCount.setBounds(24, 304, 565, 120);
		ActionPanel.add(lblRowCount);
		
		JLabel lblUP = new JLabel("");
		lblUP.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\MainFrame\\ArrowUp.png"));
		lblUP.setBounds(244, 179, 124, 99);
		ActionPanel.add(lblUP);
		
		JLabel lblDOWN = new JLabel("New label");
		lblDOWN.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\MainFrame\\ArrowDown.png"));
		lblDOWN.setBounds(244, 421, 124, 104);
		ActionPanel.add(lblDOWN);
		
		JLabel lblLine = new JLabel("New label");
		lblLine.setIcon(new ImageIcon("C:\\Users\\pierc\\Downloads\\cooltext413212825384717.png"));
		lblLine.setBounds(-21, 521, 652, 33);
		ActionPanel.add(lblLine);
		
		JLabel lblHover = new JLabel("");
		lblHover.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\MainFrame\\ins.png"));
		lblHover.setBounds(150, 48, 312, 43);
		ActionPanel.add(lblHover);
	}
}
