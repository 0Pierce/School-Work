package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ColorUIResource;

public class TravelLogX extends JFrame {

	private JPanel contentPane;
	private int doubleflag = 0;
	
	/**
	 * Create the frame.
	 */
	public TravelLogX() {

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		setVisible(true);
		setResizable(false);

		System.out.println("Entered TLOG constructor");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setBackground(Color.DARK_GRAY);
		setContentPane(contentPane);
		TravelLogPanel();
	}

	// TODO make it so you can see the postition if it's misterX's turn and if you
	// click on it
	// create our way to know the methods of transports
	// and the labels that will hold them
	private JLabel[] numbers = new JLabel[25];
	private JLabel[] transports = new JLabel[25];
	private JLabel[] points = new JLabel[25];
	Color CustomBlue = Color.decode("#5FC1FD");
	JLabel lbblur = new JLabel("");

	private int flag = 0;
	private int round = 1;
	
	protected int point;

	public void TravelLogPanel() {
		
		
		
		
		setLayout(null);
		// setting the box to be 200x100
		setBounds(1366 - 250, 708 - 300, 600, 900);
		// setting the background to a custom rgb value (light blue)
		setBackground(new ColorUIResource(150, 150, 255));

		

		// Creates the title
		JLabel lbTitle = new JLabel("");
		lbTitle.setIcon(new ImageIcon("images/TravelLog.png"));
		lbTitle.setToolTipText("Dont forget to hide this window!");
		lbTitle.setBounds(110, 11, 346, 57);
		contentPane.add(lbTitle);

		System.out.println("TLOG Panel");

		// add the title
		add(lbTitle);
		// create our labels and update the text
		createLabels();

	}

	public void determineTransport(int c) {

		
		
		
		ImageIcon icon = null;
		if (c == 1) {

			icon = new ImageIcon("images/TaxiTicket.png");
			
		} else if (c == 2) {

			System.out.println("C = 2 ");
			icon = new ImageIcon("images/BusTicket.png");
			;
		} else if (c == 3) {

			System.out.println("C = 3 ");
			icon = new ImageIcon("images/TubeTicket.png");
			
		} else if (c == 4) {
			icon = new ImageIcon("images/BlackTicket.png");

		} else if (c == 5) {
			
			icon = new ImageIcon("images/DoubleMove.png");
		}
		
		
		
		transports[round].setIcon(icon);
		c = 0;
		round++;
	}

	// These loops were created with the help of Marc. I adjusted them to add the
	// functionality of adding images instead of text
	private void createLabels() {
		int height1 = 30;
		int height2 = 30;
		// for each label in the first column
		for (int i = 1; i <= 12; i++) {
			int y = 20 + (i * 13);
			height1 += 50;

			numbers[i] = new JLabel(i + "|");
			numbers[i].setBounds(46, height1, 140, y + 100);
			numbers[i].setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
			numbers[i].setForeground(CustomBlue);
			add(numbers[i]);

			transports[i] = new JLabel();
			transports[i].setBounds(76, height1, 140, y + 100);
			add(transports[i]);

			System.out.println("Placed points");
			points[i] = new JLabel(point + " |");
			points[i].setBounds(196, height1, 140, y + 100);
			points[i].setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
			points[i].setForeground(CustomBlue);
			add(points[i]);

			

		}
		// for each label in the second column
		for (int i = 13; i <= 24; i++) {
			int y = 20 + ((i - 12) * 13);
			height2 += 50;
			numbers[i] = new JLabel(i + ".|");
			numbers[i].setBounds(421, height2, 140, y + 100);
			numbers[i].setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
			numbers[i].setForeground(CustomBlue);
			add(numbers[i]);

			transports[i] = new JLabel();
			transports[i].setBounds(461, height2, 140, y + 100);
			add(transports[i]);

			points[i] = new JLabel("| " + point);
			points[i].setBounds(280, height2, 140, y + 100);
			points[i].setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
			points[i].setForeground(CustomBlue);
			add(points[i]);

		}

		JLabel lbCloud = new JLabel("");
		lbCloud.setIcon(new ImageIcon("images/Clouds.gif"));
		lbCloud.setBounds(35, -130, 494, 517);
		contentPane.add(lbCloud);

	}

}