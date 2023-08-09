package com.talan.githubsearch.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
class UserController {

    private final CustomUserDetailsService customUserDetailsService;

    @GetMapping(value = "/api/v1/user")
    LoggedUser getCurrentUser() {
        return customUserDetailsService.getCurrentUser();
    }
}
