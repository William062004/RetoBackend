package RetoBackend.William.infrastructure.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.server.webmvc.GraphQlWebSocketHandler;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    private final GraphQlWebSocketHandler graphQlWebSocketHandler;

    public WebSocketConfig(GraphQlWebSocketHandler graphQlWebSocketHandler) {
        this.graphQlWebSocketHandler = graphQlWebSocketHandler;
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
            registry.addHandler(graphQlWebSocketHandler, "/graphql")
                    .setAllowedOriginPatterns("*");

    }
}

