package com.example.blubearwiki.dto.wiki;

import com.example.blubearwiki.domain.wiki.WikiMemberAccessType;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@RequiredArgsConstructor
public class WikiMemberUpdateRequestDto {
    @NotNull
    private Long wikiMemberId;

    private Date expireDate;

    private WikiMemberAccessType type;
}
