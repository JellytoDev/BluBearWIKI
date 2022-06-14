package com.example.blubearwiki.domain.wiki;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "WIKI_MEMBER")
public class WikiMember {
    @Id
    @GeneratedValue
    @Column(name = "WIKI_MEM_ID")
    Long id;

    @Column(name = "WIKI_MEM_NAME")
    String name;

    @Column(name = "WIKI_MEM_EMAIL")
    String email;

    @Column(name = "WIKI_MEM_JOIN")
    Date joinDate;

    @Column(name = "WIKI_MEM_EXPIRE")
    Date expireDate;

    @Column(name = "WIKI_MEM_TYPE")
    WikiAccessType type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "WIKI_ID")
    Wiki wiki;

    public WikiMember() {

    }
}
