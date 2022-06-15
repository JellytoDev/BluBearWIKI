package com.example.blubearwiki.controller;

import com.example.blubearwiki.dto.wiki.WikiMemberRequestDto;
import com.example.blubearwiki.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/rest/w")
@ResponseBody
public class WikiRestController {

    private final MemberRepository memberRepository;

    /*
     * index : 페이징
     * wiki_set : 위키 생성, 맴버 추가, 삭제 , 업데이트
     * */

    @PostMapping("/member/add")
    public WikiMemberRequestDto memberAdd(@ModelAttribute WikiMemberRequestDto wikiMemberRequestDto) {
        System.out.println("wikiMemberRequestDto = " + wikiMemberRequestDto.toString());

        return wikiMemberRequestDto;
    }

    @PostMapping("/member/delete")
    public String memberDelete() {
        return "member delete";
    }

    @PostMapping("/member/update")
    public String memberUpdate() {
        return "member update";
    }

    @PostMapping("/create")
    public String create() {
        return "wiki create";
    }
}
