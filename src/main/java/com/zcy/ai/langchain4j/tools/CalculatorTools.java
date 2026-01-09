package com.zcy.ai.langchain4j.tools;

import dev.langchain4j.agent.tool.P;
import dev.langchain4j.agent.tool.Tool;
import dev.langchain4j.agent.tool.ToolMemoryId;
import org.springframework.stereotype.Component;

@Component
public class CalculatorTools {

    @Tool(name = "加法", value = "返回两个参数相加之和")
    double sum(
            @ToolMemoryId long memoryId,
            @P(value = "加数1", required = true) double a,
            @P(value = "加数2", required = true) double b
    ) {
        System.out.println("调用加法运算" + memoryId);
        return a + b;
    }

    @Tool(name = "平方根", value = "返回给定参数的平方根")
    double squareRoot(@ToolMemoryId long memoryId, double a) {
        System.out.println("调用平方根运算" + memoryId);
        return Math.sqrt(a);
    }
}
