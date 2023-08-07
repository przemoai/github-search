package com.talan.githubsearch.searchhistory.resource;

import com.talan.githubsearch.searchhistory.domain.SearchHistoryFacade;
import com.talan.githubsearch.searchhistory.dto.SearchHistoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/history")
@RequiredArgsConstructor
class SearchHistoryController {

    private final SearchHistoryFacade searchHistoryFacade;

    @GetMapping("/")
    List<SearchHistoryDto> getSearchHistory() {
        return searchHistoryFacade.getSearchHistory();
    }
}
