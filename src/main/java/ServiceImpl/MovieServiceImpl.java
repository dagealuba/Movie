package ServiceImpl;

import Dao.GradeMovieMapper;
import Dao.MovieMapper;
import Entity.GradeMovie;
import Entity.GradeMovieExample;
import Entity.Movie;
import Entity.MovieExample;
import Service.MovieService;
import converter.DateConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
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
        MovieExample.Criteria criteria = movieExample.createCriteria();
        criteria.andNameLike("%"+name+"%");
        if (name != null){
            System.out.println("name: "+name);
        }

        return movieMapper.selectByExample(movieExample);
    }

    @Override
    public List<Movie> findByCreator(String leadingCreator) {
        MovieExample movieExample=new MovieExample();
        MovieExample.Criteria criteria=movieExample.createCriteria();
        criteria.andLeadingCreatorLike("%"+leadingCreator+"%");
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
    public int updateMovieByid(@RequestParam Movie movie){
        MovieExample example = new MovieExample();
        MovieExample.Criteria criteria = example.createCriteria();
        criteria.andMovieidEqualTo(movie.getMovieid());

        movie.setTime(movie.getTime());
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
        movieExample.setOrderByClause("grade DESC");
        return movieMapper.selectByExample(movieExample);
    }

    @Override
    public List<Movie>  latelyMovie(){
        MovieExample movieExample = new MovieExample();
        MovieExample.Criteria criteria = movieExample.createCriteria();
        criteria.andMovieidIsNotNull();
        DateConverter dateConverter=new DateConverter();
        String time1="2019-09-10";
        String time2="2019-09-18";
        Date date1=dateConverter.convert(time1);
        Date date2=dateConverter.convert(time2);
        criteria.andReleaseDateBetween(date1,date2);
        movieExample.setOrderByClause("grade DESC");
        return movieMapper.selectByExample(movieExample);
    }


    //对电影进行评分
    @Override
    public int scoreMovie(int score ,String userid,String movieid ){
        int flag=0;
        System.out.println("userid:"+userid);
        Movie m = findById(movieid);
        GradeMovie gradeMovie=new GradeMovie();
        int b;
        gradeMovie.setUser(userid);
        gradeMovie.setGrade(score);
        gradeMovie.setMovie(movieid);
        b = gradeMovieMapper.insertSelective(gradeMovie);

        int num=m.getGradenum();//评分人数

        float scorenow=m.getGrade();//现在的平均评分

        scorenow = ((scorenow*num)+score)/(num+1);

        num++;

        MovieExample movieExample = new MovieExample();
        MovieExample.Criteria criteria = movieExample.createCriteria();
        criteria.andMovieidEqualTo(movieid);
        Movie movie=new Movie();
        movie.setGrade(scorenow);
        movie.setGradenum(num);
        int a=movieMapper.updateByExampleSelective(movie,movieExample) ;

        if(a==1&&b==1){
            flag=1;
        }
        else {
            flag=0;
        }
        return  flag;
    }

    @Override
    public List<GradeMovie> isScored(String userid, String movieid) {
        GradeMovieExample gradeMovieExample = new GradeMovieExample();
        GradeMovieExample.Criteria criteria = gradeMovieExample.createCriteria();
        criteria.andMovieEqualTo(movieid);
        criteria.andUserEqualTo(userid);

        return gradeMovieMapper.selectByExample(gradeMovieExample);
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

    //计算平均总分
    @Override
    public  float scoreNow(String movieid){
        Movie movie = findById(movieid);
        int num = movie.getGradenum();//评分人数
        float score = movie.getGrade();//总评分

        float scorenow=score/num;
        return scorenow;
    }

    @Override
    public List<GradeMovie> findgradebyuser(String userid){
        GradeMovieExample gradeMovieExample=new GradeMovieExample();
        GradeMovieExample.Criteria criteria=gradeMovieExample.createCriteria();
        criteria.andUserEqualTo(userid);
        return gradeMovieMapper.selectByExample(gradeMovieExample);
    }

    @Override
    public List<Movie> movielike(String name){
        MovieExample movieExample = new MovieExample();
        MovieExample.Criteria criteria = movieExample.createCriteria();
        criteria.andNameLike("%"+name+"%");
        movieExample.setOrderByClause("grade DESC");
        return movieMapper.selectByExample(movieExample);
    }
}