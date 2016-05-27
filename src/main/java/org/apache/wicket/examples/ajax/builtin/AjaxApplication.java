package org.apache.wicket.examples.ajax.builtin;

import org.apache.wicket.Page;
// import org.apache.wicket.examples.WicketExampleApplication;


import org.apache.wicket.examples.ajax.builtin.modal.ModalWindowPage;

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
public class AjaxApplication extends WebApplication
{
		public AjaxApplication()
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
        
        mountPage("modal-window", ModalWindowPage.class);
        
        mountPage("guest-book", GuestBook.class);
        
        mountPage("todo-list", TodoList.class);
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