package com.codefrequencyservice.codefrequencyservice.service;

import com.codefrequencyservice.codefrequencyservice.dto.GitHubCodeFrequencyDto;
import com.codefrequencyservice.codefrequencyservice.model.GitHubCodeFrequency;
import com.codefrequencyservice.codefrequencyservice.repository.GitHubCodeFrequencyRepository;
import com.codefrequencyservice.codefrequencyservice.service.external.GitHubExternalClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CodeFrequencyServiceImpl implements CodeFrequencyService {

    private final GitHubExternalClient githubExternalClient;
    private final GitHubCodeFrequencyRepository gitHubCodeFrequencyRepository;

    @Override
    public List<GitHubCodeFrequency> getGitHubCodeFrequencies() {
        List<GitHubCodeFrequency> gitHubCodeFrequencies = new ArrayList<>();

        List<GitHubCodeFrequencyDto> gitHubCodeFrequencyDtoList = this.githubExternalClient.getCodeFrequencyDetails();
        gitHubCodeFrequencyDtoList.forEach(gitHubCodeFrequencyDto -> {
            GitHubCodeFrequency gitHubCodeFrequency = this.generateGitHubCodeFrequencyObject(gitHubCodeFrequencyDto);
            gitHubCodeFrequencies.add(gitHubCodeFrequency);
        });

        this.gitHubCodeFrequencyRepository.saveAll(gitHubCodeFrequencies);

        return gitHubCodeFrequencies;
    }

    @Override
    public List<GitHubCodeFrequency> getAllCodeFrequencies() {
        return this.gitHubCodeFrequencyRepository.findAll();
    }

    private GitHubCodeFrequency generateGitHubCodeFrequencyObject(GitHubCodeFrequencyDto gitHubCodeFrequencyDto) {
        return GitHubCodeFrequency.builder()
                .total(gitHubCodeFrequencyDto.getTotal())
                .build();
    }
}
