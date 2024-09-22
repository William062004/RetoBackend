package RetoBackend.William.application.service;

import RetoBackend.William.domain.model.Message;
import RetoBackend.William.domain.repository.MessageRepository;
import RetoBackend.William.infrastructure.graphql.subscription.MessageSubscription;
import RetoBackend.William.shared.MessageCreatedEvent;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MessageService {

    private final MessageRepository messageRepository;
    private final MessageSubscription messageSubscription;

    public MessageService(MessageRepository messageRepository, MessageSubscription messageSubscription) {
        this.messageRepository = messageRepository;
        this.messageSubscription = messageSubscription;
    }

    public Message createMessage(@Valid @NotBlank String content) {
        Message message = new Message(UUID.randomUUID().toString(), content);
        System.out.println("Creating message: " + message.getId() + ", " + message.getContent());
        messageRepository.save(message);
        messageSubscription.publishEvent(new MessageCreatedEvent(message));
        return message;
    }

}