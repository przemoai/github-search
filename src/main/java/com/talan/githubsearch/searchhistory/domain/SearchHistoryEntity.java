package com.talan.githubsearch.searchhistory.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.Instant;

@Entity(name = "search_history")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
class SearchHistoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String avatar;
    private Instant visitedAt;
}
