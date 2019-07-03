package Dao;

import Entity.LikeExample;
import Entity.LikeKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LikeMapper {
    int countByExample(LikeExample example);

    int deleteByExample(LikeExample example);

    int deleteByPrimaryKey(LikeKey key);

    int insert(LikeKey record);

    int insertSelective(LikeKey record);

    List<LikeKey> selectByExample(LikeExample example);

    int updateByExampleSelective(@Param("record") LikeKey record, @Param("example") LikeExample example);

    int updateByExample(@Param("record") LikeKey record, @Param("example") LikeExample example);
}