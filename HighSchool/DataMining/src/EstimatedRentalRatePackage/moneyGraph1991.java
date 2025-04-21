package EstimatedRentalRatePackage;

import java.awt.Color;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
public class moneyGraph1991 extends JPanel{
	//fields
	private static fileImport files;
	private static moneyStorage[] tempData;
	public moneyGraph1991(){
		//creation of graph based off template on classroom
		setBounds(0,200,1000,700);
		setBackground(new Color(203,233,254));
		setLayout(null);

		CategoryDataset dataset = createDataset();
		JFreeChart chart = ChartFactory.createBarChart(
				"Rental Rate per Acre 1991", 		
				"Region",		
				"Dollars (CAD)",
				dataset,
				PlotOrientation.HORIZONTAL,
				true,
				true,
				false);
		CategoryPlot plot = (CategoryPlot) chart.getPlot();
		BarRenderer renderer = (BarRenderer) plot.getRenderer();
		
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setBounds(50, 25, 900, 650);
		
		add(chartPanel);
		setVisible(true);
		
	}
	//add data into chart
private static CategoryDataset createDataset() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		//import data from csv file to variable
		tempData = fileImport.importMoneyYear1991();
		for (int i = 0; i < tempData.length;i++)
		{
			//input temp data into chart
			if(tempData[i].getRentRate()!=0) {
				dataset.addValue(tempData[i].getRentRate(),"Rental Rate", tempData[i].getArea());
			}
		}
		return dataset;
		
	}


}

