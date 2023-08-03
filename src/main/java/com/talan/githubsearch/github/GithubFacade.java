package com.talan.githubsearch.github;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GithubFacade {
    private final GithubRepository githubRepository;

    String getUserName(String username) {
        return username;
    }
}
