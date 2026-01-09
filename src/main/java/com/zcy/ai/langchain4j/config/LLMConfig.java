package com.zcy.ai.langchain4j.config;

import dev.langchain4j.model.chat.StreamingChatLanguageModel;
import dev.langchain4j.model.openai.OpenAiStreamingChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LLMConfig {

    @Bean("openAiStreamingChatModel")
    public StreamingChatLanguageModel openAiStreamingChatModel() {
        return OpenAiStreamingChatModel
                .builder()
                .baseUrl("http://192.168.13.111:9997/v1")
                .apiKey("gpustack_e9cbbe10f4db5925_3dd7624bd0cd30deedb550d0c82d1fc1")
                .modelName("Qwen3-Instruct")
                .build();
    }
}
