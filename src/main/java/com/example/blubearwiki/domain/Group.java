package com.example.blubearwiki.domain;

import javax.persistence.*;

@Entity
public class Group {
    @Id
    @GeneratedValue
    @Column(name = "GROUP_ID")
    Long id;

    @Column(name = "GROUP_NAME")
    String name;

    @ManyToOne
    Company company;
}
