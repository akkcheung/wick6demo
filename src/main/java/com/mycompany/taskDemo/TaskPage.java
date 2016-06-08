package com.mycompany.taskDemo;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.PropertyListView;
import org.apache.wicket.markup.html.list.ListItem;

import java.util.Date;
import java.util.List;

import com.mycompany.taskDemo.service.TaskListService;
import com.mycompany.taskDemo.model.Task;


public class TaskPage extends WebPage {
    
    List <Task> tkl;
    TaskListService ts ;    
    
    public TaskPage() { 
    	  
    	  ts = new TaskListService();
    	  tkl = ts.getTasks();

				add(new PropertyListView<Task>("tks", tkl) {
            @Override
            public void populateItem(final ListItem<Task> item) {
                item.add(new Label("name"));
                // listItem.add(new MultiLineLabel("text"));
                
                item.add(new Label("pid"));
                item.add(new Label("type"));
                item.add(new Label("ramUsage"));
            }
        }).setVersioned(false);
    	   	    
    }
    
    /*
    add(new AbstractAjaxTimerBehavior(Duration.seconds(3))
    {
    	 @Override
       protected void onTimer(AjaxRequestTarget target)
       {              	
       }
  	}
  	*/
         
}

