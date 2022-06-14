package com.example.blubearwiki.domain.doc;

import com.example.blubearwiki.domain.wiki.Wiki;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "DOC")
public class Doc {
    @Id
    @GeneratedValue
    @Column(name = "DOC_ID")
    Long id;

    @Column(name = "DOC_CONTENT")
    String content;

    @Column(name = "DOC_STATUS")
    DocStatus status;

    @Column(name = "DOC_UPDATED")
    Date updated;

    @JoinColumn(name = "DOC_CA_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    DocCategory docCategory;

    @JoinColumn(name = "WIKI_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    Wiki wiki;

    @OneToMany(mappedBy = "doc", fetch = FetchType.LAZY)
    List<DocLog> docLogList;

    public Doc() {

    }
}
