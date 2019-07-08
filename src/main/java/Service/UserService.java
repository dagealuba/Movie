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

    User selectByPrimaryKey(String userid);

    int deleteUserByName(String username);

    int updateByPrimaryKey(User user);
}