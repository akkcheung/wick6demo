package wicket.quickstart;

import java.util.LinkedList;
import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;

//import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.list.PropertyListView;

import wicket.quickstart.model.Movie;

import org.apache.wicket.model.LoadableDetachableModel;

// public class MovieListPage extends WebPage {
public class MovieListPage extends BasePage {
    public MovieListPage() {  
    	
    	 	List<Movie> movies = new LinkedList<Movie>();
        
        /*
        Movie movie1 = new Movie("The Shining");
        movie1.setYear(1980);
        movies.add(movie1);
        Movie movie2 = new Movie("Barton Fink");
        movie2.setYear(1991);
        movies.add(movie2);    	  
    	  /*
    	  
    	  ListView movieListView = new ListView("movie_list", movies) {
            @Override
            protected void populateItem(ListItem item) {
                Movie movie = (Movie) item.getModelObject();
                item.add(new Label("title", movie.getTitle()));
                item.add(new Label("year", movie.getYear().toString()));
            }
        };
        */
        
        /*
        PropertyListView movieListView =
        new PropertyListView("movie_list", movies) {
            @Override
            protected void populateItem(ListItem item) {
                item.add(new Label("title"));
                item.add(new Label("year"));
            }
        };
        */
        
      
        /*
        PropertyListView movieListView = new PropertyListView("movie_list", 
        		new LoadableDetachableModel<List<Movie>>() {
	            protected List<Movie> load() {
	            	
	            		
	            		List<Movie> movies  = new LinkedList<Movie>();	            	
	            		
	                // Movie movie1 = new Movie("The Shining");
        					// movie1.setYear(1980);
					        // movies.add(movie1);
					        // Movie movie2 = new Movie("Barton Fink");
					        // movie2.setYear(1991);
					        // movies.add(movie2); 
					        
					        					        
					              
        					List<Movie> movies = getMovies();
					        
					        return movies;
	            }
        		}) 
       {
            	@Override
	            protected void populateItem(ListItem item) {
	            		
	                // item.add(new Label("title"));
	                // item.add(new Label("year"));
	                
	                
	                Movie movie = (Movie) item.getModelObject();
                  
                  MovieDisplayPageLink movieLink =
                        new MovieDisplayPageLink("movie_link", movie);
                  
                  movieLink.add(new Label("title"));
                  movieLink.add(new Label("year"));
                  item.add(movieLink);  
	            }
       };              
       this.add(movieListView);    
       */
       
       
       MovieListForm movieListForm = new MovieListForm("movie_list_form");
			 this.add(movieListForm);

	}
	
	public List <Movie> getMovies() {		
		  WicketApplication app = (WicketApplication) this.getApplication();  		  		  
		  return app.getCollection().getMovies();		  		  
	}   
}

