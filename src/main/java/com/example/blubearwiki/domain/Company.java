package com.example.blubearwiki.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class Company {
    @Id
    @GeneratedValue
    @Column(name = "COMPANY_ID")
    Long id;

    @Column(name = "COMPANY_NAME")
    String name;
}
