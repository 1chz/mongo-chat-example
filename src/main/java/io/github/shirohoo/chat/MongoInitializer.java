package io.github.shirohoo.chat;


import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MongoInitializer {
    private final MongoTemplate mongoTemplate;

    @PostConstruct
    public void init() {
        mongoTemplate.createCollection("chat");

        // @Tailable은 buffer size를 늘려야 동작함
        Document command = new Document();
        command.put("convertToCapped", "chat");
        command.put("size", 100_000);

        mongoTemplate.executeCommand(command);
    }
}
