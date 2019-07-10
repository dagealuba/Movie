package Controller.SpaceController;

import javax.servlet.http.HttpSession;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

@ServerEndpoint(value = "/chat",configurator = GetHttpSessionConfigurator.class)//保证session中要有值，否则无法建立连接，报空指针错误
public class WebSorket {
    private static final String GUEST_PREFIX = "Guest";
    private static final AtomicInteger connectionIds=new AtomicInteger(0);
    private static final Set<WebSorket> connections=new CopyOnWriteArraySet<WebSorket>();

    private String nickname;
    private Session session;
    private static HttpSession httpSession;

    public WebSorket(){
        nickname=GUEST_PREFIX+connectionIds.getAndIncrement();
    }

    //连接成功调用的方法
    @OnOpen
    public void start(Session session, EndpointConfig config){
        this.session=session;
        //获取HTTPSession
        httpSession=(HttpSession)config.getUserProperties().get(HttpSession.class.getName());
        connections.add(this);
        System.out.println(httpSession.getAttribute("name"));
        String message=String.format("* %s %s",nickname,"has joined");
        broadcast(message);
    }

    //连接关闭调用的方法
    @OnClose
    public void end(){
        connections.remove(this);
        String message=String.format("* %s %s",nickname,"has disconnection");
        broadcast(message);
    }

    //监听要发送的内容
    @OnMessage
    public void incoming(String message){
        broadcast(message);
    }

    //发生错误时调用的方法
    @OnError
    public void onError(Throwable t) throws Throwable{
        System.out.println("Chat Error:"+t.toString());
    }

    private static void broadcast(String message) {
        for(WebSorket client:connections){
            try {
                synchronized (client){
                    client.session.getBasicRemote().sendText(message);
                }
            } catch (IOException e) {
                System.out.println("Chat Error: Failed to send message to client");
                connections.remove(client);
                try{
                    client.session.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                String meg=String.format("* %s %s",client.nickname,"has been disconnected.");
                broadcast(meg);
            }
        }
    }

}
