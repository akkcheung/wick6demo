package wicket.quickstart;

import org.apache.wicket.markup.html.link.Link;
import wicket.quickstart.model.Movie;

public class MovieDisplayPageLink extends Link {
    private Movie movie;

    public MovieDisplayPageLink(String id, Movie movie) {
        super(id);
        this.movie = movie;
    }

    @Override
    public void onClick() {
        this.setResponsePage(new MovieDisplayPage(this.movie));
    }
}

