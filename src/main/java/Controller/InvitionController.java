package Controller;

import Dao.InvitionMapper;
import Dao.SpaceMapper;
import Entity.InvitionExample;
import Entity.Space;
import Entity.SpaceExample;
import Service.SpaceService;
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
    private SpaceService spaceService;

      @Autowired
      private SpaceMapper spaceMapper;

    @Autowired
    private InvitionMapper invitionMapper;

    //邀请
    @RequestMapping(value="/invition",method = RequestMethod.POST)
    @ResponseBody
    public Map invition(Invition invition){
        if(judgeIn(invition.getInvitee(),invition.getSpaceid())==1) {
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
        }
        else{
            String message = "该用户已在群里";
            Map<String, String> map = new HashMap();
            map.put("message", message);
            return map;
        }
    }
      //所邀请用户是否已在群里
      public  int judgeIn(String userid,String spaceId){
            int flag=1;
          Space space1=spaceMapper.selectByPrimaryKey(spaceId);
          String str=space1.getUsers();
          String[] strlist=str.split(";");

          for(int j=0;j<strlist.length;j++) {
              if (userid.equals(strlist[j])) {
                  flag=0;
              }
          }
          return flag;
      }

//回应邀请
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

    //退出space群
    @RequestMapping(value = "/exitspace",method = RequestMethod.POST)
    @ResponseBody
    public Map exitspace(String userid,String spaceid){
        int flag;
        Map<String, Boolean> map = new HashMap();
        //judgeIn(userid,spaceid)==0)  //用户不在该群
        Space space1=spaceMapper.selectByPrimaryKey(spaceid);
        String str=space1.getUsers();
        String[] strlist=str.split(";");
        String str1=str;
        for(int j=0;j<strlist.length;j++) {
            if (userid.equals(strlist[j])) {
               str1=str.replace(strlist[j]+";","");
            }
        }
        Space space=new Space();
        space.setUsers(str1);
        SpaceExample spaceExample = new SpaceExample();
        SpaceExample.Criteria criteria1 = spaceExample.createCriteria();
        criteria1.andSpaceidEqualTo(spaceid);
        int a=spaceMapper.updateByExampleSelective(space, spaceExample);

        Invition invition=new Invition();
        invition.setStatus(-1);
        InvitionExample invitionExample = new InvitionExample();
        InvitionExample.Criteria criteria = invitionExample.createCriteria();
        criteria.andInviteeEqualTo(userid);
        criteria.andSpaceidEqualTo(spaceid);
        int b=invitionMapper.updateByExampleSelective(invition,invitionExample);

        if(a==1&&b==1){
            map.put("message",true);
        }
        else
            map.put("message",false);
        return map;
    }


}
