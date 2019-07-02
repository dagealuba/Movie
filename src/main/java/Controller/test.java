package Controller;

import Entity.Movie;
import Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
public class test {
    @Autowired
    private MovieService movieService;



    @RequestMapping("/movie/newMovie")
    @ResponseBody
    public Map newMovie(){
        Movie movie = new Movie();
        movie.setMovieid(UUID.randomUUID().toString());
        movie.setName("WDNMD");
        movie.setTime("0");
        movie.setGradenum(0);

        Map<String, String> res = new HashMap<>();
        if (movieService.newMovie(movie) == 1){
            res.put("res","true");
        }
        else {
            res.put("res","error");
        }
        return res;
    }

    @RequestMapping("/movie/find")
    @ResponseBody
    public List<Movie> findMovie(String name){
        return movieService.findByName(name);
    }
}
