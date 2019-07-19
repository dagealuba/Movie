package ServiceImpl;

import Dao.MessageMapper;
import Entity.Message;
import Entity.MessageExample;
import Service.MessageService;
import com.mysql.jdbc.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired(required = false)
    private MessageMapper messageMapper;
    @Override
    public int addMessage(Message message){
//        message.setSenderid(UUID.randomUUID().toString());
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
    public List<Message> getUnreadMessage(String userid) {
        MessageExample messageExample = new MessageExample();
        MessageExample.Criteria criteria = messageExample.createCriteria();
        criteria.andReceiveridEqualTo(userid);
        criteria.andStatusEqualTo(0);
        List<Message> messages = messageMapper.selectByExample(messageExample);
        return messages;
    }

    @Override
    public Message findById(String id) {
        MessageExample messageExample = new MessageExample();
        MessageExample.Criteria criteria = messageExample.createCriteria();
        criteria.andMessageidEqualTo(id);
        List<Message> messages = messageMapper.selectByExample(messageExample);

        if (messages.size() > 0){
            return messages.get(0);
        }
        return null;
    }

    @Override
    public boolean readMessage(String id) {
        MessageExample messageExample = new MessageExample();

        Message message = findById(id);
        message.setStatus(1);



        return  messageMapper.updateByPrimaryKeySelective(message) > 0;
    }


}
