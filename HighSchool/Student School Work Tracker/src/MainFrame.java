import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class MainFrame extends JFrame {
	private JPanel contentPane;
	JTable table;
	
	private String data[][];

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
		setTitle("Student School Work Tracker");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 835, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(10, 10, 10));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		mainFrameGUI();
		
	}
	
	//Main GUI
	public void mainFrameGUI(){
		
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
		
		JPanel NewsFeedPanel = new JPanel();
		NewsFeedPanel.setBackground(new Color(36, 36,36));
		NewsFeedPanel.setBounds(76, 0, 743, 561);
		contentPane.add(NewsFeedPanel);
		NewsFeedPanel.setLayout(null);
	
		
		
		
		
		String Column[] = { "Usernames", "Passwords", "Screen Time", "Last Login", "Join Date" };
		
		table = new JTable(data, Column) {

			
			private boolean[] canEdit = new boolean[] { false, false, true, true, true};

			public boolean isCellEditable(int row, int column) {

				//Makes sure the 3 last colums can be edited
				return canEdit[column];
			};

		};
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		JPanel CalendarPanel = new JPanel();
		CalendarPanel.setBackground(Color.GRAY);
		CalendarPanel.setBounds(0, 0, 743, 561);
		NewsFeedPanel.add(CalendarPanel);
		CalendarPanel.setLayout(null);
		
		
		
		
		
		
		
		
		
		
	}

}
