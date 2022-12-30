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
        increaseBufferSize("chat", 8_192)
    }
    
    // @Tailable works only when the buffer size is increased
    private void increaseBufferSize(String collection, int bufferSize) {
        Document command = new Document();
        command.put("convertToCapped", collection);
        command.put("size", bufferSize);
        mongoTemplate.executeCommand(command);
    }
}
