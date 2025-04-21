package Mining;

import java.awt.BorderLayout;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;



import java.awt.GridLayout;
import java.awt.MenuItem;
import java.awt.Window;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.GeneralPath;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.Color;
import java.awt.Component;

import javax.swing.SwingConstants;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;

public class FarmAreaOriginal extends Menu {

	// These are the XY coords for each regions bounds.
	// I did this by using WindowBuilder and placing Jlabels where i want each point
	// to be. I then just copied the XY of each JLabel and put them here.
	// It took some tweaking to make it accurate but it worked very well overall and
	// wasnt too painful to do.
	private JPanel contentPane;
	int xPoints[] = { 183, 193, 183, 183, 168, 156, 157, 109, 98, 54, 52, 136, 221, 279, 238, 229, 240, 238, 215, 225,
			229, 245, 248, 230 };
	int yPoints[] = { 493, 526, 551, 562, 574, 610, 684, 714, 760, 795, 835, 813, 762, 770, 756, 715, 707, 693, 672,
			651, 624, 612, 589, 539 };

	int x1Points[] = { 233, 225, 228, 220, 230, 245, 233, 241, 254, 350, 337, 292, 278 };
	int y1Points[] = { 624, 643, 653, 669, 688, 709, 719, 751, 738, 729, 696, 685, 672 };

	int x2Points[] = { 253, 250, 276, 298, 364, 360, 343, 337, 316, 288 };
	int y2Points[] = { 590, 624, 663, 680, 627, 607, 603, 580, 598, 607 };

	int x3Points[] = { 212, 266, 308, 276, 282, 258, 240, 237, 252, 276, 281, 307, 318, 337, 370, 374, 434, 474, 508,
			492, 442, 413, 419, 399, 392, 366, 336, 305, 276, 229 };
	int y3Points[] = { 381, 457, 527, 518, 540, 552, 537, 540, 584, 580, 599, 596, 580, 574, 607, 628, 609, 649, 636,
			600, 432, 445, 467, 475, 465, 474, 409, 403, 385, 377 };

	int x4Points[] = { 392, 400, 445, 466, 448, 499, 524, 560, 592, 630, 672, 732, 734, 714, 630, 596, 555, 532, 520,
			483, 456 };
	int y4Points[] = { 338, 352, 370, 414, 426, 596, 613, 605, 585, 542, 518, 495, 444, 433, 455, 444, 443, 407, 414,
			388, 353 };

	int x5Points[] = { 25, 32, 130, 149, 187, 195, 204, 240, 285, 340, 368, 396, 401, 413, 407, 457, 441, 395, 364,
			25 };
	int y5Points[] = { 321, 361, 421, 441, 430, 411, 379, 372, 383, 404, 467, 457, 469, 464, 442, 413, 368, 360, 309,
			308 };
	
	private int GSwitch;
	
	//The chart panels
	ChartPanel chartPanel;
	ChartPanel LineChartPanel;
	

	// The year flag
	// Used to switch between year labels
	protected int year;
	// The Region flag
	// Used to determine which region is clicked
	protected int region;

	JPanel MapPanel = new JPanel();
	JLabel lblWestern = new JLabel("");
	JLabel lblWesternSelected = new JLabel("");

	JLabel lblSouthern = new JLabel("");
	JLabel lblCentral = new JLabel("");
	JLabel lblNorthEastern = new JLabel("");
	JLabel lblNorthern = new JLabel("");
	JLabel lblEastern = new JLabel("");

	// lblWesternSelected.setVisible(false);
	JLabel lblSouthernSelected = new JLabel("");
	// lblSouthernSelected.setVisible(false);
	JLabel lblCentralSelected = new JLabel("");
	// lblCentralSelected.setVisible(false);
	JLabel lblNorthEasternSelected = new JLabel("");
	// lblNorthEasternSelected.setVisible(false);
	JLabel lblNorthernSelected = new JLabel("");
	// lblNorthernSelected.setVisible(false);
	JLabel lblEasternSelected = new JLabel("");
	// lblEasternSelected.setVisible(false);

	static String row = "";

	//Stores the various region names
	static String[] csvData = new String[12];
	static String[] csvData1 = new String[12];
	static String[] csvData2 = new String[12];
	static String[] csvData3 = new String[12];
	static String[] csvData4 = new String[12];

	public String[] csvDataRegional = new String[5];

	JPanel TopPanel = new JPanel();

	
	
	//Constructor - Setsup the Frame
	public FarmAreaOriginal() {

		// System.out.println("Entered constructor");

		// Default Panel - Other panels will be added on top
		// I wanted to add another set of panels for a completely different set of
		// data(Another csv sheet), but due to time constraints i did not do this
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Calls the actual GUI
		FarmArea();

	}

	//Creates the FarmArea panels and everything else GUI related
	public void FarmArea() {

		// Sets the selected regions to false for its default state
		lblWesternSelected.setVisible(false);
		lblSouthernSelected.setVisible(false);
		lblCentralSelected.setVisible(false);
		lblNorthEasternSelected.setVisible(false);
		lblNorthernSelected.setVisible(false);
		lblEasternSelected.setVisible(false);
		
		
		

		// Creates the labels - Anything under
		// Top panel
		// --------------------------------------------------------------------------------------------------------------------------------------------------
		TopPanel.setBackground(new Color(153, 217, 234));
		TopPanel.setBounds(0, 0, 984, 200);
		contentPane.add(TopPanel);
		TopPanel.setLayout(null);
		
		
		//Labels
		JLabel lblTitle = new JLabel("");
		lblTitle.setIcon(new ImageIcon("DataMiningImages\\Title1.png"));
		lblTitle.setForeground(new Color(255, 255, 255));

		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		lblTitle.setBounds(288, 11, 430, 55);
		TopPanel.add(lblTitle);

		JLabel lblLeafGifLeft = new JLabel("");
		lblLeafGifLeft.setIcon(new ImageIcon("DataMiningImages\\Leafs.gif"));
		lblLeafGifLeft.setBounds(0, 0, 515, 200);
		TopPanel.add(lblLeafGifLeft);

		JLabel lblLeafGifRight = new JLabel("");
		lblLeafGifRight.setIcon(new ImageIcon("DataMiningImages\\Leafs.gif"));
		lblLeafGifRight.setBounds(469, 0, 515, 200);
		TopPanel.add(lblLeafGifRight);

		JMenu frameMenu = new JMenu("Farm Data");
		JMenuBar menuBar = new JMenuBar();
		
		
		
		JMenuItem EVL = new JMenuItem("Estimated Value of Land");
		JMenuItem ERR = new JMenuItem("Estimated Rental Rate");
		JMenuItem RR = new JMenuItem("Rental Rate : Land Value");
		
		
		//Adds the different JMenuItems to the menuFrame
		frameMenu.add(EVL);
		frameMenu.add(ERR);
		frameMenu.add(RR);
		
		
		
		EVL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Estimated Value of Land
				
			}
			
		});
		
		ERR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Estimated Rental Rate
				
			}
			
		});
		
		RR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Rental Rate : Land Value
				
			}
			
		});
			
			
			
	
		
		
		menuBar.add(frameMenu);
		menuBar.setBounds(915, 0, 70, 20);
		TopPanel.add(menuBar);
		
		JButton btn2001 = new JButton("2001");
		JButton btn2006 = new JButton("2006");
		JButton btn2011 = new JButton("2011");
		JButton btn2016 = new JButton("2016");
		

		JLabel lblAmount = new JLabel("" + amountofData);
		JLabel lblArrowUP = new JLabel("");
		JLabel lblArrowDown = new JLabel("");
		
		
		
		
		JButton btnGraphR = new JButton("Regional Graph");
		JButton btnGraphM = new JButton("Municipal Graph");
		btnGraphR.setFont(new Font("Consolas", Font.BOLD, 20));
		btnGraphR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Hides the various components that dont need to be visible for the regional graph. Gets rid of clutter
				btnGraphR.setVisible(false);
				btnGraphM.setVisible(true);
				btn2001.setVisible(false);
				btn2006.setVisible(false);
				btn2011.setVisible(false);
				btn2016.setVisible(false);
				lblAmount.setVisible(false);
				lblArrowUP.setVisible(false);
				lblArrowDown.setVisible(false);
				lblyr2001.setVisible(false);
				lblyr2006.setVisible(false);
				lblyr2011.setVisible(false);
				lblyr2016.setVisible(false);
				
				//Plays a audio file
				File sound = new File("Sounds/Sound4.wav");
				try {
					Clip clip = AudioSystem.getClip();
					clip.open(AudioSystem.getAudioInputStream(sound));
					clip.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				//A flag so the code knows which chart to call when a region is selected
				GSwitch = 1;
				LineChart();
				
				
			}
		});
		btnGraphR.setBounds(39, 30, 207, 48);
		btnGraphR.setBackground(new Color(203, 231, 254));
		TopPanel.add(btnGraphR);
		
		
		//Creates the graph button for the municipals
		btnGraphM.setFont(new Font("Consolas", Font.BOLD, 20));
		btnGraphM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnGraphR.setVisible(true);
				btnGraphM.setVisible(false);
				btn2001.setVisible(true);
				btn2006.setVisible(true);
				btn2011.setVisible(true);
				btn2016.setVisible(true);
				lblAmount.setVisible(true);
				lblArrowUP.setVisible(true);
				lblArrowDown.setVisible(true);
				
				File sound = new File("Sounds/Sound4.wav");
				try {
					Clip clip = AudioSystem.getClip();
					clip.open(AudioSystem.getAudioInputStream(sound));
					clip.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				//If's serve as a way to remember the year so you see the year you previous selected without needing to select the year again.
				if(year == 2001) {
					lblyr2001.setVisible(true);
					
				}else if(year == 2006) {
					lblyr2006.setVisible(true);
					
				}else if(year == 2011) {
					lblyr2011.setVisible(true);
					
				}else if(year == 2016) {
					lblyr2016.setVisible(true);
					
				}
				
				
				
				
				//A flag so the code knows which chart to call when a region is selected
				GSwitch = 0;
				PieChart();
				
			}
		});

		btnGraphM.setBounds(39, 30, 207, 48);
		btnGraphM.setBackground(new Color(203, 231, 254));
		TopPanel.add(btnGraphM);


		
		btn2001.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				File sound = new File("Sounds/Sound3.wav");
				try {
					Clip clip = AudioSystem.getClip();
					clip.open(AudioSystem.getAudioInputStream(sound));
					clip.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				lblyr2001.setVisible(true);
				lblyr2006.setVisible(false);
				lblyr2011.setVisible(false);
				lblyr2016.setVisible(false);
				year = 2001;
				PieChart();

			}
		});
		btn2001.setVerticalAlignment(SwingConstants.BOTTOM);
		btn2001.setBackground(new Color(203, 231, 254));
		btn2001.setBounds(10, 125, 104, 41);
		TopPanel.add(btn2001);
		btn2001.setFont(new Font("Consolas", Font.BOLD, 25));

		
		btn2006.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				File sound = new File("Sounds/Sound3.wav");
				try {
					Clip clip = AudioSystem.getClip();
					clip.open(AudioSystem.getAudioInputStream(sound));
					clip.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				lblyr2001.setVisible(false);
				lblyr2006.setVisible(true);
				lblyr2011.setVisible(false);
				lblyr2016.setVisible(false);
				year = 2006;
				PieChart();

			}
		});
		btn2006.setVerticalAlignment(SwingConstants.BOTTOM);
		btn2006.setFont(new Font("Consolas", Font.BOLD, 25));
		btn2006.setBounds(152, 125, 104, 41);
		btn2006.setBackground(new Color(203, 231, 254));
		TopPanel.add(btn2006);

		
		btn2011.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				File sound = new File("Sounds/Sound3.wav");
				try {
					Clip clip = AudioSystem.getClip();
					clip.open(AudioSystem.getAudioInputStream(sound));
					clip.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				lblyr2001.setVisible(false);
				lblyr2006.setVisible(false);
				lblyr2011.setVisible(true);
				lblyr2016.setVisible(false);
				year = 2011;
				PieChart();

			}
		});
		btn2011.setVerticalAlignment(SwingConstants.BOTTOM);
		btn2011.setFont(new Font("Consolas", Font.BOLD, 25));
		btn2011.setBounds(728, 125, 104, 41);
		btn2011.setBackground(new Color(203, 231, 254));
		TopPanel.add(btn2011);

		
		btn2016.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				File sound = new File("Sounds/Sound3.wav");
				try {
					Clip clip = AudioSystem.getClip();
					clip.open(AudioSystem.getAudioInputStream(sound));
					clip.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				lblyr2001.setVisible(false);
				lblyr2006.setVisible(false);
				lblyr2011.setVisible(false);
				lblyr2016.setVisible(true);
				year = 2016;
				PieChart();

			}
		});
		btn2016.setVerticalAlignment(SwingConstants.BOTTOM);
		btn2016.setFont(new Font("Consolas", Font.BOLD, 25));
		btn2016.setBounds(870, 125, 104, 41);
		btn2016.setBackground(new Color(203, 231, 254));
		TopPanel.add(btn2016);

		JLabel lblIns = new JLabel("");
		lblIns.setIcon(new ImageIcon("DataMiningImages\\Ins.png"));
		lblIns.setToolTipText("<html>" + "HOW TO USE:" + "<br>" + "1| Select a year" + "<br>" + "2| Select a region"
				+ "<br>" + "3| Change the amount of data displayed via the arrows" + "<br>"
				+ "4| To switch between graphs click on Regional Graph" + "<br>" + " " + "<br>" + "DESCRIPTION:"
				+ "<br>" + "<br>"+ "The Eastern region only has 8 counties on record" + "<br>"
				+ "Click on the top right menu to select a new frame" + "<br>" + "The North Eastern region has no data"
				+ "<br>" + "All data except Eastern goes up to 10 counties" + "<br>"
				+ "The County graph on the bottom right displays each regions county farm area for that year" + "<br>"
				+ "The Regional graph on the bottom right displays each regions total farm are change over all 4 years"
				+ "<html>");

		lblIns.setBounds(328, 106, 332, 67);
		TopPanel.add(lblIns);

		JLabel lblHover = new JLabel("");
		lblHover.setIcon(new ImageIcon("DataMiningImages\\Hover.png"));
		lblHover.setBounds(351, 166, 280, 34);
		TopPanel.add(lblHover);

		JLabel lblGrass = new JLabel("");
		lblGrass.setIcon(new ImageIcon("DataMiningImages\\Grass.png"));
		lblGrass.setBounds(87, 106, 984, 157);
		TopPanel.add(lblGrass);

		JLabel lblTree = new JLabel("");
		lblTree.setBounds(-254, -14, 713, 435);
		TopPanel.add(lblTree);
		lblTree.setIcon(new ImageIcon("DataMiningImages\\Tree3.png"));

//Bottom Panel		
//--------------------------------------------------------------------------------------------------------

		MapPanel.setBackground(new Color(203, 231, 254));
		MapPanel.setBounds(0, 0, 984, 861);
		contentPane.add(MapPanel);
		MapPanel.setLayout(null);

		JLabel lblTopBar = new JLabel("New label");
		lblTopBar.setIcon(new ImageIcon("DataMiningImages\\bar.png"));
		lblTopBar.setBounds(-23, 193, 1018, 32);
		MapPanel.add(lblTopBar);
		
		
		lblyr2001.setIcon(new ImageIcon("DataMiningImages\\2001.png"));
		lblyr2001.setBounds(783, 224, 159, 62);
		MapPanel.add(lblyr2001);

		lblyr2006.setIcon(new ImageIcon("DataMiningImages\\2006.png"));
		lblyr2006.setBounds(783, 224, 173, 62);
		MapPanel.add(lblyr2006);

		lblyr2011.setIcon(new ImageIcon("DataMiningImages\\2011.png"));
		lblyr2011.setBounds(799, 224, 159, 62);
		MapPanel.add(lblyr2011);

		lblyr2016.setIcon(new ImageIcon("DataMiningImages\\2016.png"));
		lblyr2016.setBounds(793, 224, 159, 62);
		MapPanel.add(lblyr2016);

		
		
		lblArrowDown.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {

				//Sets the amount of data to be shown for the piechart.
				//The variable amountofData is then used in the forloops when taking in data
				if (amountofData > 1) {
					
					File sound = new File("Sounds/Sound1.wav");
					try {
						Clip clip = AudioSystem.getClip();
						clip.open(AudioSystem.getAudioInputStream(sound));
						clip.start();
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					
					
					
					System.out.println("ENTERED DOWN");
					--amountofData;
					lblAmount.setText("" + amountofData);
					System.out.println(amountofData);
					PieChart();
				}

			}
		});
		lblArrowDown.setIcon(new ImageIcon("DataMiningImages\\down.png"));
		lblArrowDown.setBounds(840, 499, 72, 74);
		MapPanel.add(lblArrowDown);

		
		lblArrowUP.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {

				if (amountofData < 10) {
					
					File sound = new File("Sounds/Sound1.wav");
					try {
						Clip clip = AudioSystem.getClip();
						clip.open(AudioSystem.getAudioInputStream(sound));
						clip.start();
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					
					System.out.println("ENTERED UP");
					++amountofData;
					lblAmount.setText("" + amountofData);
					System.out.println(amountofData);
					PieChart();
				}

			}
		});
		lblArrowUP.setIcon(new ImageIcon("DataMiningImages\\up.png"));
		lblArrowUP.setBounds(840, 333, 72, 74);
		MapPanel.add(lblArrowUP);

		lblAmount.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblAmount.setBounds(840, 405, 72, 87);
		lblAmount.setHorizontalAlignment(JLabel.CENTER);
		MapPanel.add(lblAmount);

		lblWestern.setIcon(new ImageIcon("DataMiningImages\\MapWestern.png"));
		lblWestern.setBounds(23, 451, 249, 377);
		MapPanel.add(lblWestern);

		lblSouthern.setIcon(new ImageIcon("DataMiningImages\\MapSouthern.png"));
		lblSouthern.setBounds(173, 557, 284, 206);
		MapPanel.add(lblSouthern);

		lblCentral.setIcon(new ImageIcon("DataMiningImages\\MapCentral.png"));
		lblCentral.setBounds(214, 539, 209, 129);
		MapPanel.add(lblCentral);

		lblNorthEastern.setIcon(new ImageIcon("DataMiningImages\\MapNorthEastern.png"));
		lblNorthEastern.setBounds(143, 344, 358, 290);
		MapPanel.add(lblNorthEastern);

		lblNorthern.setIcon(new ImageIcon("DataMiningImages\\MapNorthern.png"));
		lblNorthern.setBounds(-9, 276, 462, 179);
		MapPanel.add(lblNorthern);

		lblEastern.setIcon(new ImageIcon("DataMiningImages\\MapEastern.png"));
		lblEastern.setBounds(340, 304, 398, 290);
		MapPanel.add(lblEastern);

		

//Once a region is clicked the label gets swapped out for the selected version
//--------------------------------------------------------------------------------------------------------

		// The selected version of the region and pops ups
		lblWesternSelected.setIcon(new ImageIcon("DataMiningImages\\Selected\\MapWesternSelected.png"));
		lblWesternSelected.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {

				// So you can unselect the selected region by clicking on it.
				lblWestern.setVisible(true);
				lblWesternSelected.setVisible(false);

			}
		});
		lblWesternSelected.setBounds(23, 451, 249, 377);
		MapPanel.add(lblWesternSelected);

		lblSouthernSelected.setIcon(new ImageIcon("DataMiningImages\\Selected\\MapSouthernSelected.png"));
		lblSouthernSelected.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {

				lblSouthern.setVisible(true);
				lblSouthernSelected.setVisible(false);

			}
		});
		lblSouthernSelected.setBounds(173, 557, 284, 206);
		MapPanel.add(lblSouthernSelected);

		lblCentralSelected.setIcon(new ImageIcon("DataMiningImages\\Selected\\MapCentralSelected.png"));
		lblCentralSelected.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {

				lblCentral.setVisible(true);
				lblCentralSelected.setVisible(false);

			}
		});
		lblCentralSelected.setBounds(214, 539, 209, 129);
		MapPanel.add(lblCentralSelected);

		lblNorthEasternSelected.setIcon(new ImageIcon("DataMiningImages\\Selected\\MapNorthEasternSelected.png"));
		lblNorthEasternSelected.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {

				lblNorthEastern.setVisible(true);
				lblNorthEasternSelected.setVisible(false);

			}
		});
		lblNorthEasternSelected.setBounds(143, 344, 358, 290);
		MapPanel.add(lblNorthEasternSelected);

		lblNorthernSelected.setIcon(new ImageIcon("DataMiningImages\\Selected\\MapNorthernSelected.png"));
		lblNorthernSelected.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {

				lblNorthern.setVisible(true);
				lblNorthernSelected.setVisible(false);

			}
		});
		lblNorthernSelected.setBounds(-9, 276, 462, 179);
		MapPanel.add(lblNorthernSelected);

		lblEasternSelected.setIcon(new ImageIcon("DataMiningImages\\Selected\\MapEasternSelected.png"));
		lblEasternSelected.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {

				lblEastern.setVisible(true);
				lblEasternSelected.setVisible(false);

			}
		});
		lblEasternSelected.setBounds(340, 304, 398, 290);
		MapPanel.add(lblEasternSelected);

	}

	// This needs to be called paint so it overrides JFrames default paint method.
	// Without this the shape would not appear and couldnt be used. (The
	// super.paint)
	public void paint(Graphics g) {
		super.paint(g);

		Graphics2D g2 = (Graphics2D) g;

		System.out.println("Entered border method");

		// Creates the path object
		GeneralPath polylineW = new GeneralPath(GeneralPath.WIND_EVEN_ODD, xPoints.length);
		GeneralPath polylineS = new GeneralPath(GeneralPath.WIND_EVEN_ODD, x1Points.length);
		GeneralPath polylineC = new GeneralPath(GeneralPath.WIND_EVEN_ODD, x2Points.length);
		GeneralPath polylineNE = new GeneralPath(GeneralPath.WIND_EVEN_ODD, x3Points.length);
		GeneralPath polylineE = new GeneralPath(GeneralPath.WIND_EVEN_ODD, x4Points.length);
		GeneralPath polylineN = new GeneralPath(GeneralPath.WIND_EVEN_ODD, x5Points.length);
		
		

		// These place all the points for each path using the arrays above which store
		// XY coords
		polylineW.moveTo(xPoints[0], yPoints[0]);

		for (int i = 1; i < xPoints.length; i++) {
			polylineW.lineTo(xPoints[i], yPoints[i]);

		}

		polylineS.moveTo(x1Points[0], y1Points[0]);

		for (int i = 1; i < x1Points.length; i++) {
			polylineS.lineTo(x1Points[i], y1Points[i]);

		}

		polylineC.moveTo(x2Points[0], y2Points[0]);

		for (int i = 1; i < x2Points.length; i++) {
			polylineC.lineTo(x2Points[i], y2Points[i]);

		}

		polylineNE.moveTo(x3Points[0], y3Points[0]);

		for (int i = 1; i < x3Points.length; i++) {
			polylineNE.lineTo(x3Points[i], y3Points[i]);

		}

		polylineE.moveTo(x4Points[0], y4Points[0]);

		for (int i = 1; i < x4Points.length; i++) {
			polylineE.lineTo(x4Points[i], y4Points[i]);

		}

		polylineN.moveTo(x5Points[0], y5Points[0]);

		for (int i = 1; i < x5Points.length; i++) {
			polylineN.lineTo(x5Points[i], y5Points[i]);

		}

	
		
		// Closes the path
		polylineW.closePath();
		polylineS.closePath();
		polylineC.closePath();
		polylineNE.closePath();
		polylineE.closePath();
		polylineN.closePath();

		// Draws each path
		// -----------------------------------------------------
		// If you wish to see the border for each region simply uncomment the code below
		// ------------------------------------------------------
		// g2.draw(polylineW);
		// g2.draw(polylineS);
		// g2.draw(polylineC);
		// g2.draw(polylineNE);
		// g2.draw(polylineE);
		// g2.draw(polylineN);

		// Adds an actionlistener onto the panel
		MapPanel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {

				System.out.println("Clicked Panel");

				// Used for testing
				// System.out.println(me.getPoint());
				// System.out.println(polylineW.contains(me.getPoint()));
				// System.out.println(polylineS.contains(me.getPoint()));
				// System.out.println(polylineC.contains(me.getPoint()));
				// System.out.println(polylineNE.contains(me.getPoint()));
				// System.out.println(polylineE.contains(me.getPoint()));
				// System.out.println(polylineN.contains(me.getPoint()));

				// Used to check if the user clicks inside the shape.
				if (polylineW.contains(me.getPoint())) {
					
					File sound = new File("Sounds/Sound2.wav");
					try {
						Clip clip = AudioSystem.getClip();
						clip.open(AudioSystem.getAudioInputStream(sound));
						clip.start();
					} catch (Exception e) {
						e.printStackTrace();
					}
					

					// Pretty much hides all selected regions and shows the selected region based on
					// the one you clicked. This ensures you can only select one region at a time
					lblWesternSelected.setVisible(true);
					lblSouthernSelected.setVisible(false);
					lblCentralSelected.setVisible(false);
					lblNorthEasternSelected.setVisible(false);
					lblEasternSelected.setVisible(false);
					lblNorthernSelected.setVisible(false);

					lblWestern.setVisible(false);
					lblSouthern.setVisible(true);
					lblCentral.setVisible(true);
					lblNorthEastern.setVisible(true);
					lblEastern.setVisible(true);
					lblNorthern.setVisible(true);
					region = 1;
					//0 = PieChart
					if(GSwitch == 0) {
						PieChart();
					//0 = LineChart
					}else if(GSwitch == 1) {
						LineChart();
						
					}
					
					

				}

				if (polylineS.contains(me.getPoint())) {
					
					File sound = new File("Sounds/Sound2.wav");
					try {
						Clip clip = AudioSystem.getClip();
						clip.open(AudioSystem.getAudioInputStream(sound));
						clip.start();
					} catch (Exception e) {
						e.printStackTrace();
					}

					lblWesternSelected.setVisible(false);
					lblSouthernSelected.setVisible(true);
					lblCentralSelected.setVisible(false);
					lblNorthEasternSelected.setVisible(false);
					lblEasternSelected.setVisible(false);
					lblNorthernSelected.setVisible(false);

					lblWestern.setVisible(true);
					lblSouthern.setVisible(false);
					lblCentral.setVisible(true);
					lblNorthEastern.setVisible(true);
					lblEastern.setVisible(true);
					lblNorthern.setVisible(true);
					region = 2;
					//0 = PieChart
					if(GSwitch == 0) {
						PieChart();
					//0 = LineChart
					}else if(GSwitch == 1) {
						LineChart();
						
					}
				}

				if (polylineC.contains(me.getPoint())) {
					
					File sound = new File("Sounds/Sound2.wav");
					try {
						Clip clip = AudioSystem.getClip();
						clip.open(AudioSystem.getAudioInputStream(sound));
						clip.start();
					} catch (Exception e) {
						e.printStackTrace();
					}

					lblWesternSelected.setVisible(false);
					lblSouthernSelected.setVisible(false);
					lblCentralSelected.setVisible(true);
					lblNorthEasternSelected.setVisible(false);
					lblEasternSelected.setVisible(false);
					lblNorthernSelected.setVisible(false);

					lblWestern.setVisible(true);
					lblSouthern.setVisible(true);
					lblCentral.setVisible(false);
					lblNorthEastern.setVisible(true);
					lblEastern.setVisible(true);
					lblNorthern.setVisible(true);
					region = 3;
					//0 = PieChart
					if(GSwitch == 0) {
						PieChart();
					//0 = LineChart
					}else if(GSwitch == 1) {
						LineChart();
						
					}
				}

				if (polylineNE.contains(me.getPoint())) {
					
					File sound = new File("Sounds/Sound2.wav");
					try {
						Clip clip = AudioSystem.getClip();
						clip.open(AudioSystem.getAudioInputStream(sound));
						clip.start();
					} catch (Exception e) {
						e.printStackTrace();
					}

					lblWesternSelected.setVisible(false);
					lblSouthernSelected.setVisible(false);
					lblCentralSelected.setVisible(false);
					lblNorthEasternSelected.setVisible(true);
					lblEasternSelected.setVisible(false);
					lblNorthernSelected.setVisible(false);

					lblWestern.setVisible(true);
					lblSouthern.setVisible(true);
					lblCentral.setVisible(true);
					lblNorthEastern.setVisible(false);
					lblEastern.setVisible(true);
					lblNorthern.setVisible(true);
					region = 4;
					//0 = PieChart
					if(GSwitch == 0) {
						PieChart();
					//0 = LineChart
					}else if(GSwitch == 1) {
						LineChart();
						
					}
				}

				if (polylineE.contains(me.getPoint())) {
					
					File sound = new File("Sounds/Sound2.wav");
					try {
						Clip clip = AudioSystem.getClip();
						clip.open(AudioSystem.getAudioInputStream(sound));
						clip.start();
					} catch (Exception e) {
						e.printStackTrace();
					}

					lblWesternSelected.setVisible(false);
					lblSouthernSelected.setVisible(false);
					lblCentralSelected.setVisible(false);
					lblNorthEasternSelected.setVisible(false);
					lblEasternSelected.setVisible(true);
					lblNorthernSelected.setVisible(false);

					lblWestern.setVisible(true);
					lblSouthern.setVisible(true);
					lblCentral.setVisible(true);
					lblNorthEastern.setVisible(true);
					lblEastern.setVisible(false);
					lblNorthern.setVisible(true);
					region = 5;
					//0 = PieChart
					if(GSwitch == 0) {
						PieChart();
					//0 = LineChart
					}else if(GSwitch == 1) {
						LineChart();
						
					}
				}

				if (polylineN.contains(me.getPoint())) {
					
					File sound = new File("Sounds/Sound2.wav");
					try {
						Clip clip = AudioSystem.getClip();
						clip.open(AudioSystem.getAudioInputStream(sound));
						clip.start();
					} catch (Exception e) {
						e.printStackTrace();
					}

					lblWesternSelected.setVisible(false);
					lblSouthernSelected.setVisible(false);
					lblCentralSelected.setVisible(false);
					lblNorthEasternSelected.setVisible(false);
					lblEasternSelected.setVisible(false);
					lblNorthernSelected.setVisible(true);

					lblWestern.setVisible(true);
					lblSouthern.setVisible(true);
					lblCentral.setVisible(true);
					lblNorthEastern.setVisible(true);
					lblEastern.setVisible(true);
					lblNorthern.setVisible(false);
					region = 6;
					//0 = PieChart
					if(GSwitch == 0) {
						PieChart();
					//0 = LineChart
					}else if(GSwitch == 1) {
						LineChart();
						
					}
				}

			}
		});

	}

	//Creates the actual line Graph
	public void PieChart() {

		System.out.println("Entered PieChart");

		PieDataset data = createDataset();
		JFreeChart chart = ChartFactory.createPieChart("Municipal Area", data, true, true, false);
		chartPanel = new ChartPanel(chart);
		chartPanel.setBounds(536, 630, 450, 230);

		add(chartPanel);
		System.out.println("Added ChartPanel");
		chartPanel.setBackground(new Color(255, 0, 0));
		//chartPanel.setVisible(true);
		// setVisible(true);

	}

	//Creates the dataset for the PieGraph and determines which region data will be shown
	private PieDataset createDataset() {

		// The arrays where all the int data is stored
		// The 4 is the amount of years and the 12 is the amount of different numbers
		// there can be
		int csvDatanumW[][] = new int[4][12];

		int csvDatanumS[][] = new int[4][12];
		int csvDatanumN[][] = new int[4][12];
		int csvDatanumE[][] = new int[4][12];
		int csvDatanumC[][] = new int[4][12];

		System.out.println("Entered CreateDataset");

		// Takes in the file
		DefaultPieDataset data = new DefaultPieDataset();

		String path = "Western.csv";
		String path1 = "Southern.csv";
		String path2 = "Northern.csv";
		String path3 = "Eastern.csv";
		String path4 = "Central.csv";

		// Reads in all the data. Specifically stores the municipal names into the
		// String Array csvData
		// Stores all numbers into the Datanum arrays for each region using the a temp
		// string array
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			BufferedReader br1 = new BufferedReader(new FileReader(path1));
			BufferedReader br2 = new BufferedReader(new FileReader(path2));
			BufferedReader br3 = new BufferedReader(new FileReader(path3));
			BufferedReader br4 = new BufferedReader(new FileReader(path4));
			int i = 0;
			// While there is a line
			// Western
			while ((row = br.readLine()) != null) {

				String[] temp = row.split(",");
				// System.out.println("Entered first While in Data");
				// Takes in the first index from temp which are the region names
				csvData[i] = temp[0];

				// Converts the String Array into a 2D int array storing each year as an array
				// and storing its corresponding data
				// So at index one all the numbers will be for year 1
				// At index 2 all the numbers will be for year 2
				// TDLR; The temp[int] represents the column of sorts

				// Converts the string into an int
				// 01 (Year)
				csvDatanumW[0][i] = Integer.parseInt(temp[1]);
				// 06
				csvDatanumW[1][i] = Integer.parseInt(temp[2]);
				// 11
				csvDatanumW[2][i] = Integer.parseInt(temp[3]);
				// 16
				csvDatanumW[3][i] = Integer.parseInt(temp[4]);

				// Counts up
				i++;

				// System.out.println(csvData[0]);
				// System.out.println(csvData[1]);

			}
			i = 0;
			// System.out.println(csvData[0]);

			// Southern
			while ((row = br1.readLine()) != null) {

				String[] temp = row.split(",");
				// System.out.println("Entered first While in Data");
				// Takes in the first index from temp which are the region names
				csvData1[i] = temp[0];

				// Converts the String Array into a 2D int array storing each year as an array
				// and storing its corresponding data
				// 01
				csvDatanumS[0][i] = Integer.parseInt(temp[1]);
				// 06
				csvDatanumS[1][i] = Integer.parseInt(temp[2]);
				// 11
				csvDatanumS[2][i] = Integer.parseInt(temp[3]);
				// 16
				csvDatanumS[3][i] = Integer.parseInt(temp[4]);

				// Counts up
				i++;

			}
			i = 0;

			// Northern
			while ((row = br2.readLine()) != null) {

				String[] temp = row.split(",");
				// System.out.println("Entered first While in Data");
				// Takes in the first index from temp which are the region names
				csvData2[i] = temp[0];

				// Converts the String Array into a 2D int array storing each year as an array
				// and storing its corresponding data
				// 01
				csvDatanumN[0][i] = Integer.parseInt(temp[1]);
				// 06
				csvDatanumN[1][i] = Integer.parseInt(temp[2]);
				// 11
				csvDatanumN[2][i] = Integer.parseInt(temp[3]);
				// 16
				csvDatanumN[3][i] = Integer.parseInt(temp[4]);

				// Counts up
				i++;

			}
			i = 0;

			// Eastern
			while ((row = br3.readLine()) != null) {
				String[] temp = row.split(",");
				// System.out.println("Entered first While in Data");
				// Takes in the first index from temp which are the region names
				csvData3[i] = temp[0];

				// Converts the String Array into a 2D int array storing each year as an array
				// and storing its corresponding data
				// 01
				csvDatanumE[0][i] = Integer.parseInt(temp[1]);
				// 06
				csvDatanumE[1][i] = Integer.parseInt(temp[2]);
				// 11
				csvDatanumE[2][i] = Integer.parseInt(temp[3]);
				// 16
				csvDatanumE[3][i] = Integer.parseInt(temp[4]);

				// Counts up
				i++;

			}
			i = 0;

			// Central
			while ((row = br4.readLine()) != null) {

				String[] temp = row.split(",");
				// System.out.println("Entered first While in Data");
				// Takes in the first index from temp which are the region names
				csvData4[i] = temp[0];

				// Converts the String Array into a 2D int array storing each year as an array
				// and storing its corresponding data
				// 01
				csvDatanumC[0][i] = Integer.parseInt(temp[1]);
				// 06
				csvDatanumC[1][i] = Integer.parseInt(temp[2]);
				// 11
				csvDatanumC[2][i] = Integer.parseInt(temp[3]);
				// 16
				csvDatanumC[3][i] = Integer.parseInt(temp[4]);

				// Counts up
				i++;

			}
			i = 0;

			// A mandatory catch
		} catch (FileNotFoundException e) {
			System.out.println("Oopsi poopsi");
			e.printStackTrace();

		} catch (IOException e) {
			System.out.println("Oopsi poopsi");
			e.printStackTrace();

		}

		// Checks for the year button and which region is selected to show appropriate
		// data for said region.
		// Probably could have done with less code but i for simplicity sake i just did
		// ifs.
		if (year == 2001) {

			System.out.println("01");

			// West
			if (region == 1) {

				System.out.println("West");

				// Displays
				// Change the 10 to show a specific amount of data
				for (int i = 0; i < amountofData; i++) {
					data.setValue(csvData[i], csvDatanumW[0][i]);
				}

				return data;

				// South
			} else if (region == 2) {

				System.out.println("South");

				for (int i = 0; i < amountofData; i++) {
					data.setValue(csvData1[i], csvDatanumS[0][i]);
				}

				return data;

				// Central
			} else if (region == 3) {

				System.out.println("Central");

				for (int i = 0; i < amountofData; i++) {
					data.setValue(csvData2[i], csvDatanumC[0][i]);
				}

				return data;

				// North East
			} else if (region == 4) {
				System.out.println("North East - No Data");
				// No Data

				// East
			} else if (region == 5) {

				System.out.println("East");

				for (int i = 0; i < amountofData && i < 8; i++) {
					data.setValue(csvData3[i], csvDatanumE[0][i]);
				}

				return data;

				// North
			} else if (region == 6) {

				System.out.println("North");

				for (int i = 0; i < amountofData; i++) {
					data.setValue(csvData4[i], csvDatanumN[0][i]);
				}

				return data;

			}

		} else if (year == 2006) {

			System.out.println("06");

			if (region == 1) {

				for (int i = 0; i < amountofData; i++) {
					data.setValue(csvData[i], csvDatanumW[1][i]);
				}

				return data;

			} else if (region == 2) {

				for (int i = 0; i < amountofData; i++) {
					data.setValue(csvData1[i], csvDatanumS[1][i]);
				}

				return data;

			} else if (region == 3) {

				for (int i = 0; i < amountofData; i++) {
					data.setValue(csvData2[i], csvDatanumC[1][i]);
				}

				return data;

			} else if (region == 4) {

				// No Data

			} else if (region == 5) {

				for (int i = 0; i < amountofData && i < 8; i++) {
					data.setValue(csvData3[i], csvDatanumE[1][i]);
				}

				return data;

			} else if (region == 6) {

				for (int i = 0; i < amountofData; i++) {
					data.setValue(csvData4[i], csvDatanumN[1][i]);
				}

				return data;

			}

		} else if (year == 2011) {

			System.out.println("11");

			if (region == 1) {

				for (int i = 0; i < amountofData; i++) {
					data.setValue(csvData[i], csvDatanumW[2][i]);
				}

				return data;

			} else if (region == 2) {

				for (int i = 0; i < amountofData; i++) {
					data.setValue(csvData1[i], csvDatanumS[2][i]);
				}

				return data;

			} else if (region == 3) {

				for (int i = 0; i < amountofData; i++) {
					data.setValue(csvData2[i], csvDatanumC[2][i]);
				}

				return data;

			} else if (region == 4) {
				// No Data

			} else if (region == 5) {

				for (int i = 0; i < amountofData && i < 8; i++) {
					data.setValue(csvData3[i], csvDatanumE[2][i]);
				}

				return data;

			} else if (region == 6) {

				for (int i = 0; i < amountofData; i++) {
					data.setValue(csvData4[i], csvDatanumN[2][i]);
				}

				return data;

			}

		} else if (year == 2016) {

			System.out.println("16");

			if (region == 1) {

				for (int i = 0; i < amountofData; i++) {
					data.setValue(csvData[i], csvDatanumW[3][i]);
				}

				return data;

			} else if (region == 2) {

				for (int i = 0; i < amountofData; i++) {
					data.setValue(csvData1[i], csvDatanumS[3][i]);
				}

				return data;

			} else if (region == 3) {

				for (int i = 0; i < amountofData; i++) {
					data.setValue(csvData2[i], csvDatanumC[3][i]);
				}

				return data;

			} else if (region == 4) {
				// No Data

			} else if (region == 5) {

				for (int i = 0; i < amountofData && i < 8; i++) {
					data.setValue(csvData3[i], csvDatanumE[3][i]);
				}

				return data;

			} else if (region == 6) {

				for (int i = 0; i < amountofData; i++) {
					data.setValue(csvData4[i], csvDatanumN[3][i]);
				}

				return data;

			}

		}

		System.out.println("NeinData");
		return data;

	}

	//Creates the actual line Graph
	public void LineChart() {

		//Testing
		//System.out.println("-------------------ENTERED LINECHART CREATION------------------");
		
		//Creates the graph
		CategoryDataset dataset = createDatasetLine();
		JFreeChart LineChart = ChartFactory.createLineChart("Regional Change", "Year", "Farm Land", dataset,PlotOrientation.VERTICAL, true, true, false);
		LineChartPanel = new ChartPanel(LineChart);

		LineChartPanel.setBounds(536, 630, 450, 230);
		
		add(LineChartPanel);
			
		
		
		LineChartPanel.setBackground(new Color(255, 0, 0));
		System.out.println("CREATED GRAPH");

	}

	//Creates the dataset for the LineGraph and determines which region data will be shown
	private CategoryDataset createDatasetLine() {
		System.out.println("-------------ENTERED LINECHART DATASET-------------");

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		String path = "RegionalChange.csv";

		int csvDatanumRegional[][] = new int[4][10];

		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			int i = 0;
			//System.out.println("Entered TRY");

			// While there is a line
			
			//Very similar to the first method of data input. Im storing the region name in a String array
			//And then storing the actual data in a int Array
			while ((row = br.readLine()) != null) {

				//System.out.println("Entered LOOP");
				String[] temp = row.split(",");
				csvDataRegional[i] = temp[0];

				//Testing
				//System.out.println(temp[0]);
				
				// 01
				csvDatanumRegional[0][i] = Integer.parseInt(temp[1]);
				// 06
				csvDatanumRegional[1][i] = Integer.parseInt(temp[2]);
				// 11
				csvDatanumRegional[2][i] = Integer.parseInt(temp[3]);
				// 16
				csvDatanumRegional[3][i] = Integer.parseInt(temp[4]);

			

				i++;

			}

			// A mandatory catch
		} catch (FileNotFoundException e) {
			System.out.println("Oopsi poopsi");
			e.printStackTrace();

		} catch (IOException e) {
			System.out.println("Oopsi poopsi");
			e.printStackTrace();

		}
		
		
			
	
		
		
		System.out.println("Region =="+region);
		if (region == 1) {
			
			//I could have done a forloop like before but id have to include the year in the data which i felt was a lot more hassle
			//then just writting it out manually especially since it wasnt a lot of data anyways. If there was a lot more data i would have
			//added the years to the csv file and done it automatically like before.
			//System.out.println("WEST LINE");
			dataset.setValue(csvDatanumRegional[0][0], csvDataRegional[0], "2001");
			//System.out.println(csvDatanumRegional[0][0]);
			dataset.setValue(csvDatanumRegional[1][0], csvDataRegional[0], "2006");
			//System.out.println(csvDatanumRegional[1][0]);
			dataset.setValue(csvDatanumRegional[2][0], csvDataRegional[0], "2011");
			//System.out.println(csvDatanumRegional[2][0]);
			dataset.setValue(csvDatanumRegional[3][0], csvDataRegional[0], "2016");
			//System.out.println(csvDatanumRegional[3][0]);
			return dataset;

			// South
		} else if (region == 2) {
			//System.out.println("SOUTH LINE");
			dataset.setValue(csvDatanumRegional[0][1], csvDataRegional[1], "2001");
			//System.out.println(csvDatanumRegional[0][1]);
			dataset.setValue(csvDatanumRegional[1][1], csvDataRegional[1], "2006");
			//System.out.println(csvDatanumRegional[1][1]);
			dataset.setValue(csvDatanumRegional[2][1], csvDataRegional[1], "2011");
		    //System.out.println(csvDatanumRegional[2][1]);
			dataset.setValue(csvDatanumRegional[3][1], csvDataRegional[1], "2016");
			//System.out.println(csvDatanumRegional[3][1]);
			return dataset;

		//Central
		}else if(region == 3) {
			System.out.println("CENTRAL LINE");
			dataset.setValue(csvDatanumRegional[0][2], csvDataRegional[2], "2001");
			dataset.setValue(csvDatanumRegional[1][2], csvDataRegional[2], "2006");
			dataset.setValue(csvDatanumRegional[2][2], csvDataRegional[2], "2011");
			dataset.setValue(csvDatanumRegional[3][2], csvDataRegional[2], "2016");
			return dataset;
		
		//North East
		}else if(region == 4) {
			//No Data
		
		//East
		}else if(region == 5) {
			//System.out.println("EAST LINE");
			dataset.setValue(csvDatanumRegional[0][3], csvDataRegional[3], "2001");
			dataset.setValue(csvDatanumRegional[1][3], csvDataRegional[3], "2006");
			dataset.setValue(csvDatanumRegional[2][3], csvDataRegional[3], "2011");
			dataset.setValue(csvDatanumRegional[3][3], csvDataRegional[3], "2016");
			return dataset;
		
		//North
		}else if(region == 6) {
			//System.out.println("NORTH LINE");
			dataset.setValue(csvDatanumRegional[0][4], csvDataRegional[4], "2001");
			dataset.setValue(csvDatanumRegional[1][4], csvDataRegional[4], "2006");
			dataset.setValue(csvDatanumRegional[2][4], csvDataRegional[4], "2011");
			dataset.setValue(csvDatanumRegional[3][4], csvDataRegional[4], "2016");
			return dataset;
			
		}
		return dataset;

		

	}

}
