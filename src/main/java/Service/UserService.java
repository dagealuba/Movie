package Service;

import Entity.User;
import Entity.UserExample;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface UserService {
//    public int addUser(User user);

    int register(User user);

    List<User> login(String username, String password);

    List<User> findByName(@RequestParam String name);

    List<User> findByEmail(@RequestParam String email);
    //查找
    User selectByPrimaryKey(String userid);

    //通过条件删除
    int deleteUserByName(String username);

    //信息修改
    int updateByPrimaryKey(User user);
}