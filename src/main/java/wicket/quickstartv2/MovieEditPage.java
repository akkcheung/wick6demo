package wicket.quickstartv2;

import wicket.quickstart.model.Movie;

public final class MovieEditPage extends BasePage {
    public MovieEditPage(Movie movie) {
        // this.add(new MovieEditForm("movie_edit", movie));
        this.add(new MovieEditForm("movie_edit", movie, true));
    }
    
    public MovieEditPage(Movie movie, boolean isNewMovie) {
        this.add(new MovieEditForm("movie_edit", movie, isNewMovie));
    }
}
