package RetoBackend.William.infrastructure.graphql.query;

import RetoBackend.William.domain.model.Message;
import RetoBackend.William.domain.repository.MessageRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class MessageQuery {

    private final MessageRepository messageRepository;

    public MessageQuery(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @QueryMapping
    public Message getMessage(@Argument String id) {
        return messageRepository.findById(id).orElse(null);
    }

    @QueryMapping
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }
}