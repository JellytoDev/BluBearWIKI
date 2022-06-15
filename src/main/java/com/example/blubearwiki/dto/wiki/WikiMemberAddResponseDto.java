package com.example.blubearwiki.dto.wiki;

import com.example.blubearwiki.domain.wiki.WikiMemberAccessType;
import com.example.blubearwiki.domain.wiki.WikiMember;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@RequiredArgsConstructor
@Data
public class WikiMemberAddResponseDto {
    Long id;
    String name;
    String email;
    Date joinDate;
    Date expireDate;
    WikiMemberAccessType type;

    public static WikiMemberAddResponseDto builderByWikiMember(WikiMember wikiMember) {
        WikiMemberAddResponseDto wikiMemberResponseDto = new WikiMemberAddResponseDto();
        wikiMemberResponseDto.setEmail(wikiMember.getMember().getEmail());
        wikiMemberResponseDto.setExpireDate(wikiMember.getExpireDate());
        wikiMemberResponseDto.setJoinDate(wikiMember.getJoinDate());
        wikiMemberResponseDto.setName(wikiMember.getMember().getName());
        wikiMemberResponseDto.setId(wikiMember.getId());
        wikiMemberResponseDto.setType(wikiMember.getType());

        return wikiMemberResponseDto;
    }
}
