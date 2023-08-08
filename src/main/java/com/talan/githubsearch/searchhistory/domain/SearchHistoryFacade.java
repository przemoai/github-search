package com.talan.githubsearch.searchhistory.domain;

import com.talan.githubsearch.github.dto.GithubUserResponseDto;
import com.talan.githubsearch.searchhistory.dto.SearchHistoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SearchHistoryFacade {

    private final SearchHistoryRepository searchHistoryRepository;
    private final SearchHistoryMapper searchHistoryMapper;

    public List<SearchHistoryDto> getSearchHistory() {
        List<SearchHistoryDto> unordered = searchHistoryMapper.toDto(searchHistoryRepository.findAll());
        return unordered.stream()
                .sorted(Comparator.comparing(SearchHistoryDto::visitedAt).reversed())
                .toList();
    }

    public void addToHistory(GithubUserResponseDto response) {

        Optional<SearchHistoryEntity> searchedInPastProfile = searchHistoryRepository.findByUsername(response.getUsername());

        searchedInPastProfile.ifPresent(searchHistoryEntity -> searchHistoryEntity.setVisitedAt(Instant.now()));

        SearchHistoryEntity searchHistory = SearchHistoryEntity.builder()
                .username(response.getUsername())
                .avatar(response.getAvatar())
                .visitedAt(Instant.now())
                .build();

        searchHistoryMapper.toDto(searchHistoryRepository.save(searchHistory));
    }
}
