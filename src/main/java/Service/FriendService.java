package Service;

import Entity.User;

import java.util.List;
import java.util.Map;

public interface FriendService {
    Map getFriends(String userid);

    List<User> getAllFriends(String userid);

    boolean addFriend(String userid, String friendid);

    boolean deleteFriend(String userid, String friendid);

    boolean update(String userid, String friendid, String updateGroup);
}
