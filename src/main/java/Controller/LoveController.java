package Controller;


import Entity.Love;
import Entity.Movie;
import Service.LoveService;
import Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.*;

@Controller
@SessionAttributes("love")
public class LoveController {
    @Autowired
    private LoveService loveService;
    @Autowired
    private MovieService movieService;

    //统计收藏夹中的电影数
    @RequestMapping(value = "/countMovieByLoveId",method = RequestMethod.GET)
    @ResponseBody
    public int countMovieByLoveId(String loveid){
        Love love=loveService.selectById(loveid);
        String str=love.getMovies();
        String[] strList=str.split(";");
        for(int i=0;i<strList.length;i++){
            System.out.println(strList[i]);
        }
        return strList.length;
    }

    //创建收藏夹
    @RequestMapping(value = "/insertLove",method = RequestMethod.POST)
    @ResponseBody
    public Love insertLove(Love love){
        Love love1=new Love();
        love1.setLoveid(UUID.randomUUID().toString());
        love1.setUser(love.getUser());
        love1.setName(love.getName());
        love1.setMovies(love.getMovies());
        int tag=loveService.insertLove(love1);
        if(tag==1){
            return love1;
        }
        else{
            return null;
        }

    }

    //添加电影收藏
    @RequestMapping(value = "/insertLoveMovie",method = RequestMethod.POST)
    @ResponseBody
    public Map insertLoveMovie(String loveid,String movie){
        Map<String,Boolean> map=new HashMap<String, Boolean>();
        Love love=loveService.selectById(loveid);
        String str=love.getMovies();
        System.out.println(str);
        //字符串拼接
        String str1=str.concat(";");
        str1=str1.concat(String.valueOf(movie));
        love.setMovies(str1);
        System.out.println(love.getMovies());
        int tag=loveService.updateByLove(love);
        if(tag==1){
            map.put("message",true);
        }
        else{
            map.put("message",false);
        }
        return map;
    }

    //取消收藏
    @RequestMapping(value = "/deleteLoveMovie",method = RequestMethod.POST)
    @ResponseBody
    public Map deleteLoveMovie(String loveid,String movie){
        Map<String,Boolean> map=new HashMap<String, Boolean>();
        Love love=loveService.selectById(loveid);
        String str=love.getMovies();
        System.out.println(str);
        String[] strList=str.split(";");
        String str1=str;
        for(int i=0;i<strList.length;i++){
            if(movie.equals(strList[i])&&(i!=0)){
                str1=str.replace(";"+strList[i],"");
                System.out.println(str1);
            }
            else if(movie.equals(strList[i])&&(i==0)){
                str1=str.replace(strList[i]+";","");
                System.out.println(str1);
            }
        }
        if(str.equals(str1)){
            System.out.println("删除失败");
            map.put("message",false);
        }
        else{
            love.setMovies(str1);
            loveService.updateByLove(love);
            System.out.println("删除成功");
            map.put("message",true);
        }
        return map;
    }

    //通过id删除收藏夹
    @RequestMapping(value = "/deleteLoveById",method = RequestMethod.POST)
    @ResponseBody
    public Map deleteLoveById(String loveid){
        Map<String,Boolean> map=new HashMap<String, Boolean>();
        int tag=loveService.deleteLoveById(loveid);
        if(tag==1){
            map.put("message",true);
        }
        else{
            map.put("message",true);
        }
        return map;
    }

    //通过用户id删除收藏夹
    @RequestMapping(value = "/deleteLoveByUserId",method = RequestMethod.POST)
    @ResponseBody
    public Map deleteLoveByUserId(String user){
        Map<String,Boolean> map=new HashMap<String, Boolean>();
        int tag=loveService.deleteLoveByUserId(user);
        if(tag==1){
            map.put("message",true);
        }
        else{
            map.put("message",true);
        }
        return map;
    }

    //通过名字选择收藏夹
    @RequestMapping(value = "/selectByName",method = RequestMethod.GET)
    @ResponseBody
    public List<Love> selectByName(String name,String user){
        List<Love> loves=loveService.selectByName(name,user);
        if(loves.size()!=0){
            return loves;
        }
        else{
            return null;
        }
    }

    //通过用户id选择收藏夹
    @RequestMapping(value = "/selectByUserId",method = RequestMethod.GET)
    @ResponseBody
    public List<Love> selectByUserId(String user){
        List<Love> loves=loveService.selectByUserId(user);
        if(loves.size()!=0){
            return loves;
        }
        else{
            return null;
        }
    }

    //通过id选择收藏夹
    @RequestMapping(value = "/selectById",method = RequestMethod.GET)
    @ResponseBody
    public Love selectById(String loveid){
        Love love=new Love();
        love=loveService.selectById(loveid);
        if(love!=null){
            String str=love.getMovies();
            String[] strList=str.split(";");
            for(int i=0;i<strList.length;i++){
                System.out.println(strList[i]);
            }
            //System.out.println(str);
        }
        else
        {
            System.out.println("没有此收藏夹");
        }
        return love;
    }

    //通过收藏夹id查看收藏电影
    @RequestMapping(value = "/selectMovieByLoveId",method = RequestMethod.GET)
    @ResponseBody
    public List<Movie> selectMovieByLoveId(String loveid){
        Love love=loveService.selectById(loveid);
        String str=love.getMovies();
        //movieList串中存放的是收藏夹中的每个的电影id
        String[] movieList=str.split(";");
        List<Movie> movies=new ArrayList<Movie>();
        for(int i=0;i<movieList.length;i++){
            movies.add(movieService.findById(movieList[i]));
        }
        for(int j=0;j<movieList.length;j++){
            System.out.println(movieList[j]);
        }
        return movies;
    }

}
