package ServiceImpl;

import Dao.UserMapper;
import Entity.User;
import Entity.UserExample;
import Service.UserService;
import com.alibaba.fastjson.JSON;
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
        //System.out.println("name: "+username+"\npassword: "+password);
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria=userExample.createCriteria();
        criteria.andEmailEqualTo(username);     //添加Email字段等于username的条件
        criteria.andPasswordEqualTo(password);
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
        return userMapper.selectByExample(userExample);
    }

    @Override
    public User selectByPrimaryKey(String userid) {
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria=userExample.createCriteria();
        criteria.andUseridEqualTo(userid);
        return userMapper.selectByPrimaryKey(userid);
    }


    @Override
    public int deleteUserByName(String username) {
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria=userExample.createCriteria();
        criteria.andNameEqualTo(username);
        return userMapper.deleteByExample(userExample);
    }

    @Override
    public int updateByPrimaryKey(User user) {
        return userMapper.updateByPrimaryKey(user);
    }

}