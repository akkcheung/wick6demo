package org.apache.wicket.examples.authentication1;

// import org.apache.wicket.examples.WicketExamplePage;
import org.apache.wicket.markup.html.WebPage;

import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 * Simple logout page.
 * 
 * @author Jonathan Locke
 */
// public class SignOut extends WicketExamplePage
public class SignOut extends WebPage
{
    /**
     * Constructor
     * 
     * @param parameters
     *            Page parameters (ignored since this is the home page)
     */
    public SignOut(final PageParameters parameters)
    {
        getSession().invalidate();
    }
}
