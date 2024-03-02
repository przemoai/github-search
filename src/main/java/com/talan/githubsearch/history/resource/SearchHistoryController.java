package com.talan.githubsearch.history.resource;

import com.talan.githubsearch.history.domain.SearchHistoryFacade;
import com.talan.githubsearch.history.dto.SearchHistoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/github/history")
@RequiredArgsConstructor
public class SearchHistoryController {

    private final SearchHistoryFacade searchHistoryFacade;

    @GetMapping()
    List<SearchHistoryDto> getSearchHistory() {
        return searchHistoryFacade.getSearchHistory();
    }

    @DeleteMapping(value = "{username}")
    Long deleteFromHistory(@PathVariable String username){
        return searchHistoryFacade.deleteFromHistory(username);
    }
}
