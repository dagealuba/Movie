package Controller;

import Dao.InvitionMapper;
import Dao.SpaceMapper;
import Entity.Space;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import Entity.Invition;
import Service.InvitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.HashMap;
import java.util.Map;
@Controller
@SessionAttributes("movie")
public class InvitionController {

    @Autowired
    private InvitionService invitionService;
    @Autowired
    private SpaceMapper spaceMapper;

    //邀请
    @RequestMapping(value = "/invition", method = RequestMethod.POST)
    @ResponseBody
    public Map invition(Invition invition) {
        if (judgeIn(invition.getInvitee(), invition.getSpaceid()) == 1) {
            if (invitionService.invition(invition) == 1) {
                Map<String, Boolean> map = new HashMap();
                map.put("message", true);
                return map;
            } else {
                String message = "您不是该群群主，没有权限邀请好友";
                Map<String, String> map = new HashMap();
                map.put("message", message);
                return map;
            }
        } else {
            String message = "该用户已在群里";
            Map<String, String> map = new HashMap();
            map.put("message", message);
            return map;
        }
    }

    //所邀请用户是否已在群里
    public int judgeIn(String userid, String spaceId) {
        int flag = 1;
        Space space1 = spaceMapper.selectByPrimaryKey(spaceId);
        String str = space1.getUsers();
        String[] strlist = str.split(";");

        for (int j = 0; j < strlist.length; j++) {
            if (userid.equals(strlist[j])) {
                flag = 0;
            }
        }
        return flag;
    }

    //回应邀请
    @RequestMapping(value = "/ifaccept", method = RequestMethod.POST)
    @ResponseBody
    public Map ifaccept(Invition invition) {
        Map<String, Boolean> map = new HashMap();
        if (invitionService.ifAccept(invition) == 1) {
            map.put("message", true);
        } else {
            map.put("message", false);
        }

        return map;
    }

    //查找我所邀请过的用户
    @RequestMapping(value = "/findinvitionsByinviter", method = RequestMethod.GET)
    @ResponseBody
    public Map findinvitionsByinviter(String inviter){
        return invitionService.findInvitionsByinviter(inviter);
    }

    //查找我的被邀请条目
    @RequestMapping(value = "/findinvitionsByinvitee", method = RequestMethod.GET)
    @ResponseBody
    public Map findinvitionsByinvitee(String invitee){
        return invitionService.findInvitionsByinvitee(invitee);
    }
}