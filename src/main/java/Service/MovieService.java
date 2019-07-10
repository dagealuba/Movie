package Service;

import Entity.GradeMovie;
import Entity.Movie;

import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface MovieService {

    List<Movie> findByCreator(String leadingCreator);

    int newMovie(Movie movie);

    int  deleteMovieByname(String name);

    int deleteMovieByid(String id);

    List<Movie> findByName(String Name);

    Movie findById(String Id);

    int updateMovieByid(Movie movie);

    List<Movie> showAllMovie();

    List<Movie>  highGradeMovie() ;

    List<Movie>  latelyMovie();

    int  scoreMovie(int score,String userid,Movie movie);

    int ifExist(String userid,String movieid );

    float scoreNow(Movie movie);

}