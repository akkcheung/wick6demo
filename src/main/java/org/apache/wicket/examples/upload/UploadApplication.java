package org.apache.wicket.examples.upload;

import org.apache.wicket.Page;
// import org.apache.wicket.examples.WicketExampleApplication;

import org.apache.wicket.protocol.http.WebApplication;

import org.apache.wicket.util.file.Folder;


/**
 * Application class for org.apache.wicket.examples.upload example.
 * 
 * @author Eelco Hillenius
 */
// public class UploadApplication extends WicketExampleApplication
public class UploadApplication extends WebApplication
{
    private Folder uploadFolder = null;

    /**
     * Constructor.
     */
    public UploadApplication()
    {
    }


    /**
     * @see org.apache.wicket.Application#getHomePage()
     */
    @Override
    public Class<? extends Page> getHomePage()
    {
        // return UploadPage.class;
        return Index.class;
    }

    /**
     * @return the folder for uploads
     */
    public Folder getUploadFolder()
    {
        return uploadFolder;
    }

    /**
     * @see org.apache.wicket.examples.WicketExampleApplication#init()
     */
    @Override
    protected void init()
    {
        super.init();

        getResourceSettings().setThrowExceptionOnMissingResource(false);

        uploadFolder = new Folder(System.getProperty("java.io.tmpdir"), "wicket-uploads");
        // Ensure folder exists
        uploadFolder.mkdirs();

        mountPage("/multi", MultiUploadPage.class);
        // mountPage("/single", UploadPage.class);

        getApplicationSettings().setUploadProgressUpdatesEnabled(true);
    }
}