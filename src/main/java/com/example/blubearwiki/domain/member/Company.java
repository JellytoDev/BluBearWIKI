package com.example.blubearwiki.domain.member;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "COMPANY")
@NoArgsConstructor
public class Company {
    @Id
    @GeneratedValue
    @Column(name = "COMPANY_ID")
    private Long id;

    @Column(name = "COMPANY_NAME")
    private String name;

    @OneToMany(mappedBy = "company", cascade = CascadeType.REMOVE)
    private List<Group> groups;
}
