package Controller;

import Entity.Movie;
import Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.UUID;

@Controller
public class test {
    @Autowired(required = false)
    private MovieService movieService;


    @RequestMapping("/movie/newMovie")
    @ResponseBody
    public int newMovie(){
        Movie movie = new Movie();
        movie.setMovieid(UUID.randomUUID().toString());
        movie.setName("WDNMD");
        movie.setTime("0");
        movie.setGradenum(0);
        return movieService.newMovie(movie);
    }

    @RequestMapping("/movie/find")
    @ResponseBody
    public List<Movie> findMovie(String name){
        return movieService.findByName(name);
    }
}
