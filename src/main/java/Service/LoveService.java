package Service;

import Entity.Love;

import java.util.List;

public interface LoveService {

    //新建收藏夹
    int insertLove(Love love);

    //通过loveid删除收藏夹
    int deleteLoveById(String loveid);

    //通过用户id删除收藏夹
    int deleteLoveByUserId(String user);

    //通过名字搜索收藏夹
    List<Love> selectByName(String name,String user);

    //通过用户id搜索收藏夹
    List<Love> selectByUserId(String user);

    //通过id搜索收藏夹
    Love selectById(String loveid);

    //更新Love的信息
    int updateByLove(Love love);

}
