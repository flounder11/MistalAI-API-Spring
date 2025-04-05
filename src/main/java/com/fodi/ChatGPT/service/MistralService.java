package com.fodi.ChatGPT.service;

import com.fodi.ChatGPT.ApiKeys;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.mistralai.MistralAiChatModel;
import dev.langchain4j.model.mistralai.MistralAiChatModelName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MistralService {
    private static final Logger log = LoggerFactory.getLogger(MistralService.class);

    public String generateText(String userQuestion) {
        String rolePrompt = "Ты ассистент, для работы с банковским приложением - ZloyBank, ты должен отвечать в шуточной форме, старайся максимально уйти от ответа и отвечай очень коротко ";
        String request = userQuestion + rolePrompt;

        ChatLanguageModel model = MistralAiChatModel.builder()
                .apiKey(ApiKeys.MISTRALAI_API_KEY)
                .modelName(MistralAiChatModelName.MISTRAL_SMALL_LATEST)
                .build();
        System.out.println(model.generate(request));
        return  model.generate(request);
    }
}
