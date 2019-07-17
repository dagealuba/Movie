package Controller.SpaceController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;


@Component
@EnableWebSocket
public class MyWbeSocketConfig extends WebMvcConfigurerAdapter implements WebSocketConfigurer {
    @Autowired
    MyWebSocketHandler handler;

    private static final String LINK_URI="/ws";
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry){
        //添加websocket处理器，添加握手拦截器
        webSocketHandlerRegistry.addHandler(handler,LINK_URI).addInterceptors(new MyHandShakeInterceptor()).setAllowedOrigins("*");
        //添加websocket处理器，添加握手拦截器
        webSocketHandlerRegistry.addHandler(handler,"/wa/sockjs").addInterceptors(new MyHandShakeInterceptor()).withSockJS();

    }
}
