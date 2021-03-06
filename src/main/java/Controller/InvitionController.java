package Controller;

import org.springframework.web.bind.annotation.*;

import Entity.Invition;
import Service.InvitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

  /*  @RequestMapping(value = "/invition",method = RequestMethod.POST)
    @ResponseBody
    public Map invition(Invition invition){
        String inviter=
    }
    */
@Controller
@CrossOrigin
public class InvitionController {

    @Autowired
    private InvitionService invitionService;

    @RequestMapping(value="/invition",method = RequestMethod.POST)
    @ResponseBody
    public Map invition(Invition invition){
       /*String inviter=invition.getInviter();
       System.out.println(inviter);
      /*  String invitee=invition.getInvitee();
        String spaceid=invition.getSpaceid();*/
        if(invitionService.invition(invition)==1){
            Map<String, Boolean> map = new HashMap();
            map.put("message",true);
            return  map;
        }
        else{
            String message="您不是该群群主，没有权限邀请好友";
            Map<String, String > map = new HashMap();
            map.put("message",message);
            return  map;
        }
    }

    @RequestMapping(value = "/ifaccept",method = RequestMethod.POST)
    @ResponseBody
    public Map ifaccept(Invition invition){
        Map<String, Boolean> map = new HashMap();
        if(invitionService.ifAccept(invition)==1){
            map.put("message",true);
        }
        else{
            map.put("message",false);
        }

        return  map;
    }

}
