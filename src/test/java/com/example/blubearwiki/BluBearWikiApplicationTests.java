package com.example.blubearwiki;

import com.example.blubearwiki.domain.doc.DocCategory;
import com.example.blubearwiki.domain.member.Member;
import com.example.blubearwiki.domain.wiki.WikiMemberAccessType;
import com.example.blubearwiki.repository.doc.DocCategoryRepository;
import com.example.blubearwiki.repository.member.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

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

		Optional<DocCategory> docCategory = Optional.empty();
		System.out.println("docCategory = " + docCategory);

		WikiMemberAccessType wikiAccessType;
		System.out.println("wikiAccessType = " + WikiMemberAccessType.OWNER);
	}

}
