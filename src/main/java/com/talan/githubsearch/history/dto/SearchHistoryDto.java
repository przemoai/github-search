package com.talan.githubsearch.history.dto;

import java.time.Instant;

public record SearchHistoryDto(
        String username,
        String avatar,
        Instant visitedAt) {
}
