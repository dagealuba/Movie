package ServiceImpl;

import Dao.LikeCommentMapper;
import Entity.LikeCommentExample;
import Entity.LikeCommentKey;
import Service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeServiceImpl implements LikeService {
    @Autowired(required = false)
    public LikeCommentMapper likeCommentMapper;

    @Override
    public int countLike(String comment) {
        LikeCommentExample likeCommentExample=new LikeCommentExample();
        LikeCommentExample.Criteria criteria=likeCommentExample.createCriteria();
        criteria.andCommentEqualTo(comment);
        return likeCommentMapper.countByExample(likeCommentExample);
    }

    @Override
    public List<LikeCommentKey> selectLikeByCommentId(String comment) {
        LikeCommentExample likeExample=new LikeCommentExample();
        LikeCommentExample.Criteria criteria=likeExample.createCriteria();
        criteria.andCommentEqualTo(comment);
        return likeCommentMapper.selectByExample(likeExample);
    }

    @Override
    public int insertLike(LikeCommentKey like) {
        return likeCommentMapper.insert(like);
    }

    @Override
    public int deleteLikeByUserId(String user) {
        LikeCommentExample likeExample=new LikeCommentExample();
        LikeCommentExample.Criteria criteria=likeExample.createCriteria();
        criteria.andUserEqualTo(user);
        return likeCommentMapper.deleteByExample(likeExample);
    }

    @Override
    public int deleteLikeByCommentId(String comment) {
        LikeCommentExample likeExample=new LikeCommentExample();
        LikeCommentExample.Criteria criteria=likeExample.createCriteria();
        criteria.andCommentEqualTo(comment);
        return likeCommentMapper.deleteByExample(likeExample);
    }
}
