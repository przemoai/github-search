package com.talan.githubsearch.github.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class GithubUserResponseDto {
    @JsonAlias(value = "login")
    String username;
    @JsonAlias(value = "avatar_url")
    String avatar;
    @JsonAlias(value = "url")
    String url;
    @JsonAlias(value = "created_at")
    Instant createdAt;
}