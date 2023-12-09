package com.codefrequencyservice.codefrequencyservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
//mongodb saves classes as documents -- creates in this manner
@Document(collection = "github_codefrequncies")
public class GitHubCodeFrequency {

    @Id
    private String id;

    private int total;

}
