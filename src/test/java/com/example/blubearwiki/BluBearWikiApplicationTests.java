package com.example.blubearwiki;

import com.example.blubearwiki.domain.wiki.WikiAccessType;
import org.junit.jupiter.api.Test;

//@SpringBootTest
class BluBearWikiApplicationTests {

	@Test
	void contextLoads() {
		WikiAccessType wikiAccessType;
		System.out.println("wikiAccessType = " + WikiAccessType.OWNER);
	}

}
