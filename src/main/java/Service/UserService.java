package Service;

import Entity.User;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface UserService {

    int register(User user);

    int updateUser(User user);

    List<User> login(String email, String password);

    List<User> findByName(@RequestParam String name);

    List<User> findByEmail(@RequestParam String email);

    List<User> findById(String id);

    List<User> findLikeId(String id);

    List<User> findLikeEmail(String email);

    Boolean sendEmail(String email , String emailSubject, String emailContent, String emailType);


    boolean deleteUser(String userid);
}