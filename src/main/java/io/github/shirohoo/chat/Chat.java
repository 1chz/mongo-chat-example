package io.github.shirohoo.chat;


import java.time.LocalDateTime;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "chat")
public class Chat {
    @Id private String id;
    private String sender;
    private String receiver;
    private String message;
    private LocalDateTime createdAt = LocalDateTime.now();

    public Chat() {}

    public Chat(String sender, String receiver, String message) {
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
    }
}
