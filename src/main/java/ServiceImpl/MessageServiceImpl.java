package ServiceImpl;

import Dao.MessageMapper;
import Entity.Message;
import Service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired(required = false)
    private MessageMapper messageMapper;
    @Override
    public int addMessage(Message message){
        return messageMapper.insertSelective(message);
    }
}