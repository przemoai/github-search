package com.talan.githubsearch.searchhistory.domain;

import com.talan.githubsearch.searchhistory.dto.SearchHistoryDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
interface SearchHistoryMapper {
    SearchHistoryDto toDto(SearchHistoryEntity searchHistoryEntity);

    List<SearchHistoryDto> toDto(List<SearchHistoryEntity> searchHistoryEntityList);
}
