package wicket.quickstart.service;

import java.util.List;
import wicket.quickstart.model.Movie;

public interface IMovieCollection {
    public List<Movie> getMovies();
    public void addMovie(Movie movie);
    public void deleteMovie(Movie movie);
    public void updateMovie(Movie movie);
}
