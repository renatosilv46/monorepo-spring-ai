package com.spring.ai.adapters.in;

import com.spring.ai.application.ports.out.ChatServicePort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/generate")
public class GenerativeAIController {

    private final ChatServicePort chatServicePort;

    public GenerativeAIController(ChatServicePort chatServicePort) {
        this.chatServicePort = chatServicePort;
    }

    @GetMapping("/standard")
    public String getResponse(@RequestParam String prompt) {
        return chatServicePort.getResponse(prompt);
    }

    @GetMapping("/personalized")
    public String getResponseWithOptions(@RequestParam String prompt) {
        return chatServicePort.getResponseWithOptions(prompt);
    }
}
