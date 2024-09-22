package RetoBackend.William.shared;

import RetoBackend.William.domain.model.Message;
import lombok.Getter;

@Getter
public class MessageCreatedEvent {
    private Message message;

    public MessageCreatedEvent(Message message) {
        this.message = message;
    }

}
