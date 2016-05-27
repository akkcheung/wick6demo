package com.javaonline;
 
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.mapper.parameter.PageParameters;
 
public class Acknowledgement extends WebPage {
 
	public Acknowledgement(final PageParameters page) throws Exception {
	 
		Label name = new Label("name", page.get("name"));
		Label email = new Label("email", page.get("email"));
		Label regDate = new Label("createdOn", page.get("createdOn"));
		 
		add(name);
		add(email);
		add(regDate);
	}
}
