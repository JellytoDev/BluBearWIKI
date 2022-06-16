package com.example.blubearwiki.repository.wiki;

import com.example.blubearwiki.domain.wiki.Wiki;

import java.util.List;

public interface WikiRepositoryCustom {
    List<Wiki> findPagingAll(Integer page, Integer size);
}
