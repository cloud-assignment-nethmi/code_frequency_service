package com.codefrequencyservice.codefrequencyservice.controller;

import com.codefrequencyservice.codefrequencyservice.model.GitHubCodeFrequency;
import com.codefrequencyservice.codefrequencyservice.service.CodeFrequencyService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/git-hub")
public class CodeFrequencyController {
    //GitHubCommitService interface in service package
    private CodeFrequencyService gitHubCodeFrequencyService;

    @GetMapping("/codefrequencies")
    public ResponseEntity<List<GitHubCodeFrequency>> getGitHubCodeFrequncies() {
        return ResponseEntity.ok(this.gitHubCodeFrequencyService.getGitHubCodeFrequencies());
    }

    @GetMapping("/codefrequencies/get-all")
    public ResponseEntity<List<GitHubCodeFrequency>> getAllCodeFrequencies() {
        return ResponseEntity.ok(this.gitHubCodeFrequencyService.getAllCodeFrequencies());
    }

}
