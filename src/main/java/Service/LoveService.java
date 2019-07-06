package Service;

import Entity.Love;

import java.util.List;

public interface LoveService {

    //统计收藏夹中的电影数
    //int countMovieByLoveId(String loveid);

    //新建收藏夹
    int insertLove(Love love);

    //添加电影收藏
    int insertLoveMovie(String movies);

    //通过loveid删除收藏夹
    int deleteLoveById(String loveid);

    //通过用户id删除收藏夹
    int deleteLoveByUserId(String user);

    //通过电影id删除收藏夹中的电影
    int deleteLoveMovieByMovieId(String movies);

    //通过名字搜索收藏夹
    List<Love> selectByName(String name,String user);

    //通过用户id搜索收藏夹
    List<Love> selectByUserId(String user);

    //通过id搜索收藏夹
    Love selectById(String loveid);



}
