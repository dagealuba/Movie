package Controller;


import Entity.Love;
import Entity.User;
import Service.LoveService;
import Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


@Controller
@SessionAttributes("name")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private LoveService loveService;

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

            //注册成功后默认生成一个收藏夹
            Love love=new Love();
            love.setLoveid(UUID.randomUUID().toString());
            love.setName("我喜欢的");
            love.setUser(user.getUserid());
            loveService.insertLove(love);
            System.out.println("收藏夹添加成功！");

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

    @RequestMapping(value = "/findUserByName",method = RequestMethod.GET)
    @ResponseBody
    public List<User> findUserByName(String username){
        List<User> users=userService.findByName(username);
        return users;
    }

    @RequestMapping(value = "/deleteUserByName",method =RequestMethod.POST)
    @ResponseBody
    public Map deleteUserByName(String name){
        Map<String,Boolean> map=new HashMap<String,Boolean>();
        int tag=userService.deleteUserByName(name);
        if(tag==1)
        {
            System.out.println("删除成功");
            map.put("message",true);
        }
        else
        {
            System.out.println("删除失败");
            map.put("message",false);
        }
        return map;
    }

    @RequestMapping(value = "updateById",method = RequestMethod.POST)
    @ResponseBody
    public User updateById(User user){
        String id=user.getUserid();
        String name=user.getName();
        String password=user.getPassword();
        String address=user.getAddress();
        String email=user.getEmail();
        String avatar=user.getAvatar();

        User u=userService.selectByPrimaryKey(id);
        int type=u.getType();
        user.setType(type);

        System.out.println(user.getUserid());
        System.out.println(user.getName());
        System.out.println(type);

        if(userService.updateByPrimaryKey(user)==1){
            System.out.println("修改成功");
        }
        else{
            System.out.println("修改失败");
        }
        return user;
    }

}