package Dao;

import Entity.LikeCommentExample;
import Entity.LikeCommentKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LikeCommentMapper {
    int countByExample(LikeCommentExample example);

    int deleteByExample(LikeCommentExample example);

    int deleteByPrimaryKey(LikeCommentKey key);

    int insert(LikeCommentKey record);

    int insertSelective(LikeCommentKey record);

    List<LikeCommentKey> selectByExample(LikeCommentExample example);

    int updateByExampleSelective(@Param("record") LikeCommentKey record, @Param("example") LikeCommentExample example);

    int updateByExample(@Param("record") LikeCommentKey record, @Param("example") LikeCommentExample example);
}