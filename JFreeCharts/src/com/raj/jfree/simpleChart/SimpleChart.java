package com.raj.jfree.simpleChart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;


/** Simple Jfree Chart Creation
 * @author Raja Pratap
 *
 */
public class SimpleChart extends ApplicationFrame {

	/**
	 * Generated Serial ID
	 */
	private static final long serialVersionUID = -4994407687348119019L;

	public SimpleChart(String title) {
		super(title);

		final CategoryDataset dataset = createDataset();
		final JFreeChart chart = createChart(dataset);

		final ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new java.awt.Dimension(400, 270));
		setContentPane(chartPanel);
	}

	private CategoryDataset createDataset() { 
		final double[][] data = new double[][] {
				{210,300,320,265,299},
				{200,304,201,201,340},
		};
		return DatasetUtilities.createCategoryDataset("Team ", 
				"Match ", data);
	}

	private JFreeChart createChart(final CategoryDataset dataset) {

		final JFreeChart chart = ChartFactory.createBarChart(
				"Bar Chart Demo", "Category", "Score", dataset,
				PlotOrientation.VERTICAL, true, true, false);
		return chart;
	}

	public static void main(final String[] args) {
		SimpleChart chart = new SimpleChart("Vertical Bar Chart Demo");
		chart.pack();
		RefineryUtilities.centerFrameOnScreen(chart);
		chart.setVisible(true);
	}
} 