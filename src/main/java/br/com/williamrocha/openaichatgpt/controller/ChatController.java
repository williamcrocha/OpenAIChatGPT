package br.com.williamrocha.openaichatgpt.controller;

import br.com.williamrocha.openaichatgpt.dto.ChatRequestDTO;
import br.com.williamrocha.openaichatgpt.dto.ChatResponseDTO;
import br.com.williamrocha.openaichatgpt.dto.MessageDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
@Tag(name = "Chat",description = "API for chat with ChatGPT")
@Slf4j
public class ChatController {

    @Qualifier("openAiRestTemplate")
    @Autowired
    private RestTemplate restTemplate;

    @Value("${openai.model}")
    private String model;

    @Value("${openai.url}")
    private String apiUrl;

    @GetMapping("/chat")
    @Operation(summary = "Get an response from ChatGPT")
    public String chat(
            @Parameter(description = "Describe what you want")
            @RequestParam String chat) throws JsonProcessingException {
        ChatRequestDTO request = ChatRequestDTO.builder().model(model)
                .messages(Arrays.asList(
                        MessageDTO.builder()
                                .role(MessageDTO.ROLE_USER)
                                .content(chat)
                                .build()
                ))
                .build();
        ChatResponseDTO response = restTemplate.postForObject(apiUrl, request, ChatResponseDTO.class);
        if (ChatResponseDTO.isValid(response)) {
            return "No response";
        }
        log.debug(new ObjectMapper().writeValueAsString(response));
        return response.getChoices().get(0).getMessage().getContent();
    }
}
