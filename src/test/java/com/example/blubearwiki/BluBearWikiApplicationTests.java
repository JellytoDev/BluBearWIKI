package com.example.blubearwiki;

import com.example.blubearwiki.domain.member.Member;
import com.example.blubearwiki.domain.wiki.WikiAccessType;
import com.example.blubearwiki.repository.DocCategoryRepository;
import com.example.blubearwiki.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BluBearWikiApplicationTests {

	@Autowired
	MemberRepository memberRepository;
	@Autowired
	DocCategoryRepository docCategoryRepository;

	@Test
	void contextLoads() {
		memberRepository.save(new Member());
		docCategoryRepository.findBySeqBetween(1, 20);

		WikiAccessType wikiAccessType;
		System.out.println("wikiAccessType = " + WikiAccessType.OWNER);
	}

}
