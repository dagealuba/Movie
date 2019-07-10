package ServiceImpl;

import Dao.SpaceMapper;
import Entity.Space;
import Entity.SpaceExample;
import Service.InvitionService;
import Service.SpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpaceServiceImpl implements SpaceService {
    @Autowired
    private InvitionService invitionService;
    @Autowired
    private SpaceService spaceService;
    @Autowired
    private SpaceMapper spaceMapper;
    //搜索电影
    @Override
    public Space findSpace(String  spaceid){
        System.out.println("test"+spaceid);
        Space space=spaceMapper.selectByPrimaryKey(spaceid);
        return  space;
    }
    //群主添加部分电影
    @Override
    public int addMovie(String spaceid,String owner,String movies ){
        if(invitionService.judgeown(spaceid,owner)==1){
            Space space=spaceMapper.selectByPrimaryKey(spaceid);
            String str=space.getUsers();
            String str1=str;
            String[] strlist=movies.split(";");
            for(int i=0;i<strlist.length;i++) {
                str1 = str.concat(";" + strlist[i]);
            }
            Space space1=new Space();
            space1.setMovies(str1);
            SpaceExample spaceExample = new SpaceExample();
            SpaceExample.Criteria criteria = spaceExample.createCriteria();
            criteria.andSpaceidEqualTo(spaceid);
            return  spaceMapper.updateByExampleSelective(space1, spaceExample);
        }
        else{
            return 0;//不是群主
        }
    }
    //群主删除部分电影
    @Override
    public int deleteMovie(String spaceid,String owner,String movies ){
        if(invitionService.judgeown(spaceid,owner)==1){
            Space space=spaceMapper.selectByPrimaryKey(spaceid);
            String str=space.getMovies();//数据库里的电影
            String[] strlist=movies.split(";");//需要删除的movies
            String[] strlist1=str.split(";");//数据库里的movies
            String str1=str;

            for(int i=0;i<strlist.length;i++ ){
                for(int j=0;j<strlist1.length;j++){
                    if(strlist[i].equals(strlist1[j])){
                        str1=str.replace(strlist1[j]+";","");
                    }
                }
            }
            Space space1=new Space();
            space1.setMovies(str1);
            SpaceExample spaceExample = new SpaceExample();
            SpaceExample.Criteria criteria = spaceExample.createCriteria();
            criteria.andSpaceidEqualTo(spaceid);
            return  spaceMapper.updateByExampleSelective(space1, spaceExample);
        }
        else
            return 0;//不是群主
    }

}
