package ServiceImpl;
import Dao.InvitionMapper;
import Dao.SpaceMapper;
import Entity.InvitionExample;
import Entity.Space;
import Entity.SpaceExample;
import Service.InvitionService;
import java.util.List;
import Entity.Invition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvitionServiceImpl implements InvitionService {
    @Autowired
    private InvitionMapper invitionMapper;
    @Autowired
    private SpaceMapper spaceMapper;
//邀请进群
    @Override
    public int invition(Invition invition){
        Invition invition1=new Invition();
            if (judgeown(invition) == 1) {
                //是否已经邀请过该用户
                if (ifExist(invition.getInviter(), invition.getInvitee(), invition.getSpaceid()) == 1) {
                    invition1.setStatus(0);
                    InvitionExample invitionExample = new InvitionExample();
                    InvitionExample.Criteria criteria = invitionExample.createCriteria();
                    criteria.andInviterEqualTo(invition.getInviter());
                    criteria.andInviteeEqualTo(invition.getInvitee());
                    criteria.andStatusNotEqualTo(1);
                    return invitionMapper.updateByExampleSelective(invition1, invitionExample);
                } else {
                    invition1.setInvitee(invition.getInvitee());
                    invition1.setInviter(invition.getInviter());
                    invition1.setSpaceid(invition.getSpaceid());
                    invition1.setStatus(0);
                    return invitionMapper.insertSelective(invition1);
                }
            } else {
                return 0;
            }

    }


//回应邀请
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
            b=updatespace();
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

    public int updatespace(){
        InvitionExample invitionExample = new InvitionExample();
        InvitionExample.Criteria criteria = invitionExample.createCriteria();
        criteria.andStatusEqualTo(1);
        List<Invition> invitions=invitionMapper.selectByExample(invitionExample);
        if(invitions.size()!=0){
            int flag=1;
            for(int i=0;i<invitions.size();i++){
                flag=1;
                Space space1=spaceMapper.selectByPrimaryKey(invitions.get(i).getSpaceid());
                Space space=new Space();
                String str=space1.getUsers();
                String[] strlist=str.split(";");
                String u = invitions.get(i).getInvitee();
                for(int j=0;j<strlist.length;j++) {
                    if (u.equals(strlist[j])) {
                        flag=0;
                    }
                }
                if(flag==1){
                        String str1 = str.concat(invitions.get(i).getInvitee()+";" );
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

    //退出空间群


}
