package com.talan.githubsearch.github.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GithubUserRepositoryDto {
    @JsonAlias(value = "name")
    private String name;
    @JsonAlias(value = "description")
    private String description;
    @JsonAlias(value = "language")
    private String language;
    @JsonAlias(value = "html_url")
    private String htmlUrl;
    @JsonAlias(value = "ssh_url")
    private String sshUrl;
    @JsonAlias(value = "clone_url")
    private String cloneUrl;
    @JsonAlias(value = "size")
    private int size;
}
