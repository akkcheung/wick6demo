package com.mycompany.taskDemo;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.image.NonCachingImage;

// import org.apache.wicket.ajax.AjaxSelfUpdatingTimerBehavior;
import org.apache.wicket.ajax.AbstractAjaxTimerBehavior;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.util.time.Duration;

import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import java.util.Random;
 
public class PieChartExampleAjaxPage extends WebPage {
 
    public PieChartExampleAjaxPage() {
        
        final WebMarkupContainer wc = new WebMarkupContainer("wc");
        wc.setOutputMarkupId(true);
        
        NonCachingImage img = generateImage();
        wc.add(img);
        
        wc.add(
            // new AjaxSelfUpdatingTimerBehavior(Duration.seconds(5)){
            new AbstractAjaxTimerBehavior(Duration.seconds(5)) {
  
                /*
                @Override
                protected void onPostProcessTarget(AjaxRequestTarget target) {
                    target.add(wc.replace(generateImage()));
                }
                */
                
                @Override
                protected void onTimer(AjaxRequestTarget target) {
                    target.add(wc.replace(generateImage()));
                }
                
            }
        );
        
        add(wc);
    }
 
    public NonCachingImage generateImage() {
            
        int i = new Random().nextInt(100 + 1) ;
        
        DefaultPieDataset d = new DefaultPieDataset();
        d.setValue("JavaWorld", new Integer(i));
        d.setValue("Other", new Integer(100 - i));        
        
        // System.out.println("i > " + i);
        
         JFreeChart chart = ChartFactory.createPieChart("Sample Pie Chart", d,
                 true,      // Show legend 
                 true,      // Show tooltips
                 true);     // Show urls
        
        NonCachingImage img = new JFreeChartImage("image", chart, 300, 300);
        
        img.setOutputMarkupId(true);
        return img; 
    }
    
}