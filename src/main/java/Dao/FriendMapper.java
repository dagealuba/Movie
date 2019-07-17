package Dao;

import Entity.Friend;
import Entity.FriendExample;
import Entity.FriendKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FriendMapper {
    int countByExample(FriendExample example);

    int deleteByExample(FriendExample example);

    int deleteByPrimaryKey(FriendKey key);

    int insert(Friend record);

    int insertSelective(Friend record);

    List<Friend> selectByExample(FriendExample example);

    Friend selectByPrimaryKey(FriendKey key);

    int updateByExampleSelective(@Param("record") Friend record, @Param("example") FriendExample example);

    int updateByExample(@Param("record") Friend record, @Param("example") FriendExample example);

    int updateByPrimaryKeySelective(Friend record);

    int updateByPrimaryKey(Friend record);
}