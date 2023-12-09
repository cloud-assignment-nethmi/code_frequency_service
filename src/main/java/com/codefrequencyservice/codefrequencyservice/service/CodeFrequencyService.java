package com.codefrequencyservice.codefrequencyservice.service;

import com.codefrequencyservice.codefrequencyservice.model.GitHubCodeFrequency;

import java.util.List;

public interface CodeFrequencyService {

    List<GitHubCodeFrequency> getGitHubCodeFrequencies();

    List<GitHubCodeFrequency> getAllCodeFrequencies();
}

