package com.example.blubearwiki.controller;

import com.example.blubearwiki.domain.member.Company;
import com.example.blubearwiki.domain.member.Group;
import com.example.blubearwiki.domain.member.Member;
import com.example.blubearwiki.dto.member.CompanyDto;
import com.example.blubearwiki.dto.member.MemberDto;
import com.example.blubearwiki.repository.member.CompanyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/rest/m")
public class MemberRestController {

    private final CompanyRepository companyRepository;

    /*
    * wiki set : member 찾기
    * dummy 세팅부터 하기
    * */
    //public List<MemberDto>
    @PostMapping("/company/member/all/{companyId}")
    public CompanyDto findMemberList(@PathVariable Long companyId) {
        Company company = companyRepository.findById(companyId).get();


    }
}
