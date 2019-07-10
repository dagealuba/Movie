package Controller.SpaceController;

import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;

public class GetHttpSessionConfigurator extends ServerEndpointConfig.Configurator{
    @Override
    public void modifyHandshake(ServerEndpointConfig config,
                                HandshakeRequest request, HandshakeResponse response) {
        // TODO Auto-generated method stub
        HttpSession httpSession = (HttpSession) request.getHttpSession();
        // ActionContext.getContext().getSession()
        config.getUserProperties().put(HttpSession.class.getName(), httpSession);
    }
}
