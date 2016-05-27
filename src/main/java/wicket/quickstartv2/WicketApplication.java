package wicket.quickstartv2;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;

// import wicket.quickstart.service.MovieCollection;
import wicket.quickstart.service.IMovieCollection;
import wicket.quickstart.service.MovieCollectionJpa;

import org.apache.wicket.RuntimeConfigurationType;

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
        
        // How to find out component-path
        if (getConfigurationType() == RuntimeConfigurationType.DEVELOPMENT) {
            getDebugSettings().setOutputComponentPath(true);
        }
    }
    

    
    public IMovieCollection getCollection() {
        return this.collection;
    }
    
    
}
