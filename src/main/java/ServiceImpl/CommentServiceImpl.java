package ServiceImpl;

import Dao.CommentMapper;
import Entity.Comment;
import Entity.CommentExample;
import Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired(required = false)
    public CommentMapper commentMapper;

    @Override
    public int countComment(String movie) {
        CommentExample commentExample=new CommentExample();
        CommentExample.Criteria criteria=commentExample.createCriteria();
        criteria.andMovieEqualTo(movie);
        int count=commentMapper.countByExample(commentExample);
        return count;
    }

    @Override
    public int countCommentByToComment(String tocomment) {
        CommentExample commentExample=new CommentExample();
        CommentExample.Criteria criteria=commentExample.createCriteria();
        criteria.andTocommentEqualTo(tocomment);
        int count=commentMapper.countByExample(commentExample);
        return count;
    }

    @Override
    public int insertComment(Comment comment) {
        return commentMapper.insert(comment);
    }

    @Override
    public int deleteComment(String commentId) {
        return commentMapper.deleteByPrimaryKey(commentId);
    }

    @Override
    public int deleteCommentByMovieId(String movie) {
        CommentExample commentExample=new CommentExample();
        CommentExample.Criteria criteria=commentExample.createCriteria();
        criteria.andMovieEqualTo(movie);
        return commentMapper.deleteByExample(commentExample);
    }

    @Override
    public List<Comment> selectCommentByMovieId(String movie) {
        CommentExample commentExample=new CommentExample();
        CommentExample.Criteria criteria=commentExample.createCriteria();
        criteria.andMovieEqualTo(movie);
        commentExample.setOrderByClause("time desc");
        return commentMapper.selectByExample(commentExample);
    }

    @Override
    public List<Comment> selectCommentByToCommentId(String tocomment) {
        CommentExample commentExample=new CommentExample();
        CommentExample.Criteria criteria=commentExample.createCriteria();
        criteria.andTocommentEqualTo(tocomment);
        commentExample.setOrderByClause("time desc");
        return commentMapper.selectByExample(commentExample);
    }

    @Override
    public Comment selectCommentById(String commentid) {
        return commentMapper.selectByPrimaryKey(commentid);
    }


}
