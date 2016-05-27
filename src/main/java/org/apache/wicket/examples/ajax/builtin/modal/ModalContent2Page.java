package org.apache.wicket.examples.ajax.builtin.modal;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.markup.html.WebPage;


/**
 * @author Matej Knopp
 * 
 */
public class ModalContent2Page extends WebPage
{

    /**
     * @param window
     */
    public ModalContent2Page(final ModalWindow window)
    {
        add(new AjaxLink<Void>("close")
        {
            private static final long serialVersionUID = 1L;

            @Override
            public void onClick(AjaxRequestTarget target)
            {
                window.close(target);
            }
        });


    }


}
