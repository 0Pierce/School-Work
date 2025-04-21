import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

public class MainGUI extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI frame = new MainGUI();
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
	public MainGUI() {
		setTitle("Student School Work Tracker");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 835, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(36, 36, 36));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel NewsFeedPanel = new JPanel();
		NewsFeedPanel.setBackground(new Color(36, 36,36));
		NewsFeedPanel.setBounds(76, 0, 743, 561);
		contentPane.add(NewsFeedPanel);
		NewsFeedPanel.setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
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
				"New column", "New column", "New column", "New column", "New column"
			}
		));
		table.setBackground(new Color(105, 105, 105));
		table.setBounds(0, 77, 743, 484);
		NewsFeedPanel.add(table);
		
		JLabel lblCalendar = new JLabel("New label");
		lblCalendar.setIcon(new ImageIcon("C:\\Users\\pierc\\Documents\\SWT Images\\Calendar.png"));
		lblCalendar.setBounds(0, 133, 77, 92);
		contentPane.add(lblCalendar);
		
		JLabel lblFeed = new JLabel("New label");
		lblFeed.setIcon(new ImageIcon("C:\\Users\\pierc\\Documents\\SWT Images\\newsFeed.png"));
		lblFeed.setBounds(0, 24, 77, 92);
		contentPane.add(lblFeed);
		
		JLabel lblUpload = new JLabel("New label");
		lblUpload.setIcon(new ImageIcon("C:\\Users\\pierc\\Documents\\SWT Images\\upload4.png"));
		lblUpload.setBounds(0, 469, 77, 92);
		contentPane.add(lblUpload);
	}
}
