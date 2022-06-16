package com.example.blubearwiki.dto.member;

import com.example.blubearwiki.domain.member.Group;
import com.example.blubearwiki.domain.member.Member;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@RequiredArgsConstructor
public class GroupDto {
    private Long id;
    private String name;
    private List<MemberDto> members = new ArrayList<>();

    public void fromGroup(Group group) {
        this.id = group.getId();
        this.name = group.getName();

        for (Member member : group.getMembers()) {
            MemberDto memberDto = new MemberDto();
            memberDto.fromMember(member);
            members.add(memberDto);
        }
    }
}
