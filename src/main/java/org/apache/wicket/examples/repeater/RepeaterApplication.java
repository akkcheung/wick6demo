package org.apache.wicket.examples.repeater;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.response.filter.ServerAndClientTimeFilter;

// import org.apache.wicket.examples.repeater.service.*;

/**
 * application class for repeater examples application
 * 
 * @author Igor Vaynberg (ivaynberg)
 * 
 */
public class RepeaterApplication extends WebApplication
{
    private final ContactsDatabase contactsDB = new ContactsDatabase(50);


    /**
     * Constructor.
     */
    public RepeaterApplication()
    {
    }

    /**
     * @see org.apache.wicket.protocol.http.WebApplication#init()
     */
    @Override
    protected void init()
    {
        getDebugSettings().setDevelopmentUtilitiesEnabled(true);

        getRequestCycleSettings().addResponseFilter(new ServerAndClientTimeFilter());
    }

    /**
     * @return contacts database
     */
    public ContactsDatabase getContactsDB()
    {
        return contactsDB;
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
