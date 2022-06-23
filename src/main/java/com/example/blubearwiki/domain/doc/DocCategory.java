package com.example.blubearwiki.domain.doc;

import com.example.blubearwiki.domain.wiki.Wiki;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
@Getter
@Setter
@Table(name = "DOC_CATEGORY")
public class DocCategory {
    @Id
    @GeneratedValue
    @Column(name = "DOC_CA_ID")
    Long id;

    @Column(name = "DOC_CA_NAME")
    String name;

    @Column(name = "DOC_CA_SEQ")
    Integer seq;

    @OneToMany(mappedBy = "docCategory", fetch = FetchType.LAZY)
    List<Doc> docList;

    @JoinColumn(name = "WIKI_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    Wiki wiki;

    public DocCategory() {

    }
}
