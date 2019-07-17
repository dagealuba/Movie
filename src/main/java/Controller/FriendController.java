package Controller;


import Dao.InvitionMapper;
import Entity.Invition;
import Entity.User;
import Service.FriendService;
import Service.InvitionService;
import Service.SpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @Autowired
    private SpaceService spaceService;
    @RequestMapping(value = "/isFriend")
    @ResponseBody
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
    @ResponseBody
    public Boolean addFriend(Integer invitationid,Integer status,String space){
        Invition invition =invitionService.findByid(invitationid);
        if (space!=null){
            spaceService.addMembers(invition.getSpaceid(),invition.getInvitee());
            invition.setStatus(status);
            invitionMapper.updateByPrimaryKey(invition);

        }else {
            friendService.addFriend(invition.getInviter(),invition.getInvitee());
            invition.setStatus(status);
            invitionMapper.updateByPrimaryKey(invition);
        }
        return true;
    }
}
