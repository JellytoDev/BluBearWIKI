package com.example.blubearwiki.dto.wiki;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Map;

@Data
@RequiredArgsConstructor
public class WikiPagingRequestDto {
    private Integer page;
    private Integer size;
    private Map<String,String> where;

}
