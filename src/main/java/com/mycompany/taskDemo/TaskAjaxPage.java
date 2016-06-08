package com.mycompany.taskDemo;

import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.list.PropertyListView;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;

import org.apache.wicket.ajax.AjaxSelfUpdatingTimerBehavior;
import org.apache.wicket.util.time.Duration;


import java.util.List;
import java.util.TimeZone;

import com.mycompany.taskDemo.service.TaskListService;
import com.mycompany.taskDemo.model.Task;



public class TaskAjaxPage extends WebPage {

    List <Task> tkl;
    // TaskListService ts ;

    public TaskAjaxPage() {

        IModel tkl =  new LoadableDetachableModel() {
            protected Object load() {
                return getTaskList();
            }
        };

        ListView tks = new ListView("tks", tkl) {
            protected void populateItem(final ListItem item) {
                Task tk = (Task)item.getModelObject();
                item.add(new Label("name", tk.getName()));
                item.add(new Label("pid", Long.toString(tk.getPid())));
                item.add(new Label("type", tk.getType()));
                item.add(new Label("ramUsage", tk.getRamUsage()));
            }
        };

        WebMarkupContainer wc = new WebMarkupContainer("wc");
        wc.setOutputMarkupId(true);
        wc.add(new AjaxSelfUpdatingTimerBehavior(Duration.seconds(5)));
        wc.add(tks);

        Clock clock = new Clock("clock", TimeZone.getTimeZone(
                                    // "America/Los_Angeles"
                                    "Asia/Hong_Kong"
                                ));
        wc.add(clock);

        add(wc);


    }

    private List getTaskList() {

        TaskListService ts = new TaskListService();
        return ts.getTasks();
    }
}
