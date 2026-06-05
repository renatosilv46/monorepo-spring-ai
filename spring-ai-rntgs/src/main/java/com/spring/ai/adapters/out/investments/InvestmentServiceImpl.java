package com.spring.ai.adapters.out.investments;

import com.spring.ai.adapters.in.dtos.InvestmentResponse;
import com.spring.ai.adapters.out.helper.HtmlHelper;
import com.spring.ai.application.ports.services.InvestmentServicePort;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;

@Service
public class InvestmentServiceImpl implements InvestmentServicePort {

    private final ChatModel chatModel;
    private final PromptTemplateConfigure promptTemplateConfigure;

    public InvestmentServiceImpl(ChatModel chatModel,
                                 PromptTemplateConfigure promptTemplateConfigure) {
        this.chatModel = chatModel;
        this.promptTemplateConfigure = promptTemplateConfigure;
    }

    @Override
    public InvestmentResponse createInvestmentPlan(String value, String profile, String period) {

        final String promptTemplate = String.format(
                promptTemplateConfigure.getCreateInvestmentsPlan(),
                period,
                profile,
                value);

        final Prompt promptPrepared = new Prompt(promptTemplate);
        final ChatResponse response = chatModel.call(promptPrepared);

        if(response.getResult().getOutput().getText() == null ||
            response.getResult().getOutput().getText().isEmpty()) {
            throw new RuntimeException("Failed to generate investment plan.");
        }

        final UUID operationId = UUID.randomUUID();
        final Timestamp timestamp = Timestamp.from(Instant.now());
        final String planPayloadHtml = HtmlHelper.parseMarkdownToHtml(response.getResult().getOutput().getText());

        return new InvestmentResponse(operationId, planPayloadHtml, timestamp);
    }
}
