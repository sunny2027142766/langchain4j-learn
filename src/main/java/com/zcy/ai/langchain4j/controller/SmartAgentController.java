package com.zcy.ai.langchain4j.controller;

import com.zcy.ai.langchain4j.assistant.SeparateChatAssistant;
import com.zcy.ai.langchain4j.bean.ChatForm;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@Tag(name = "硅谷小智")
@RestController
@RequestMapping("/agent/xiaozhi")
public class SmartAgentController {

    @Autowired
    public SeparateChatAssistant separateChatAssistant;

    @Operation(summary = "小智智能体")
    @PostMapping(value = "/chat", produces = "text/stream;charset=utf-8")
    public Flux<String> chat(@RequestBody ChatForm form) {
        return separateChatAssistant.agentChat(form.getMemoryId(),form.getMessage());
    }
}
