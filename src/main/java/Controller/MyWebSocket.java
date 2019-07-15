//package Controller;
//
//import Entity.Message;
//
//import javax.websocket.*;
//import javax.websocket.server.ServerEndpoint;
//import java.io.IOException;
//import java.util.UUID;
//import java.util.concurrent.CopyOnWriteArraySet;
//
//@ServerEndpoint(value = "/websocket")
//public class MyWebSocket {
//
//    //记录当前在线连接数，设置为线程安全
//    private static int onlineCount=0;
//
//    //存放客户端每个websocket对象
//    private static CopyOnWriteArraySet<MyWebSocket> WebSocketSet=new CopyOnWriteArraySet<>();
//
//    public void sendMessage(String message) throws IOException{
//        this.session.getBasicRemote().sendText(message);
//    }
//
//    public static synchronized int getOnlineCount(){
//        return onlineCount;
//    }
//
//    public static synchronized void addOnlineCount(){
//        MyWebSocket.onlineCount++;
//    }
//
//    public static synchronized void subOnlineCount(){
//        MyWebSocket.onlineCount--;
//    }
//
//    //向客户端发送会话时通过Session向客户端发送数据
//    private Session session;
//
//    @OnOpen
//    public void onOPen(Session session){
//        this.session=session;
//        WebSocketSet.add(this);
//        addOnlineCount();
//        System.out.println("有新连接加入,当前人数为："+MyWebSocket.getOnlineCount());
//    }
//
//    @OnClose
//    public void onClose(){
//        WebSocketSet.remove(this);
//        subOnlineCount();
//        System.out.println("连接退出，当前人数为："+MyWebSocket.getOnlineCount());
//    }
//
//    @OnMessage
//    public void onMessage(String message,Session session){
//        System.out.println("来自客户端的消息："+message);
//        //群发消息
//        Message message1=new Message();
//        message1.setMessageid(UUID.randomUUID().toString());
//
//        for(MyWebSocket item:WebSocketSet){
//            try{
//                item.sendMessage(message);
//            } catch (IOException e) {
//                e.printStackTrace();
//                continue;
//            }
//        }
//    }
//
//    @OnError
//    public void onError(Session session,Throwable error){
//        System.out.println("发生错误");
//        error.printStackTrace();
//    }
//
//}
