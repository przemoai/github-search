package com.talan.githubsearch.github;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;


@Getter
@Setter
@Entity
class GithubDetails {
    @Id
    private Long id;
    private String username;
    private String profileUrl;

}
