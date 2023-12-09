package com.codefrequencyservice.codefrequencyservice.service.external;

import com.codefrequencyservice.codefrequencyservice.dto.GitHubCodeFrequencyDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@Slf4j
public class GitHubExternalClient {

    private final RestTemplate restTemplate;

    @Value("${github.codefrequency-detail-url}")
    private String gitHubCodeFrequencyDetailsUrl;

    public GitHubExternalClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<GitHubCodeFrequencyDto> getCodeFrequencyDetails() {
        ResponseEntity<List<GitHubCodeFrequencyDto>> response = restTemplate.exchange(gitHubCodeFrequencyDetailsUrl, HttpMethod.GET, null, new ParameterizedTypeReference<>() {
        });
        return response.getBody();
    }
}
