package com.example.blubearwiki.dto.wiki;

import com.example.blubearwiki.domain.wiki.Wiki;
import com.example.blubearwiki.domain.wiki.WikiAccessType;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@RequiredArgsConstructor
@Data
public class WikiMemberResponseDto {
    Long id;
    String name;
    String email;
    Date joinDate;
    Date expireDate;
    WikiAccessType type;
}
