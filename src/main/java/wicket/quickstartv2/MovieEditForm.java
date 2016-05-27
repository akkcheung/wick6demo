package wicket.quickstartv2;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;

import wicket.quickstart.model.Movie;
// import wicket.quickstart.service.MovieCollection;
import wicket.quickstart.service.IMovieCollection;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormSubmitBehavior;

public class MovieEditForm extends Form {
    
    private boolean isNewMovie;
    
    // public MovieEditForm(String id, Movie movie) {
    public MovieEditForm(String id, Movie movie, boolean isNewMovie) {
        super(id);

        CompoundPropertyModel model = new CompoundPropertyModel(movie);
        this.setModel(model);

        //this.add(new TextField("title"));
        final TextField title = new TextField("title");
        
        // this.add(title);
        this.add(title.setOutputMarkupId(true));
        
        // this.add(new TextField("year"));
        final TextField year = new TextField("year");
        
        // this.add(year);
        this.add(year.setOutputMarkupId(true));
        
        this.isNewMovie = isNewMovie;
        
        //ajax
        this.add(new AjaxFormSubmitBehavior(this,"submit"){
        	 	@Override
            protected void onSubmit(AjaxRequestTarget target) 
            {
            	// add the list of components that need to be updated
     					target.add(title);
     					target.add(year);
          	}
          	
          	@Override
            protected void onError(AjaxRequestTarget target)
            {
            		target.appendJavaScript("document.getElementById('" + title.getMarkupId() +
                    "').focus();");
            }
      	});
    }

    @Override
    public void onSubmit() {    		
    	
    		Movie movie = (Movie) this.getModelObject();
    		WicketApplication app = (WicketApplication) this.getApplication();
        
        IMovieCollection collection = app.getCollection();
        
        if (this.isNewMovie)
            collection.addMovie(movie);
        else
            collection.updateMovie(movie);  
				
				// this.setResponsePage(new MovieDisplayPage(movie));
    }    
    
}
