package ServiceImpl;

import Dao.InvitionMapper;
import Dao.SpaceMapper;
import Entity.Invition;
import Entity.InvitionExample;
import Entity.Space;
import Entity.SpaceExample;
import Service.InvitionService;
import Service.SpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SpaceServiceImpl implements SpaceService {
    @Autowired
    private InvitionService invitionService;
    @Autowired
    private SpaceMapper spaceMapper;
    @Autowired
    private InvitionMapper invitionMapper;
    //搜索电影

    @Override
    public Map exitspace(String userid, String spaceid){
        Map<String, Boolean> map = new HashMap();
        //judgeIn(userid,spaceid)==0)  //用户不在该群
        Space space1 = spaceMapper.selectByPrimaryKey(spaceid);
        String str = space1.getUsers();
        String[] strlist = str.split(";");
        String str1 = str;
        for (int j = 0; j < strlist.length; j++) {
            if (userid.equals(strlist[j])) {
                str1 = str.replace(strlist[j] + ";", "");
            }
        }
        Space space = new Space();
        space.setUsers(str1);
        SpaceExample spaceExample = new SpaceExample();
        SpaceExample.Criteria criteria1 = spaceExample.createCriteria();
        criteria1.andSpaceidEqualTo(spaceid);
        int a = spaceMapper.updateByExampleSelective(space, spaceExample);

        Invition invition = new Invition();
        invition.setStatus(-1);
        InvitionExample invitionExample = new InvitionExample();
        InvitionExample.Criteria criteria = invitionExample.createCriteria();
        criteria.andInviteeEqualTo(userid);
        criteria.andSpaceidEqualTo(spaceid);
        int b = invitionMapper.updateByExampleSelective(invition, invitionExample);

        if (a == 1 && b == 1) {
            map.put("message", true);
        } else
            map.put("message", false);
        return map;
    }

    @Override
    public Space findSpace(String  spaceid){
        System.out.println("test"+spaceid);
        Space space=spaceMapper.selectByPrimaryKey(spaceid);
        return  space;
    }
    //群主添加部分电影
    @Override
    public Map addMovies(String spaceid,String owner,String movies ){
        Map<String, Boolean> map = new HashMap();
        if (invitionService.judgeown(spaceid, owner) == 1) {
            Space space = spaceMapper.selectByPrimaryKey(spaceid);
            String str = space.getMovies();
            String str1 = str;
            String[] strlist = movies.split(";");
            for (int i = 0; i < strlist.length; i++) {
                str1 = str.concat(";" + strlist[i]);
            }
            Space space1 = new Space();
            space1.setMovies(str1);
            SpaceExample spaceExample = new SpaceExample();
            SpaceExample.Criteria criteria = spaceExample.createCriteria();
            criteria.andSpaceidEqualTo(spaceid);
            if(spaceMapper.updateByExampleSelective(space1, spaceExample)==1){
                map.put("message",true);
            }
        } else {
            map.put("message",false);//不是群主
        }
        return map;
    }
    //群主删除部分电影
    @Override
    public Map deleteMovies(String spaceid,String owner,String movies ){
        Map<String, Boolean> map = new HashMap();
        int flag = 0;
        if (invitionService.judgeown(spaceid, owner) == 1) {
            Space space = spaceMapper.selectByPrimaryKey(spaceid);
            String str = space.getMovies();//数据库里的电影
            String[] strlist = movies.split(";");//需要删除的movies
            String[] strlist1 = str.split(";");//数据库里的movies
            String str1 = str;

            for (int i = 0; i < strlist.length; i++) {
                for (int j = 0; j < strlist1.length; j++) {
                    if (strlist[i].equals(strlist1[j])) {
                        str1 = str.replace(strlist1[j] + ";", "");
                        flag = 1;
                    }
                }
            }
            if (flag == 1) {
                Space space1 = new Space();
                space1.setMovies(str1);
                SpaceExample spaceExample = new SpaceExample();
                SpaceExample.Criteria criteria = spaceExample.createCriteria();
                criteria.andSpaceidEqualTo(spaceid);
                if(spaceMapper.updateByExampleSelective(space1, spaceExample)==1){
                    map.put("message",true);
                }
            }
            else {
                map.put("message",false);
            }
        }
        else
            map.put("message",false);//不是群主
        return map;
    }


}
