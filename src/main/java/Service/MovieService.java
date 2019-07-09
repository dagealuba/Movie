package Service;

import Entity.GradeMovie;
import Entity.Movie;

import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface MovieService {
    public int newMovie(Movie movie);
    public int  deleteMovieByname(String name);
    public  int deleteMovieByid(String id);
    public List<Movie> findByName(String Name);
    public Movie findById(String Id);
    public int updateMovie(Movie movie);
    public int updateMovieByid(Movie movie);
    public List<Movie> showAllMovie();
    public List<Movie>  highGradeMovie() ;
    public List<Movie>  latelyMovie();
    public  int  scoreMovie(int score,String userid,Movie movie);
    public  int ifExist(String userid,String movieid );
    public  float scoreNow(Movie movie);
}
