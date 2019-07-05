package ServiceImpl;

import Dao.LikeMapper;
import Entity.LikeExample;
import Entity.LikeKey;
import Service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeServiceImpl implements LikeService {
    @Autowired(required = false)
    public LikeMapper likeMapper;

    @Override
    public int countLike(String comment) {
        LikeExample likeExample=new LikeExample();
        LikeExample.Criteria criteria=likeExample.createCriteria();
        criteria.andCommentEqualTo(comment);
        return likeMapper.countByExample(likeExample);
    }

    @Override
    public List<LikeKey> selectLikeByCommentId(String comment) {
        LikeExample likeExample=new LikeExample();
        LikeExample.Criteria criteria=likeExample.createCriteria();
        criteria.andCommentEqualTo(comment);
        return likeMapper.selectByExample(likeExample);
    }

    @Override
    public int insertLike(LikeKey like) {
        return likeMapper.insert(like);
    }

    @Override
    public int deleteLikeByUserId(String user) {
        LikeExample likeExample=new LikeExample();
        LikeExample.Criteria criteria=likeExample.createCriteria();
        criteria.andUserEqualTo(user);
        return likeMapper.deleteByExample(likeExample);
    }

    @Override
    public int deleteLikeByCommentId(String comment) {
        LikeExample likeExample=new LikeExample();
        LikeExample.Criteria criteria=likeExample.createCriteria();
        criteria.andCommentEqualTo(comment);
        return likeMapper.deleteByExample(likeExample);
    }
}
