package ServiceImpl;

import Dao.MessageMapper;
import Entity.Message;
import Service.MessageService;
import com.mysql.jdbc.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired(required = false)
    private MessageMapper messageMapper;
    @Override
    public int addMessage(Message message){
        return messageMapper.insertSelective(message);
    }

    @Override
    public List<Message> findMsgHistory(String senderid, String receiverid) {
        List<Message> messages=(List<Message>)messageMapper.selectByPrimaryKey(senderid,receiverid);

        return messages;
    }


}
