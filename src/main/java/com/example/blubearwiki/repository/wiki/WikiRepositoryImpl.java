package com.example.blubearwiki.repository.wiki;

import com.example.blubearwiki.domain.wiki.QWiki;
import com.example.blubearwiki.domain.wiki.Wiki;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WikiRepositoryImpl extends QuerydslRepositorySupport implements WikiRepositoryCustom {
    public WikiRepositoryImpl() {
        super(Wiki.class);
    }

    @Override
    public List<Wiki> findPagingAll(Integer page, Integer size) {

        QWiki qWiki = QWiki.wiki;

        return from(qWiki)
                .fetch();
    }
}
