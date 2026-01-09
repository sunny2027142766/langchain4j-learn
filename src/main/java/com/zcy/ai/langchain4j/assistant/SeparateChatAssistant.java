package com.zcy.ai.langchain4j.assistant;

import dev.langchain4j.model.openai.OpenAiStreamingChatModel;
import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;
import reactor.core.publisher.Flux;

@AiService(
        wiringMode = AiServiceWiringMode.EXPLICIT,
        streamingChatModel = "openAiStreamingChatModel",
        chatMemoryProvider = "chatMemoryProvider"
//        tools = "calculatorTools"
)
public interface SeparateChatAssistant {
    //    @SystemMessage("用河南话回答,今天是{{current_date_time}}")
    @SystemMessage(fromResource = "prompt.template.txt")
    String chat(@MemoryId int memoryId, @UserMessage String userMessage);

    @UserMessage("你是我河南的好朋友。用河南话回答，增加语气词,{{userMessage}}")
    String chat2(@MemoryId int memoryId, @V("userMessage") String userMessage);

    @SystemMessage(fromResource = "prompt.system.template.txt")
    String chat3(
            @MemoryId int memoryId,
            @UserMessage String userMessage,
            @V("username") String username,
            @V("age") int age
    );

    @SystemMessage(fromResource = "prompt.agent.template.txt")
    Flux<String> agentChat(
            @MemoryId Long memoryId,
            @UserMessage String userMessage
    );
}
