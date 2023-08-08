package com.talan.githubsearch.searchhistory.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface SearchHistoryRepository extends JpaRepository<SearchHistoryEntity, Long> {
    Optional<SearchHistoryEntity> findByUsername(String username);
}
