package org.apache.wicket.examples.repeater;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.extensions.ajax.markup.html.repeater.data.table.AjaxFallbackDefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.AbstractColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import org.apache.wicket.examples.repeater.model.Contact;

/**
 * @author Martijn Dashorst
 */
public class AjaxDataTablePage extends BasePage
{
    /**
     * Constructor.
     */
    public AjaxDataTablePage()
    {
        List<IColumn<Contact, String>> columns = new ArrayList<IColumn<Contact, String>>();

        columns.add(new AbstractColumn<Contact, String>(new Model<String>("Actions"))
        {
            @Override
            public void populateItem(Item<ICellPopulator<Contact>> cellItem, String componentId,
                IModel<Contact> model)
            {
                cellItem.add(new ActionPanel(componentId, model));
            }
        });

        columns.add(new PropertyColumn<Contact, String>(new Model<String>("ID"), "id"));
        columns.add(new PropertyColumn<Contact, String>(new Model<String>("First Name"), "firstName",
            "firstName"));
        columns.add(new PropertyColumn<Contact, String>(new Model<String>("Last Name"), "lastName",
            "lastName"));
        columns.add(new PropertyColumn<Contact, String>(new Model<String>("Home Phone"), "homePhone"));
        columns.add(new PropertyColumn<Contact, String>(new Model<String>("Cell Phone"), "cellPhone"));

        add(new AjaxFallbackDefaultDataTable<Contact, String>("table", columns,
            new SortableContactDataProvider(), 8));
    }
}