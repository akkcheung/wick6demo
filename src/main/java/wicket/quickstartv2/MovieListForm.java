package wicket.quickstartv2;

import java.util.LinkedList;
import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Check;
import org.apache.wicket.markup.html.form.CheckGroup;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;

import wicket.quickstart.model.Movie;
// import wicket.quickstart.service.MovieCollection;
import wicket.quickstart.service.IMovieCollection;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormSubmitBehavior;
// import org.apache.wicket.ajax.form.AjaxFormChoiceComponentUpdatingBehavior;


public class MovieListForm extends Form {
    private List<Movie> _selectedMovies;

    public MovieListForm(String id) {
        super(id);
        this._selectedMovies = new LinkedList<Movie>();

        CheckGroup movieCheckGroup =
                new CheckGroup("selected_movies", this._selectedMovies);
        
        this.add(movieCheckGroup);
        // this.add(movieCheckGroup.setOutputMarkupId(true));

        WicketApplication app = (WicketApplication) this.getApplication();
        
        // MovieCollection collection = app.getCollection();
        IMovieCollection collection = app.getCollection();
        
        List<Movie> movies = collection.getMovies();

        PropertyListView movieListView =
                new PropertyListView("movie_list", movies) {
            @Override
            protected void populateItem(ListItem item) {
                Movie movie = (Movie) item.getModelObject();
                MovieDisplayPageLink movieLink =
                        new MovieDisplayPageLink("movie_link", movie);
                movieLink.add(new Label("title"));
                movieLink.add(new Label("year"));
                item.add(new Check("selected", item.getModel()));
                item.add(movieLink);
            }
        };
        movieCheckGroup.add(movieListView);
        
        //ajax
        this.add(new AjaxFormSubmitBehavior(this,"submit"){
         	 	@Override
            protected void onSubmit(AjaxRequestTarget target) 
            {
            	// add the list of components that need to be updated
     					// target.add(movieCheckGroup);
     					// target.add(movieListView.setOutputMarkupId(true));
          	}
          	
          	@Override
            protected void onError(AjaxRequestTarget target)
            {            
            }
      	});
    }

    @Override
    public void onSubmit() {
        WicketApplication app = (WicketApplication) this.getApplication();
        
        //MovieCollection collection = app.getCollection();
        IMovieCollection collection = app.getCollection();
        for (Movie movie : this._selectedMovies)
            collection.deleteMovie(movie);
        
        this.setResponsePage(new MovieListPage());
    }
}