package Controller;
import Entity.User;
import Entity.UserExample;
import Service.UserService;
import Entity.Movie;
import  Entity.MovieExample;
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

        String name=movie.getName();
        System.out.println(name);
        String time=movie.getTime();
     //   String id=movie.getMovieid();
        String  leading_creator=movie.getLeadingCreator();
        String cover=movie.getCover();
        String stills=movie.getStills();
        Integer grade=movie.getGrade();
        Date releasedate=movie.getReleaseDate();
      //  String message="id已存在";
        String message1="id已存在";
         //   if (judgeid(id) == false) {
                movie.setMovieid(UUID.randomUUID().toString());
               // movie.setMovieid(id);
                movie.setName(name);
                movie.setLeadingCreator(leading_creator);
                movie.setCover(cover);
                movie.setStills(stills);
                movie.setReleaseDate(releasedate);
                movie.setTime(time);
                movie.setGrade(grade);
                movie.setGradenum(0);
                movieService.newMovie(movie);
                Map<String, Boolean> map = new HashMap();
                map.put("message", true);
                return map;
        /*    }
            else{
                Map<String,String> map=new HashMap();
                map.put("message",message);
                return map;
            }*/


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
        List<Movie> movies =movieService.findById(id);
        if(movies.size()!=0){
            flag=true;
        }
        else{
            flag=false;
        }
        return flag;
    }

    //通过name查找电影
    @RequestMapping(value = "/findmovie",method = RequestMethod.POST)
    @ResponseBody
    public Map findmovie(Movie movie){
        String name=movie.getName();
        String message="名字无效";
        System.out.println("test3: ");
        List<Movie> movies =movieService.findByName(name);
        System.out.println(movies.size());
        if(movies.size()!=0) {
            System.out.println(movies.size());
            Map<String, List<Movie>> map = new HashMap();
            map.put("movies", movies);
            return map;
        }
        else {
            //  System.out.println("ok2");
            Map<String, String > map = new HashMap();
            map.put("message",message);
            return map;
        }

    }

    //通过name删除电影
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

    //通过id删除电影
    @RequestMapping(value = "/deletemoviebyid",method = RequestMethod.POST)
    @ResponseBody
    public Map deletemoviebyid(Movie movie){
        String id=movie.getMovieid();
        System.out.println(id);
        String message="id无效";
        List <Movie> movies=movieService.findById(id);
        if(movies.size()!=0){
            System.out.println(movies.size());
            Map<String, Boolean> map = new HashMap();
            if(movieService.deleteMovieByid(id)==1){
                map.put("message",true);
            }
            else{
                map.put("message",false);
            }
            return  map;
        }
        else{
            Map<String,String> map = new HashMap();
            map.put("message",message);
            return  map;
        }
    }

    //通过name更新电影
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

    //通过id更新电影
    @RequestMapping(value = "/findbyid",method = RequestMethod.POST)
    @ResponseBody
    public Map findbyid(Movie movie){
        String id=movie.getMovieid();
        System.out.println(id);
        List<Movie> movies =movieService.findById(id);
        //Map<String, List<Movie>> map = new HashMap();
        String message="id无效";
        if(movies.size()!=0) {
            Map<String, List<Movie>> map = new HashMap();
            map.put("movies", movies);
            return map;
        }
        else{
            Map<String, String> map = new HashMap();
            map.put("message",message);
            return  map;
        }

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
    @RequestMapping(value = "/showallmovie",method = RequestMethod.POST)
    @ResponseBody
    public Map showallmovie(){
        String message ="暂无电影";
        List<Movie> movies =movieService.showAllMovie();
        if(movies.size()!=0){
            Map<String, List<Movie>> map = new HashMap();
            map.put("movies",movies);
            return map;
        }
        else {
            Map<String, String> map = new HashMap();
            map.put("message",message);
            System.out.println("暂无电影");
            return map;
        }
    }

    //评分前五名的电影
    @RequestMapping(value ="/highgrademovie",method = RequestMethod.POST)
    @ResponseBody
    public Map highgrademovie(){
        List<Movie> movies =movieService.highGradeMovie();
        List<Movie> movies1=null;
     //   System.out.println("ok1");
        if(movies.size()!=0){
            MovieExample movieExample = new MovieExample();
            MovieExample.Criteria criteria = movieExample.createCriteria();
          //  criteria.andGradeIn(movies.size());
            movies1=movies.subList(0,5);
           // System.out.println("ok2");
            Map<String, List<Movie>> map = new HashMap();
            map.put("movies",movies1);
            return map;
        }
       // map.put("message",message);
        else {
            Map<String, String > map = new HashMap();
            String message="暂无电影";
            map.put("message",message);
            return map;
        }
    }

    //最新上映电影
    @RequestMapping(value ="/latelymovie",method = RequestMethod.POST)
    @ResponseBody
    public Map latelymovie(){
        System.out.println("ok1");
        List<Movie> movies =movieService.latelyMovie();
        if(movies.size()!=0){
            System.out.println(movies.size());
            Map<String, List<Movie>> map = new HashMap();
            map.put("movies",movies.subList(0,5));
            return map;
        }
        else{
            Map<String, String > map = new HashMap();
            String message="暂无电影";
            map.put("message",message);
            return map;
        }
    }

    //电影评分
    @RequestMapping(value ="/scoremovie",method = RequestMethod.POST)
    @ResponseBody
    public Map scoremovie(Movie movie,User user){
        String userid=user.getUserid();
        System.out.println("userid:"+userid);
        String movieid=movie.getMovieid();
        System.out.println("movieid:"+movieid);
        int  score=movie.getGrade();
        System.out.println("score:"+score);
        Movie movie1=new Movie();
        List<Movie> movies =movieService.findById(movieid);
        movie1=movies.get(0);
        System.out.println("movie1.id:"+movie1.getMovieid());
        int gradenow=scorenow(score,movie1);
        System.out.println("gradenow:"+gradenow);
        Map<String, Boolean> map = new HashMap();
        if(movieService.scoreMovie(score,userid,gradenow,movie1)==1){
            map.put("message",true);
        }
        else {
            map.put("message",false);
        }
        return map;
    }

    @RequestMapping(value = "/scorenow",method = RequestMethod.GET)
    @ResponseBody
    public  int  scorenow(int score,Movie movie){
        int  grade=movie.getGrade();
        int gradenum=movie.getGradenum();
        int gradenow=(grade*gradenum+score)/(gradenum+1);
        return gradenow;
    }
}
