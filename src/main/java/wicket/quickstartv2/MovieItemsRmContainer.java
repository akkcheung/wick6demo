package wicket.quickstartv2;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.ajax.AjaxRequestTarget;

import wicket.quickstart.model.Movie;
import wicket.quickstart.service.IMovieCollection;

import java.util.List;

public class MovieItemsRmContainer extends WebMarkupContainer
{
	
	 	/** Visibility toggle so that either the link or the form is visible. */
   	private boolean linkVisible = true;
	
		public MovieItemsRmContainer(String id)
		{
				super(id);
        setOutputMarkupId(true);
                
        add(new RemoveMoviesLink("remove"));
		}


		private final class RemoveMoviesLink extends AjaxFallbackLink
		{
            /**
             * Constructor.
             * 
             * @param id
             *            component id
             */
            public RemoveMoviesLink(String id)
            {
                super(id);                
            }

            /**
             * @see AjaxFallbackLink#onClick(org.apache.wicket.ajax.AjaxRequestTarget)
             */
            @Override
            public void onClick(AjaxRequestTarget target)
            {
                onRemoveChecked(target);
            }

            /**
             * Toggles the visibility with the add form.
             * 
             * @return <code>true</code> when the add links is visible and the form isn't.
             */
            @Override
            public boolean isVisible()
            {
                return linkVisible;
            }
 		}
 		
 		void onRemoveChecked(AjaxRequestTarget target)
    {          
            
            WicketApplication app = (WicketApplication) this.getApplication();
             
        		IMovieCollection collection = app.getCollection();
        		List<Movie> movies = collection.getMovies();
        		
        		
        		for (Movie movie : movies)
        		{
        			if (movie.isChecked())
        			{
            		collection.deleteMovie(movie);
            	}
            }

            // repaint our panel
            target.add(this);

            // repaint the listview as there was a new item added.
            // target.add(movieItems);
            target.add(this.getParent().get("movieItems"));
    }

}