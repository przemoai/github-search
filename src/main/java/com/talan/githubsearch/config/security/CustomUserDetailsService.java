package com.talan.githubsearch.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CustomUser user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("CustomUser not found: " + username);
        }
        return new User(
                user.getUsername(),
                user.getPassword(),
                true,
                true,
                true,
                true, // Add necessary authorities/roles
                Collections.emptyList()
        );
    }

    LoggedUser getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication instanceof AnonymousAuthenticationToken principal) {

            return new LoggedUser(principal.getName(), false);
        }

        OAuth2AuthenticationToken principal = (OAuth2AuthenticationToken) authentication;


        return new LoggedUser(principal.getPrincipal().getAttribute("login"), true);
    }
}