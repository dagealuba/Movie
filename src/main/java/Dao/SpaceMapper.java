package Dao;

import Entity.Space;
import Entity.SpaceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SpaceMapper {
    int countByExample(SpaceExample example);

    int deleteByExample(SpaceExample example);

    int deleteByPrimaryKey(String spaceid);

    int insert(Space record);

    int insertSelective(Space record);

    List<Space> selectByExample(SpaceExample example);

    Space selectByPrimaryKey(String spaceid);

    int updateByExampleSelective(@Param("record") Space record, @Param("example") SpaceExample example);

    int updateByExample(@Param("record") Space record, @Param("example") SpaceExample example);

    int updateByPrimaryKeySelective(Space record);

    int updateByPrimaryKey(Space record);
}