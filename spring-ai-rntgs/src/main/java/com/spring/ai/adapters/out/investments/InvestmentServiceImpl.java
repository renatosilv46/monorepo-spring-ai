package com.spring.ai.adapters.out.investments;

import com.spring.ai.adapters.in.dtos.CreateInvestmentPlanResponse;
import com.spring.ai.adapters.out.helper.HtmlHelper;
import com.spring.ai.application.ports.out.InvestmentServicePort;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

@Service
public class InvestmentServiceImpl implements InvestmentServicePort {

    private final ChatModel chatModel;
    private final MessageSource messageSource;
    private final static String TEMPLATE_PATH = "investments_plan";

    public InvestmentServiceImpl(ChatModel chatModel, MessageSource messageSource) {
        this.chatModel = chatModel;
        this.messageSource = messageSource;
    }

    @Override
    public CreateInvestmentPlanResponse createInvestmentPlan(String value, String profile, String period) {

        final String template = messageSource.getMessage(
                TEMPLATE_PATH,
                null,
                LocaleContextHolder.getLocale());

        final String promptTemplate = String.format(
                template,
                period,
                profile,
                value);

        final Prompt promptPrepared = new Prompt(promptTemplate);
        final ChatResponse response = chatModel.call(promptPrepared);

        if(response.getResult().getOutput().getText() == null ||
            response.getResult().getOutput().getText().isEmpty()) {
            throw new RuntimeException("Failed to generate investment plan.");
        }

        return new CreateInvestmentPlanResponse(
                HtmlHelper.parseMarkdownToHtml(response.getResult().getOutput().getText()));
    }
}
