package Controller;
import Entity.Space;
import Service.SpaceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Map;
@Controller
@SessionAttributes("movie")
public class Spacecontroller {

    @Autowired
    private SpaceService spaceService;

    @RequestMapping(value = "/exitspace", method = RequestMethod.POST)
    @ResponseBody
    public Map exitspace(String userid, String spaceid){
        return spaceService.exitspace(userid,spaceid);
    }

    @RequestMapping(value = "/findspace",method = RequestMethod.GET)
    @ResponseBody
    public Space findspace(String spaceid){
        System.out.println(spaceid);
        return  spaceService.findSpace(spaceid);
    }
    //群主加入电影
    @RequestMapping(value = "/addmovies",method = RequestMethod.POST)
    @ResponseBody
    public Map addmovies(String spaceid,String owner,String movies){
        return spaceService.addMovies(spaceid,owner,movies);
    }
    //群主删除电影
    @RequestMapping(value = "/deletemovies",method = RequestMethod.POST)
    @ResponseBody
    public Map deletemovies(String spaceid,String owner,String movies){
        return spaceService.deleteMovies(spaceid,owner,movies);
    }

}
