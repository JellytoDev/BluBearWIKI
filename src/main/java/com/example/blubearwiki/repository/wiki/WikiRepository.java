package com.example.blubearwiki.repository.wiki;

import com.example.blubearwiki.domain.member.Member;
import com.example.blubearwiki.domain.wiki.Wiki;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WikiRepository extends JpaRepository<Wiki,Long>,WikiRepositoryCustom {

}
