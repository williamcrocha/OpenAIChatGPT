package br.com.williamrocha.openaichatgpt.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ChatResponseDTO {
    String id;
    String object;
    Date created;
    List<ChoiceDTO> choices;
    UsageDTO usage;

    public static boolean isValid(ChatResponseDTO response){
        return response == null || response.getChoices() == null || response.getChoices().isEmpty();
    }
}
