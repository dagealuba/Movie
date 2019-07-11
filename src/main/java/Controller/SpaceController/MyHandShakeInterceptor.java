package Controller.SpaceController;

import Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import javax.servlet.Servlet;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class MyHandShakeInterceptor implements HandshakeInterceptor {
    public boolean beforeHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Map<String,Object> map)throws Exception{
        System.out.println("用户ID："+((ServletServerHttpRequest) serverHttpRequest).getServletRequest().getSession(false).getAttribute("user")+"已建立连接");
        if (serverHttpRequest instanceof ServletServerHttpRequest){
            ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) serverHttpRequest;
            HttpSession session =servletRequest.getServletRequest().getSession(false);
            //标记用户
            User user =(User) session.getAttribute("user");
            if (user!=null){
                map.put("userId",user.getUserid());
                System.out.println("用户ID："+user.getUserid()+"加入");
            }else {
                System.out.println("user为空");
                return false;
            }

        }
        return true;
    }
    public void afterHandshake(ServerHttpRequest serverHttpRequest,ServerHttpResponse serverHttpResponse,WebSocketHandler webSocketHandler,Exception e){

    }
}