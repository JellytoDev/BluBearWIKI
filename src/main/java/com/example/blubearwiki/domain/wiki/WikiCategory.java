package com.example.blubearwiki.domain.wiki;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "WIKI_CATEGORY")
public class WikiCategory {
    @Id
    @GeneratedValue
    @Column(name = "WIKI_CA_ID")
    Long id;

    @Column(name = "WIKI_CA_NAME")
    String name;

    @Column(name = "WIKI_CA_SEQ")
    Integer seq;

    @OneToMany(mappedBy = "wikiCategory", fetch = FetchType.LAZY)
    List<Wiki> wikiList = new ArrayList<>();

    public void addWikiList(Wiki wiki) {
        wikiList.add(wiki);
    }

}
