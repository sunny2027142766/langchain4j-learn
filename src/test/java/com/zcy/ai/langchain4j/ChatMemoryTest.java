package com.zcy.ai.langchain4j;

import com.zcy.ai.langchain4j.assistant.Assistant;
import com.zcy.ai.langchain4j.assistant.MemoryChatAssistant;
import com.zcy.ai.langchain4j.assistant.SeparateChatAssistant;
import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.response.ChatResponse;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
public class ChatMemoryTest {
    @Autowired
    private Assistant assistant;

    @Test
    public void testChatMemory() {
        String answer1 = assistant.chat("我是张草原");
        System.out.println(answer1);

        String answer2 = assistant.chat("我是谁？");
        System.out.println(answer2);
    }


    @Autowired
    private OpenAiChatModel openAiChatModel;

    @Test
    public void testChatMemory2() {
        UserMessage userMessage = UserMessage.userMessage("我是张草原");
        ChatResponse chatResponse = openAiChatModel.chat(userMessage);
        AiMessage aiMessage = chatResponse.aiMessage();
        System.out.println(aiMessage.text());

        UserMessage userMessage2 = UserMessage.userMessage("你知道我是谁吗？");
        ChatResponse chatResponse2 = openAiChatModel.chat(Arrays.asList(userMessage, aiMessage, userMessage2));
        AiMessage aiMessage2 = chatResponse2.aiMessage();
        System.out.println(aiMessage2.text());
    }

    @Test
    public void testChatMemory3() {
        MessageWindowChatMemory chatMemory = MessageWindowChatMemory.withMaxMessages(10);

        Assistant assistant = AiServices
                .builder(Assistant.class)
                .chatLanguageModel(openAiChatModel)
                .chatMemory(chatMemory)
                .build();
        String message1 = assistant.chat("我是张草原");
        System.out.println(message1);
        String message2 = assistant.chat("我是谁?");
        System.out.println(message2);
    }

    @Autowired
    private MemoryChatAssistant memoryChatAssistant;

    @Test
    public void testChatMemory4() {
        String message1 = memoryChatAssistant.chat("我是张草原");
        System.out.println(message1);
        String message2 = memoryChatAssistant.chat("我是谁?");
        System.out.println(message2);
    }

    @Autowired
    private SeparateChatAssistant separateChatAssistant;

    @Test
    public void testChatMemory5() {
        String message1 = separateChatAssistant.chat(1,"我是张草原");
        System.out.println(message1);

        String message2 = separateChatAssistant.chat(1,"我是谁?");
        System.out.println(message2);

        String message3 = separateChatAssistant.chat(2,"我是谁?");
        System.out.println(message3);
    }

    @Autowired
    private SeparateChatAssistant separateChatAssistant2;

    @Test
    public void testChatMemory6() {
        String message1 = separateChatAssistant2.chat(1,"气象GIS场景展示");
        System.out.println(message1);
    }
}
