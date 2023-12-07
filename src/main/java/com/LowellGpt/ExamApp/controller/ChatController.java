package com.LowellGpt.ExamApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LowellGpt.ExamApp.service.OpenAIService;

@RestController
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    private OpenAIService openAIService;

    @PostMapping("/ask")
    public String askQuestion(@RequestBody String prompt) {
        return openAIService.queryChatGPT(prompt);
    }
}
