package wicket.quickstart;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;

import wicket.quickstart.model.Movie;
// import wicket.quickstart.service.MovieCollection;
import wicket.quickstart.service.IMovieCollection;

public class MovieEditForm extends Form {
    
    private boolean isNewMovie;
    
    // public MovieEditForm(String id, Movie movie) {
    public MovieEditForm(String id, Movie movie, boolean isNewMovie) {
        super(id);

        CompoundPropertyModel model = new CompoundPropertyModel(movie);
        this.setModel(model);

        this.add(new TextField("title"));
        this.add(new TextField("year"));
        
        this.isNewMovie = isNewMovie;
    }

    @Override
    public void onSubmit() {
        Movie movie = (Movie) this.getModelObject();
        WicketApplication app = (WicketApplication) this.getApplication();
        
        // MovieCollection collection = app.getCollection();
        IMovieCollection collection = app.getCollection();
        
        //collection.addMovie(movie);        
        if (this.isNewMovie)
            collection.addMovie(movie);
        else
            collection.updateMovie(movie);
                
        this.setResponsePage(new MovieDisplayPage(movie));
    }
}
