package ServiceImpl;

import Dao.FriendMapper;
import Dao.InvitionMapper;
import Entity.Friend;
import Service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class FriendServiceImpl implements FriendService {
    @Autowired
    private FriendMapper friendMapper;
    @Autowired
    private InvitionMapper invitionMapper;

    @Override
    public Map getFriends(String userid) {
        return null;
    }

    @Override
    public boolean addFriend(String user, String friend, String group) {
        return false;
    }

    @Override
    public boolean deleteFriend(String user, String friend) {
        return false;
    }

    @Override
    public boolean update(String user, String friend, String updateGroup) {
        return false;
    }
}
