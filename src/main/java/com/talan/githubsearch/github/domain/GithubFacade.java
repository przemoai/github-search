package com.talan.githubsearch.github.domain;


import com.talan.githubsearch.github.dto.GithubUserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


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
                .retrieve().onStatus(HttpStatus::isError, this::handleErrorResponse)
                .bodyToMono(GithubUserResponseDto.class)
                .block();
    }

    private Mono<? extends Throwable> handleErrorResponse(ClientResponse response) {
        return response.bodyToMono(String.class).flatMap(errorBody -> Mono.error(RepositoryNotFoundException::new));
    }
}
