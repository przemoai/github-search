package com.talan.githubsearch.history.domain;

import com.talan.githubsearch.history.dto.SearchHistoryDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
interface SearchHistoryMapper {
    SearchHistoryDto toDto(SearchHistoryEntity searchHistoryEntity);

    List<SearchHistoryDto> toDto(List<SearchHistoryEntity> searchHistoryEntityList);
}
