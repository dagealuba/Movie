package Controller;


import Entity.Love;
import Service.LoveService;
import Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@SessionAttributes("love")
public class LoveController {
    @Autowired
    private LoveService loveService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/insertLove",method = RequestMethod.POST)
    @ResponseBody
    public Map insertLove(Love love){
        Map<String,Boolean> map=new HashMap<String, Boolean>();
        Love love1=new Love();
        love1.setLoveid(UUID.randomUUID().toString());
        love1.setUser(love.getUser());
        love1.setName(love.getName());
        //love1.setMovies(love.getMovies());
        int tag=loveService.insertLove(love1);
        if(tag==1){
            map.put("message",true);
        }
        else{
            map.put("message",true);
        }
        return map;
    }

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

    @RequestMapping(value = "/selectById",method = RequestMethod.GET)
    @ResponseBody
    public Love selectById(String loveid){
        Love love=new Love();
        love=loveService.selectById(loveid);
        return love;
    }


}
