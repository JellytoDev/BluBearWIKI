package com.example.blubearwiki.controller;

import com.example.blubearwiki.domain.member.Member;
import com.example.blubearwiki.domain.wiki.Wiki;
import com.example.blubearwiki.domain.wiki.WikiMember;
import com.example.blubearwiki.dto.wiki.*;
import com.example.blubearwiki.repository.member.MemberRepository;
import com.example.blubearwiki.repository.wiki.WikiMemberRepository;
import com.example.blubearwiki.repository.wiki.WikiRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/rest/w")
@ResponseBody
public class WikiRestController {

    private final MemberRepository memberRepository;
    private final WikiRepository wikiRepository;
    private final WikiMemberRepository wikiMemberRepository;

    Date d = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
    /*
     * index : 페이징
     * wiki_set : 위키 생성, 맴버 추가, 삭제 , 업데이트
     * */

    @PostMapping("/member/add")
    public WikiMemberAddResponseDto memberAdd(@RequestBody WikiMemberAddRequestDto wikiMemberRequestDto) {
        System.out.println("wikiMemberRequestDto = " + wikiMemberRequestDto.toString());

        Member member = memberRepository.findById(wikiMemberRequestDto.getMemberId()).get();
        Wiki wiki = wikiRepository.findById(wikiMemberRequestDto.getWikiId()).get();

        //LocalDateTime now = LocalDateTime.parse(dateFormat.format(d), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));


        WikiMember wikiMember = new WikiMember();
        wikiMember = WikiMember.builder()
                .member(member)
                .wiki(wiki)
                .expireDate(wikiMemberRequestDto.getExpireDate())
                .joinDate(d)
                .type(wikiMemberRequestDto.getType())
                .build();

        wikiMemberRepository.save(wikiMember);

        WikiMemberAddResponseDto wikiMemberResponseDto = WikiMemberAddResponseDto.builderByWikiMember(wikiMember);

        System.out.println("wikiMemberResponseDto = " + wikiMemberResponseDto);

        return wikiMemberResponseDto;
    }

    @PostMapping("/member/delete")
    public ResponseEntity memberDelete(@RequestParam Long wikiMemberId) {

        String name = wikiMemberRepository.findById(wikiMemberId).get().getMember().getName();
        wikiMemberRepository.deleteById(wikiMemberId);

        return new ResponseEntity(name,HttpStatus.OK);
    }

    @PostMapping("/member/update")
    public ResponseEntity memberUpdate(@ModelAttribute WikiMemberUpdateRequestDto wikiMemberUpdateRequestDto) {
        //
        WikiMember wikiMember = wikiMemberRepository.findById(wikiMemberUpdateRequestDto.getWikiMemberId()).get();

        wikiMember.update(wikiMemberUpdateRequestDto.getExpireDate(),wikiMemberUpdateRequestDto.getType());

        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/create")
    public String create(@RequestBody WikiCreateRequestDto wikiCreateRequestDto) {

        System.out.println("wikiCreateRequestDto = " + wikiCreateRequestDto);

        List<WikiMemberDto> wikiMemberList = wikiCreateRequestDto.getWikiMemberList();

        Member member1 = memberRepository.findById(1L).get();

        Wiki wiki = new Wiki();
        wiki.setMember(member1);
        wiki.setTitle(wikiCreateRequestDto.getTitle());
        wiki.setDescription(wikiCreateRequestDto.getDescription());
        //wiki.setWikiCategory();

        wikiRepository.save(wiki);

        for (WikiMemberDto wikiMemberDto : wikiMemberList) {
            WikiMember wikiMember = new WikiMember();
            Member member = memberRepository.findById(wikiMemberDto.getMemberId()).get();
            //
            wikiMember = WikiMember.builder()
                    .member(member)
                    .type(wikiMemberDto.getType())
                    .expireDate(wikiMemberDto.getExpireDate())
                    .joinDate(d)
                    .wiki(wiki)
                    .build();

            wikiMemberRepository.save(wikiMember);
        }

        return "wiki create";
    }

    @PostConstruct
    public void init() {
        Member member = new Member();
        member.setName("test name");
        member.setEmail("test@Test.com");
        memberRepository.save(member);

        Wiki wiki = new Wiki();
        wiki.setTitle("test wiki");
        wiki.setMember(member);
        wikiRepository.save(wiki);

    }
}
