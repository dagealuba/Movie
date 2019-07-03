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

import java.util.List;


@Controller
@SessionAttributes("name")
public class UserController {
    @Autowired
    private UserService userService;
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
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    //登录验证
    public ModelAndView login(String name, String password, ModelAndView mv , Model model) {
        List<User> user = userService.login(name, password);
        if (user != null){
            model.addAttribute("user",user);
            mv.setViewName("mainPage");
        }else {
            mv.addObject("message","登录名和密码错误，请重新输入");
            mv.setViewName("error");
        }
        return mv;
    }
}
