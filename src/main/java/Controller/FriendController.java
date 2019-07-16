package Controller;


import Dao.InvitionMapper;
import Entity.Invition;
import Entity.User;
import Service.FriendService;
import Service.InvitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@CrossOrigin
public class FriendController {
    @Autowired
    private FriendService friendService;
    @Autowired
    private InvitionService invitionService;
    @Autowired
    private InvitionMapper invitionMapper;
    @RequestMapping(value = "/isFriend")
    public Boolean isFriend(String userid,String friendid){
        //System.out.println(friendService.getFriends(userid).get(userid));
        List<User> user=(List<User>)friendService.getFriends(userid).get(userid);
        for (int i=0;i<user.size();i++){
            if (user.get(i).getUserid().equalsIgnoreCase(friendid)){
                return false;
            }
        }
        return true;

    }
    @RequestMapping(value="/addFriend")
    public Boolean addFriend(Integer invitionid,Integer status,String space){
        Invition invition =invitionService.findByid(invitionid);
        if (space!=null){

        }else {
            friendService.addFriend(invition.getInviter(),invition.getInvitee());
            invition.setStatus(status);
            invitionMapper.updateByPrimaryKey(invitionid);
        }
        return true;
    }
}
