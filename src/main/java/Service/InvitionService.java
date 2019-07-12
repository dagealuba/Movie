package Service;

import Entity.Invition;

import java.util.Map;

public interface InvitionService {
    public int invition(Invition invition);
    public  int ifExist(String inviter,String invitee, String spaceid);
    public  int ifAccept(Invition invition );
    public int judgeown(String spaceid,String inviter);
    public Map findInvitionsByinviter(String inviter);
    public Map findInvitionsByinvitee(String invitee);
}