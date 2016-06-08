package com.mycompany.taskDemo;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;

import org.apache.wicket.settings.IRequestLoggerSettings;

public class WicketApplication extends WebApplication {
		
    @Override
    public Class<? extends WebPage> getHomePage() {
        // return TaskPage.class;
        // return TaskAjaxPage.class;       
        
        // return DynamicRowPage.class;
        
        // return PieChartExamplePage.class;
        // return PieChartExampleAjaxPage.class;
        
        // return DefaultDatePickerPage.class;
    }

    @Override
    public void init() {
        super.init(); 
       
        //Get the logger
        //IRequestLoggerSettings reqLogger = getRequestLoggerSettings();
   
        //Enable the logger
        //reqLogger.setRequestLoggerEnabled(true);
 
          /**
          * Set the window of all the requests that is kept in memory for viewing. Default is 2000, You
          * can set this to 0 then only Sessions data is recorded (number of request, total time, latest
          * size)
          */
          //reqLogger.setRequestsWindowSize(3000);
                
    }
    
   
}


