package com.talan.githubsearch.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
class SecurityConfig {

    private final UserRepository userRepository;
    private final CustomOAuth2UserService customOAuth2UserService;
    private static final String[] ANGULAR_UI_RESOURCES = {"/index.html", "/static/**", "/3rdpartylicenses.txt", "/favicon.ico", "/main.*.js", "/polyfills.*.js", "/runtime.*.js", "/styles.*.css", "/assets/**"};
    private static final String[] ALLOWED_API_ENDPOINTS = {"/api/v1/user"};
    private static final String[] ALLOWED_UI_VIEWS = {"/", "/auth/**"};

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .csrf()
                .disable()
                .authorizeHttpRequests().antMatchers(ALLOWED_UI_VIEWS).permitAll().antMatchers(ALLOWED_API_ENDPOINTS).permitAll().antMatchers(ANGULAR_UI_RESOURCES).permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .logout()
                .logoutSuccessUrl("/auth/login")
                .deleteCookies("JSESSIONID")
                .and()
                .oauth2Login()
                    .defaultSuccessUrl("/github")
                    .userInfoEndpoint()
                    .userService(customOAuth2UserService);
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsService(userRepository);
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOriginPatterns(List.of("*"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
