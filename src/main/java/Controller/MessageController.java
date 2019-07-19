package Controller;

import Entity.Message;
import Service.MessageService;
import com.alibaba.fastjson.JSON;
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
        List<Message> messages1 = messageService.findMsgHistory(senderid,receiverid);

        List<Message> messages2 = messageService.findMsgHistory(receiverid,senderid);

        messages1.addAll(messages2);

        System.out.println("sender"+senderid);
        System.out.println("receiver"+receiverid);
        System.out.println("messages"+JSON.toJSONString(messages1));
        return messages1;
    }

    @RequestMapping(value = "/getUnreadMessage",method = RequestMethod.GET)
    @ResponseBody
    public List<Message> getUnreadMessage(String senderid,String receiverid){
        return messageService.getUnreadMessage(senderid);
    }

    @RequestMapping(value = "/read",method = RequestMethod.GET)
    @ResponseBody
    public boolean read(String ids){
        System.out.println(ids);

        String[] messageids = ids.split(";");

        boolean flag = false;
        for (String id: messageids){
            if (messageService.readMessage(id)){
                flag = true;
            }
        }
        return flag;
    }
}
