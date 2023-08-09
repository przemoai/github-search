package com.talan.githubsearch.config.security;

import org.springframework.data.jpa.repository.JpaRepository;

interface UserRepository extends JpaRepository<CustomUser,Long> {
    CustomUser findByUsername(String username);
}
