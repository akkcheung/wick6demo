package com.javaonline;
 
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
 
public class WicketStarter extends WebApplication
{
	@Override
	public Class<? extends WebPage> getHomePage(){
		// return FirstPage.class;
		return RegistrationInputPage.class;
	}
	 
	@Override
	public void init(){
		super.init();	 
	}
}
