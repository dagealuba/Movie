package Service;

import Entity.LikeKey;

import java.util.List;


public interface LikeService {

    //统计点赞数
    int countLike(String comment);

    //查看点赞
    List<LikeKey> selectLikeByCommentId(String comment);

    //添加点赞
    int insertLike(LikeKey like);

    //通过用户id删除点赞
    int deleteLikeByUserId(String user);

    //通过评论id删除点赞
    int deleteLikeByCommentId(String comment);


}
