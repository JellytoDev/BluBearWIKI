package com.example.blubearwiki.controller;

import com.example.blubearwiki.domain.member.Company;
import com.example.blubearwiki.domain.member.Group;
import com.example.blubearwiki.domain.member.Member;
import com.example.blubearwiki.dto.member.CompanyDto;
import com.example.blubearwiki.dto.member.MemberDto;
import com.example.blubearwiki.repository.member.CompanyRepository;
import com.example.blubearwiki.repository.member.GroupRepository;
import com.example.blubearwiki.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/rest/m")
public class MemberRestController {

    private final CompanyRepository companyRepository;
    private final GroupRepository groupRepository;
    private final MemberRepository memberRepository;

    /*
    * wiki set : member 찾기
    * dummy 세팅부터 하기
    * */
    //public List<MemberDto>
    @PostMapping("/company/member/all/{companyId}")
    @ResponseBody
    public CompanyDto findMemberList(@PathVariable Long companyId) {
        Company companyEntity = companyRepository.findById(companyId).get();

        CompanyDto companyDto = new CompanyDto();
        companyDto.fromCompany(companyEntity);

        return companyDto;
    }

    @PostConstruct
    public void init() {
        Company company = new Company();
        company.setName("test company");
        companyRepository.save(company);

        Group group = new Group();
        group.setName("test group");
        group.setCompany(company);
        company.addGroup(group);
        groupRepository.save(group);

        Member member = new Member();
        member.setEmail("test@test.com");
        member.setName("test1");
        member.setGroup(group);
        group.addMember(member);
        memberRepository.save(member);
    }
}
