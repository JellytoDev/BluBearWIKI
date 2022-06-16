package com.example.blubearwiki.domain.member;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "C_GROUP")
public class Group {
    @Id
    @GeneratedValue
    @Column(name = "C_GROUP_ID")
    private Long id;

    @Column(name = "C_GROUP_NAME")
    private String name;

    @JoinColumn(name = "COMPANY_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;

    @OneToMany(mappedBy = "group", cascade = CascadeType.REMOVE)
    List<Member> members = new ArrayList<>();

    public void addMember(Member member) {
        this.members.add(member);
    }
}
