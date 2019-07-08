package Service;

import Entity.Comment;

import java.util.List;

public interface CommentService {

    //统计电影评论数
    int countComment(String movie);

    //统计评论的回复数
    int countCommentByToComment(String tocomment);

    //添加评论
    int insertComment(Comment comment);

    //通过评论id删除评论
    int deleteComment(String commentId);

    //通过电影id删除评论
    int deleteCommentByMovieId(String movie);

    //通过电影id查找评论
    List<Comment> selectCommentByMovieId(String movie);

    //通过评论的id查找评论的回复
    List<Comment> selectCommentByToCommentId(String tocomment);

    //通过评论id查找评论
    Comment selectCommentById(String commentid);



}
