package Dao;

import Entity.Love;
import Entity.LoveExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LoveMapper {
    int countByExample(LoveExample example);

    int deleteByExample(LoveExample example);

    int deleteByPrimaryKey(String loveid);

    int insert(Love record);

    int insertSelective(Love record);

    List<Love> selectByExample(LoveExample example);

    Love selectByPrimaryKey(String loveid);

    int updateByExampleSelective(@Param("record") Love record, @Param("example") LoveExample example);

    int updateByExample(@Param("record") Love record, @Param("example") LoveExample example);

    int updateByPrimaryKeySelective(Love record);

    int updateByPrimaryKey(Love record);
}