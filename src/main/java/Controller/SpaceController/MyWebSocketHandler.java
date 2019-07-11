package Controller.SpaceController;


import Entity.Message;
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
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Component
@Controller
public class MyWebSocketHandler implements WebSocketHandler {
    @Autowired
    private MessageService messageService;
    //当wensockethandler类被加载时就会创建该map
    public static final Map<String, WebSocketSession> userSocketSessionMap;
    static {
        userSocketSessionMap=new HashMap<String, WebSocketSession>();
    }


    //握手实现连接后
    @Override
    public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {
        String uid=(String) webSocketSession.getAttributes().get("uid");
        if (userSocketSessionMap.get(uid)==null){
            userSocketSessionMap.put(uid,webSocketSession);
        }
    }

    //发送信息前的处理
    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?>webSocketMessage)throws Exception{
        if(webSocketMessage.getPayloadLength()==0)
            return;

        //等到socket通道中的数据并转化成Message
        Message msg=JSON.parseObject(webSocketMessage.getPayload().toString(),Message.class);

        Date now =new Date(System.currentTimeMillis());
        msg.setMessagedate(now);
        //信息存入数据库
        messageService.addMessage(msg);
        //发送socket信息
        sendMessageToUser(msg.getReceiverid(),new TextMessage(JSON.toJSONString(msg)));
    }
    public void handleTransportError(WebSocketSession webSocketSession,Throwable throwable)throws Exception{

    }

    @Override
    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {
        System.out.println("WebSocket:"+webSocketSession.getAttributes().get("uid")+"close connection");
        Iterator<Map.Entry<String,WebSocketSession>> iterator = userSocketSessionMap.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String,WebSocketSession> entry = iterator.next();
            if(entry.getValue().getAttributes().get("uid")==webSocketSession.getAttributes().get("uid")){
                userSocketSessionMap.remove(webSocketSession.getAttributes().get("uid"));
                System.out.println("WebSocket in staticMap:" + webSocketSession.getAttributes().get("uid") + "removed");
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
            session.sendMessage(message);
        }
    }

}
