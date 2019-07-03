package ServiceImpl;

import Dao.MovieMapper;
import Entity.Movie;
import Entity.MovieExample;
import Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired(required = false)
    private MovieMapper movieMapper;

    @Override
    public int newMovie(Movie movie) {
        return movieMapper.insertSelective(movie);
    }

    @Override
    public List<Movie> findByName(@RequestParam String name) {
        MovieExample movieExample = new MovieExample();
        MovieExample.Criteria criteria = movieExample.createCriteria();
        criteria.andNameLike("%"+name+"%");
        if (name != null){
            System.out.println("name: "+name);
        }

        return movieMapper.selectByExample(movieExample);
    }
}
