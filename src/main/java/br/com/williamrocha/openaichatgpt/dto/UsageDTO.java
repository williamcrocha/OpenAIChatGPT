package br.com.williamrocha.openaichatgpt.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UsageDTO {

    @JsonProperty("prompt_tokens")
    Long promptTokens;
    @JsonProperty("completion_tokens")
    Long completionTokens;
    @JsonProperty("total_tokens")
    Long totalTokens;
}
