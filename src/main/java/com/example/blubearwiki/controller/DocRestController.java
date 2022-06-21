package com.example.blubearwiki.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/rest/d")
public class DocRestController {

    @PostMapping(value = "/save", produces = "application/json")
    public ResponseEntity save(@RequestBody Map<String,String> test) {

        log.info("save test : " + test.toString());

        Map<String, Object> result = new HashMap<>();
        result.put("success", "success");
        result.put("data", "success");
        return new ResponseEntity(result, HttpStatus.OK);
    }
}
