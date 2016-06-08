package com.mycompany.taskDemo;

import java.util.Date;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.Model;

import com.googlecode.wicket.jquery.ui.form.button.AjaxButton;
import com.googlecode.wicket.jquery.ui.form.button.Button;
import com.googlecode.wicket.jquery.ui.form.datepicker.DatePicker;
import com.googlecode.wicket.jquery.ui.panel.JQueryFeedbackPanel;

import com.googlecode.wicket.jquery.core.Options;

import org.apache.wicket.markup.html.WebPage;

// public class DefaultDatePickerPage extends AbstractDatePickerPage
 public class DefaultDatePickerPage extends WebPage 
{
	private static final long serialVersionUID = 1L;

	public DefaultDatePickerPage()
	{
		final Form<Date> form = new Form<Date>("form", new Model<Date>());
		this.add(form);

		// FeedbackPanel //
		form.add(new JQueryFeedbackPanel("feedback"));

		// Date Picker //
		form.add(
            // new DatePicker("datepicker", form.getModel()).setRequired(true)            
        
            new DatePicker( "datepicker", form.getModel(), "dd/MM/yy", new Options("dateFormat", Options.asString("dd/mm/yy")))
            //    .setRequired(true)
        );

		// Buttons //
		form.add(new Button("submit") {

			private static final long serialVersionUID = 1L;

			@Override
			public void onSubmit()
			{
				DefaultDatePickerPage.this.info(this, form);
                
                // System.out.println( (Date)form.getModel()) ;
			}
		});

		form.add(new AjaxButton("button") {

			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form)
			{
				DefaultDatePickerPage.this.info(this, form);
				target.add(form);
			}

			@Override
			protected void onError(AjaxRequestTarget target, Form<?> form)
			{
				target.add(form); //refresh feedback panel
			}
		});
	}

	private void info(Component component, Form<?> form)
	{
		this.info(component.getMarkupId() + " has been clicked");
		this.info("The model object is: " + form.getModelObject());
	}
}