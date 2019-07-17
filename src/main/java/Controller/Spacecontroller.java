//package Controller;
//import Entity.Space;
//import Service.SpaceService;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.SessionAttributes;
//
//import java.util.Map;
//@Controller
//@SessionAttributes("movie")
//public class Spacecontroller {
//
//    @Autowired
//    private SpaceService spaceService;
//
//    //退出群
//    @RequestMapping(value = "/exitspace", method = RequestMethod.POST)
//    @ResponseBody
//    public Map exitspace(String userid, String spaceid){
//        return spaceService.exitspace(userid,spaceid);
//    }
//
//    //搜索群
//    @RequestMapping(value = "/findspace",method = RequestMethod.GET)
//    @ResponseBody
//    public Space findspace(String spaceid){
//        return  spaceService.findSpace(spaceid);
//    }
//
//    //模糊查询
//
//
//
//    //群主加入电影
//    @RequestMapping(value = "/addmovies",method = RequestMethod.POST)
//    @ResponseBody
//    public Map addmovies(String spaceid,String owner,String movies){
//        return spaceService.addMovies(spaceid,owner,movies);
//    }
//    //群主删除电影
//    @RequestMapping(value = "/deletemovies",method = RequestMethod.GET)
//    @ResponseBody
//    public Map deletemovies(String spaceid,String owner,String movies){
//        return spaceService.deleteMovies(spaceid,owner,movies);
//    }
//
//    //加入群，不需要群主同意
//    @RequestMapping(value = "/joinspace",method = RequestMethod.POST)
//    @ResponseBody
//    public Map joinspace(String userid, String spaceid ){
//        return spaceService.joinSpace(userid,spaceid);
//    }
//
//}