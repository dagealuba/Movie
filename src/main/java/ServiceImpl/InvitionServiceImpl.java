package ServiceImpl;
import Dao.InvitionMapper;
import Dao.SpaceMapper;
import Entity.InvitionExample;
import Entity.Space;
import Entity.SpaceExample;
import Service.InvitionService;
import java.util.List;
import Entity.Invition;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvitionServiceImpl implements InvitionService {
    @Autowired
    private InvitionMapper invitionMapper;
    @Autowired
    private SpaceMapper spaceMapper;

    @Override
    public int invition(Invition invition){
       /* System.out.println("invitee"+invition.getInvitee());
        System.out.println("invitee"+invition.getInviter());
        System.out.println("spaceid"+invition.getSpaceid());*/
        Invition invition1=new Invition();
        if(judgeown(invition)==1) {
            if (ifExist(invition.getInviter(), invition.getInvitee(), invition.getSpaceid()) == 1) {
                invition1.setStatus(0);
                InvitionExample invitionExample = new InvitionExample();
                InvitionExample.Criteria criteria = invitionExample.createCriteria();
                criteria.andInviterEqualTo(invition.getInviter());
                criteria.andInviteeEqualTo(invition.getInvitee());
                criteria.andStatusNotEqualTo(1);
                return invitionMapper.updateByExampleSelective(invition, invitionExample);
            } else {
                invition1.setInvitee(invition.getInvitee());
                invition1.setInviter(invition.getInviter());
                invition1.setSpaceid(invition.getSpaceid());
                invition1.setStatus(0);
                return invitionMapper.insertSelective(invition1);
            }
        }
        else{
            return 0;
        }
    }

    @Override
    public int addFriend(Invition invition) {
        Invition invition1=new Invition();
        if (ifExist(invition.getInviter(), invition.getInvitee()) == 1) {
            invition1.setStatus(0);
            InvitionExample invitionExample = new InvitionExample();
            InvitionExample.Criteria criteria = invitionExample.createCriteria();
            criteria.andInviterEqualTo(invition.getInviter());
            criteria.andInviteeEqualTo(invition.getInvitee());
            criteria.andStatusNotEqualTo(1);
            return invitionMapper.updateByExampleSelective(invition, invitionExample);
        } else {
            invition1.setInvitee(invition.getInvitee());
            invition1.setInviter(invition.getInviter());
            invition1.setSpaceid(invition.getSpaceid());
            invition1.setStatus(0);
            return invitionMapper.insertSelective(invition1);
        }
    }

    @Override
    public  int ifAccept(Invition invition ){
        int flag=0;int a;int b = 0;
        Invition invition1=new Invition();
        invition1.setStatus(invition.getStatus());
        InvitionExample invitionExample=new InvitionExample();
        InvitionExample.Criteria criteria=invitionExample.createCriteria();
        criteria.andInviterEqualTo(invition.getInviter());
        criteria.andInviteeEqualTo(invition.getInvitee());
        criteria.andStatusNotEqualTo(1);
        a=invitionMapper.updateByExampleSelective(invition,invitionExample);
        if(invition.getStatus()==1){
            b=updatespace();
        }
        if(a==1&b==1) {
            flag = 1;
        }
        else{
            flag=0;
        }
        return flag;
    }

    @Override
    public  int ifExist(String inviter,String invitee ,String spaceid){
        InvitionExample invitionExample=new InvitionExample();
        InvitionExample.Criteria criteria=invitionExample.createCriteria();
        criteria.andInviterEqualTo(inviter);
        criteria.andInviteeEqualTo(invitee);
        criteria.andSpaceidEqualTo(spaceid);
        List<Invition> invitions=invitionMapper.selectByExample(invitionExample);
        if(invitions.size()!=0){
            return 1;
        }
        else{
            return 0;
        }
    }

    @Override
    public int ifExist(String inviter, String invitee) {
        InvitionExample invitionExample=new InvitionExample();
        InvitionExample.Criteria criteria=invitionExample.createCriteria();
        criteria.andInviterEqualTo(inviter);
        criteria.andInviteeEqualTo(invitee);
        criteria.andSpaceidIsNull();
        List<Invition> invitions=invitionMapper.selectByExample(invitionExample);
        if(invitions.size()!=0){
            return 1;
        }
        else{
            return 0;
        }
    }

    @Override
    public int judgeown(Invition invition){
        SpaceExample spaceExample=new SpaceExample();
        SpaceExample.Criteria criteria=spaceExample.createCriteria();
        criteria.andSpaceidEqualTo(invition.getSpaceid());
        criteria.andOwnerEqualTo(invition.getInviter());
        List<Space> spaces=spaceMapper.selectByExample(spaceExample);
        if(spaces.size()!=0){
            return 1;
        }
        else {
            return 0;
        }
    }

    @Override
    public Invition findByid(Integer invitationid) {
        Invition invitation=invitionMapper.selectByPrimaryKey(invitationid);
        return invitation;
    }

    @Override
    public List<Invition> getUnread(String userid) {
        InvitionExample invitionExample = new InvitionExample();
        InvitionExample.Criteria criteria = invitionExample.createCriteria();
        criteria.andStatusEqualTo(0);
        criteria.andInviteeEqualTo(userid);
        System.out.println(JSON.toJSONString(invitionMapper.selectByExample(invitionExample)));
        return invitionMapper.selectByExample(invitionExample);
    }

    public int updatespace(){
        InvitionExample invitionExample = new InvitionExample();
        InvitionExample.Criteria criteria = invitionExample.createCriteria();
        criteria.andStatusEqualTo(1);
        List<Invition> invitions=invitionMapper.selectByExample(invitionExample);

        if(invitions.size()!=0){
            int flag=1;
            for(int i=0;i<invitions.size();i++){
                Space space1=spaceMapper.selectByPrimaryKey(invitions.get(i).getSpaceid());

                Space space=new Space();
                String str=space1.getUsers();
                String[] strlist=str.split(";");
                for(int j=0;j<str.length();j++) {
                    String u = invitions.get(i).getInvitee();
                    if (u.equals(strlist[i])) {
                        flag=0;
                    }
                    continue;
                }
                if(flag==1){
                        String str1 = str.concat(";" + invitions.get(i).getInvitee());
                        space.setUsers(str1);
                        SpaceExample spaceExample = new SpaceExample();
                        SpaceExample.Criteria criteria1 = spaceExample.createCriteria();
                        criteria1.andSpaceidEqualTo(invitions.get(i).getSpaceid());
                        spaceMapper.updateByExampleSelective(space, spaceExample);
                    }
                }
            return 1;
            }
        else {
            return 0;
        }
    }

}
