package com.talan.githubsearch.github;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/github")
@RequiredArgsConstructor
class GithubController {

    private final GithubFacade githubFacade;


    @GetMapping(value = "{username}")
    String getGithubUserByUsername(@PathVariable String username) {
        return githubFacade.getUserName(username);
    }
}
