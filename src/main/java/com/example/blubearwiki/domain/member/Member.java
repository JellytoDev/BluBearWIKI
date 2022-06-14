package com.example.blubearwiki.domain.member;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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

    @JoinColumn(name = "GROUP_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    Group group;

    public Member() {

    }
}
