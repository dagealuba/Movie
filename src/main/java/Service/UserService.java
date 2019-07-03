package Service;

import Entity.User;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface UserService {

    int register(User user);

    List<User> login(String username, String password);
    List<User> findByName(@RequestParam String name);
    List<User> findByEmail(@RequestParam String email);
    List<User> findById(String id);

}
