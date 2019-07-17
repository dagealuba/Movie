package Controller.SpaceController;

import Entity.User;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import javax.servlet.Servlet;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@Component
public class MyHandShakeInterceptor implements HandshakeInterceptor {
    @Override
    public boolean beforeHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Map<String,Object> map)throws Exception{
        System.out.println("用户ID："+((ServletServerHttpRequest) serverHttpRequest).getServletRequest().getSession(false).getAttribute("username")+"已建立连接");
        if (serverHttpRequest instanceof ServletServerHttpRequest){
            ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) serverHttpRequest;
            HttpSession session =servletRequest.getServletRequest().getSession(false);
            System.out.println(JSON.toJSONString(session));
            //标记用户
            String user =(String) session.getAttribute("username");
            if (user!=null){
                map.put("username",user);
                System.out.println("用户ID："+map.get("username")+"加入");
            }else {
                System.out.println("user为空");
                return false;
            }

        }
        return true;
    }
    @Override
    public void afterHandshake(ServerHttpRequest serverHttpRequest,ServerHttpResponse serverHttpResponse,WebSocketHandler webSocketHandler,Exception e){

    }
}
