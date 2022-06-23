package com.example.blubearwiki.controller;

import com.example.blubearwiki.domain.doc.DocCategory;
import com.example.blubearwiki.dto.doc.DocCategoryDto;
import com.example.blubearwiki.dto.doc.DocEditInfoDto;
import com.example.blubearwiki.repository.doc.DocCategoryRepository;
import com.example.blubearwiki.repository.doc.DocRepository;
import com.example.blubearwiki.repository.wiki.WikiRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ViewController {

    private final DocCategoryRepository docCategoryRepository;
    private final DocRepository docRepository;
    private final WikiRepository wikiRepository;
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

        System.out.println("docId = " + docId);


        DocEditInfoDto docEditInfoDto = new DocEditInfoDto();


        Long docCategoryId = docRepository.findById(docId).get().getDocCategory().getId();

        docEditInfoDto.setDocId(docId);
        docEditInfoDto.setWikiId(wikiId);
        docEditInfoDto.setDocCategoryId(docCategoryId);

        List<DocCategory> docCategoryEntityList = wikiRepository.findById(wikiId).get().getDocCategoryList();
        List<DocCategoryDto> docCategoryList = new ArrayList<>();

        for (DocCategory docCategory: docCategoryEntityList) {
            System.out.println("docCategory = " + docCategory.toString());
            docCategoryList.add(new DocCategoryDto(docCategory.getId(), docCategory.getName()));
        }

        model.addAttribute("docEditInfo", docEditInfoDto);
        model.addAttribute("docCategoryList", docCategoryList);

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
