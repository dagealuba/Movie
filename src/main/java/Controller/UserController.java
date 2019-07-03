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


@Controller
@SessionAttributes("name")
public class UserController {
    @Autowired
    private static UserService userService;
    @RequestMapping(value = "/register",method = RequestMethod.GET)
    @ResponseBody
    //注册新用户
    public String register(User user ){
        String username=user.getName();
        if (userService.findByName(username)==null){
            //添加用户
            userService.register(user);
            //注册成功跳转到主页面
            return "mainPage";
        }else{
            //跳转失败页面
            return"error";
        }
    }
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    @ResponseBody
    //登录验证
    public  static Map login(String name, String password) {
        System.out.println("name: "+name+"\npassword: "+password);
        List<User> user = userService.login(name, password);
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
