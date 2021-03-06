package Controller;

import Entity.Love;
import Entity.Movie;
import Service.LoveService;
import Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@CrossOrigin
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
        String str="";
        int length=-1;
        if(love!=null){
            str=love.getMovies();
            String[] strList=str.split(";");
            for(int i=0;i<strList.length;i++){
//                System.out.println(strList[i]);
            }
            length=strList.length;
        }

        return length;
    }

    //创建收藏夹
    @RequestMapping(value = "/insertLove",method = RequestMethod.POST)
    @ResponseBody
    public Map insertLove(Love love){
        Map<String,String> map=new HashMap<>();
        love.setLoveid(UUID.randomUUID().toString());
        int tag=loveService.insertLove(love);
        if(tag==1){
//            System.out.println("true");
            map.put("message","true");
            map.put("loveid",love.getLoveid());
        }
        else{
//            System.out.println("false");
            map.put("message","false");
        }
        return map;
    }

    //添加电影收藏
    @RequestMapping(value = "/insertLoveMovie",method = RequestMethod.POST)
    @ResponseBody
    public Map insertLoveMovie(String loveid,String movie){
        Map<String,Boolean> map=new HashMap<String, Boolean>();
        Love love=loveService.selectById(loveid);
        String str=love.getMovies();
//        System.out.println(str);

        //字符串拼接
        String str1;
        if (str == null){
            str1 = movie;
        }
        else str1 = str + ";" + movie;
        love.setMovies(str1);
//        System.out.println(str1);
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
//        System.out.println(str);
        String[] strList=str.split(";");
        String str1=str;
        for(int i=0;i<strList.length;i++){
            if(movie.equals(strList[i])&&(i!=0)){
                str1=str.replace(";"+strList[i],"");
//                System.out.println(str1);
            }
            else if(movie.equals(strList[i])&&(i==0)){
                str1=str.replace(strList[i]+";","");
//                System.out.println(str1);
            }
        }
        if(str.equals(str1)){
//            System.out.println("删除失败");
            map.put("message",false);
        }
        else{
            love.setMovies(str1);
            loveService.updateByLove(love);
//            System.out.println("删除成功");
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
            map.put("message",false);
        }
        return map;
    }

    //通过用户id删除收藏夹
    @RequestMapping(value = "/deleteLoveByUserId",method = RequestMethod.POST)
    @ResponseBody
    public Map deleteLoveByUserId(String user){
        int tag=0;
        Map<String,Boolean> map=new HashMap<String, Boolean>();
            tag=loveService.deleteLoveByUserId(user);
            if(tag==1){
                map.put("message",true);
            }
            else{
                map.put("message",false);
            }
        return map;
    }

    //通过名字选择收藏夹
    @RequestMapping(value = "/selectByName",method = RequestMethod.GET)
    @ResponseBody
    public List<Love> selectByName(String name,String user){
        List<Love> loves=loveService.selectByName(name,user);
        if(loves.size()!=0){
//            System.out.println("true");
        }
        else{
//            System.out.println("false");
        }
        return loves;
    }

    //通过用户id选择收藏夹
    @RequestMapping(value = "/selectByUserId",method = RequestMethod.GET)
    @ResponseBody
    public List<Love> selectByUserId(String user){
        List<Love> loves=new ArrayList<Love>();
            loves=loveService.selectByUserId(user);
            if(loves.size()!=0){
//                System.out.println("true");
            }
            else{
//                System.out.println("false");
            }
        return loves;
    }

    //通过id选择收藏夹
    @RequestMapping(value = "/selectById",method = RequestMethod.GET)
    @ResponseBody
    public Love selectById(String loveid){
        Love love=new Love();
        love=loveService.selectById(loveid);
        if(love!=null){
            //输出收藏夹中的电影id
            String str=love.getMovies();
            String[] strList=str.split(";");
            for(int i=0;i<strList.length;i++){
//                System.out.println(strList[i]);
            }
        }
        else
        {
//            System.out.println("没有此收藏夹");
        }
        return love;
    }

    //通过收藏夹id查看收藏电影
    @RequestMapping(value = "/selectMovieByLoveId",method = RequestMethod.GET)
    @ResponseBody
    public List<Movie> selectMovieByLoveId(String loveid){
        Love love=loveService.selectById(loveid);
        String str="";
        List<Movie> movies=new ArrayList<Movie>();
        if(love!=null){
            str=love.getMovies();
            //movieList串中存放的是收藏夹中的每个的电影id
            if (str == null){
                return movies;
            }
            String[] movieList=str.split(";");
            for(int i=0;i<movieList.length;i++){
                movies.add(movieService.findById(movieList[i]));
            }
            for(int j=0;j<movieList.length;j++){
//                System.out.println(movieList[j]);
            }
        }
        else{
            movies=null;
        }

        return movies;
    }


    @RequestMapping(value = "/isloved",method = RequestMethod.GET)
    @ResponseBody
    public Map isLoved(String userid, String movieid){
        Map<String, Boolean> res = new HashMap<>();
        res.put("isLoved",false);
        List<Love> loves = loveService.selectByUserId(userid);
        for (Love love:loves){
            String movies = love.getMovies();
//            System.out.println(movies);
            if (movies == null){
                continue;
            }

            if (movies.indexOf(movieid) != -1){
                res.put("isLoved", true);
            }
        }

        return res;
    }
}
