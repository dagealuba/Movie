package Service;

import Entity.User;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface UserService {
//    public int addUser(User user);

    int register(User user);

    List<User> login(String username, String password);

    List<User> findByName(@RequestParam String name);

    public User getUserById(String id);
}
