package org.apache.wicket.examples.ajax.builtin.modal;

import java.util.Map;

import org.apache.wicket.extensions.yui.calendar.DateTimeField;
import org.apache.wicket.markup.html.panel.Panel;

/**
 * @author Matej Knopp
 */
public class ModalPanel1 extends Panel
{

    /**
     * @param id
     */
    public ModalPanel1(String id)
    {
        super(id);

        add(new DateTimeField("dateTimeField")
        {
            /**
             * @see org.apache.wicket.extensions.yui.calendar.DateTimeField#configure(java.util.Map)
             */
            @Override
            protected void configure(Map<String, Object> widgetProperties)
            {
                super.configure(widgetProperties);
                // IE 6 breaks layout with iframe - is that a YUI bug?
                widgetProperties.put("iframe", false);
            }
        });
    }

}
