package wicket.quickstart.service;

import java.util.LinkedList;
import java.util.List;

import wicket.quickstart.model.Movie;

// public class MovieCollection {
public class MovieCollection implements IMovieCollection {
    private List<Movie> movies;


    public MovieCollection() {
        this.movies = new LinkedList<Movie>();
    }
		
    public List<Movie> getMovies() {
        return this.movies;
    }

    public void addMovie(Movie movie) {
        this.movies.add(movie);
    }

    public void deleteMovie(Movie movie) {
        this.movies.remove(movie);
    }
    
    public void updateMovie(Movie movie) {
    }

}
