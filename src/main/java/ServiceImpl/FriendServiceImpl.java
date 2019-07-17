package ServiceImpl;

import Dao.FriendMapper;
import Dao.InvitionMapper;
import Entity.Friend;
import Entity.FriendExample;
import Entity.FriendKey;
import Entity.User;
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
        FriendExample friendExample =new FriendExample();
        FriendExample.Criteria criteria=friendExample.createCriteria();
//        System.out.println(userid);
        criteria.andUseridEqualTo(userid);
        List<Friend> friends=friendMapper.selectByExample(friendExample);

        for (Friend friend: friends){
            if (map.get(friend.getGroupname()) == null){
                List<User> users = new ArrayList<>();
                users.add(userService.findById(friend.getFriendid()).get(0));
                map.put(friend.getGroupname(),users);
            }
            else {
                map.get(friend.getGroupname()).add(userService.findById(friend.getFriendid()).get(0));
            }
        }

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
        friendMapper.deleteByPrimaryKey(new FriendKey(userid,friendid));
        return true;
    }

    @Override
    public boolean update(String userid, String friendid, String updateGroup) {
        Friend friend = new Friend();
        friend.setUserid(userid);
        friend.setFriendid(friendid);
        friend.setGroupname(updateGroup);
        friendMapper.updateByPrimaryKeySelective(friend);
        return true;
    }
}
