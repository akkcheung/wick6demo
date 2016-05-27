package wicket.quickstart;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;

// import wicket.quickstart.service.MovieCollection;
import wicket.quickstart.service.MovieCollectionJpa;

import wicket.quickstart.service.IMovieCollection;

public class WicketApplication extends WebApplication {
	
		// private MovieCollection collection;
		private IMovieCollection collection;
	
    @Override
    public Class<? extends WebPage> getHomePage() {
        return HomePage.class;
    }

    @Override
    public void init() {
        super.init();        
        
        //this.collection = new MovieCollection();        
        this.collection = new MovieCollectionJpa();
    }
    
    public IMovieCollection getCollection() {
        return this.collection;
    }
}
