package org.apache.wicket.examples.chart;

import org.apache.wicket.Page;
// import org.apache.wicket.examples.WicketExampleApplication;


// import org.apache.wicket.examples.ajax.builtin.modal.ModalWindowPage;

/*
import org.apache.wicket.examples.ajax.builtin.tree.EditableTreeTablePage;
import org.apache.wicket.examples.ajax.builtin.tree.SimpleTreePage;
import org.apache.wicket.examples.ajax.builtin.tree.TreeTablePage;
*/

import org.apache.wicket.response.filter.AjaxServerAndClientTimeFilter;

import org.apache.wicket.protocol.http.WebApplication;


/**
 * Application object for the wicked ajax examples
 */
// public class AjaxApplication extends WicketExampleApplication
public class ChartApplication extends WebApplication
{
		public ChartApplication()
    {
    }

    /**
     * @see org.apache.wicket.examples.WicketExampleApplication#init()
     */
    @Override
    protected void init()
    {
        super.init();

        getApplicationSettings().setUploadProgressUpdatesEnabled(true);

        getResourceSettings().setThrowExceptionOnMissingResource(false);

        getRequestCycleSettings().addResponseFilter(new AjaxServerAndClientTimeFilter());

        getDebugSettings().setAjaxDebugModeEnabled(true);
        
        mountPage("pie-chart", PieChartExamplePage.class);              
		}

    /**
     * @see org.apache.wicket.Application#getHomePage()
     */
    @Override
    public Class<? extends Page> getHomePage()
    {
        return Index.class;
    }
}