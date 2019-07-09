package ServiceImpl;

import Dao.LoveMapper;
import Entity.Love;
import Entity.LoveExample;
import Service.LoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoveServiceImpl implements LoveService {
    @Autowired(required = false)
    private LoveMapper loveMapper;

    @Override
    public int insertLove(Love love) {
        return loveMapper.insert(love);
    }

    @Override
    public int deleteLoveById(String loveid) {
        return loveMapper.deleteByPrimaryKey(loveid);
    }

    @Override
    public int deleteLoveByUserId(String user) {
        LoveExample loveExample=new LoveExample();
        LoveExample.Criteria criteria=loveExample.createCriteria();
        criteria.andUserEqualTo(user);
        return loveMapper.deleteByExample(loveExample);
    }

    @Override
    public List<Love> selectByName(String name, String user) {
        LoveExample loveExample=new LoveExample();
        LoveExample.Criteria criteria=loveExample.createCriteria();
        criteria.andUserEqualTo(user);
        criteria.andNameEqualTo(name);
        return loveMapper.selectByExample(loveExample);
    }

    @Override
    public List<Love> selectByUserId(String user) {
        LoveExample loveExample=new LoveExample();
        LoveExample.Criteria criteria=loveExample.createCriteria();
        criteria.andUserEqualTo(user);
        return loveMapper.selectByExample(loveExample);
    }

    @Override
    public Love selectById(String loveid) {
        return loveMapper.selectByPrimaryKey(loveid);
    }

    @Override
    public int updateByLove(Love love) {
        LoveExample loveExample=new LoveExample();
        LoveExample.Criteria criteria=loveExample.createCriteria();
        criteria.andLoveidEqualTo(love.getLoveid());
        return loveMapper.updateByExample(love,loveExample);
    }
}
