package Service;

import Entity.Message;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MessageService {
    int addMessage(Message message);
    List<Message> findMsgHistory(String senderid, String receiverid);
    List<Message> getUnreadMessage(String sendid, String receiverid);
}
