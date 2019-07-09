package ServiceImpl;

import Dao.GradeMovieMapper;
import Dao.MovieMapper;
import Entity.GradeMovie;
import Entity.GradeMovieExample;
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

    @Autowired
    private GradeMovieMapper gradeMovieMapper;

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
    public List<Movie> findByCreator(String leadingCreator) {
        MovieExample movieExample=new MovieExample();
        MovieExample.Criteria criteria=movieExample.createCriteria();
        criteria.andLeadingCreatorEqualTo(leadingCreator);
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
    public Movie findById(@RequestParam String Id){
        return movieMapper.selectByPrimaryKey(Id);
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
    public  int  scoreMovie(int score ,String userid,Movie movie1 ){
        //  String name=movie.getName();
        int flag=0;
        System.out.println("impl");
        GradeMovie gradeMovie=new GradeMovie();
        int b;
        if(ifExist(userid,movie1.getMovieid())==1){
            System.out.println("exist");
            gradeMovie.setGrade(score);
            GradeMovieExample gradeMovieExample=new GradeMovieExample();
            GradeMovieExample.Criteria criteria1=gradeMovieExample.createCriteria();
            criteria1.andUserEqualTo(userid);
            criteria1.andMovieEqualTo(movie1.getMovieid());
            b=gradeMovieMapper.updateByExampleSelective(gradeMovie,gradeMovieExample);
        }
        else {
            gradeMovie.setUser(userid);
            gradeMovie.setGrade(score);
            gradeMovie.setMovie(movie1.getMovieid());
            b = gradeMovieMapper.insert(gradeMovie);
        }

        GradeMovieExample gradeMovieExample=new GradeMovieExample();
        GradeMovieExample.Criteria criteria2=gradeMovieExample.createCriteria();
        criteria2.andMovieEqualTo(movie1.getMovieid());

        List <GradeMovie>  gradeMovies=gradeMovieMapper.selectByExample(gradeMovieExample);

        int num=gradeMovies.size();//评分人数

        float scorenow=scoreNow(movie1);//现在的平均评分
        System.out.println(scorenow);

        MovieExample movieExample = new MovieExample();
        MovieExample.Criteria criteria = movieExample.createCriteria();
        criteria.andMovieidEqualTo(movie1.getMovieid());
        Movie movie=new Movie();
        movie.setGrade(scorenow);
        movie.setGradenum(num);
        int a=movieMapper.updateByExampleSelective(movie,movieExample) ;



        System.out.println("a:"+a);

        System.out.println("b:"+b);

        if(a==1&&b==1){
            flag=1;
        }
        else {
            flag=0;
        }
        return  flag;
    }

    @Override
    public  int ifExist(String userid,String movieid ){
        GradeMovieExample gradeMovieExample=new GradeMovieExample();
        GradeMovieExample.Criteria criteria=gradeMovieExample.createCriteria();
        criteria.andUserEqualTo(userid);
        criteria.andMovieEqualTo(movieid);

        List <GradeMovie>  gradeMovies = gradeMovieMapper.selectByExample(gradeMovieExample);
        if(gradeMovies.size()!=0){
            return  1;
        }
        else {
            return 0;
        }
    }

    @Override
    public  float scoreNow(Movie movie){
        GradeMovieExample gradeMovieExample=new GradeMovieExample();
        GradeMovieExample.Criteria criteria=gradeMovieExample.createCriteria();
        criteria.andMovieEqualTo(movie.getMovieid());

        List <GradeMovie>  gradeMovies=gradeMovieMapper.selectByExample(gradeMovieExample);

        float num=gradeMovies.size();//评分人数
        System.out.println("num:"+num);
        float count=0;//总评分
        for(int i=0;i<gradeMovies.size();i++){
            count+=gradeMovies.get(i).getGrade();
        }

        System.out.println("count:"+count);
        float scorenow=count/num;
        System.out.println("计算德："+scorenow);
        return scorenow;
    }
}