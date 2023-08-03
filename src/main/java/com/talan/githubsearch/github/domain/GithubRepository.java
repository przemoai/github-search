package com.talan.githubsearch.github.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface GithubRepository extends JpaRepository<GithubDetails, Long> {
}
