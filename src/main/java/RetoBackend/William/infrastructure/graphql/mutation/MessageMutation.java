package RetoBackend.William.infrastructure.graphql.mutation;

import RetoBackend.William.application.service.MessageService;
import RetoBackend.William.domain.model.Message;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class MessageMutation {

    private final MessageService messageService;

    public MessageMutation(MessageService messageService) {
        this.messageService = messageService;
    }

    @MutationMapping
    public Message createMessage(@Argument @Valid @NotBlank String content) {
        return messageService.createMessage(content);
    }
}