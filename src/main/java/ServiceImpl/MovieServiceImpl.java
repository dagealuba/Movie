package ServiceImpl;

import Dao.MovieMapper;
import Entity.Movie;
import Entity.MovieExample;
import Service.MovieService;
import converter.TimeSteamp;
import converter.DateConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.util.Date;
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
          //  System.out.println("Id: "+Id);
        }
        return movieMapper.selectByExample(movieExample);
    }

    @Override
    public  List<Movie> showAllMovie(){
        MovieExample movieExample = new MovieExample();
        MovieExample.Criteria criteria = movieExample.createCriteria();
        criteria.andMovieidIsNotNull();
        movieExample.setOrderByClause("grade DESC");
        return movieMapper.selectByExample(movieExample);
    }

    @Override
    public List<Movie>  highGradeMovie() {
        MovieExample movieExample = new MovieExample();
        MovieExample.Criteria criteria = movieExample.createCriteria();
        criteria.andMovieidIsNotNull();
      //  criteria.andGradeBetween(0,10);
        movieExample.setOrderByClause("grade DESC");
        return movieMapper.selectByExample(movieExample);
    }

    @Override
    public List<Movie>  latelyMovie(){
      //  System.out.println("ok2");
        MovieExample movieExample = new MovieExample();
        MovieExample.Criteria criteria = movieExample.createCriteria();
        criteria.andMovieidIsNotNull();
        DateConverter dateConverter=new DateConverter();
        String time1="2019-09-10";
        String time2="2019-09-18";
       // System.out.println("ok3");
        Date date1=dateConverter.convert(time1);
            System.out.println(date1);
        Date date2=dateConverter.convert(time2);
        System.out.println(date2);
        criteria.andReleaseDateBetween(date1,date2);
       // System.out.println("ok6");
        movieExample.setOrderByClause("grade DESC");
        return movieMapper.selectByExample(movieExample);
    }

    @Override
    public  int  scoreMovie(int scorenow,String name){
      //  String name=movie.getName();
        MovieExample movieExample = new MovieExample();
        MovieExample.Criteria criteria = movieExample.createCriteria();
        criteria.andNameEqualTo(name);
        Movie movie=new Movie();
        movie.setGrade(scorenow);
        System.out.println("ok2");
        return movieMapper.updateByExampleSelective(movie,movieExample) ;
    }
}
