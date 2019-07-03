package Controller;


import Entity.User;
import Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.portlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


@Controller
@SessionAttributes("name")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    //注册新用户
    public Map register(User user ){
        String email=user.getEmail();
        System.out.println(user.getName());
        Map<String,Boolean> map=new HashMap<String, Boolean>();
        if (userService.findByEmail(email).size()==0){
            //添加用户
            user.setUserid(UUID.randomUUID().toString());
            userService.register(user);
            map.put("message",true);
        }else{
            map.put("message",false);
        }
        return map;
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    @ResponseBody
    //登录验证
    public Map login(String name, String password) {
        //System.out.println("xxx");
        List<User> user = userService.login(name, password);
        //System.out.println("nmsl");
        Map<String,Boolean> map=new HashMap<String, Boolean>();
        if (user.size() != 0){
            //model.addAttribute("user",user);
            map.put("message",true);
        }else {
            map.put("message",false);
        }
        return map;
    }
}
