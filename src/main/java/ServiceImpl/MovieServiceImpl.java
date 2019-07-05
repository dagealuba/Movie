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
        System.out.println("test: ");
        MovieExample movieExample = new MovieExample();
        System.out.println("test1: ");
        MovieExample.Criteria criteria = movieExample.createCriteria();
        System.out.println("test2: ");
        criteria.andNameEqualTo(name);
        if (name != null){
            System.out.println("name: "+name);
        }

        return movieMapper.selectByExample(movieExample);
    }

    @Override
    public int deleteMovieByname( @RequestParam String name){
        MovieExample example = new MovieExample();
        MovieExample.Criteria criteria = example.createCriteria();
        criteria.andNameLike(name);
        return movieMapper.deleteByExample(example);
    }

    @Override
    public  int deleteMovieByid(@RequestParam String id){
        MovieExample example = new MovieExample();
        MovieExample.Criteria criteria = example.createCriteria();
        criteria.andMovieidLike(id);
        return movieMapper.deleteByExample(example);
    }

    @Override
    public int updateMovie(@RequestParam  Movie movie){
    /*    movie.setMovieid(movie.getMovieid());
        System.out.println(movie.getMovieid());*/
        MovieExample example = new MovieExample();
        MovieExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(movie.getName());

        movie.setTime(movie.getTime());
        movie.setGradenum(movie.getGradenum() ) ;
        movie.setGrade(movie.getGrade() );
        movie.setCover(movie.getCover());
        movie.setLeadingCreator(movie.getLeadingCreator());
        movie.setReleaseDate(movie.getReleaseDate()) ;
        movie.setStills(movie.getStills());
        return movieMapper.updateByExampleSelective(movie,example) ;
    }

    @Override
    public int updateMovieByid(@RequestParam Movie movie){
        MovieExample example = new MovieExample();
        MovieExample.Criteria criteria = example.createCriteria();
        criteria.andMovieidEqualTo(movie.getMovieid());

        movie.setTime(movie.getTime());
        //    System.out.println(movie.getTime());
        movie.setGradenum(movie.getGradenum() ) ;
        movie.setCover(movie.getCover());
        movie.setName(movie.getName());
        movie.setLeadingCreator(movie.getLeadingCreator());
        movie.setGrade(movie.getGrade() );
        movie.setReleaseDate(movie.getReleaseDate()) ;
        movie.setStills(movie.getStills());
        return movieMapper.updateByExampleSelective(movie,example);
    }

    @Override
    public List <Movie> findById(@RequestParam String Id){
        MovieExample movieExample = new MovieExample();
        MovieExample.Criteria criteria = movieExample.createCriteria();
        criteria.andMovieidEqualTo(Id);
        if (Id != null){
            System.out.println("Id: "+Id);
        }
        return movieMapper.selectByExample(movieExample);
    }
}
