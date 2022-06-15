package com.example.blubearwiki.dto.wiki;

import com.example.blubearwiki.domain.wiki.WikiAccessType;
import com.example.blubearwiki.domain.wiki.WikiMemberAccessType;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.File;
import java.util.List;

@RequiredArgsConstructor
@Data
public class WikiCreateRequestDto {

    private String title;
    private Long wikiCategoryId;
    private WikiAccessType access;
    private File logo;
    private String description;

    private List<WikiMemberDto> wikiMemberList;
}
