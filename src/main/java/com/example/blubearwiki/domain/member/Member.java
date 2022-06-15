package com.example.blubearwiki.domain.member;

import com.example.blubearwiki.domain.wiki.WikiMember;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "MEMBER")
public class Member {
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    Long id;

    @Column(name = "MEMBER_NAME")
    String name;

    @Column(name = "MEMBER_EMAIL")
    String email;

    @JoinColumn(name = "GROUP_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    Group group;

    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
    List<WikiMember> wikiMemberList;

    public Member() {

    }
}
