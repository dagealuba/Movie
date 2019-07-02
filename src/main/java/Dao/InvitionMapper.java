package Dao;

import Entity.Invition;
import Entity.InvitionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InvitionMapper {
    int countByExample(InvitionExample example);

    int deleteByExample(InvitionExample example);

    int insert(Invition record);

    int insertSelective(Invition record);

    List<Invition> selectByExample(InvitionExample example);

    int updateByExampleSelective(@Param("record") Invition record, @Param("example") InvitionExample example);

    int updateByExample(@Param("record") Invition record, @Param("example") InvitionExample example);
}