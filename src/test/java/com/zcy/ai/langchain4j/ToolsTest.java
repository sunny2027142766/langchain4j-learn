package com.zcy.ai.langchain4j;

import com.zcy.ai.langchain4j.assistant.SeparateChatAssistant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ToolsTest {

    @Autowired
    private SeparateChatAssistant separateChatAssistant;

    @Test
    public void testCalculatorTools(){
        String answer = separateChatAssistant.chat(6,"1+2等于几？4的平方根是几？");
        System.out.println(answer);
    }
}
