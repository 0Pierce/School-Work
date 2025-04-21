package EstimatedValueLandPackage;
import java.awt.Color;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * This class creates the line graph panel for the growth panel. The line graph panel shows the overall growth of the
 * regions between all years of available data
 * 
 * @author Daphne Ho
 *
 */
public class LVLineGraph extends JPanel {
	
	// CONSTANTS
	public final static Color LINE_COLOUR = new Color(75, 89, 103);
	
	// FIELDS
	private static CategoryDataset dataset = createDataset();
	private static JFreeChart lineGraph = ChartFactory.createLineChart(null, null, "Average Value ($)", dataset,
			PlotOrientation.VERTICAL, false, false, false);
	private ChartPanel chartPanel = new ChartPanel(lineGraph);
	public static CategoryPlot plot = lineGraph.getCategoryPlot();

	// CONSTRUCTOR
	public LVLineGraph() {

		// setup panel
		setLayout(null);
		setBounds(0, 150, LVGrowthPanel.GPANEL_WIDTH, 500);
		setOpaque(true);
		setBackground(Color.black);
		
		// line graph
		chartPanel.setBounds(0, 0, LVGrowthPanel.GPANEL_WIDTH, 280);
		lineGraph.setBackgroundPaint(Color.white);
		
		// colour in the line graph 
		for (int index = 0; index < 6; index++)
			plot.getRenderer().setSeriesPaint(index, new Color(75, 89, 103));
		
		// add elements to panel
		add(chartPanel);
		
		// make panel visible
		setVisible(true);
	}
	

	/**
	 * This method creates the dataset that is going to be used for the line grpah
	 * @return
	 */
	private static CategoryDataset createDataset() {

		// create a category dataset to hold the data
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		// import the data into the dataset
		for (int index = 0; index < 6; index++) {
			
			String name = LVApplication.regionList[index].getName();
			int[] valueList = LVApplication.regionList[index].getValueList();
			int[] yearList = {1991, 1996, 2001, 2006, 2011, 2016};
			
			for (int listIndex = 0; listIndex < 6; listIndex++) {
				dataset.addValue(valueList[listIndex], name, String.valueOf(yearList[listIndex]));
				
			}
			
		}

		return dataset;

	}

}
