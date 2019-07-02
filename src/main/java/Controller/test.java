package Controller;

import Entity.User;
import Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class test {

    @Autowired
    private UserService userService;

    @RequestMapping("/test")
    public @ResponseBody User test(){
        User user = userService.getUserById("2016210786");
        if (user == null){
            System.out.println("nmsl");
        }
        return userService.getUserById("2016210787");
    }
}
