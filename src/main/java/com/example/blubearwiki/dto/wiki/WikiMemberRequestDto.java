package com.example.blubearwiki.dto.wiki;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class WikiMemberRequestDto {
    @NotNull
    private Long wikiId;
    @NotNull
    private Long memberId;
}
