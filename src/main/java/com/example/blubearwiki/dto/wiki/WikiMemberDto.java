package com.example.blubearwiki.dto.wiki;

import com.example.blubearwiki.domain.wiki.WikiMemberAccessType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@RequiredArgsConstructor
@Data
public class WikiMemberDto {
    Long memberId;
    WikiMemberAccessType type;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    Date expireDate;
}
//
//        "expireDate":"2022/3/1 22:10:20"