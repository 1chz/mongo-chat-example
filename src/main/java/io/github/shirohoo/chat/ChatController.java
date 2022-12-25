package io.github.shirohoo.chat;


import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RestController
@RequiredArgsConstructor
public class ChatController {
    private final ChatRepository chatRepository;

    @GetMapping(
            value = "/chat/sender/{sender}/receiver/{receiver}",
            produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Chat> getMessage(@PathVariable String sender, @PathVariable String receiver) {
        return chatRepository
                .findBySenderAndReceiver(sender, receiver)
                .subscribeOn(Schedulers.boundedElastic());
    }

    @PostMapping("/chat")
    public Mono<Chat> putMessage(@RequestBody Chat chat) {
        return chatRepository.save(chat);
    }
}
