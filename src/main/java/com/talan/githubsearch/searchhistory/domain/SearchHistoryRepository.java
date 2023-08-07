package com.talan.githubsearch.searchhistory.domain;

import org.springframework.data.jpa.repository.JpaRepository;

interface SearchHistoryRepository extends JpaRepository<SearchHistoryEntity, Long> {
}
