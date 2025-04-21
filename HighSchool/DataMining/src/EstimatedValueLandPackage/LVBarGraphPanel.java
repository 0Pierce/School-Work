package EstimatedValueLandPackage;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;



/**
 * This class creates the panel that displays the bar graph. The bar graph displays the avg value of each region within ontario
 * (but does not include the province itself). Bar graph will change data when user decides to view a different dataset from a different year
 * by clicking on one of the year buttons
 * 
 * SOURCES: how to change data in bargraph:
 * https://stackoverflow.com/questions/37483611/jfreechart-is-not-updating-chartpanel-after-reading-data-from-serial-port
 * https://stackoverflow.com/questions/32002258/get-java2d-y-coordinate-in-category-plot-corresponding-to-a-value-in-jfreechart
 * 
 * @author Daphne Ho
 *
 */
public class LVBarGraphPanel extends JLayeredPane implements MouseListener, MouseMotionListener {

	// FIELDS
	public final static Color BAR_COLOUR = new Color(207, 226, 243);
	public final static Color HOVER_COLOUR = new Color(243, 179, 140);

	private CategoryDataset dataset = createDataset();
	private JFreeChart barGraph = ChartFactory.createBarChart(null, null, "Average Value ($)", dataset,
			PlotOrientation.VERTICAL, true, true, false);
	private ChartPanel chartPanel = new ChartPanel(barGraph);
	private CategoryPlot plot = barGraph.getCategoryPlot(); // splits the bargraph categories, allowing user to make
															// changes to all or selected categories

	private JLabel[] barLabelList = new JLabel[5];

	private LVHoverPanel hoverPanel = new LVHoverPanel();

	// 5 = 2016, 4 = 2011, 3 = 2006, 2 = 2001, 1 = 1996, 0 = 1991
	private static int currentYear = 5;

	
	// CONSTRUCTOR
	public LVBarGraphPanel() {

		// config pane
		setLayout(null);
		setBounds(LVFrame.PANELS_X, LVFrame.PANELS_Y, 1000, LVFrame.PANELS_LENGTH);
		setOpaque(false);
		setBackground(Color.black);

		// bar graph
		barGraph.setBackgroundPaint(LVFrame.LIGHT_BLUE);
		chartPanel.setBounds(0, 0, 700, LVFrame.PANELS_LENGTH);
		
		// add a mouse listener - once the user's mouse enters the area of the bar graph, set up the bar labels
		// (this can only be done once the chart has been made)
		chartPanel.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				setupBarLabels();
			}
		});

		// colour in the bars
		for (int index = 0; index < 5; index++)
			plot.getRenderer().setSeriesPaint(index, BAR_COLOUR);

		// add elements to the pane
		add(hoverPanel, Integer.valueOf(1));
		add(chartPanel, Integer.valueOf(0));
		
		// set the hover panel to false (only shows when user hovers over a bar)
		hoverPanel.setVisible(false);
		
		// show the panel
		setVisible(true);
	}

	// SETTERS AND GETTERS
	public int getCurrentYear() {
		return currentYear;
	}

	public void setCurrentYear(int currentYear) {
		this.currentYear = currentYear;
	}

	
	/**
	 * This method creates the datasets used to display information on the bar braph
	 * 
	 * @return
	 */
	private CategoryDataset createDataset() {

		// create a category dataset to hold the data
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		// go through the list and input the data into the dataset
		for (int index = 1; index < 6; index++) {
			int[] valueList = LVApplication.regionList[index].getValueList();
			String name = LVApplication.regionList[index].getName();
			dataset.addValue(valueList[currentYear], name, "");

		}

		return dataset;

	}

	/**
	 * This method configures the bargraph to display the data based on the year the
	 * user wants to see
	 */
	public void setBarGraph() {
		dataset = createDataset();
		plot.setDataset(dataset);
	}

	/**
	 * This method sets up the bar labels used to detect if a user is hovering over a bar on the graph
	 */
	public void setupBarLabels() {

		// remove any exisiting labels
		if (barLabelList[0] != null) {
			for (int labelIndex = 0; labelIndex < 5; labelIndex++) {
				remove(barLabelList[labelIndex]);

			}
		}

		int x; 		// x-coordinate of the label
		int labelIndex = 0;		// used to put the labels into the correct label list slot 

		// adjust starting x-coordinate based on the year
		// (2016's graph starts sligthy more on the right)
		if (currentYear == 5)
			x = 100;
		else
			x = 95;

		// create the labels
		for (int index = 1; index < 6; index++) {

			// find the y coordinate
			int y = getYCoordinate(index);

			// get the area of the the area of the chart panel (coordinates and measurements)
			Rectangle2D area = chartPanel.getChartRenderingInfo().getPlotInfo().getPlotArea();

			// get the length of the bar by subtracting the y-coordinate's magnitude
			// from the height of the graph area
			int length = (int) (area.getHeight() - y);

			// adjusting the coverage of the bars
			// (for some reason, the last 3 bars are always slightly off)
			if (index == 3 || index == 4 || index == 5) {
				y -= 5;
				length += 5;
			}

			// create label
			barLabelList[labelIndex] = new JLabel();
			barLabelList[labelIndex].addMouseListener(this); // add a mouse listener
			barLabelList[labelIndex].addMouseMotionListener(this); // add motion listener
			barLabelList[labelIndex].setBounds(x, y, 88, length);
			add(barLabelList[labelIndex], Integer.valueOf(1));

			x += 119;	// add on to the x-value, space out labels
			labelIndex++;	// add to the next element on the label list
		}

	}

	
	// MouseListener Methods
	
	/**
	 * This method configures the information and graphs when the user's mosue hover's over a bar
	 */
	@Override
	public void mouseEntered(MouseEvent event) {

		// downcasting - make sure its a JLabel
		if (event.getSource() instanceof JLabel) {

			JLabel barLabel = (JLabel) event.getSource();

			int plotNum = 1;

			// check which bar it is
			for (int index = 0; index < barLabelList.length; index++)
				if (barLabel == barLabelList[index])
					plotNum += index;

			// configure growth panel to show information on the hovered bar
			LVFrame.growthPanel.setLandNameLabel(plotNum, currentYear);
			LVFrame.growthPanel.setPercentageLabel(plotNum, currentYear);
			LVFrame.growthPanel.setValueLabel(plotNum, currentYear);

			// change bar to a different colour
			plot.getRenderer().setSeriesPaint(plotNum - 1, new Color(243, 179, 140));

			// colour of the line to cooresponding region
			LVLineGraph.plot.getRenderer().setSeriesPaint(plotNum, HOVER_COLOUR);
			LVLineGraph.plot.getRenderer().setSeriesPaint(0, LVLineGraph.LINE_COLOUR);
		}

	}
	
	
	/**
	 * This method resets the frame back to its orginal state (displaying Ontario's data for the current year)
	 * once the user stop hovering over the bar
	 */
	@Override
	public void mouseExited(MouseEvent event) {

		JLabel barLabel = (JLabel) event.getSource();

		int plotNum = 0;

		// check which bar it is
		for (int index = 0; index < barLabelList.length; index++)
			if (barLabel == barLabelList[index])
				plotNum = index;

		// get rid of hover panel
		hoverPanel.setVisible(false);
		
		// set growth panel to dispaly Ontario information
		LVFrame.growthPanel.setLandNameLabel(0, currentYear);
		LVFrame.growthPanel.setPercentageLabel(0, currentYear);
		LVFrame.growthPanel.setValueLabel(0, currentYear);
		
		// change the graphs back 
		plot.getRenderer().setSeriesPaint(plotNum, BAR_COLOUR);

		LVLineGraph.plot.getRenderer().setSeriesPaint(plotNum + 1, LVLineGraph.LINE_COLOUR);
		LVLineGraph.plot.getRenderer().setSeriesPaint(0, HOVER_COLOUR);

	}
	
	/**
	 * Below methods are needed for the implementation of the MouseListener
	 */
	@Override
	public void mouseClicked(MouseEvent event) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	

	// MouseMotionListener
	// needed for the implementation of MouseMotionListener
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	
	
	/**
	 * This method runs when the user's mosue moves across the bar; when the user hovers over the bar, a 
	 * panel will pop up displaying the name of the cateogry and the exact value
	 */
	@Override
	public void mouseMoved(MouseEvent event) {

		if (event.getSource() instanceof JLabel) {

			// x -coordinate
			int x;

			// adjust the starting x-coordinate based on the year 
			if (currentYear == 5)
				x = 100;
			else
				x = 95;

			JLabel barLabel = (JLabel) event.getSource();

			// used to track the index in the data list
			int listNum = 1;

			// check which bar it is
			for (int index = 0; index < barLabelList.length; index++)
				if (barLabel == barLabelList[index])
					listNum += index;

			// get y-coordinate
			int y = getYCoordinate(listNum);

			// display the data for the bar
			hoverPanel.setValueLabel(listNum, currentYear);
			hoverPanel.setNameLabel(listNum);

			// adjust the x-coordinate to the right bar
			x += 119 * (listNum - 1);

			// set the location of the hover panel
			hoverPanel.setLocation(event.getX() + x, y + event.getY());
			hoverPanel.setVisible(true);

		}
		
	}
	
	
	/**
	 * This method gets the y-coordinate of the bar on the graph
	 *
	 */
	private int getYCoordinate(int index) {

		// get the yAxis, its scaling, and the area of bargraph
		ValueAxis yAxis = plot.getRangeAxis();
		Rectangle2D area = chartPanel.getChartRenderingInfo().getPlotInfo().getPlotArea();

		// create int-list to hold the values from the land
		int[] valueList = LVApplication.regionList[index].getValueList();

		// find the y-coordinate of the top left corner of the bargraph based on its
		// value and the y-axis scaling
		int y = (int) yAxis.valueToJava2D(valueList[currentYear], area, plot.getRangeAxisEdge());

		return y;
	}
}
