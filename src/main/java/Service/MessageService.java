package Service;

import Entity.Message;
import org.springframework.stereotype.Service;

@Service
public interface MessageService {
    int addMessage(Message message);
}
