package com.spring.ai.adapters.out.chat;

import com.spring.ai.application.ports.services.ChatServicePort;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.stereotype.Service;

@Service
public class ChatServiceImpl implements ChatServicePort {

    private final ChatModel chatModel;

    public ChatServiceImpl(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    @Override
    public String getResponse(String prompt) {
        return chatModel.call(prompt);
    }

    @Override
    public String getResponseWithOptions(String prompt) {
        Prompt personalizedPrompt = new Prompt(
            prompt,
            OpenAiChatOptions.builder()
                .model("gpt-4o-mini")
                .temperature(0.2)
                .build());

        ChatResponse response = chatModel.call(personalizedPrompt);
        return response.getResult().getOutput().getText();
    }
}
