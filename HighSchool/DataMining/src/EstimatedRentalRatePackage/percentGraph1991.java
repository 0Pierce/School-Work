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
public class percentGraph1991 extends JPanel{
	
	private static fileImport files;
	private static percentStorage[] tempData;
	public percentGraph1991(){
		setBounds(0,200,1000,700);
		setBackground(new Color(203,233,254));
		setLayout(null);

		CategoryDataset dataset = createDataset();
		JFreeChart chart = ChartFactory.createBarChart(
				"Percent Change of Rental Rate 1991", 		
				"Region",		
				"Percent"
				+ "",
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
		
		tempData = fileImport.importPercentYear1991();
		for (int i = 0; i < tempData.length;i++)
		{
			if(tempData[i].getPercentChange()!=0) {
				dataset.addValue(tempData[i].getPercentChange(),"Percent Change", tempData[i].getArea());
			}
		}
		return dataset;
		
	}


}
