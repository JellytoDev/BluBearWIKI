package com.example.blubearwiki.domain.doc;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "DOC_LOG")
public class DocLog {
    @Id
    @GeneratedValue
    @Column(name = "DOC_LOG_ID")
    Long id;

    @Column(name = "DOC_LOG_UPDATED")
    Date updated;

    @JoinColumn(name = "DOC_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    Doc doc;

    public DocLog() {

    }
}
