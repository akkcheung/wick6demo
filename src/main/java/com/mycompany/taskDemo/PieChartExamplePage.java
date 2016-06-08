package com.mycompany.taskDemo;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.WebMarkupContainer;

import org.apache.wicket.ajax.AjaxSelfUpdatingTimerBehavior;
import org.apache.wicket.util.time.Duration;
import org.apache.wicket.ajax.AjaxRequestTarget;

import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import java.util.Random;
 
public class PieChartExamplePage extends WebPage {
 
   //  private int i ;
    
    public PieChartExamplePage() {
        
        DefaultPieDataset d = new DefaultPieDataset();
        
        int i = new Random().nextInt(100 + 1) ;                        

                
        d.setValue("JavaWorld", new Integer(i));
        d.setValue("Other", new Integer(100 - i));
    
        System.out.println("i > " + i);
        
        JFreeChart chart = ChartFactory.createPieChart("Sample Pie Chart", d,
                 true,      // Show legend 
                 true,      // Show tooltips
                 true);     // Show urls
        //chart.setBackgroundPaint(Color.white);
        //chart.setBorderVisible(false);
        
        add(new JFreeChartImage("image", chart, 300, 300));
        
    }

}