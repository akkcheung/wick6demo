package com.mycompany.taskDemo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
 
// import org.apache.wicket.Resource;
import org.apache.wicket.request.resource.IResource ;

import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.markup.html.image.NonCachingImage;

// import org.apache.wicket.markup.html.image.resource.DynamicImageResource;
import org.apache.wicket.request.resource.DynamicImageResource;

import org.apache.wicket.model.Model;

// import org.apache.wicket.protocol.http.WebResponse;
import org.apache.wicket.request.http.WebResponse;

import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
 
// public class JFreeChartImage extends Image {
public class JFreeChartImage extends NonCachingImage {
     
    private int width;
    private int height;
 
    public JFreeChartImage(String id, JFreeChart chart, int width, int height){
        super(id, new Model(chart));
        this.width = width;
        this.height = height;
    }
 
    @Override
    // protected Resource getImageResource() { 
    protected IResource  getImageResource() {

        return new DynamicImageResource(){
            @Override
            // protected byte[] getImageData() {
            protected byte[] getImageData(IResource.Attributes attributes) {
                JFreeChart chart = (JFreeChart)getDefaultModelObject();
                return toImageData(chart.createBufferedImage(width, height));
            }
 
            /*
            @Override
            protected void setHeaders(WebResponse response) {
                if (isCacheable()) {
                    super.setHeaders(response);
                } else {
                    response.setHeader("Pragma", "no-cache");
                    response.setHeader("Cache-Control", "no-cache");
                    response.setDateHeader("Expires", 0);
                }
            }
            */
            
            
        };
    }
 
}