package ServiceImpl;

import Dao.UserMapper;
import Entity.User;
import Entity.UserExample;
import Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

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
    public List<User> login(String email,String password) {
        //System.out.println("name: "+username+"\npassword: "+password);
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria=userExample.createCriteria();
        criteria.andEmailEqualTo(email);
        criteria.andPasswordEqualTo(password);
        //List<User> users = userMapper.selectByExample(userExample);
        //System.out.println(users.size()+JSON.toJSONString(users));
        return userMapper.selectByExample(userExample);
    }

    @Override
    public List<User> findByName(@RequestParam String name) {
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria=userExample.createCriteria();
        criteria.andNameEqualTo(name);
        return userMapper.selectByExample(userExample);
    }

    @Override
    public List<User> findByEmail(String email) {
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria=userExample.createCriteria();
        criteria.andEmailEqualTo(email);
        List<User> users = userMapper.selectByExample(userExample);
        return users;
    }


    @Override
    public User findById(String id) {

        return userMapper.selectByPrimaryKey(id);
    }


}
