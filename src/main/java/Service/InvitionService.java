package Service;

import Entity.Invition;

import java.util.List;

public interface InvitionService {
    public int invition(Invition invition);
    public int addFriend(Invition invition);
    public  int ifExist(String inviter,String invitee, String spaceid);
    public  int ifExist(String inviter,String invitee);
    public  int ifAccept(Invition invition );
    public int judgeown(Invition invition);
    Invition findByid(Integer invitationid);
    Invition findByOther(String inviter,String invitee);
    List<Invition> getUnread(String userid);
}
