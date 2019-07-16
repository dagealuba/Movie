package Controller;

import Entity.Message;
import Service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Controller
@CrossOrigin
public class MessageController {
    @Autowired
    private MessageService messageService;
    @RequestMapping(value = "/findMsgHistory")
    public List<Message>findMsgHistory(String senderid,String receiverid){
        return messageService.findMsgHistory(senderid,receiverid);
    }
}
