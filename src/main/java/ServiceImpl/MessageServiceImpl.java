package ServiceImpl;

import Dao.MessageMapper;
import Entity.Message;
import Entity.MessageExample;
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
        MessageExample messageExample = new MessageExample();
        MessageExample.Criteria criteria = messageExample.createCriteria();
        criteria.andSenderidEqualTo(senderid);
        criteria.andReceiveridEqualTo(receiverid);
        List<Message> messages=messageMapper.selectByExample(messageExample);
        return messages;
    }

    @Override
    public List<Message> getUnreadMessage(String sendid, String receiverid) {
        MessageExample messageExample = new MessageExample();
        MessageExample.Criteria criteria = messageExample.createCriteria();
        criteria.andSenderidEqualTo(sendid);
        criteria.andReceiveridEqualTo(receiverid);
        criteria.andStatusEqualTo(0);
        List<Message> messages = messageMapper.selectByExample(messageExample);
        return messages;
    }


}
