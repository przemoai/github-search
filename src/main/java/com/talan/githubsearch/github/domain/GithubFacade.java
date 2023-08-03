package com.talan.githubsearch.github.domain;


import com.talan.githubsearch.github.dto.GithubUserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class GithubFacade {
    private final GithubRepository githubRepository;
    private final WebClient.Builder webClientBuilder;

    public GithubUserResponseDto getUserName(String username) {

        return webClientBuilder.build().get()
                .uri("https://api.github.com/users", uriBuilder -> uriBuilder
                        .path("/{username}")
                        .build(username))
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(GithubUserResponseDto.class)
                .block();
    }
}
