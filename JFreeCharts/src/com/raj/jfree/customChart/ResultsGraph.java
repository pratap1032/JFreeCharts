package com.raj.jfree.customChart;
import java.awt.*;
import java.awt.geom.RectangularShape;

import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.axis.SymbolAxis;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.ClusteredXYBarRenderer;
import org.jfree.chart.renderer.xy.StandardXYBarPainter;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.*;

/**
 * A demonstration application showing a time series chart overlaid
 *  with a vertical XY bar chart.
 *  @author Raja Pratap
 */
public class ResultsGraph extends ApplicationFrame {

	/**
	 * Generated Serial ID
	 */
	private static final long serialVersionUID = -5793600882027370976L;


	public ResultsGraph(String s) {
		super(s);
		setContentPane(createDemoPanel());
	}

	public static JPanel createDemoPanel() {
		JPanel jpanel = new JPanel(new GridLayout(1, 1));
		jpanel.setPreferredSize(new Dimension(800, 400));
		IntervalXYDataset intervalxydataset = createDataset();
		JFreeChart jfreechart = ChartFactory.createXYBarChart("Company Result", null, true,
				"", intervalxydataset, PlotOrientation.VERTICAL, true,
				true, false);

		jfreechart.setBackgroundPaint(Color.white);
		LegendTitle legend = jfreechart.getLegend();
		legend.setPosition(RectangleEdge.RIGHT);
		legend.setFrame(BlockBorder.NONE);


		XYPlot xyplot = (XYPlot) jfreechart.getPlot();
		SymbolAxis domainAxis = new SymbolAxis("",new String[]{"NPA","1 Year","2 year","3 year","4 year","5 year"});
		domainAxis.setGridBandsVisible(false);
		xyplot.setDomainAxis(domainAxis);
		xyplot.setBackgroundPaint(Color.white);
		xyplot.setRangeGridlinePaint(Color.lightGray);
		xyplot.setDomainGridlinesVisible(false);

		ClusteredXYBarRenderer clusteredxybarrenderer = new ClusteredXYBarRenderer(
				0.20000000000000001D, false);
		xyplot.setRenderer(clusteredxybarrenderer);



		XYBarRenderer xybarrenderer = (XYBarRenderer) xyplot.getRenderer();
		xybarrenderer.setDrawBarOutline(false);
		xybarrenderer.setSeriesPaint(0, new Color(154,205,50));
		xybarrenderer.setSeriesPaint(1, new Color(70,130,180));
		xybarrenderer.setSeriesPaint(2,  new Color(165,42,42));
		xybarrenderer.setBarPainter(new StandardXYBarPainter() {
			/**
			 * Generated Serial ID
			 */
			private static final long serialVersionUID = -5083643771352449443L;

			@Override
			public void paintBarShadow(Graphics2D g2, XYBarRenderer renderer, int row,
					int column, RectangularShape bar, RectangleEdge base,
					boolean pegShadow) {}
		});

		xybarrenderer.setGradientPaintTransformer(new StandardGradientPaintTransformer(
				GradientPaintTransformType.VERTICAL));

		final XYDataset data5 = createDataset1();
		final XYItemRenderer renderer5 = new StandardXYItemRenderer(3);
		renderer5.setSeriesPaint(0, new Color(72,61,139));
		xyplot.setDataset(1, data5);
		xyplot.setRenderer(1, renderer5);
		xyplot.setOutlineVisible(false);


		ChartPanel chartpanel = new ChartPanel(jfreechart);
		jpanel.add(chartpanel);
		return jpanel;
	}

	private static IntervalXYDataset createDataset() {

		XYSeries XYSeries = new XYSeries("Company Net Benefits");
		XYSeries.add(0, 30000);

		XYSeries XYSeries1 = new XYSeries("Company Benefits");
		XYSeries1.add(1, 5000);
		XYSeries1.add(2, 10000);
		XYSeries1.add(3, 10000);
		XYSeries1.add(4, 10000);
		XYSeries1.add(5, 10000);

		XYSeries XYSeries2 = new XYSeries("Company Costs");
		XYSeries2.add(1, -1000);
		XYSeries2.add(2, -500);
		XYSeries2.add(3, -3000);
		XYSeries2.add(4, -1000);
		XYSeries2.add(5, -1000);

		XYSeriesCollection timeseriescollection = new XYSeriesCollection(
				XYSeries);
		timeseriescollection.addSeries(XYSeries1);
		timeseriescollection.addSeries(XYSeries2);
		return timeseriescollection;
	}

	/**
	 * @return Dataset
	 */
	private static XYDataset createDataset1() {
		XYSeries XYSeries = new XYSeries("Company Accumulated Benefits");
		XYSeries.add(1, 5000);
		XYSeries.add(2, 10000);
		XYSeries.add(3, 10000);
		XYSeries.add(4, 10000);
		XYSeries.add(5, 10000);

		XYSeriesCollection timeseriescollection = new XYSeriesCollection(
				XYSeries);
		return timeseriescollection;
	}


	public static void main(String args[]) {
		ResultsGraph clusteredxybarrendererdemo1 = new ResultsGraph(
		"SimpleResultsGraphDemo");
		clusteredxybarrendererdemo1.pack();
		RefineryUtilities.centerFrameOnScreen(clusteredxybarrendererdemo1);
		clusteredxybarrendererdemo1.setVisible(true);
	}
}

