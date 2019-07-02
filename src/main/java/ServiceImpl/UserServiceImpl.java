package ServiceImpl;

import Dao.UserDao;
import Entity.User;
import Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired(required = false)
    private UserDao userDao;

//    @Override
//    public int addUser(User user) {
//        return userDao.addUser(user);
//    }

    @Override
    public User getUserById(String id){
        return userDao.selectUserById(id);
    }
}
