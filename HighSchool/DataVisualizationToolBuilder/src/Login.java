import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Toolkit;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUSER;
	private JTextField textFieldPASSWORD;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\pierc\\Downloads\\Webp.net-resizeimage (3).png"));
		setTitle("DVT Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		setMinimumSize(new Dimension(600, 450));
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		
		JLabel lblTitle = new JLabel("", SwingConstants.CENTER);
		lblTitle.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\Title.png"));
		
		JLabel lblUsername = new JLabel("", SwingConstants.CENTER);
		lblUsername.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\Username.png"));
		
		textFieldUSER = new JTextField();
		textFieldUSER.setColumns(10);
		
		JLabel lblPassword = new JLabel("", SwingConstants.CENTER);
		lblPassword.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\Password.png"));
		
		textFieldPASSWORD = new JTextField();
		textFieldPASSWORD.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("", SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\Login2.png"));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\pierc\\Desktop\\DVTImages\\Wrong.gif"));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTitle, GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
					.addGap(0))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(150)
					.addComponent(lblUsername, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(151))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(156)
					.addComponent(lblPassword, GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
					.addGap(145))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(99)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textFieldPASSWORD, GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
						.addComponent(textFieldUSER, GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE))
					.addGap(78))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(179)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
					.addGap(146))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(256)
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
					.addGap(272))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblTitle)
					.addGap(18)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
					.addGap(37)
					.addComponent(lblUsername, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textFieldUSER, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblPassword, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textFieldPASSWORD, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addGap(0))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
