package com.talan.githubsearch.github.domain;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
class GithubRepositoryExceptionHandler {

    private static final String REPOSITORY_NOT_FOUND_MESSAGE = "Repository not found";
    private static final String ILLEGAL_ARGUMENT_MESSAGE = "Illegal argument passed";

    @ExceptionHandler(RepositoryNotFoundException.class)
    public ResponseEntity<String> handleRepositoryNotFoundException() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(REPOSITORY_NOT_FOUND_MESSAGE);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ILLEGAL_ARGUMENT_MESSAGE);
    }
}

