package com.codefrequencyservice.codefrequencyservice.repository;

import com.codefrequencyservice.codefrequencyservice.model.GitHubCodeFrequency;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GitHubCodeFrequencyRepository extends MongoRepository<GitHubCodeFrequency, String> {
}
