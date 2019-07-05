package Service;

import Entity.Movie;

import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface MovieService {
    public int newMovie(Movie movie);
    public int  deleteMovieByname(String name);
    public  int deleteMovieByid(String id);
    public List<Movie> findByName(String Name);
    public List <Movie> findById(String Id);
    public int updateMovie(Movie movie);
    public int updateMovieByid(Movie movie);
    //public
}
