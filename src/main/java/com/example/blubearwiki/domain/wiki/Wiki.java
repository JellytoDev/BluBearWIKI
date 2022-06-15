package com.example.blubearwiki.domain.wiki;

import com.example.blubearwiki.domain.member.Member;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="WIKI")
public class Wiki {
    @Id
    @GeneratedValue
    @Column(name = "WIKI_ID")
    Long id;

    @Column(name = "WIKI_TITLE")
    String title;

    @Column(name = "WIKI_ACCESS")
    WikiAccessType access;

    @Column(name = "WIKI_DESCRIPTION")
    String description;

    @JoinColumn(name = "MEMBER_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    Member member;

    @JoinColumn(name = "WIKI_CA_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    WikiCategory wikiCategory;

    @OneToMany(mappedBy = "wiki", fetch = FetchType.LAZY)
    List<WikiMember> memberList;

    public Wiki() {

    }
}
