package org.apache.wicket.examples.report;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.util.resource.IResourceStream;
import org.apache.wicket.util.resource.FileResourceStream;
import org.apache.wicket.markup.html.link.ResourceLink;
import org.apache.wicket.Application;


import javax.servlet.ServletContext;  

import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

import org.wicketstuff.jasperreports.JRResource;
import org.wicketstuff.jasperreports.JRConcreteResource;
import org.wicketstuff.jasperreports.EmbeddedJRReport;
import org.wicketstuff.jasperreports.handlers.PdfResourceHandler;

import java.sql.*;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperExportManager;

import org.apache.wicket.examples.repeater.ContactsDatabase;
import org.apache.wicket.examples.repeater.model.Contact;



// public class SimplePdfPage extends WicketExamplePage implements Serializable
 public class SimplePdfPage extends WebPage implements Serializable {
 	
 	/**
 	 * Constructor.
 	 */
 	public SimplePdfPage() 	{
 		ServletContext context = ((WebApplication)getApplication()).getServletContext();
 		
 		System.out.println("context.getRealPath :" + context.getRealPath("/"));
 		
 		final File reportFile = new File(context.getRealPath("/reports/contactReport.jasper"));
 		
 		final Map parameters = new HashMap();
 		
 		JRResource pdfResource = new JRConcreteResource<PdfResourceHandler>(reportFile, 
 				new PdfResourceHandler()) {
			    public JRDataSource getReportDataSource() {
			        
			        //retrieve you data
			        List<Contact> contacts = getContactsDB().getIndex(null);
			        
			        return new JRBeanCollectionDataSource(contacts);
			    }
			
			  	public Map<String, Object> getReportParameters() {
			        Map<String, Object> params = new HashMap<String, Object>();
			        //set your parameters
			        // params.put("base_path", WebApplication.get().getServletContext().getRealPath(""));
			        return params;
			   	}
		}; 
 		
 		// add(new EmbeddedJRReport("report", pdfResource));
 		
 		add(new ResourceLink<Void>("linkToPdf", pdfResource));
 		
					
 	}
 	
	
	protected ContactsDatabase getContactsDB()
  {
        ReportApplication app = (ReportApplication)Application.get();
        return app.getContactsDB();
  }
	
}
 	