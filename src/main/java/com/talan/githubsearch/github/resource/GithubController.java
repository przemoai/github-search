package com.talan.githubsearch.github.resource;

import com.talan.githubsearch.github.domain.GithubFacade;
import com.talan.githubsearch.github.dto.GithubUserDetailsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/github/user/")
@RequiredArgsConstructor
class GithubController {

    private final GithubFacade githubFacade;


    @GetMapping(value = "{username}")
    GithubUserDetailsDto getGithubUserByUsername(@PathVariable String username) {
        return githubFacade.getDetailsByUsername(username);
    }
}
