package org.apache.wicket.examples.ajax.builtin;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.ajax.markup.html.form.AjaxCheckBox;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.util.io.IClusterable;

public class TodoList extends BasePage
{
	
	 	/**
     * Container for redrawing the todo items list with an AJAX call.
     */
    // private final WebMarkupContainer showItems = null;
    private WebMarkupContainer showItems = null;

    /**
     * The list of todo items.
     */
    final List<TodoItem> items = new ArrayList<TodoItem>();
	
		/**
     * Constructor.
     */
    public TodoList()
    {
        // add the listview container for the todo items.
        showItems = new TodoItemsContainer("showItems");
        add(showItems);

        add(new AjaxFallbackLink<Void>("ajaxback")
        {
            /**
             * @see org.apache.wicket.ajax.markup.html.AjaxFallbackLink#onClick(org.apache.wicket.ajax.AjaxRequestTarget)
             */
            @Override
            public void onClick(AjaxRequestTarget target)
            {
                setResponsePage(getPage());
            }
        });
        // add the add container for the todo items.
        add(new AddItemsContainer("addItems"));
    }
	
	
    /**
     * The todo object.
     */   	     
     
    public static class TodoItem implements IClusterable
    {
        private static final long serialVersionUID = 1L;

        /** Is the item done? */
        private boolean checked;

        /** Description of the item. */
        private String text;

        /** Constructor. */
        public TodoItem()
        {
        }

        public TodoItem(TodoItem item)
        {
            text = item.text;
        }

        public boolean isChecked()
        {
            return checked;
        }
        
          public void setChecked(boolean checked)
        {
            this.checked = checked;
        }

        public String getText()
        {
            return text;
        }
        
        public void setText(String text)
        {
            this.text = text;
        }
    }
    
    
    /**
     * Container for displaying the todo items in a list.
     */
    public class TodoItemsContainer extends WebMarkupContainer
    {
        /**
         * Constructor.
         * 
         * @param id
         * the component identifier.
         */
        public TodoItemsContainer(String id)
        {
            super(id);

            // let wicket generate a markup-id so the contents can be
            // updated through an AJAX call.
            setOutputMarkupId(true);

            // add the listview to the container
            add(new ListView<TodoItem>("item", items)
            {
                @Override
                protected void populateItem(ListItem<TodoItem> item)
                {
                    // add an AJAX checkbox to the item
                    item.add(new AjaxCheckBox("check", new PropertyModel<Boolean>(
                        item.getDefaultModel(), "checked"))
                    {
                        @Override
                        protected void onUpdate(AjaxRequestTarget target)
                        {
                            // no need to do anything, the model is updated by
                            // itself, and we don't have to re-render a
                            // component (the client already has the correct
                            // state).
                        }
                    });
                    // display the text of the todo item
                    item.add(new Label("text", new PropertyModel<String>(item.getDefaultModel(),
                        "text")));
                }
            });
        }
    }
    
        /**
     * Container for showing either the add link, or the addition form.
     */
    public class AddItemsContainer extends WebMarkupContainer
    {
        /** Visibility toggle so that either the link or the form is visible. */
        private boolean linkVisible = true;

        /** Link for displaying the AddTodo form. */
        private final class AddTodoLink extends AjaxFallbackLink
        {
            /** Constructor. */
            private AddTodoLink(String id)
            {
                super(id);
            }
            
            @Override
            public void onClick(AjaxRequestTarget target)
            {
                onShowForm(target);
            }
            
            @Override
            public boolean isVisible()
            {
                return linkVisible;
            }
        }
        
        /**
         * Link for removing all completed todos from the list, this link follows the same
         * visibility rules as the add link.
         */
        private final class RemoveCompletedTodosLink extends AjaxFallbackLink
        {
            /**
             * Constructor.
             * 
             * @param id
             *            component id
             */
            public RemoveCompletedTodosLink(String id)
            {
                super(id);
            }

            /**
             * @see AjaxFallbackLink#onClick(org.apache.wicket.ajax.AjaxRequestTarget)
             */
            @Override
            public void onClick(AjaxRequestTarget target)
            {
                onRemoveCompletedTodos(target);
            }

            /**
             * Toggles the visibility with the add form.
             * 
             * @return <code>true</code> when the add links is visible and the form isn't.
             */
            @Override
            public boolean isVisible()
            {
                return linkVisible;
            }
        }

        /**
         * Displays a form which offers an edit field and two buttons: one for adding the todo item,
         * and one for canceling the addition. The visibility of this component is mutual exclusive
         * with the visibility of the add-link.
         */
        private final class AddTodoForm extends Form<TodoItem>
        {
            /**
             * Constructor.
             * @param id
             * the component id.
             */
            public AddTodoForm(String id)
            {
                super(id, new CompoundPropertyModel<TodoItem>(new TodoItem()));
                setOutputMarkupId(true);
                add(new TextField<String>("text"));
                add(new AjaxButton("add", this)
                {
                    @Override
                    protected void onSubmit(AjaxRequestTarget target, Form<?> form)
                    {
                        // retrieve the todo item
                        TodoItem item = (TodoItem)getParent().getDefaultModelObject();

                        // add the item
                        onAdd(item, target);
                    }

                    @Override
                    protected void onError(AjaxRequestTarget target, Form<?> form)
                    {
                    }
                });

                add(new AjaxButton("cancel", this)
                {
                    @Override
                    public void onSubmit(AjaxRequestTarget target, Form<?> form)
                    {
                        onCancelTodo(target);
                    }

                    @Override
                    protected void onError(AjaxRequestTarget target, Form<?> form)
                    {
                    }
                });
            }

            /**
             * Toggles the visibility with the add link. When the link is visible, the form isn't.
             * 
             * @return true when the form is visible and the link isn't.
             */
            @Override
            public boolean isVisible()
            {
                return !linkVisible;
            }
        }
        
        /**
         * Constructor.
         * @param id
         * the component id.
         */
        public AddItemsContainer(String id)
        {
            super(id);
            // let wicket generate a markup-id so the contents can be
            // updated through an AJAX call.
            setOutputMarkupId(true);
            add(new AddTodoLink("link"));
            add(new RemoveCompletedTodosLink("remove"));
            add(new AddTodoForm("form"));
        }
        
        /**
         * Called then the add link was clicked, shows the form, and hides the link.
         */
        void onShowForm(AjaxRequestTarget target)
        {
            // toggle the visibility
            linkVisible = false;

            // redraw the add container.
            target.add(this);
        }
        
        void onRemoveCompletedTodos(AjaxRequestTarget target)
        {
            List<TodoItem> ready = new ArrayList<TodoItem>();
            for (TodoItem todo : items)
            {
                if (todo.isChecked())
                {
                    ready.add(todo);
                }
            }
            items.removeAll(ready);

            // repaint our panel
            target.add(this);

            // repaint the listview as there was a new item added.
            target.add(showItems);
        }
        
        
        /**
         * Called when the form is submitted through the add button, stores the todo item, hides the
         * form, displays the add link and updates the listview.
         */         
        void onAdd(TodoItem item, AjaxRequestTarget target)
        {
            // add the item
            items.add(new TodoItem(item));

            // reset the model
            item.setChecked(false);
            item.setText("");

            // toggle the visibility
            linkVisible = true;

            // repaint our panel
            target.add(this);

            // repaint the listview as there was a new item added.
            target.add(showItems);
        }

				/**
         * Called when adding a new todo item was canceled. Hides the add form and displays the add
         * link.         
         * @param target
         * the request target.
         */
        void onCancelTodo(AjaxRequestTarget target)
        {
            // toggle the visibility
            linkVisible = true;

            // repaint the panel.
            target.add(this);
        }

    }
}