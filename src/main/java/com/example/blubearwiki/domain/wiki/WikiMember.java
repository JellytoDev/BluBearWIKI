package com.example.blubearwiki.domain.wiki;

import com.example.blubearwiki.domain.member.Member;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Builder
@AllArgsConstructor
//@Setter
@Table(name = "WIKI_MEMBER")
@NoArgsConstructor
public class WikiMember {
    @Id
    @GeneratedValue
    @Column(name = "WIKI_MEM_ID")
    Long id;

    //@Column(name = "WIKI_MEM_NAME")
    //String name;
    //
    //@Column(name = "WIKI_MEM_EMAIL")
    //String email;

    @Column(name = "WIKI_MEM_JOIN")
    Date joinDate;

    @Column(name = "WIKI_MEM_EXPIRE")
    Date expireDate;

    @Column(name = "WIKI_MEM_TYPE")
    WikiMemberAccessType type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "WIKI_ID")
    Wiki wiki;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    Member member;

    public void update(Date expireDate, WikiMemberAccessType type) {
        this.expireDate = expireDate;
        this.type = type;
    }
}
