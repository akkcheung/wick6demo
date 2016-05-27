package org.apache.wicket.examples.guestbook;

import java.util.Date;

import org.apache.wicket.util.io.IClusterable;


/**
 * Simple "POJO" bean for guestbook comments.
 * 
 * @author Jonathan Locke
 */
public class Comment implements IClusterable
{
    private String text;
    private Date date = new Date();

    /**
     * Constructor
     */
    public Comment()
    {
    }

    /**
     * Copy constructor
     * 
     * @param comment
     *            The comment to copy
     */
    public Comment(final Comment comment)
    {
        this.text = comment.text;
        this.date = comment.date;
    }

    /**
     * @return Returns the text.
     */
    public String getText()
    {
        return text;
    }

    /**
     * @param text
     *            The text to set.
     */
    public void setText(String text)
    {
        this.text = text;
    }

    /**
     * @return Returns the date.
     */
    public Date getDate()
    {
        return date;
    }

    /**
     * @param date
     *            The date to set.
     */
    public void setDate(Date date)
    {
        this.date = date;
    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "[Comment date = " + date + ", text = " + text + "]";
    }
}
