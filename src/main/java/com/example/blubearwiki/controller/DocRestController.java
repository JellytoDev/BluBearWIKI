package com.example.blubearwiki.controller;

import com.example.blubearwiki.domain.doc.Doc;
import com.example.blubearwiki.domain.doc.DocCategory;
import com.example.blubearwiki.domain.doc.DocStatus;
import com.example.blubearwiki.domain.wiki.Wiki;
import com.example.blubearwiki.domain.wiki.WikiAccessType;
import com.example.blubearwiki.dto.doc.DocCreateRequestDto;
import com.example.blubearwiki.dto.doc.DocSaveRequestDto;
import com.example.blubearwiki.dto.doc.DocSetRequestDto;
import com.example.blubearwiki.repository.doc.DocCategoryRepository;
import com.example.blubearwiki.repository.doc.DocRepository;
import com.example.blubearwiki.repository.wiki.WikiRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/rest/d")
public class DocRestController {

    private final DocRepository docRepository;
    private final DocCategoryRepository docCategoryRepository;
    private final WikiRepository wikiRepository;

    Date d = new Date();

    @PostMapping(value = "/save", produces = "application/json")
    public ResponseEntity save(@RequestBody DocSaveRequestDto docSaveRequestDto) {

        log.info("save test : " + docSaveRequestDto.toString());
        Doc doc = docRepository.findById(docSaveRequestDto.getDocId()).get();
        if(docSaveRequestDto.getDocCategoryId()!=null){
            DocCategory docCategory = docCategoryRepository.findById(docSaveRequestDto.getDocCategoryId()).get();
            doc.setDocCategory(docCategory);
        }

        doc.setTitle(docSaveRequestDto.getTitle());
        doc.setContent(docSaveRequestDto.getContent());
        doc.setUpdated(d);
        docRepository.save(doc);

        Map<String, Object> result = new HashMap<>();
        result.put("status", HttpStatus.OK);
        result.put("data", "success");
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @PostMapping(value = "/create", produces = "application/json")
    public ResponseEntity create(@RequestBody DocCreateRequestDto docCreateRequestDto) {

        Doc doc = new Doc();
        Wiki wiki = wikiRepository.findById(docCreateRequestDto.getWikiId()).get();
        DocCategory docCategory = docCategoryRepository.findById(docCreateRequestDto.getDocCategoryId()).get();

        doc.setWiki(wiki);
        doc.setDocCategory(docCategory);
        doc.setUpdated(d);
        doc.setTitle("");
        doc.setContent("");
        doc.setStatus(DocStatus.ACTIVE);

        docRepository.save(doc);

        Map<String, Object> result = new HashMap<>();
        result.put("status", HttpStatus.OK);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @PostMapping(value = "/set/save", produces = "application/json")
    public ResponseEntity setSave(@RequestBody DocSetRequestDto docSetRequestDto) {

        Map<String, Object> result = new HashMap<>();

        Doc doc = docRepository.findById(docSetRequestDto.getDocId()).get();
        DocCategory docCategory = docCategoryRepository.findById(docSetRequestDto.getDocCategoryId()).get();
        doc.setDocCategory(docCategory);
        doc.setStatus(docSetRequestDto.getStatus());
        docRepository.save(doc);

        result.put("status", HttpStatus.OK);
        result.put("data", "success");

        return new ResponseEntity(result, HttpStatus.OK);
    }

    @PostConstruct
    public void init() {

        Wiki wiki = new Wiki();
        wiki.setTitle("test doc wiki!");
        wiki.setAccess(WikiAccessType.PUBLIC);
        wiki.setDescription("this is doc test wiki");
        wikiRepository.save(wiki);


        DocCategory docCategory = new DocCategory();
        docCategory.setName("test doc ca");
        docCategory.setSeq(1);
        docCategory.setWiki(wiki);
        wiki.addDocCategoryList(docCategory);
        docCategoryRepository.save(docCategory);

        Doc doc = new Doc();
        doc.setTitle("test doc");
        doc.setStatus(DocStatus.ACTIVE);
        doc.setUpdated(d);
        doc.setContent("# doc test title");
        doc.setWiki(wiki);
        doc.setDocCategory(docCategory);
        docRepository.save(doc);
    }
}
