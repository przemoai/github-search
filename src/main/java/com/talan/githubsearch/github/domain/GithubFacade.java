package com.talan.githubsearch.github.domain;


import com.talan.githubsearch.github.dto.GithubUserResponseDto;
import com.talan.githubsearch.searchhistory.domain.SearchHistoryFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Objects;


@Service
@RequiredArgsConstructor
@Slf4j
public class GithubFacade {
    private final GithubRepository githubRepository;
    private final WebClient.Builder webClientBuilder;
private final SearchHistoryFacade searchHistoryFacade;
    public GithubUserResponseDto getUserName(String username) {

        GithubUserResponseDto response = webClientBuilder.build().get()
                .uri("https://api.github.com/users", uriBuilder -> uriBuilder
                        .path("/{username}")
                        .build(username))
                .accept(MediaType.APPLICATION_JSON)
                .retrieve().onStatus(HttpStatus::isError, this::handleErrorResponse)
                .bodyToMono(GithubUserResponseDto.class)
                .block();

        if(Objects.nonNull(response)){
           var x = searchHistoryFacade.addToHistory(response);
           log.info(x.username());
        }
        return response;
    }

    private Mono<? extends Throwable> handleErrorResponse(ClientResponse response) {
        return response.bodyToMono(String.class).flatMap(errorBody -> Mono.error(RepositoryNotFoundException::new));
    }
}
