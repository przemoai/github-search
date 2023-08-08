package com.talan.githubsearch.github.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
public class GithubUserDetailsDto {
    @JsonAlias(value = "login")
    String username;
    @JsonAlias(value = "avatar_url")
    String avatar;
    @JsonAlias(value = "html_url")
    String url;
    @JsonAlias(value = "created_at")
    Instant createdAt;
    List<GithubUserRepositoryDto> repos;
}