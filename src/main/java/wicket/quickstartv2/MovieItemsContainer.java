package wicket.quickstartv2;

import java.util.List;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.ajax.markup.html.form.AjaxCheckBox;
import org.apache.wicket.markup.html.list.PropertyListView;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.basic.Label;

import org.apache.wicket.ajax.AjaxRequestTarget;

import wicket.quickstart.model.Movie;
import wicket.quickstart.service.IMovieCollection;

import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;

 public class MovieItemsContainer extends WebMarkupContainer
 {
 		
 		 		PropertyListView movieListView ;
 		 		// Movie movie ;

  			public MovieItemsContainer(String id)
        {
            super(id);

            // let wicket generate a markup-id so the contents can be
            // updated through an AJAX call.
            setOutputMarkupId(true);
       
      
         
	  			// WicketApplication app = (WicketApplication) this.getApplication();	        
	        // IMovieCollection collection = app.getCollection();	        
	        // List<Movie> movies = collection.getMovies();
	
	  		IModel movies =  new LoadableDetachableModel()
        {
            protected Object load() {
                return getMovies();
            }
        };
	
	
	
	        // PropertyListView 
	        movieListView =
	            new PropertyListView("movie_list", movies) 
	            {
		            @Override
		            protected void populateItem(ListItem item) {
		            	
		                Movie movie = (Movie) item.getModelObject();
		                MovieDisplayPageLink movieLink =
		                        new MovieDisplayPageLink("movie_link", movie);
		                
		                movieLink.add(new Label("title"));
		                movieLink.add(new Label("year"));												
		
										item.add(
											new AjaxCheckBox("checked", item.getModel())
											{
											 	@Override
		                    protected void onUpdate(AjaxRequestTarget target)
		                    {
		                        // no need to do anything, the model is updated by
		                        // itself, and we don't have to re-render a
		                        // component (the client already has the correct
		                        // state).
		                        
		                        // updateMovie(this.getModelObject());
		                        // updateMovie();
		                        
		                        // this.movie = 
		                    }
											
											});
		                
		                item.add(movieLink);
		            }
	       		 };
	        
	        	add(movieListView);
	      }
	      
	      private List <Movie> getMovies() {
	      		      	
	      	WicketApplication app = (WicketApplication) this.getApplication();	        
	         IMovieCollection collection = app.getCollection();	        
	         List<Movie> movies = collection.getMovies();
	         
	         return movies;
	    	}
	    	
	    	private void updateMovie(Movie movie) {
	    		
	    			WicketApplication app = (WicketApplication) this.getApplication();        
        		IMovieCollection collection = app.getCollection();                	
            collection.updateMovie(movie);  
            
            
            // System.out.println("b ->" + b);
            
            /*
            Movie m;
            
            for (Object o : movieListView.getList())
    				{
     					m = (Movie) o ;     					
     					System.out.println("You are deleting ->" + m.getTitle()) ;
    				}
    				*/
	    		
	      }
}