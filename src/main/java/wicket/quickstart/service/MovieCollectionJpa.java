package wicket.quickstart.service;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Query;

import wicket.quickstart.model.Movie;
import wicket.quickstart.util.HibernateUtil;

public class MovieCollectionJpa implements IMovieCollection {

		public List<Movie> getMovies() {        
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();   
        session.beginTransaction();                   
        Query query = session.createQuery("from Movie as m");
        
        List result = query.list();
        session.getTransaction().commit();

        return result;
    }

    public void addMovie(Movie movie) {        
      this.updateMovie(movie);
    }

    public void deleteMovie(Movie movie) {
      Session session = HibernateUtil.getSessionFactory().getCurrentSession();   
      session.beginTransaction();
			session.delete(movie);
			session.getTransaction().commit();
    }

    public void updateMovie(Movie movie) {
      Session session = HibernateUtil.getSessionFactory().getCurrentSession();   
			session.beginTransaction();
			session.saveOrUpdate(movie);
			session.getTransaction().commit();
    }

}

