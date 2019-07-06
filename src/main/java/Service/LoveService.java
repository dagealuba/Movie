package Service;

import Entity.Love;

import java.util.List;

public interface LoveService {

    int insertLove(Love love);

    int deleteLoveById(String loveid);

    int deleteLoveByUserId(String user);

    List<Love> selectByName(String name);

    List<Love> selectByUserId(String user);

    Love selectById(String loveid);



}
