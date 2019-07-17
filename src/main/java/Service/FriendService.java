package Service;

import java.util.Map;

public interface FriendService {
    Map getFriends(String userid);

    boolean addFriend(String user, String friend, String group);

    boolean deleteFriend(String user, String friend);

    boolean update(String user, String friend, String updateGroup);
}
