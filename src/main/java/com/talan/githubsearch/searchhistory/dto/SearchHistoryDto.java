package com.talan.githubsearch.searchhistory.dto;

import java.time.Instant;

public record SearchHistoryDto(
        String username,
        String avatar,
        Instant visitedAt) {
}
