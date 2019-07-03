package ServiceImpl;

import Dao.UserMapper;
import Entity.User;
import Entity.UserExample;
import Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.bind.annotation.ActionMapping;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired(required = false)

    private UserMapper userMapper;

    @Override
    public int register(User user) {
        return userMapper.insertSelective(user);
    }

    @Override
    public List<User> login(String username,String password) {
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria=userExample.createCriteria();
        criteria.andNameEqualTo("name");
        criteria.andPasswordEqualTo("password");
        return userMapper.selectByExample(userExample);
    }

    @Override
    public List<User> findByName(@RequestParam String name) {
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria=userExample.createCriteria();
        criteria.andNameEqualTo("name");
        return userMapper.selectByExample(userExample);
    }


    @Override
    public User getUserById(String id) {
        return null;
    }
}
