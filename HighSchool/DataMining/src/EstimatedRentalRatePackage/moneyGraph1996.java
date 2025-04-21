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
public class moneyGraph1996 extends JPanel{
	
	private static fileImport files;
	private static moneyStorage[] tempData;
	public moneyGraph1996(){
		setBounds(0,200,1000,700);
		setBackground(new Color(203,233,254));
		setLayout(null);

		CategoryDataset dataset = createDataset();
		JFreeChart chart = ChartFactory.createBarChart(
				"Rental Rate per Acre 1996", 		
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
private static CategoryDataset createDataset() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		tempData = fileImport.importMoneyYear1996();
		for (int i = 0; i < tempData.length;i++)
		{
			if(tempData[i].getRentRate()!=0) {
				dataset.addValue(tempData[i].getRentRate(),"Rental Rate", tempData[i].getArea());
			}
		}
		return dataset;
		
	}


}

