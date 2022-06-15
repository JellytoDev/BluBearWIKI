package com.example.blubearwiki.repository.wiki;

import com.example.blubearwiki.domain.wiki.Wiki;
import com.example.blubearwiki.domain.wiki.WikiMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WikiMemberRepository extends JpaRepository<WikiMember,Long> {

}
