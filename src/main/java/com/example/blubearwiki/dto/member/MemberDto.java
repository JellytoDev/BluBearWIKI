package com.example.blubearwiki.dto.member;

import com.example.blubearwiki.domain.member.Group;
import com.example.blubearwiki.domain.member.Member;
import com.example.blubearwiki.domain.wiki.WikiMember;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@RequiredArgsConstructor
public class MemberDto {
    Long id;
    String name;
    String email;

    public void fromMember(Member member) {
        this.id = member.getId();
        this.name = member.getName();
        this.email = member.getEmail();
    }
}
