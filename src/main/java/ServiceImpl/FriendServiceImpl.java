package ServiceImpl;

import Dao.FriendMapper;
import Dao.InvitionMapper;
import Dao.UserMapper;
import Entity.Friend;
import Entity.FriendExample;
import Entity.User;
import Entity.UserExample;
import Service.FriendService;
import Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FriendServiceImpl implements FriendService {
    @Autowired
    private FriendMapper friendMapper;
    @Autowired
    private InvitionMapper invitionMapper;
    @Autowired
    private UserService userService;
    @Override
    public Map<String, List<User>> getFriends(String userid) {
        Map<String,List<User> > map = new HashMap<>();
        List<User> users =new ArrayList<>();
        FriendExample friendExample =new FriendExample();
        FriendExample.Criteria criteria=friendExample.createCriteria();
        criteria.andUseridEqualTo(userid);
        List<Friend> friend=friendMapper.selectByExample(friendExample);
        for (int i=0;i<friend.size();i++){
            users.add((User) userService.findById(friend.get(i).getFriendid()));
        }
        map.put(userid,users);
        return map;
    }

    @Override
    public boolean addFriend(String userid, String friendid) {
        Friend friend =new Friend();
        friend.setUserid(userid);
        friend.setFriendid(friendid);
        friendMapper.insertSelective(friend);
        friend.setUserid(friendid);
        friend.setFriendid(userid);
        friendMapper.insertSelective(friend);
        return true;
    }

    @Override
    public boolean deleteFriend(String userid, String friendid) {
        friendMapper.deleteByPrimaryKey(userid,friendid);
        return true;
    }

    @Override
    public boolean update(String userid, String friendid, String updateGroup) {
        Friend friend = new Friend();
        friend.setUserid(userid);
        friend.setFriendid(friendid);
        friend.setGroup(updateGroup);
        friendMapper.updateByPrimaryKeySelective(userid,friendid,friend);
        return true;
    }
}
