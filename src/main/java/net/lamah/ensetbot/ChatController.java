package net.lamah.ensetbot;

import net.lamah.ensetbot.agent.AIagent;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController

public class ChatController {
    private AIagent aIagent;


    public ChatController(AIagent aIagent) {
        this.aIagent = aIagent;
    }
    @GetMapping("/chat")
    public Flux<String> chat(String query){
        return aIagent.askAgent(query);
    }
}
