package com.example.blubearwiki.dto.wiki;

import com.example.blubearwiki.domain.wiki.WikiMemberAccessType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@RequiredArgsConstructor
public class WikiMemberAddRequestDto {
    @NotNull
    private Long wikiId;
    @NotNull
    private Long memberId;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date expireDate;

    private WikiMemberAccessType type;
}
