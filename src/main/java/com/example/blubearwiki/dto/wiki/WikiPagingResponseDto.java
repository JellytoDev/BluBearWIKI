package com.example.blubearwiki.dto.wiki;

import com.example.blubearwiki.domain.wiki.Wiki;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Data
public class WikiPagingResponseDto {
    private Integer page;
    private Integer size;
    private List<Wiki> wikiList;
}
