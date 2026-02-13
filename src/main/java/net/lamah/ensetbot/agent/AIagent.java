package net.lamah.ensetbot.agent;

import net.lamah.ensetbot.tools.AITools;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.api.Advisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Flux;



@Component

public class AIagent {

    private ChatClient chatClient;

    public AIagent(ChatClient.Builder builder,
                   ChatMemory memory,
                   AITools tools)  {
        this.chatClient = builder
                .defaultSystem("Vous etes un agent qyui se charge de repondres aux message")
             .defaultAdvisors(
                     MessageChatMemoryAdvisor.builder(memory).build())
                .defaultAdvisors((Advisor) tools)
                .build();
    }
    public Flux<String> askAgent(String query) {
        return chatClient.prompt()
                .user(query)
                .stream().content();
    }


}
