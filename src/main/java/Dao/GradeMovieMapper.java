package Dao;

import Entity.GradeMovie;
import Entity.GradeMovieExample;
import Entity.GradeMovieKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GradeMovieMapper {
    int countByExample(GradeMovieExample example);

    int deleteByExample(GradeMovieExample example);

    int deleteByPrimaryKey(GradeMovieKey key);

    int insert(GradeMovie record);

    int insertSelective(GradeMovie record);

    List<GradeMovie> selectByExample(GradeMovieExample example);

    GradeMovie selectByPrimaryKey(GradeMovieKey key);

    int updateByExampleSelective(@Param("record") GradeMovie record, @Param("example") GradeMovieExample example);

    int updateByExample(@Param("record") GradeMovie record, @Param("example") GradeMovieExample example);

    int updateByPrimaryKeySelective(GradeMovie record);

    int updateByPrimaryKey(GradeMovie record);
}