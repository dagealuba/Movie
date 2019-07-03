package Controller;


import Entity.User;
import Entity.UserExample;
import Service.UserService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


@Controller

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
        if (judgeEmail(email)==true){
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
    public Map login(String email, String password) {
        List<User> user = userService.login(email, password);
        Map<String,String> map=new HashMap<>();
        if (user.size() != 0){
            map.put("message","true");
           String id=user.get(0).getUserid();
            map.put("user", JSON.toJSONString(userBack(id),SerializerFeature.WriteMapNullValue));
        }else {
            map.put("message","false");
        }
        return map;
    }
    @RequestMapping(value = "/userBack",method=RequestMethod.POST)
    @ResponseBody
    //返回用户信息，不包括密码
    public List<User> userBack(String id){
        List<User> userInfoBack= userService.findById(id);
        userInfoBack.get(0).setPassword(null);
        return userInfoBack;
    }


    @RequestMapping(value = "judgeEmail",method = RequestMethod.GET)
    @ResponseBody
    public Boolean judgeEmail(String email) {
        Boolean flag = null;
        List<User> users =userService.findByEmail(email);
        if (users.size()!=0){
            flag=false;//数据库中已经存在该email
        }else{
            flag=true;//数据库中不存在该email
        }
        return flag;
    }
}
