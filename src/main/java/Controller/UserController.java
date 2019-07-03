package Controller;


import Entity.User;
import Service.UserService;
import com.alibaba.fastjson.JSON;
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
@SessionAttributes("name")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    //注册新用户
    public Map register(User user ){
        String email=user.getEmail();
        //System.out.println(user.getName());
        Map<String,Boolean> map=new HashMap();
        if (userService.judgeemail(email)==true){
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
        Map<String,String> map=new HashMap<>();
        if (user.size() != 0){
            //model.addAttribute("user",user);
            map.put("message","true");
            User userback=new User();
            userback.setUserid(user.get(0).getUserid());
            userback.setName(user.get(0).getName());
            userback.setEmail(user.get(0).getEmail());
            userback.setAvatar(user.get(0).getAvatar());
            userback.setAddress(user.get(0).getAddress());
            userback.setType(user.get(0).getType());
            map.put("user", JSON.toJSONString(userback));
        }else {
            map.put("message","false");
        }
        return map;
    }
}
