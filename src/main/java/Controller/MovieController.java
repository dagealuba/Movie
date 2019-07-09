package Controller;
import Entity.*;
import Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.*;

@Controller
@SessionAttributes("movie")
public class MovieController {
    @Autowired(required = false)
    private MovieService movieService;

    @RequestMapping(value = "/addmovie",method = RequestMethod.POST)
    @ResponseBody
    //添加
    public Map addmovie(Movie movie){
        movie.setMovieid(UUID.randomUUID().toString());
        int tag=movieService.newMovie(movie);
        Map<String, Boolean> map = new HashMap();
        if(tag==1){
            map.put("message",true);
        }
        else{
            map.put("message",false);
        }
        return map;

    }

    @RequestMapping(value = "judgeid",method = RequestMethod.GET)
    @ResponseBody
    public Boolean judgeid(String id){
        Boolean flag=null;
        Movie movies =movieService.findById(id);
        if(movies!=null){
            flag=true;
        }
        else{
            flag=false;
        }
        return flag;
    }

    //通过name查找电影
    @RequestMapping(value = "/findmovie",method = RequestMethod.GET)
    @ResponseBody
    public Map findmovie(String name){
        List<Movie> movies =movieService.findByName(name);
        System.out.println(movies.size());
        Map<String, List<Movie>> map = new HashMap();
        if(movies.size()!=0) {
            map.put("movies", movies);
        }
        return map;
    }

    //通过name删除电影

    @RequestMapping(value = "/deletemovie",method = RequestMethod.POST)
    @ResponseBody
    public Map deletemovie(String name) {
        List<Movie> movies =movieService.findByName(name);
        Map<String, Boolean> map = new HashMap();
        if(movies.size()!=0) {
            if (movieService.deleteMovieByname(name) == 1) {
                map.put("message", true);
            }
            else {
                map.put("message", false);
            }
        }
        return map;
    }

    //通过id删除电影
    @RequestMapping(value = "/deletemoviebyid",method = RequestMethod.POST)
    @ResponseBody
    public Map deletemoviebyid(String movieid){
        Map<String, Boolean> map = new HashMap();
        int tag=movieService.deleteMovieByid(movieid);
        if(tag==1){
            map.put("message",true);
        }
        else{
            map.put("message",false);
        }
        return map;
    }

    //通过id更新电影
    @RequestMapping(value = "/findbyid",method = RequestMethod.GET)
    @ResponseBody
    public Movie findbyid(Movie movie){
        String id=movie.getMovieid();
        System.out.println(id);
        Movie movies =movieService.findById(id);
        return movies;
    }

    @RequestMapping(value = "/updatemoviebyid",method = RequestMethod.POST)
    @ResponseBody
    public Map updatemoviebyid(Movie movie){
        String id=movie.getMovieid();
        String message="id无效";
        if(judgeid(id)==true){
            Map<String, Boolean> map = new HashMap();
            if(movieService.updateMovieByid(movie)==1){
                map.put("message", true);
            }
            else{
                map.put("message", false);
            }
            return  map;
        }
        else{
            Map<String, String > map = new HashMap();
            map.put("message", message);
            return  map;
        }
    }

    //查询所有电影
    @RequestMapping(value = "/showallmovie",method = RequestMethod.GET)
    @ResponseBody
    public Map showallmovie(){
        List<Movie> movies =movieService.showAllMovie();
        Map<String, List<Movie>> map = new HashMap();
        if(movies.size()!=0){
            map.put("movies",movies);
        }
        return map;
    }

    //评分前五名的电影
    @RequestMapping(value ="/highgrademovie",method = RequestMethod.GET)
    @ResponseBody
    public Map highgrademovie(){
        List<Movie> movies =movieService.highGradeMovie();
        List<Movie> movies1=null;
        Map<String, List<Movie>> map = new HashMap();
        if(movies.size()!=0){
            movies1=movies.subList(0,5);
            map.put("movies",movies1);
        }
        return map;
    }

    //最新上映电影
    @RequestMapping(value ="/latelymovie",method = RequestMethod.GET)
    @ResponseBody
    public Map latelymovie(){
        List<Movie> movies =movieService.latelyMovie();
        Map<String, List<Movie>> map = new HashMap();
        if(movies.size()!=0){
            map.put("movies",movies.subList(0,5));
        }
        return map;
    }

    //电影评分
    @RequestMapping(value ="/scoremovie",method = RequestMethod.POST)
    @ResponseBody
    public Map scoremovie(GradeMovie gradeMovie){
        String userid=gradeMovie.getUser();
        String movieid=gradeMovie.getMovie();
        int score=gradeMovie.getGrade();
        Movie movies =movieService.findById(movieid);
        Map<String, Boolean> map = new HashMap();
        if(movieService.scoreMovie(score,userid,movies)==1){
            map.put("message",true);
        }
        else {
            map.put("message",false);
        }
        return map;
    }

    //查找用户所评分电影
    @RequestMapping(value ="/findgradebyuser",method = RequestMethod.GET)
    @ResponseBody
    public  List<GradeMovie> findgradebyuser(String userid) {
        System.out.println("userid:"+userid);
        return movieService.findgradebyuser(userid);
    }

    //该电影评分高于n%的电影
    @RequestMapping(value = "/compareMovieGrade",method = RequestMethod.GET)
    @ResponseBody
    public float compareMovieGrade(String movieid){
        float h=0;
        float g=0;
        Movie movie=movieService.findById(movieid);
        float grade=movie.getGrade();
        List<Movie> movies=movieService.highGradeMovie();
        if(movies.size()!=0){
            float num=movies.size();
            for(int i=0;i<num;i++){
                if(movies.get(i).getGrade()<=grade){
                    h=num-i;//分数少于该电影的电影数；
                    break;
                }
                else {
                    h=num-i;
                }
            }
            System.out.println("电影数："+num);
            System.out.println("分数少于该电影的电影数:"+h);
            g=h/num;//百分比
        }
        else{
            System.out.println("false");
        }
        return g;
    }

}