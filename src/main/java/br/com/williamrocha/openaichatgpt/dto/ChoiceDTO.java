package br.com.williamrocha.openaichatgpt.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ChoiceDTO {
    private Long index;
    private MessageDTO message;
    @JsonProperty("finish_reason")
    private String finishReason;
}
