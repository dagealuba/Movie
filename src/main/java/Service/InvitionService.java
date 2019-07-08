package Service;

<<<<<<< Updated upstream
public interface InvitionService {
=======
import Entity.Invition;

public interface InvitionService {
    public int invition(Invition invition);
    public  int ifExist(String inviter,String invitee, String spaceid);
    public  int ifAccept(Invition invition );
    public int judgeown(Invition invition);
>>>>>>> Stashed changes
}
