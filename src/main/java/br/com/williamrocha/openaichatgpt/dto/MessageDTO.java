package br.com.williamrocha.openaichatgpt.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class MessageDTO {
    public static final String ROLE_USER = "user";

    private String role;
    private String content;
}
