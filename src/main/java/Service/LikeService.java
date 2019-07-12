package Service;

import Entity.LikeCommentKey;


import java.util.List;


public interface LikeService {

    //统计点赞数
    int countLike(String comment);

    //查看点赞
    List<LikeCommentKey> selectLikeByCommentId(String comment);

    //添加点赞
    int insertLike(LikeCommentKey like);

    boolean isLiked(String userid, String commentid);

    //通过用户id删除点赞
    int deleteLikeByUserId(String user);

    //通过评论id删除点赞
    int deleteLikeByCommentId(String comment);


}
