package wicket.quickstartv2;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;

import wicket.quickstart.model.Movie;

public class MovieDisplayPage extends BasePage {
	
		private Movie movie;
	
    public MovieDisplayPage(Movie movie) {
        this.add(new Label("title", movie.getTitle()));
        this.add(new Label("year", movie.getYear().toString()));
        
        this.movie = movie;
        
        Link editLink = new Link("edit_link") {
            @Override
            public void onClick() {
                MovieDisplayPage parent = (MovieDisplayPage) this.getParent();
                this.setResponsePage(new MovieEditPage(parent.getMovie(), false));
            }
        };
        this.add(editLink);
    }
    
    public Movie getMovie() {
        return this.movie;
    }
    
}
