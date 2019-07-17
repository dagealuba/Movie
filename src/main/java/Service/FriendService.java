package Service;

import java.util.Map;

public interface FriendService {
    Map getFriends(String userid);

    boolean addFriend(String userid, String friendid);

    boolean deleteFriend(String userid, String friendid);

    boolean update(String userid, String friendid, String updateGroup);
}
