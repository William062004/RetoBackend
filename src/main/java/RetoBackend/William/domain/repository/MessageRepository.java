package RetoBackend.William.domain.repository;

import RetoBackend.William.domain.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, String> {

}