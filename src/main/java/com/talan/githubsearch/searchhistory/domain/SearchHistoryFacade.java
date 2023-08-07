package com.talan.githubsearch.searchhistory.domain;

import com.talan.githubsearch.github.dto.GithubUserResponseDto;
import com.talan.githubsearch.searchhistory.dto.SearchHistoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchHistoryFacade {

    private final SearchHistoryRepository searchHistoryRepository;
    private final SearchHistoryMapper searchHistoryMapper;

    public List<SearchHistoryDto> getSearchHistory() {
        return searchHistoryMapper.toDto(searchHistoryRepository.findAll());
    }

    public SearchHistoryDto addToHistory(GithubUserResponseDto response) {
        SearchHistoryEntity searchHistory = SearchHistoryEntity.builder()
                .username(response.getUsername())
                .avatar(response.getAvatar())
                .visitedAt(Instant.now())
                .build();

        return searchHistoryMapper.toDto(searchHistoryRepository.save(searchHistory));
    }
}
