package br.com.williamrocha.openaichatgpt.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class ChatRequestDTO {

    private String model;
    private List<MessageDTO> messages;

}
