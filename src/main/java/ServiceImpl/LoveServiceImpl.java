package ServiceImpl;

import Entity.Love;
import Service.LoveService;

import java.util.List;

public class LoveServiceImpl implements LoveService {
    @Override
    public int insertLove(Love love) {
        return 0;
    }

    @Override
    public int deleteLoveById(String loveid) {
        return 0;
    }

    @Override
    public int deleteLoveByUserId(String user) {
        return 0;
    }

    @Override
    public List<Love> selectByName(String name) {
        return null;
    }

    @Override
    public List<Love> selectByUserId(String user) {
        return null;
    }

    @Override
    public Love selectById(String loveid) {
        return null;
    }
}
