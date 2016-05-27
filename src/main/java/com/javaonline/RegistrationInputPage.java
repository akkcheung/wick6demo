package com.javaonline;

import java.util.Calendar;
import java.util.Date;
 
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters; 
 
import com.javaonline.service.RegistrationDAO;
import com.javaonline.model.*;
 
public class RegistrationInputPage extends WebPage {
	
	Form<?> form = null;
	RegBean regBean= new RegBean();
 
	public RegistrationInputPage(final PageParameters page) throws Exception {
		
		super();
		
		Label createdOn = new Label("createdOn",new PropertyModel(regBean, "createdOn"));
		TextField name = new TextField("name",new PropertyModel(regBean, "name"));
		TextField emailId = new TextField("emailId", new PropertyModel(regBean, "emailId"));
		
		name.setRequired(true);
		emailId.setRequired(true);
		 
		form = new Form("regForm") {
		 
			public void onSubmit() {
			 
				System.out.println("name = "+ regBean.getName());
				System.out.println("email = "+ regBean.getEmailId());
				
				// Date date = new Date();
				Calendar calendar =  Calendar.getInstance();
				
				
				// regBean.setCreatedOn(date);
				regBean.setCreatedOn(calendar);
				
				// System.out.println("createdon = "+ regBean.getCreatedOn());
				System.out.println("createdon = "+ regBean.getCreatedOn().getTime());				
				
				 
				page.add("name", regBean.getName());
				page.add("email", regBean.getEmailId());
				page.add("createdOn",regBean.getCreatedOn());
				
				try {				 
					RegistrationDAO RegistrationDao = new RegistrationDAO();
					RegistrationDao.add(regBean);
					setResponsePage(new Acknowledgement(page));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		 
		};
		 
		form.add(createdOn);
		form.add(name);
		form.add(emailId);
		add(form);
	 
	}
}
