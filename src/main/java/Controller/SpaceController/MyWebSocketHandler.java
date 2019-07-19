package Controller.SpaceController;


import Entity.Invition;
import Entity.Message;
import Entity.User;
import Service.InvitionService;
import Service.MessageService;
import Service.UserService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import converter.TimeSteamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.*;

import java.sql.Timestamp;
import java.util.*;

@Component
@Controller
public class MyWebSocketHandler implements WebSocketHandler {
    @Autowired
    private MessageService messageService;
    @Autowired
    private InvitionService invitionService;
    @Autowired
    private UserService userService;

    //当wensockethandler类被加载时就会创建该map
    public static final Map<String, WebSocketSession> userSocketSessionMap;
    static {
        userSocketSessionMap=new HashMap<String, WebSocketSession>();
    }


    //握手实现连接后
    @Override
    public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {
        String uid=(String) webSocketSession.getAttributes().get("username");
        System.out.println(webSocketSession.isOpen());
        if (userSocketSessionMap.get(uid)==null){
            userSocketSessionMap.put(uid,webSocketSession);
            //返回未处理的好友请求
            List<Invition> unreadInvition = invitionService.getUnread(uid);
            if (unreadInvition.size() > 0){
                for (Invition invition:unreadInvition){
                    String inviter = invition.getInviter();

                    User user = userService.findById(inviter).get(0);
                    user.setPassword(null);
                    invition.setInviter(JSON.toJSONString(user));
                }
                sendMessageToUser(uid,new TextMessage(JSON.toJSONString(unreadInvition)));
            }

            //返回未读的消息
            List<Message> messages = messageService.getUnreadMessage(uid);
            if (messages.size() > 0){
                sendMessageToUser(uid,new TextMessage(JSON.toJSONString(messages)));
            }
        }
    }

    //发送信息前的处理
    @Override
    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?>webSocketMessage)throws Exception{
        if(webSocketMessage.getPayloadLength()==0)
            return;

        //等到socket通道中的数据并转化成Message
        System.out.println(webSocketMessage.getPayload().toString());
        Type type=JSON.parseObject(webSocketMessage.getPayload().toString(),Type.class);
        if (type.getType().equalsIgnoreCase("message")){
            Message message =JSON.parseObject(type.getMessage(),Message.class);
            System.out.println(JSON.toJSONString(message));
            message.setMessagedate(new Date());
            message.setMessageid(UUID.randomUUID().toString());
            message.setStatus(0);
            messageService.addMessage(message);//存入数据库
            if (message.getReceiverid()!=null){
                if (userSocketSessionMap.get(message.getReceiverid())!=null) {
                    message = messageService.findById(message.getMessageid());
                    sendMessageToUser(message.getReceiverid(), new TextMessage(JSON.toJSONString(message)));
                }
            }
        }else {
            Invition invition =JSON.parseObject(type.getMessage(),Invition.class);
            invitionService.addFriend(invition);//插入数据库
            if (invition.getInvitee()!=null){
                if (userSocketSessionMap.get(invition.getInvitee())!=null) {
                    invition = invitionService.findByOther(invition.getInviter(),invition.getInvitee());
                    invition.setInviter(JSON.toJSONString(userService.findById(invition.getInviter()).get(0)));
                    sendMessageToUser(invition.getInvitee(),new TextMessage(JSON.toJSONString(invition)));
                }
            }

        }

    }

    @Override
    public void handleTransportError(WebSocketSession webSocketSession,Throwable throwable)throws Exception{

    }

    @Override
    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {
        System.out.println("WebSocket:"+webSocketSession.getAttributes().get("username")+"close connection");
        Iterator<Map.Entry<String,WebSocketSession>> iterator = userSocketSessionMap.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String,WebSocketSession> entry = iterator.next();
            if(entry.getValue().getAttributes().get("username")==webSocketSession.getAttributes().get("username")){
                userSocketSessionMap.remove(webSocketSession.getAttributes().get("username"));
                System.out.println("WebSocket in staticMap:" + webSocketSession.getAttributes().get("username") + "removed");
            }
        }
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }


    //发送信息的实现
    public void sendMessageToUser(String uid, TextMessage message)
            throws Exception {
        WebSocketSession session = userSocketSessionMap.get(uid);
        if (session != null && session.isOpen()) {
//            System.out.println(JSON.toJSONString(session));
            System.out.println("发送:"+message);
            session.sendMessage(message);
        }
    }

}
