package com.example.blubearwiki.dto.wiki;

import com.example.blubearwiki.domain.member.Member;
import com.example.blubearwiki.domain.wiki.Wiki;
import com.example.blubearwiki.domain.wiki.WikiAccessType;
import com.example.blubearwiki.domain.wiki.WikiCategory;
import com.example.blubearwiki.domain.wiki.WikiMember;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Data
public class WikiDto {
    Long id;
    String title;
    WikiAccessType access;
    String description;
    Long memberId;
    Long wikiCategoryId;

    public void builderByWiki(Wiki wiki) {
        this.id = wiki.getId();
        this.title = wiki.getTitle();
        this.access = wiki.getAccess();
        this.description = wiki.getDescription();
        this.memberId = wiki.getMember().getId();
        this.wikiCategoryId = wiki.getWikiCategory().getId();
    }

    public static List<WikiDto> builderListByWikiList(List<Wiki> wikiList) {
        List<WikiDto> wikiDtoList = new ArrayList<>();
        for (Wiki wiki : wikiList) {
            WikiDto wikiDto = new WikiDto();
            wikiDto.builderByWiki(wiki);
            wikiDtoList.add(wikiDto);
        }

        return wikiDtoList;
    }
}
