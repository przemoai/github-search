package com.talan.githubsearch.history.domain;

import com.talan.githubsearch.github.dto.GithubUserDetailsDto;
import com.talan.githubsearch.history.dto.SearchHistoryDto;
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

    public void addToHistory(GithubUserDetailsDto response) {
        Instant now = Instant.now();

        Optional<SearchHistoryEntity> searchedInPastProfile = searchHistoryRepository.findByUsername(response.getUsername());

        searchedInPastProfile.ifPresentOrElse(
                searchHistoryEntity -> {
                    searchHistoryEntity.setVisitedAt(now);
                    searchHistoryRepository.save(searchHistoryEntity);
                },
                () -> {
                    SearchHistoryEntity searchHistory = SearchHistoryEntity.builder()
                            .username(response.getUsername())
                            .avatar(response.getAvatar())
                            .visitedAt(now)
                            .build();
                    searchHistoryRepository.save(searchHistory);
                }
        );
    }
}
