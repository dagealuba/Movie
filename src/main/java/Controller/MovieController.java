package Controller;
import Entity.*;
import Service.UserService;
import Service.MovieService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.*;

import org.springframework.web.servlet.ModelAndView;
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

    @RequestMapping(value = "judgename",method = RequestMethod.GET)
    @ResponseBody
    public Boolean judgename(String name){
        Boolean flag= null;
        List<Movie> movies =movieService.findByName(name);
        if(movies.size()!=0){
            flag=false;
        }
        else{
            flag=true;
        }
        return flag;
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
    public List<Movie> findmovie(String name){
        List<Movie> movies =movieService.findByName(name);
        if(movies.size()!=0){
            System.out.println("False");
        }
        else{
            System.out.println("True");
        }
        return movies;
    }

    //通过主创查找电影
    @RequestMapping(value = "/findByCreator",method = RequestMethod.GET)
    @ResponseBody
    public List<Movie> findByCreator(String leadingCreator){
        List<Movie> movies=movieService.findByCreator(leadingCreator);
        if(movies.size()!=0){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }
        return movies;
    }


    //通过name删除电影
    /*
    @RequestMapping(value = "/deletemovie",method = RequestMethod.POST)
    @ResponseBody
    public Map deletemovie(Movie movie) {
        String name = movie.getName();
        String message="名字无效";
        List<Movie> movies =movieService.findByName(name);
        if(movies.size()!=0) {
            Map<String, Boolean> map = new HashMap();
            if (movieService.deleteMovieByname(name) == 1) {
                map.put("message", true);
             //   System.out.println("true");
            } else {
                map.put("message", false);
               // System.out.println("flase");
            }
            return map;
        }
        else{
            Map<String, String> map = new HashMap();
            map.put("message",message);
            return map;
        }
    }
*/

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

    //通过name更新电影
    /*
    @RequestMapping(value = "/updatemovie",method = RequestMethod.POST)
    @ResponseBody
    public Map updatemovie(Movie movie) {
        String name = movie.getName();
     //   System.out.println("ok1");
        String message="名字无效";
        if (judgename(name) == false) {
         //   System.out.println("true");
            Map<String, Boolean> map = new HashMap();
            if (movieService.updateMovie(movie) == 1) {
                System.out.println("true1");
                map.put("message", true);
            } else {
                map.put("message", false);
                System.out.println("false1");
            }
            return map;
        }
        else{
            Map<String, String> map = new HashMap();
            map.put("message", message);
            return map;
        }
    }
*/
    //通过id找电影
    @RequestMapping(value = "/findbyid",method = RequestMethod.GET)
    @ResponseBody
    public Movie findbyid(String movieid){
        Movie movies =movieService.findById(movieid);
        return movies;
    }

    @RequestMapping(value = "/updatemoviebyid",method = RequestMethod.POST)
    @ResponseBody
    public Movie updatemoviebyid(String movieid,Movie movie){
        Movie movie1=new Movie();
        movie1.setMovieid(movieid);
        movieService.updateMovieByid(movie1);
        return movie1;
    }

    //查询所有电影
    @RequestMapping(value = "/showallmovie",method = RequestMethod.GET)
    @ResponseBody
    public List<Movie> showallmovie(){
        List<Movie> movies =movieService.showAllMovie();
        if(movies.size()!=0){
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }
        return movies;
    }

    //评分前五名的电影
    @RequestMapping(value ="/highgrademovie",method = RequestMethod.GET)
    @ResponseBody
    public List<Movie> highgrademovie(){
        List<Movie> movies =movieService.highGradeMovie();
        List<Movie> movies1=null;
        if(movies.size()!=0){
            movies1=movies.subList(0,5);
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }
        return movies1;
    }

    //最新上映电影
    @RequestMapping(value ="/latelymovie",method = RequestMethod.GET)
    @ResponseBody
    public List<Movie> latelymovie(){
        List<Movie> movies =movieService.latelyMovie();
        List<Movie> movies1=new ArrayList<Movie>();
        if(movies.size()!=0){
            movies1=movies.subList(0,5);
        }
        else{
            System.out.println("false");
        }
        return movies1;
    }

    //电影评分
    @RequestMapping(value ="/scoremovie",method = RequestMethod.POST)
    @ResponseBody
    public Map scoremovie(GradeMovie gradeMovie){
        String userid=gradeMovie.getUser();
        System.out.println("userid:"+userid);
        String movieid=gradeMovie.getMovie();
        System.out.println("movieid:"+movieid);
        int score=gradeMovie.getGrade();
        System.out.println("score:"+score);
        Movie movies =movieService.findById(movieid);
        System.out.println("movie1.id:"+movies.getMovieid());
        Map<String, Boolean> map = new HashMap();
        if(movieService.scoreMovie(score,userid,movies)==1){
            map.put("message",true);
        }
        else {
            map.put("message",false);
        }
        return map;
    }
}