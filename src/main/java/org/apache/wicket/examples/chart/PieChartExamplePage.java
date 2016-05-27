
package org.apache.wicket.examples.chart;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.Model;

import com.pingunaut.wicket.chartjs.chart.impl.Line;
import com.pingunaut.wicket.chartjs.chart.impl.Pie;
import com.pingunaut.wicket.chartjs.core.panel.LineChartPanel;
import com.pingunaut.wicket.chartjs.core.panel.PieChartPanel;
import com.pingunaut.wicket.chartjs.data.LineChartData;
import com.pingunaut.wicket.chartjs.data.PieChartData;

import com.pingunaut.wicket.chartjs.data.sets.LineDataSet;

import java.util.List;
import java.util.ArrayList;

public class PieChartExamplePage extends WebPage {


  public PieChartExamplePage() {
	}
	
	@Override
	protected void onInitialize() {
		
		super.onInitialize();
		
		LineChartPanel lineChartPanel = new LineChartPanel("lineChartPanel", Model.of(new Line()));
		add(lineChartPanel);
		 
		// fill your chart with some data
		List<String> labels = new ArrayList<String>();
		labels.add("jan");
		labels.add("feb");
		labels.add("mar");
		 
		List<Integer> values = new ArrayList<Integer>();
		values.add(4);
		values.add(2);
		values.add(6);
		 
		LineChartData<LineDataSet> lineData = new LineChartData<LineDataSet>();
		lineData.getDatasets().add(new LineDataSet(values));
		lineChartPanel.getChart().setData(lineData);
		lineData.setLabels(labels);
		
	}

	

}