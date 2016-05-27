package org.apache.wicket.examples.repeater;

import java.lang.Number;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.HibernateException;

import org.apache.wicket.extensions.markup.html.repeater.util.SortParam;

import com.javaonline.util.HibernateUtil;
import org.apache.wicket.examples.repeater.model.Contact;

public class ContactsDatabase {
	
		public ContactsDatabase(int count)
    {    		
    }
	
	 	public Contact get(long id) {
    	
    	Session session = HibernateUtil.createSessionFactory().getCurrentSession();    	    	     	 
    	session.beginTransaction();
    	Contact c = (Contact) session.get(Contact.class, id);
    	session.getTransaction().commit();   
    	
    	return c;
		}
		
		public void add(Contact c) {
			Session session = HibernateUtil.createSessionFactory().getCurrentSession();
			session.beginTransaction();
			session.saveOrUpdate(c);
			session.getTransaction().commit();							
		}
		
		public List<Contact> find(long first, long count, SortParam sort)    {
        Session session = HibernateUtil.createSessionFactory().getCurrentSession();
        session.beginTransaction();
                   
        Query query = session.createQuery(
        	"select c from Contact c"
        );
        
        query.setFirstResult((int) first);
        query.setMaxResults((int) count);
        
        List result = null; 
        
        try {
           result = query.list();					
    		} catch (HibernateException e) {                       
            session.getTransaction().rollback();                       
			  } finally {                              
    		}
    		
    		session.getTransaction().commit();
	    	return result;
    }
    
    public List<Contact> getIndex(SortParam sort)
    {
    	 	Session session = HibernateUtil.createSessionFactory().getCurrentSession();
				session.beginTransaction();

				String sSql =   "select c from Contact c" ;  	
    	
        if (sort == null)
        {
            return session.createQuery(sSql).list();
        }

        if (sort.getProperty().equals("firstName"))
        {
        		sSql = sSql + " order by firstName" ;
            
            if (! sort.isAscending())             
						   sSql = sSql + " desc" ;
						   
					  return session.createQuery(sSql).list();        
        }
        else if (sort.getProperty().equals("lastName"))
        {
            sSql = sSql + " order by lastName" ;
            
            if (! sort.isAscending())             
						   sSql = sSql + " desc" ;
						   
					  return session.createQuery(sSql).list(); 
        }
        
        session.getTransaction().commit();
        
        throw new RuntimeException("unknown sort option [" + sort +
            "]. valid fields: [firstName], [lastName]");
    }
		
		/**
     * @return number of contacts in the database
     */
    public int getCount()
    {
            
         Session session = HibernateUtil.createSessionFactory().getCurrentSession();
         Query query = session.createQuery(
        	"select count(c) from Contact c"
        	);
        
         Number n = (Number)query.list().get(0);
         
         return n.intValue();
         
    }
		
}