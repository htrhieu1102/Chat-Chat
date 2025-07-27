package chatchat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSockerConfig implements WebSocketMessageBrokerConfigurer{

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // Cấu hình prefix cho nơi client "subscribe" (nhận tin)
        registry.enableSimpleBroker("/topic");

        // Prefix cho nơi client "send" (gửi tin)
        registry.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // Client sẽ kết nối vào địa chỉ này qua SockJS hoặc WebSocket
        registry.addEndpoint("/ws-chat").setAllowedOrigins("*").withSockJS();
    }
    

}
