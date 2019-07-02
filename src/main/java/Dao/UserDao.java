package Dao;

import Entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
//    public int addUser(User user);

    public User selectUserById(String id);
}
