package org.apache.wicket.examples.repeater;

// import org.apache.wicket.examples.WicketExamplePage;
import org.apache.wicket.markup.html.WebPage;

/**
 * Base class for all pages in the QuickStart application. Any page which subclasses this page can
 * get session properties from QuickStartSession via getQuickStartSession().
 * 
 */
// public abstract class ExamplePage extends WicketExamplePage
public abstract class ExamplePage extends WebPage
{
    /**
     * Get downcast session object for easy access by subclasses
     * 
     * @return The session
     */
    public ContactsDatabase getContactsDB()
    {
        return ((RepeaterApplication)getApplication()).getContactsDB();
    }
}
