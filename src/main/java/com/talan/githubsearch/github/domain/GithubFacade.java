package com.talan.githubsearch.github.domain;


import com.talan.githubsearch.github.dto.GithubUserDetailsDto;
import com.talan.githubsearch.github.dto.GithubUserRepositoryDto;
import com.talan.githubsearch.searchhistory.domain.SearchHistoryFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


@Service
@RequiredArgsConstructor
@Slf4j
public class GithubFacade {

    private final WebClient.Builder webClientBuilder;
    private final SearchHistoryFacade searchHistoryFacade;
    private static final String API_URL = "https://api.github.com/users";

    public GithubUserDetailsDto getDetailsByUsername(String username) {

        GithubUserDetailsDto response = webClientBuilder.build().get()
                .uri(API_URL, uriBuilder -> uriBuilder
                        .path("/{username}")
                        .build(username)
                )
                .accept(MediaType.APPLICATION_JSON)
                .retrieve().onStatus(HttpStatus::isError, this::handleErrorResponse)
                .bodyToMono(GithubUserDetailsDto.class)
                .block();

        if(Objects.nonNull(response)){
           searchHistoryFacade.addToHistory(response);

            response.setRepos(getUserRepos(username));
            response.setRepoSize(calculateRepoSize(response.getRepos()));
        }

        return response;
    }

    private int calculateRepoSize(List<GithubUserRepositoryDto> repos) {
        return repos.stream().mapToInt(GithubUserRepositoryDto::getSize).sum();
    }

    private List<GithubUserRepositoryDto> getUserRepos(String username) {
        GithubUserRepositoryDto[] response = webClientBuilder.build().get()
                .uri(API_URL, uriBuilder -> uriBuilder
                        .path("/{username}/repos")
                        .queryParam("per_page",100)
                        .queryParam("sort","created")
                        .queryParam("direction","desc")
                        .build(username))
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(GithubUserRepositoryDto[].class)
                .block();
        if (Objects.isNull(response)) {
            return Collections.emptyList();
        }

        return Arrays.stream(response).toList();
    }

    private Mono<? extends Throwable> handleErrorResponse(ClientResponse response) {
        return response.bodyToMono(String.class).flatMap(errorBody -> Mono.error(UserNotFoundException::new));
    }
}
