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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
@CrossOrigin
public class FriendController {
    @Autowired
    private FriendService friendService;
    @Autowired
    private InvitionService invitionService;
    @Autowired
    private InvitionMapper invitionMapper;

    @RequestMapping(value = "/isFriend",method = RequestMethod.GET)
    @ResponseBody
    public Boolean isFriend(String userid,String friendid){
        //System.out.println(friendService.getFriends(userid).get(userid));
        Map<String,List<User>> friends = friendService.getFriends(userid);
        Set<String> groups = friends.keySet();
        for (String group:groups){
            List<User> users = friends.get(group);

            for (User user:users){
                if (user.getUserid().equals(friendid)){
                    return false;
                }
            }
        }

        return true;

    }

    @RequestMapping(value="/addFriend",method = RequestMethod.GET)
    @ResponseBody
    public Boolean addFriend(Integer invitationid,Integer status,String space){
        Invition invition =invitionService.findByid(invitationid);
        if (space!=null){

        }else {
            friendService.addFriend(invition.getInviter(),invition.getInvitee());
            invition.setStatus(status);
            invitionMapper.updateByPrimaryKey(invition);
        }
        return true;
    }

    @RequestMapping(value="/getFriends",method = RequestMethod.GET)
    @ResponseBody
    public Map getFriend(String userid){
        return friendService.getFriends(userid);
    }
}
