package RetoBackend.William.infrastructure.graphql.subscription;

import RetoBackend.William.domain.model.Message;
import RetoBackend.William.shared.MessageCreatedEvent;
import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

@Controller
public class MessageSubscription {

    private final Sinks.Many<MessageCreatedEvent> sink = Sinks.many().multicast().onBackpressureBuffer();

    @SubscriptionMapping
    public Flux<Message> messageCreated() {

        return sink.asFlux().map(MessageCreatedEvent::getMessage);
    }

    public void publishEvent(MessageCreatedEvent event) {
        sink.tryEmitNext(event);
    }
}
