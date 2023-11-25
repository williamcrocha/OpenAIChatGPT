package br.com.williamrocha.openaichatgpt.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class OpenAiRestTemplateConfiguration {

    @Value("${openai.key}")
    private String opeanAiKey;

    @Bean
    @Qualifier("openAiRestTemplate")
    public RestTemplate openAiRestTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add((request, body, execution) -> {
            request.getHeaders().add("Authorization", "Bearer " + opeanAiKey);
            return execution.execute(request, body);
        });
        return restTemplate;
    }
}
