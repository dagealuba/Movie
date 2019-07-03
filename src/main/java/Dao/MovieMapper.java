package Dao;

import Entity.Movie;
import Entity.MovieExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MovieMapper {
    int countByExample(MovieExample example);

    int deleteByExample(MovieExample example);

    int deleteByPrimaryKey(String movieid);

    int insert(Movie record);

    int insertSelective(Movie record);

    List<Movie> selectByExample(MovieExample example);

    Movie selectByPrimaryKey(String movieid);

    int updateByExampleSelective(@Param("record") Movie record, @Param("example") MovieExample example);

    int updateByExample(@Param("record") Movie record, @Param("example") MovieExample example);

    int updateByPrimaryKeySelective(Movie record);

    int updateByPrimaryKey(Movie record);
}