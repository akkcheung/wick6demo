package com.mycompany.taskDemo;

import org.apache.wicket.request.mapper.parameter.PageParameters;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;

import org.apache.wicket.MarkupContainer;

import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.ajax.AjaxRequestTarget;

import java.util.ArrayList;

public class DynamicRowPage extends WebPage {

    private static final long serialVersionUID = 1L;

    public DynamicRowPage(final PageParameters parameters) {
        super(parameters);

        // List all rows
        final ArrayList <String> rows = new ArrayList(2);
        rows.add(new String());
        rows.add(new String());

        // Create a panel within the form, to enable AJAX action
        final MarkupContainer rowPanel = new WebMarkupContainer("rowPanel");
        rowPanel.setOutputMarkupId(true);

        Form<?> form  = new Form("form") {
            public void onSubmit() {

                for (String temp : rows) {
                    System.out.println(temp);
                }

                // redirect page
                getRequestCycle().setResponsePage(DynamicRowPage.class);

            }
        };
        form.add(rowPanel);



        final ListView lv = new ListView("rows", rows) {
            @Override
            protected void populateItem(ListItem item) {
                int index = item.getIndex() + 1;
                item.add(new Label("index", index + "."));

                TextField text = new TextField("text", item.getModel());
                item.add(text);
            }
        };

        /** reuse the already created TextFields and
        * will call the populateItem method only for the newly added row
        */
        lv.setReuseItems(true);
        rowPanel.add(lv);

        AjaxSubmitLink addLink = new AjaxSubmitLink("addRow", form) {

            @Override
            public void onSubmit(AjaxRequestTarget target, Form form) {
                lv.getModelObject().add(new String());

                if (target != null)
                    // target.addComponent(rowPanel);
                    target.add(rowPanel);
            }
        };

        addLink.setDefaultFormProcessing(false);
        rowPanel.add(addLink);

        add(form).setVersioned(false);

        // setVersioned(false);
    }


}