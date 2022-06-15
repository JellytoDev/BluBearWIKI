package com.example.blubearwiki.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ViewController {

    /*
     * wiki 리스트 가져오기
     * */
    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    /*
     * wiki 메인 페이지 가기
     * */
    @GetMapping("/w/{wikiId}")
    public String wiki(Model model,
                       @PathVariable Long wikiId) {

        return "doc";
    }

    /*
    * doc 이동
    * */
    @GetMapping("/w/d/{wikiId}/{docId}")
    public String doc(Model model,
                      @PathVariable Long wikiId,
                      @PathVariable Long docId) {

        return "doc";
    }

    /*
     * wiki set 페이지
     * */
    @GetMapping("/w/set")
    public String wikiSet(Model model) {
        return "wiki_set";
    }
}
