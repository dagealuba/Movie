package Service;

import Entity.Movie;

import java.util.List;

public interface MovieService {
    public int newMovie(Movie movie);

    public List<Movie> findByName(String Name);
}
