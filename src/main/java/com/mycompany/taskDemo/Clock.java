package com.mycompany.taskDemo;

import java.text.DateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.AbstractReadOnlyModel;

/**
 * A simple component that displays current time
 * 
 * @author Igor Vaynberg (ivaynberg)
 */
public class Clock extends Label
{
    /**
     * Constructor
     * 
     * @param id
     *            Component id
     * @param tz
     *            Timezone
     */
    public Clock(String id, TimeZone tz)
    {
        super(id, new ClockModel(tz));

    }

    /**
     * A model that returns current time in the specified timezone via a formatted string
     * 
     * @author Igor Vaynberg (ivaynberg)
     */
    private static class ClockModel extends AbstractReadOnlyModel<String>
    {
        private final DateFormat df;

        /**
         * @param tz
         */
        public ClockModel(TimeZone tz)
        {
            df = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.LONG);
            df.setTimeZone(tz);                    
                        
   
   					// checking available Ids   					
   					// String[] availId = TimeZone.getAvailableIDs();      
   					// System.out.println("Available Ids are: ");
   					// for (int i=0; i<availId.length; i++){
   					//	System.out.println(availId[i]);
   					// } 
        }

        /**
         * @see org.apache.wicket.model.AbstractReadOnlyModel#getObject()
         */
        @Override
        public String getObject()
        {
            return df.format(new Date());
        }
    }
}
