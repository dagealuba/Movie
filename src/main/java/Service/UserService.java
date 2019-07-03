package Service;

import Entity.User;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface UserService {

    int register(User user);

    List<User> login(String username, String password);

    List<User> findByName(@RequestParam String name);
    List<User> findByEmail(@RequestParam String email);
    Boolean judgeemail(@RequestParam String email);
    public User getUserById(String id);
}
