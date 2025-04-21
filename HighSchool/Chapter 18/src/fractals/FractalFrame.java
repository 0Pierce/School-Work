package fractals;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

//Crates the frame
public class FractalFrame extends JFrame implements ActionListener {

	// Fields or Attributes or 'global' variables or instance variables

	// These are the menus
	private JMenuBar menubar = new JMenuBar();
	private JMenu fractalMenu = new JMenu("Fractal");
	// Just the array that stores the different menu options
	private JMenuItem[] fractalArray = new JMenuItem[5];

	private static JPanel controlPanel = new JPanel();
	private FractalPanel fractalPanel = new FractalPanel(0);

	// Adds clickable buttons
	private JButton changeColorButton = new JButton("color");
	private JButton increaseLevelButton = new JButton("Increase Level");
	private JButton decreaseLevelButton = new JButton("Increase Level");
	// Crates the actual texts besides the buttons and such
	private JLabel levelLabel = new JLabel("Level: 0");

	// So the code doesnt fall into negative recursion and crashes
	private static final int MIN_LEVEL = 0, MAX_LEVEL = 20;

	// This is for the fractal types in that drop down menu top left
	public static String fractalType = "";

	// Constructor method - So the code knows what to run first
	public FractalFrame() {

		//
		setLayout(new FlowLayout());
		setTitle("Mr.Fernandes' Fractal App");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 680);

		//
		fractalArray[0] = new JMenuItem("Dragon Curve");
		fractalArray[1] = new JMenuItem("Lo Fractal");
		fractalArray[2] = new JMenuItem("Lo Star Fractal");
		fractalArray[3] = new JMenuItem("Sierpinski Triangle");
		fractalArray[4] = new JMenuItem("Koch SnowFlake");

		//
		for (JMenuItem item : fractalArray) {

			fractalMenu.add(item);
			item.addActionListener(this);

		}

		//
		menubar.add(fractalMenu);
		setJMenuBar(menubar);

		// To set up the control buttons
		setupControlButtons();

		// ControlPanel
		controlPanel.add(levelLabel);

		//
		add(controlPanel);
		add(fractalPanel);

		// Sets the window actually visible
		setVisible(true);

	}

	// Sets up the buttons on the screen
	private void setupControlButtons() {

		//
		controlPanel.add(changeColorButton);
		changeColorButton.addActionListener(

				new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent event) {

						// A way to create an action event and action listener at the same time

						Color color = JColorChooser.showDialog(FractalFrame.this, "Choose a color", Color.BLUE);

						if (color == null)
							color = Color.blue;

						fractalPanel.setColor(color);

					}

				}

		);

		controlPanel.add(changeColorButton);
		changeColorButton.addActionListener(

				new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent event) {

						// A way to create an action event and action listener at the same time

						Color color = JColorChooser.showDialog(FractalFrame.this, "Choose a color", Color.BLUE);

						if (color == null)
							color = Color.blue;

						fractalPanel.setColor(color);

					}

				}

		);

	}

	// So you can interact
	@Override
	public void actionPerformed(ActionEvent event) {

		// Checks if the MenuItem was clicked
		if (event.getSource() instanceof JMenuItem) {

			//
			JMenuItem menuItem = (JMenuItem) event.getSource();

			//
			fractalType = menuItem.getText();
			levelLabel.setText("Level: 0");
			fractalPanel.setLevel(0);
			repaint();

		}

	}

}
