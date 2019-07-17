package Controller;

import Entity.Message;
import Service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Controller
@CrossOrigin
public class MessageController {
    @Autowired
    private MessageService messageService;
    @RequestMapping(value = "/findMsgHistory",method = RequestMethod.GET)
    @ResponseBody
    public List<Message>findMsgHistory(String senderid,String receiverid){
        return messageService.findMsgHistory(senderid,receiverid);
    }

    @RequestMapping(value = "/getUnreadMessage",method = RequestMethod.GET)
    @ResponseBody
    public List<Message> getUnreadMessage(String senderid,String receiverid){
        return messageService.getUnreadMessage(senderid,receiverid);
    }
}
