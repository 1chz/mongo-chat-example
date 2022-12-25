package io.github.shirohoo.chat;


import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;
import reactor.core.publisher.Flux;

public interface ChatRepository extends ReactiveMongoRepository<Chat, String> {
    @Tailable
    Flux<Chat> findBySenderAndReceiver(String sender, String receiver);
}
