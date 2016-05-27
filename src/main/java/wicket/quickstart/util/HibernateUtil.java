package wicket.quickstart.util;
 
import org.hibernate.SessionFactory;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.HibernateException;
 
public class HibernateUtil {
 
	private static final SessionFactory sessionFactory;
	
	private static ServiceRegistry serviceRegistry;
	
	static {
		try {
			Configuration configuration = new Configuration();
			configuration.configure();
			serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();		
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);	
		} catch (HibernateException ex) {
         throw new RuntimeException("Exception building session factory: " + ex.getMessage(), ex);
    }
	}

  /*	 
	public static SessionFactory createSessionFactory() {
	
		Configuration configuration = new Configuration();
		configuration.configure();
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);	
		return sessionFactory;				
	}
	*/
 
 	public static SessionFactory getSessionFactory() {
    return sessionFactory;
  }
 
}

