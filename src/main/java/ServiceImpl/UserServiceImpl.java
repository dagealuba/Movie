package ServiceImpl;

import Dao.UserMapper;
import Entity.User;
import Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired(required = false)
    private UserMapper userMapper;

//    @Override
//    public int addUser(User user) {
//        return userDao.addUser(user);
//    }

    @Override
    public User getUserById(String id){
        return userMapper.selectByPrimaryKey(id);
    }
}
