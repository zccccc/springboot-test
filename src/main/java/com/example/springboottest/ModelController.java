package com.example.springboottest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Endpoint that answers "你是什么大模型？" (What large language model are you?)
 */
@RestController
@RequestMapping("/api")
public class ModelController {

    @GetMapping("/model")
    public Map<String, String> getModelInfo() {
        Map<String, String> info = new LinkedHashMap<>();
        info.put("question", "你是什么大模型？");
        info.put("answer", "我是 GitHub Copilot，由 GitHub 和 OpenAI 联合开发的 AI 编程助手。");
        info.put("en_answer", "I am GitHub Copilot, an AI coding assistant developed jointly by GitHub and OpenAI.");
        return info;
    }
}
